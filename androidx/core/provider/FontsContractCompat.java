package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat {
  private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final String PARCEL_FONT_RESULTS = "font_results";
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
  
  private static final SelfDestructiveThread sBackgroundThread;
  
  private static final Comparator<byte[]> sByteArrayComparator;
  
  static final Object sLock;
  
  @GuardedBy("sLock")
  static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies;
  
  static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  
  static {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
    sByteArrayComparator = new Comparator<byte[]>() {
        public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
          if (param1ArrayOfbyte1.length != param1ArrayOfbyte2.length)
            return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length; 
          for (byte b = 0; b < param1ArrayOfbyte1.length; b++) {
            if (param1ArrayOfbyte1[b] != param1ArrayOfbyte2[b])
              return param1ArrayOfbyte1[b] - param1ArrayOfbyte2[b]; 
          } 
          return 0;
        }
      };
  }
  
  @Nullable
  public static Typeface buildTypeface(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontInfo[] paramArrayOfFontInfo) {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  private static List<byte[]> convertToByteArrayList(Signature[] paramArrayOfSignature) {
    ArrayList<byte[]> arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayOfSignature.length; b++)
      arrayList.add(paramArrayOfSignature[b].toByteArray()); 
    return (List<byte[]>)arrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    for (byte b = 0; b < paramList1.size(); b++) {
      if (!Arrays.equals(paramList1.get(b), paramList2.get(b)))
        return false; 
    } 
    return true;
  }
  
  @NonNull
  public static FontFamilyResult fetchFonts(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontRequest paramFontRequest) throws PackageManager.NameNotFoundException {
    ProviderInfo providerInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    return (providerInfo == null) ? new FontFamilyResult(1, null) : new FontFamilyResult(0, getFontFromProvider(paramContext, paramFontRequest, providerInfo.authority, paramCancellationSignal));
  }
  
  private static List<List<byte[]>> getCertificates(FontRequest paramFontRequest, Resources paramResources) {
    return (paramFontRequest.getCertificates() != null) ? paramFontRequest.getCertificates() : FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  @NonNull
  @VisibleForTesting
  static FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: new android/net/Uri$Builder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: ldc 'content'
    //   18: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   21: aload_2
    //   22: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   25: invokevirtual build : ()Landroid/net/Uri;
    //   28: astore #5
    //   30: new android/net/Uri$Builder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: ldc 'content'
    //   39: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   42: aload_2
    //   43: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   46: ldc 'file'
    //   48: invokevirtual appendPath : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   51: invokevirtual build : ()Landroid/net/Uri;
    //   54: astore #6
    //   56: aconst_null
    //   57: astore #7
    //   59: aload #7
    //   61: astore_2
    //   62: getstatic android/os/Build$VERSION.SDK_INT : I
    //   65: bipush #16
    //   67: if_icmple -> 155
    //   70: aload #7
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   77: astore_0
    //   78: aload #7
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual getQuery : ()Ljava/lang/String;
    //   85: astore_1
    //   86: aload #7
    //   88: astore_2
    //   89: aload_0
    //   90: aload #5
    //   92: bipush #7
    //   94: anewarray java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc '_id'
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 'file_id'
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: ldc 'font_ttc_index'
    //   111: aastore
    //   112: dup
    //   113: iconst_3
    //   114: ldc 'font_variation_settings'
    //   116: aastore
    //   117: dup
    //   118: iconst_4
    //   119: ldc 'font_weight'
    //   121: aastore
    //   122: dup
    //   123: iconst_5
    //   124: ldc_w 'font_italic'
    //   127: aastore
    //   128: dup
    //   129: bipush #6
    //   131: ldc_w 'result_code'
    //   134: aastore
    //   135: ldc_w 'query = ?'
    //   138: iconst_1
    //   139: anewarray java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: aastore
    //   146: aconst_null
    //   147: aload_3
    //   148: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   151: astore_0
    //   152: goto -> 236
    //   155: aload #7
    //   157: astore_2
    //   158: aload_0
    //   159: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   162: astore_0
    //   163: aload #7
    //   165: astore_2
    //   166: aload_1
    //   167: invokevirtual getQuery : ()Ljava/lang/String;
    //   170: astore_1
    //   171: aload #7
    //   173: astore_2
    //   174: aload_0
    //   175: aload #5
    //   177: bipush #7
    //   179: anewarray java/lang/String
    //   182: dup
    //   183: iconst_0
    //   184: ldc '_id'
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: ldc 'file_id'
    //   191: aastore
    //   192: dup
    //   193: iconst_2
    //   194: ldc 'font_ttc_index'
    //   196: aastore
    //   197: dup
    //   198: iconst_3
    //   199: ldc 'font_variation_settings'
    //   201: aastore
    //   202: dup
    //   203: iconst_4
    //   204: ldc 'font_weight'
    //   206: aastore
    //   207: dup
    //   208: iconst_5
    //   209: ldc_w 'font_italic'
    //   212: aastore
    //   213: dup
    //   214: bipush #6
    //   216: ldc_w 'result_code'
    //   219: aastore
    //   220: ldc_w 'query = ?'
    //   223: iconst_1
    //   224: anewarray java/lang/String
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: aastore
    //   231: aconst_null
    //   232: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   235: astore_0
    //   236: aload #4
    //   238: astore_1
    //   239: aload_0
    //   240: ifnull -> 535
    //   243: aload #4
    //   245: astore_1
    //   246: aload_0
    //   247: astore_2
    //   248: aload_0
    //   249: invokeinterface getCount : ()I
    //   254: ifle -> 535
    //   257: aload_0
    //   258: astore_2
    //   259: aload_0
    //   260: ldc_w 'result_code'
    //   263: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   268: istore #8
    //   270: aload_0
    //   271: astore_2
    //   272: new java/util/ArrayList
    //   275: astore_3
    //   276: aload_0
    //   277: astore_2
    //   278: aload_3
    //   279: invokespecial <init> : ()V
    //   282: aload_0
    //   283: astore_2
    //   284: aload_0
    //   285: ldc '_id'
    //   287: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   292: istore #9
    //   294: aload_0
    //   295: astore_2
    //   296: aload_0
    //   297: ldc 'file_id'
    //   299: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   304: istore #10
    //   306: aload_0
    //   307: astore_2
    //   308: aload_0
    //   309: ldc 'font_ttc_index'
    //   311: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   316: istore #11
    //   318: aload_0
    //   319: astore_2
    //   320: aload_0
    //   321: ldc 'font_weight'
    //   323: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   328: istore #12
    //   330: aload_0
    //   331: astore_2
    //   332: aload_0
    //   333: ldc_w 'font_italic'
    //   336: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   341: istore #13
    //   343: aload_0
    //   344: astore_2
    //   345: aload_0
    //   346: invokeinterface moveToNext : ()Z
    //   351: ifeq -> 533
    //   354: iload #8
    //   356: iconst_m1
    //   357: if_icmpeq -> 375
    //   360: aload_0
    //   361: astore_2
    //   362: aload_0
    //   363: iload #8
    //   365: invokeinterface getInt : (I)I
    //   370: istore #14
    //   372: goto -> 378
    //   375: iconst_0
    //   376: istore #14
    //   378: iload #11
    //   380: iconst_m1
    //   381: if_icmpeq -> 399
    //   384: aload_0
    //   385: astore_2
    //   386: aload_0
    //   387: iload #11
    //   389: invokeinterface getInt : (I)I
    //   394: istore #15
    //   396: goto -> 402
    //   399: iconst_0
    //   400: istore #15
    //   402: iload #10
    //   404: iconst_m1
    //   405: if_icmpne -> 427
    //   408: aload_0
    //   409: astore_2
    //   410: aload #5
    //   412: aload_0
    //   413: iload #9
    //   415: invokeinterface getLong : (I)J
    //   420: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   423: astore_1
    //   424: goto -> 443
    //   427: aload_0
    //   428: astore_2
    //   429: aload #6
    //   431: aload_0
    //   432: iload #10
    //   434: invokeinterface getLong : (I)J
    //   439: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   442: astore_1
    //   443: iload #12
    //   445: iconst_m1
    //   446: if_icmpeq -> 464
    //   449: aload_0
    //   450: astore_2
    //   451: aload_0
    //   452: iload #12
    //   454: invokeinterface getInt : (I)I
    //   459: istore #16
    //   461: goto -> 469
    //   464: sipush #400
    //   467: istore #16
    //   469: iload #13
    //   471: iconst_m1
    //   472: if_icmpeq -> 495
    //   475: aload_0
    //   476: astore_2
    //   477: aload_0
    //   478: iload #13
    //   480: invokeinterface getInt : (I)I
    //   485: iconst_1
    //   486: if_icmpne -> 495
    //   489: iconst_1
    //   490: istore #17
    //   492: goto -> 498
    //   495: iconst_0
    //   496: istore #17
    //   498: aload_0
    //   499: astore_2
    //   500: new androidx/core/provider/FontsContractCompat$FontInfo
    //   503: astore #4
    //   505: aload_0
    //   506: astore_2
    //   507: aload #4
    //   509: aload_1
    //   510: iload #15
    //   512: iload #16
    //   514: iload #17
    //   516: iload #14
    //   518: invokespecial <init> : (Landroid/net/Uri;IIZI)V
    //   521: aload_0
    //   522: astore_2
    //   523: aload_3
    //   524: aload #4
    //   526: invokevirtual add : (Ljava/lang/Object;)Z
    //   529: pop
    //   530: goto -> 343
    //   533: aload_3
    //   534: astore_1
    //   535: aload_0
    //   536: ifnull -> 545
    //   539: aload_0
    //   540: invokeinterface close : ()V
    //   545: aload_1
    //   546: iconst_0
    //   547: anewarray androidx/core/provider/FontsContractCompat$FontInfo
    //   550: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   553: checkcast [Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   556: areturn
    //   557: astore_0
    //   558: aload_2
    //   559: ifnull -> 568
    //   562: aload_2
    //   563: invokeinterface close : ()V
    //   568: aload_0
    //   569: athrow
    // Exception table:
    //   from	to	target	type
    //   62	70	557	finally
    //   73	78	557	finally
    //   81	86	557	finally
    //   89	152	557	finally
    //   158	163	557	finally
    //   166	171	557	finally
    //   174	236	557	finally
    //   248	257	557	finally
    //   259	270	557	finally
    //   272	276	557	finally
    //   278	282	557	finally
    //   284	294	557	finally
    //   296	306	557	finally
    //   308	318	557	finally
    //   320	330	557	finally
    //   332	343	557	finally
    //   345	354	557	finally
    //   362	372	557	finally
    //   386	396	557	finally
    //   410	424	557	finally
    //   429	443	557	finally
    //   451	461	557	finally
    //   477	489	557	finally
    //   500	505	557	finally
    //   507	521	557	finally
    //   523	530	557	finally
  }
  
  @NonNull
  static TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt) {
    try {
      FontFamilyResult fontFamilyResult = fetchFonts(paramContext, null, paramFontRequest);
      int i = fontFamilyResult.getStatusCode();
      byte b = -3;
      if (i == 0) {
        Typeface typeface = TypefaceCompat.createFromFontInfo(paramContext, null, fontFamilyResult.getFonts(), paramInt);
        if (typeface != null)
          b = 0; 
        return new TypefaceResult(typeface, b);
      } 
      if (fontFamilyResult.getStatusCode() == 1)
        b = -2; 
      return new TypefaceResult(null, b);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return new TypefaceResult(null, -1);
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Typeface getFontSync(Context paramContext, final FontRequest request, @Nullable final ResourcesCompat.FontCallback fontCallback, @Nullable final Handler handler, boolean paramBoolean, int paramInt1, final int style) {
    final TypefaceResult context;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(request.getIdentifier());
    stringBuilder.append("-");
    stringBuilder.append(style);
    final String id = stringBuilder.toString();
    Typeface typeface = (Typeface)sTypefaceCache.get(str);
    if (typeface != null) {
      if (fontCallback != null)
        fontCallback.onFontRetrieved(typeface); 
      return typeface;
    } 
    if (paramBoolean && paramInt1 == -1) {
      typefaceResult = getFontInternal(paramContext, request, style);
      if (fontCallback != null)
        if (typefaceResult.mResult == 0) {
          fontCallback.callbackSuccessAsync(typefaceResult.mTypeface, handler);
        } else {
          fontCallback.callbackFailAsync(typefaceResult.mResult, handler);
        }  
      return typefaceResult.mTypeface;
    } 
    Callable<TypefaceResult> callable = new Callable<TypefaceResult>() {
        public FontsContractCompat.TypefaceResult call() throws Exception {
          FontsContractCompat.TypefaceResult typefaceResult = FontsContractCompat.getFontInternal(context, request, style);
          if (typefaceResult.mTypeface != null)
            FontsContractCompat.sTypefaceCache.put(id, typefaceResult.mTypeface); 
          return typefaceResult;
        }
      };
    if (paramBoolean)
      try {
        return ((TypefaceResult)sBackgroundThread.postAndWait((Callable)callable, paramInt1)).mTypeface;
      } catch (InterruptedException interruptedException) {
        return null;
      }  
    if (fontCallback == null) {
      typefaceResult = null;
    } else {
      null = new SelfDestructiveThread.ReplyCallback<TypefaceResult>() {
          public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
            if (param1TypefaceResult == null) {
              fontCallback.callbackFailAsync(1, handler);
            } else if (param1TypefaceResult.mResult == 0) {
              fontCallback.callbackSuccessAsync(param1TypefaceResult.mTypeface, handler);
            } else {
              fontCallback.callbackFailAsync(param1TypefaceResult.mResult, handler);
            } 
          }
        };
    } 
    synchronized (sLock) {
      ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = (ArrayList)sPendingReplies.get(str);
      if (arrayList != null) {
        if (null != null)
          arrayList.add(null); 
        return null;
      } 
      if (null != null) {
        arrayList = new ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>();
        this();
        arrayList.add(null);
        sPendingReplies.put(str, arrayList);
      } 
      sBackgroundThread.postAndReply(callable, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() {
            public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
              synchronized (FontsContractCompat.sLock) {
                ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>> arrayList = (ArrayList)FontsContractCompat.sPendingReplies.get(id);
                if (arrayList == null)
                  return; 
                FontsContractCompat.sPendingReplies.remove(id);
                for (byte b = 0; b < arrayList.size(); b++)
                  ((SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>)arrayList.get(b)).onReply(param1TypefaceResult); 
                return;
              } 
            }
          });
      return null;
    } 
  }
  
  @Nullable
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  public static ProviderInfo getProvider(@NonNull PackageManager paramPackageManager, @NonNull FontRequest paramFontRequest, @Nullable Resources paramResources) throws PackageManager.NameNotFoundException {
    String str = paramFontRequest.getProviderAuthority();
    byte b = 0;
    ProviderInfo providerInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (providerInfo != null) {
      List<List<byte[]>> list;
      if (providerInfo.packageName.equals(paramFontRequest.getProviderPackage())) {
        List<byte[]> list1 = convertToByteArrayList((paramPackageManager.getPackageInfo(providerInfo.packageName, 64)).signatures);
        Collections.sort((List)list1, (Comparator)sByteArrayComparator);
        list = getCertificates(paramFontRequest, paramResources);
        while (b < list.size()) {
          ArrayList<byte> arrayList = new ArrayList(list.get(b));
          Collections.sort(arrayList, (Comparator)sByteArrayComparator);
          if (equalsByteArrayList(list1, (List)arrayList))
            return providerInfo; 
          b++;
        } 
        return null;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Found content provider ");
      stringBuilder1.append(str);
      stringBuilder1.append(", but package was not ");
      stringBuilder1.append(list.getProviderPackage());
      throw new PackageManager.NameNotFoundException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package found for authority: ");
    stringBuilder.append(str);
    throw new PackageManager.NameNotFoundException(stringBuilder.toString());
  }
  
  @RequiresApi(19)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramArrayOfFontInfo.length;
    for (byte b = 0; b < i; b++) {
      FontInfo fontInfo = paramArrayOfFontInfo[b];
      if (fontInfo.getResultCode() == 0) {
        Uri uri = fontInfo.getUri();
        if (!hashMap.containsKey(uri))
          hashMap.put(uri, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri)); 
      } 
    } 
    return (Map)Collections.unmodifiableMap(hashMap);
  }
  
  public static void requestFont(@NonNull Context paramContext, @NonNull FontRequest paramFontRequest, @NonNull FontRequestCallback paramFontRequestCallback, @NonNull Handler paramHandler) {
    requestFontInternal(paramContext.getApplicationContext(), paramFontRequest, paramFontRequestCallback, paramHandler);
  }
  
  private static void requestFontInternal(@NonNull final Context appContext, @NonNull final FontRequest request, @NonNull final FontRequestCallback callback, @NonNull Handler paramHandler) {
    paramHandler.post(new Runnable() {
          public void run() {
            try {
              FontsContractCompat.FontFamilyResult fontFamilyResult = FontsContractCompat.fetchFonts(appContext, null, request);
              if (fontFamilyResult.getStatusCode() != 0) {
                switch (fontFamilyResult.getStatusCode()) {
                  default:
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  case 2:
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  case 1:
                    break;
                } 
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(-2);
                      }
                    });
                return;
              } 
              FontsContractCompat.FontInfo[] arrayOfFontInfo = fontFamilyResult.getFonts();
              if (arrayOfFontInfo == null || arrayOfFontInfo.length == 0) {
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(1);
                      }
                    });
                return;
              } 
              int i = arrayOfFontInfo.length;
              for (final int resultCode = 0; j < i; j++) {
                FontsContractCompat.FontInfo fontInfo = arrayOfFontInfo[j];
                if (fontInfo.getResultCode() != 0) {
                  j = fontInfo.getResultCode();
                  if (j < 0) {
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(-3);
                          }
                        });
                  } else {
                    callerThreadHandler.post(new Runnable() {
                          public void run() {
                            callback.onTypefaceRequestFailed(resultCode);
                          }
                        });
                  } 
                  return;
                } 
              } 
              final Typeface typeface = FontsContractCompat.buildTypeface(appContext, null, arrayOfFontInfo);
              if (typeface == null) {
                callerThreadHandler.post(new Runnable() {
                      public void run() {
                        callback.onTypefaceRequestFailed(-3);
                      }
                    });
                return;
              } 
              callerThreadHandler.post(new Runnable() {
                    public void run() {
                      callback.onTypefaceRetrieved(typeface);
                    }
                  });
              return;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
              callerThreadHandler.post(new Runnable() {
                    public void run() {
                      callback.onTypefaceRequestFailed(-1);
                    }
                  });
              return;
            } 
          }
        });
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static void resetCache() {
    sTypefaceCache.evictAll();
  }
  
  public static final class Columns implements BaseColumns {
    public static final String FILE_ID = "file_id";
    
    public static final String ITALIC = "font_italic";
    
    public static final String RESULT_CODE = "result_code";
    
    public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
    
    public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
    
    public static final int RESULT_CODE_MALFORMED_QUERY = 3;
    
    public static final int RESULT_CODE_OK = 0;
    
    public static final String TTC_INDEX = "font_ttc_index";
    
    public static final String VARIATION_SETTINGS = "font_variation_settings";
    
    public static final String WEIGHT = "font_weight";
  }
  
  public static class FontFamilyResult {
    public static final int STATUS_OK = 0;
    
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    
    private final FontsContractCompat.FontInfo[] mFonts;
    
    private final int mStatusCode;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FontFamilyResult(int param1Int, @Nullable FontsContractCompat.FontInfo[] param1ArrayOfFontInfo) {
      this.mStatusCode = param1Int;
      this.mFonts = param1ArrayOfFontInfo;
    }
    
    public FontsContractCompat.FontInfo[] getFonts() {
      return this.mFonts;
    }
    
    public int getStatusCode() {
      return this.mStatusCode;
    }
  }
  
  public static class FontInfo {
    private final boolean mItalic;
    
    private final int mResultCode;
    
    private final int mTtcIndex;
    
    private final Uri mUri;
    
    private final int mWeight;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FontInfo(@NonNull Uri param1Uri, @IntRange(from = 0L) int param1Int1, @IntRange(from = 1L, to = 1000L) int param1Int2, boolean param1Boolean, int param1Int3) {
      this.mUri = (Uri)Preconditions.checkNotNull(param1Uri);
      this.mTtcIndex = param1Int1;
      this.mWeight = param1Int2;
      this.mItalic = param1Boolean;
      this.mResultCode = param1Int3;
    }
    
    public int getResultCode() {
      return this.mResultCode;
    }
    
    @IntRange(from = 0L)
    public int getTtcIndex() {
      return this.mTtcIndex;
    }
    
    @NonNull
    public Uri getUri() {
      return this.mUri;
    }
    
    @IntRange(from = 1L, to = 1000L)
    public int getWeight() {
      return this.mWeight;
    }
    
    public boolean isItalic() {
      return this.mItalic;
    }
  }
  
  public static class FontRequestCallback {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    
    public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
    
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int RESULT_OK = 0;
    
    public void onTypefaceRequestFailed(int param1Int) {}
    
    public void onTypefaceRetrieved(Typeface param1Typeface) {}
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static @interface FontRequestFailReason {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface FontRequestFailReason {}
  
  private static final class TypefaceResult {
    final int mResult;
    
    final Typeface mTypeface;
    
    TypefaceResult(@Nullable Typeface param1Typeface, int param1Int) {
      this.mTypeface = param1Typeface;
      this.mResult = param1Int;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */