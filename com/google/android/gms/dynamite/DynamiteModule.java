package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class DynamiteModule {
  @KeepForSdk
  public static final int LOCAL = -1;
  
  @KeepForSdk
  public static final int NONE = 0;
  
  @KeepForSdk
  public static final int NO_SELECTION = 0;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_LOCAL;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE;
  
  @NonNull
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
  
  @KeepForSdk
  public static final int REMOTE = 1;
  
  @NonNull
  public static final VersionPolicy zza;
  
  @Nullable
  @GuardedBy("DynamiteModule.class")
  private static Boolean zzb;
  
  @Nullable
  @GuardedBy("DynamiteModule.class")
  private static String zzc;
  
  @GuardedBy("DynamiteModule.class")
  private static boolean zzd = false;
  
  @GuardedBy("DynamiteModule.class")
  private static int zze = -1;
  
  @Nullable
  @GuardedBy("DynamiteModule.class")
  private static Boolean zzf;
  
  private static final ThreadLocal zzg = new ThreadLocal();
  
  private static final ThreadLocal zzh = new zzd();
  
  private static final VersionPolicy.IVersions zzi = new zze();
  
  @Nullable
  @GuardedBy("DynamiteModule.class")
  private static zzq zzk;
  
  @Nullable
  @GuardedBy("DynamiteModule.class")
  private static zzr zzl;
  
  private final Context zzj;
  
  static {
    PREFER_REMOTE = new zzf();
    PREFER_LOCAL = new zzg();
    PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    zza = new zzl();
  }
  
  private DynamiteModule(Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    this.zzj = paramContext;
  }
  
  @KeepForSdk
  public static int getLocalVersion(@NonNull Context paramContext, @NonNull String paramString) {
    try {
      String str;
      ClassLoader classLoader = paramContext.getApplicationContext().getClassLoader();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("com.google.android.gms.dynamite.descriptors.");
      stringBuilder.append(paramString);
      stringBuilder.append(".ModuleDescriptor");
      Class<?> clazz = classLoader.loadClass(stringBuilder.toString());
      Field field1 = clazz.getDeclaredField("MODULE_ID");
      Field field2 = clazz.getDeclaredField("MODULE_VERSION");
      if (!Objects.equal(field1.get(null), paramString)) {
        str = String.valueOf(field1.get(null));
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("Module descriptor id '");
        stringBuilder1.append(str);
        stringBuilder1.append("' didn't match expected id '");
        stringBuilder1.append(paramString);
        stringBuilder1.append("'");
        Log.e("DynamiteModule", stringBuilder1.toString());
        return 0;
      } 
      return str.getInt(null);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Local module descriptor class for ");
      stringBuilder.append(paramString);
      stringBuilder.append(" not found.");
      Log.w("DynamiteModule", stringBuilder.toString());
    } catch (Exception exception) {
      Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(exception.getMessage())));
    } 
    return 0;
  }
  
  @KeepForSdk
  public static int getRemoteVersion(@NonNull Context paramContext, @NonNull String paramString) {
    return zza(paramContext, paramString, false);
  }
  
  @NonNull
  @KeepForSdk
  public static DynamiteModule load(@NonNull Context paramContext, @NonNull VersionPolicy paramVersionPolicy, @NonNull String paramString) throws LoadingException {
    // Byte code:
    //   0: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   3: invokevirtual get : ()Ljava/lang/Object;
    //   6: checkcast com/google/android/gms/dynamite/zzn
    //   9: astore_3
    //   10: new com/google/android/gms/dynamite/zzn
    //   13: dup
    //   14: aconst_null
    //   15: invokespecial <init> : (Lcom/google/android/gms/dynamite/zzm;)V
    //   18: astore #4
    //   20: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   23: aload #4
    //   25: invokevirtual set : (Ljava/lang/Object;)V
    //   28: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   31: invokevirtual get : ()Ljava/lang/Object;
    //   34: checkcast java/lang/Long
    //   37: invokevirtual longValue : ()J
    //   40: lstore #5
    //   42: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   45: invokestatic elapsedRealtime : ()J
    //   48: invokestatic valueOf : (J)Ljava/lang/Long;
    //   51: invokevirtual set : (Ljava/lang/Object;)V
    //   54: aload_1
    //   55: aload_0
    //   56: aload_2
    //   57: getstatic com/google/android/gms/dynamite/DynamiteModule.zzi : Lcom/google/android/gms/dynamite/DynamiteModule$VersionPolicy$IVersions;
    //   60: invokeinterface selectModule : (Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/dynamite/DynamiteModule$VersionPolicy$IVersions;)Lcom/google/android/gms/dynamite/DynamiteModule$VersionPolicy$SelectionResult;
    //   65: astore #7
    //   67: aload #7
    //   69: getfield localVersion : I
    //   72: istore #8
    //   74: aload #7
    //   76: getfield remoteVersion : I
    //   79: istore #9
    //   81: new java/lang/StringBuilder
    //   84: astore #10
    //   86: aload #10
    //   88: invokespecial <init> : ()V
    //   91: aload #10
    //   93: ldc_w 'Considering local module '
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #10
    //   102: aload_2
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #10
    //   109: ldc_w ':'
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #10
    //   118: iload #8
    //   120: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #10
    //   126: ldc_w ' and remote module '
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #10
    //   135: aload_2
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload #10
    //   142: ldc_w ':'
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #10
    //   151: iload #9
    //   153: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 'DynamiteModule'
    //   159: aload #10
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: aload #7
    //   170: getfield selection : I
    //   173: istore #8
    //   175: iload #8
    //   177: ifeq -> 1227
    //   180: iload #8
    //   182: istore #9
    //   184: iload #8
    //   186: iconst_m1
    //   187: if_icmpne -> 201
    //   190: aload #7
    //   192: getfield localVersion : I
    //   195: ifeq -> 1227
    //   198: iconst_m1
    //   199: istore #9
    //   201: iload #9
    //   203: iconst_1
    //   204: if_icmpne -> 215
    //   207: aload #7
    //   209: getfield remoteVersion : I
    //   212: ifeq -> 1227
    //   215: iload #9
    //   217: iconst_m1
    //   218: if_icmpne -> 283
    //   221: aload_0
    //   222: aload_2
    //   223: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   226: astore_1
    //   227: lload #5
    //   229: lconst_0
    //   230: lcmp
    //   231: ifne -> 243
    //   234: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   237: invokevirtual remove : ()V
    //   240: goto -> 254
    //   243: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   246: lload #5
    //   248: invokestatic valueOf : (J)Ljava/lang/Long;
    //   251: invokevirtual set : (Ljava/lang/Object;)V
    //   254: aload #4
    //   256: getfield zza : Landroid/database/Cursor;
    //   259: astore_2
    //   260: aload_1
    //   261: astore_0
    //   262: aload_2
    //   263: ifnull -> 274
    //   266: aload_1
    //   267: astore_0
    //   268: aload_2
    //   269: invokeinterface close : ()V
    //   274: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   277: aload_3
    //   278: invokevirtual set : (Ljava/lang/Object;)V
    //   281: aload_0
    //   282: areturn
    //   283: iload #9
    //   285: iconst_1
    //   286: if_icmpne -> 1189
    //   289: aload #7
    //   291: getfield remoteVersion : I
    //   294: istore #8
    //   296: ldc com/google/android/gms/dynamite/DynamiteModule
    //   298: monitorenter
    //   299: aload_0
    //   300: invokestatic zzf : (Landroid/content/Context;)Z
    //   303: ifeq -> 955
    //   306: getstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Ljava/lang/Boolean;
    //   309: astore #10
    //   311: ldc com/google/android/gms/dynamite/DynamiteModule
    //   313: monitorexit
    //   314: aload #10
    //   316: ifnull -> 938
    //   319: aload #10
    //   321: invokevirtual booleanValue : ()Z
    //   324: ifeq -> 632
    //   327: new java/lang/StringBuilder
    //   330: astore #10
    //   332: aload #10
    //   334: invokespecial <init> : ()V
    //   337: aload #10
    //   339: ldc_w 'Selected remote version of '
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload #10
    //   348: aload_2
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #10
    //   355: ldc_w ', version >= '
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #10
    //   364: iload #8
    //   366: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: ldc 'DynamiteModule'
    //   372: aload #10
    //   374: invokevirtual toString : ()Ljava/lang/String;
    //   377: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   380: pop
    //   381: ldc com/google/android/gms/dynamite/DynamiteModule
    //   383: monitorenter
    //   384: getstatic com/google/android/gms/dynamite/DynamiteModule.zzl : Lcom/google/android/gms/dynamite/zzr;
    //   387: astore #10
    //   389: ldc com/google/android/gms/dynamite/DynamiteModule
    //   391: monitorexit
    //   392: aload #10
    //   394: ifnull -> 607
    //   397: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   400: invokevirtual get : ()Ljava/lang/Object;
    //   403: checkcast com/google/android/gms/dynamite/zzn
    //   406: astore #11
    //   408: aload #11
    //   410: ifnull -> 590
    //   413: aload #11
    //   415: getfield zza : Landroid/database/Cursor;
    //   418: ifnull -> 590
    //   421: aload_0
    //   422: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   425: astore #12
    //   427: aload #11
    //   429: getfield zza : Landroid/database/Cursor;
    //   432: astore #11
    //   434: aconst_null
    //   435: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   438: pop
    //   439: ldc com/google/android/gms/dynamite/DynamiteModule
    //   441: monitorenter
    //   442: getstatic com/google/android/gms/dynamite/DynamiteModule.zze : I
    //   445: iconst_2
    //   446: if_icmplt -> 455
    //   449: iconst_1
    //   450: istore #13
    //   452: goto -> 458
    //   455: iconst_0
    //   456: istore #13
    //   458: ldc com/google/android/gms/dynamite/DynamiteModule
    //   460: monitorexit
    //   461: iload #13
    //   463: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   466: invokevirtual booleanValue : ()Z
    //   469: ifeq -> 504
    //   472: ldc 'DynamiteModule'
    //   474: ldc_w 'Dynamite loader version >= 2, using loadModule2NoCrashUtils'
    //   477: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   480: pop
    //   481: aload #10
    //   483: aload #12
    //   485: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   488: aload_2
    //   489: iload #8
    //   491: aload #11
    //   493: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   496: invokevirtual zzf : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   499: astore #10
    //   501: goto -> 533
    //   504: ldc 'DynamiteModule'
    //   506: ldc_w 'Dynamite loader version < 2, falling back to loadModule2'
    //   509: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   512: pop
    //   513: aload #10
    //   515: aload #12
    //   517: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   520: aload_2
    //   521: iload #8
    //   523: aload #11
    //   525: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   528: invokevirtual zze : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   531: astore #10
    //   533: aload #10
    //   535: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   538: checkcast android/content/Context
    //   541: astore #10
    //   543: aload #10
    //   545: ifnull -> 565
    //   548: new com/google/android/gms/dynamite/DynamiteModule
    //   551: dup
    //   552: aload #10
    //   554: invokespecial <init> : (Landroid/content/Context;)V
    //   557: astore #10
    //   559: aload #10
    //   561: astore_0
    //   562: goto -> 852
    //   565: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   568: astore #10
    //   570: aload #10
    //   572: ldc_w 'Failed to get module context'
    //   575: aconst_null
    //   576: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   579: aload #10
    //   581: athrow
    //   582: astore #10
    //   584: ldc com/google/android/gms/dynamite/DynamiteModule
    //   586: monitorexit
    //   587: aload #10
    //   589: athrow
    //   590: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   593: astore #10
    //   595: aload #10
    //   597: ldc_w 'No result cursor'
    //   600: aconst_null
    //   601: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   604: aload #10
    //   606: athrow
    //   607: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   610: astore #10
    //   612: aload #10
    //   614: ldc_w 'DynamiteLoaderV2 was not cached.'
    //   617: aconst_null
    //   618: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   621: aload #10
    //   623: athrow
    //   624: astore #10
    //   626: ldc com/google/android/gms/dynamite/DynamiteModule
    //   628: monitorexit
    //   629: aload #10
    //   631: athrow
    //   632: new java/lang/StringBuilder
    //   635: astore #10
    //   637: aload #10
    //   639: invokespecial <init> : ()V
    //   642: aload #10
    //   644: ldc_w 'Selected remote version of '
    //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload #10
    //   653: aload_2
    //   654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload #10
    //   660: ldc_w ', version >= '
    //   663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload #10
    //   669: iload #8
    //   671: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: ldc 'DynamiteModule'
    //   677: aload #10
    //   679: invokevirtual toString : ()Ljava/lang/String;
    //   682: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   685: pop
    //   686: aload_0
    //   687: invokestatic zzg : (Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzq;
    //   690: astore #10
    //   692: aload #10
    //   694: ifnull -> 921
    //   697: aload #10
    //   699: invokevirtual zze : ()I
    //   702: istore #9
    //   704: iload #9
    //   706: iconst_3
    //   707: if_icmplt -> 768
    //   710: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   713: invokevirtual get : ()Ljava/lang/Object;
    //   716: checkcast com/google/android/gms/dynamite/zzn
    //   719: astore #12
    //   721: aload #12
    //   723: ifnull -> 751
    //   726: aload #10
    //   728: aload_0
    //   729: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   732: aload_2
    //   733: iload #8
    //   735: aload #12
    //   737: getfield zza : Landroid/database/Cursor;
    //   740: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   743: invokevirtual zzi : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   746: astore #10
    //   748: goto -> 823
    //   751: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   754: astore #10
    //   756: aload #10
    //   758: ldc_w 'No cached result cursor holder'
    //   761: aconst_null
    //   762: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   765: aload #10
    //   767: athrow
    //   768: iload #9
    //   770: iconst_2
    //   771: if_icmpne -> 800
    //   774: ldc 'DynamiteModule'
    //   776: ldc_w 'IDynamite loader version = 2'
    //   779: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   782: pop
    //   783: aload #10
    //   785: aload_0
    //   786: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   789: aload_2
    //   790: iload #8
    //   792: invokevirtual zzj : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   795: astore #10
    //   797: goto -> 823
    //   800: ldc 'DynamiteModule'
    //   802: ldc_w 'Dynamite loader version < 2, falling back to createModuleContext'
    //   805: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   808: pop
    //   809: aload #10
    //   811: aload_0
    //   812: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   815: aload_2
    //   816: iload #8
    //   818: invokevirtual zzh : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   821: astore #10
    //   823: aload #10
    //   825: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   828: astore #10
    //   830: aload #10
    //   832: ifnull -> 904
    //   835: new com/google/android/gms/dynamite/DynamiteModule
    //   838: dup
    //   839: aload #10
    //   841: checkcast android/content/Context
    //   844: invokespecial <init> : (Landroid/content/Context;)V
    //   847: astore #10
    //   849: aload #10
    //   851: astore_0
    //   852: lload #5
    //   854: lconst_0
    //   855: lcmp
    //   856: ifne -> 868
    //   859: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   862: invokevirtual remove : ()V
    //   865: goto -> 879
    //   868: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   871: lload #5
    //   873: invokestatic valueOf : (J)Ljava/lang/Long;
    //   876: invokevirtual set : (Ljava/lang/Object;)V
    //   879: aload #4
    //   881: getfield zza : Landroid/database/Cursor;
    //   884: astore_1
    //   885: aload_1
    //   886: ifnull -> 895
    //   889: aload_1
    //   890: invokeinterface close : ()V
    //   895: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   898: aload_3
    //   899: invokevirtual set : (Ljava/lang/Object;)V
    //   902: aload_0
    //   903: areturn
    //   904: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   907: astore #10
    //   909: aload #10
    //   911: ldc_w 'Failed to load remote module.'
    //   914: aconst_null
    //   915: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   918: aload #10
    //   920: athrow
    //   921: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   924: astore #10
    //   926: aload #10
    //   928: ldc_w 'Failed to create IDynamiteLoader.'
    //   931: aconst_null
    //   932: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   935: aload #10
    //   937: athrow
    //   938: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   941: astore #10
    //   943: aload #10
    //   945: ldc_w 'Failed to determine which loading route to use.'
    //   948: aconst_null
    //   949: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   952: aload #10
    //   954: athrow
    //   955: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   958: astore #10
    //   960: aload #10
    //   962: ldc_w 'Remote loading disabled'
    //   965: aconst_null
    //   966: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   969: aload #10
    //   971: athrow
    //   972: astore #10
    //   974: ldc com/google/android/gms/dynamite/DynamiteModule
    //   976: monitorexit
    //   977: aload #10
    //   979: athrow
    //   980: astore #12
    //   982: aload_0
    //   983: aload #12
    //   985: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   988: pop
    //   989: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   992: astore #10
    //   994: aload #10
    //   996: ldc_w 'Failed to load remote module.'
    //   999: aload #12
    //   1001: aconst_null
    //   1002: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzp;)V
    //   1005: aload #10
    //   1007: athrow
    //   1008: astore #10
    //   1010: aload #10
    //   1012: athrow
    //   1013: astore #10
    //   1015: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1018: astore #12
    //   1020: aload #12
    //   1022: ldc_w 'Failed to load remote module.'
    //   1025: aload #10
    //   1027: aconst_null
    //   1028: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzp;)V
    //   1031: aload #12
    //   1033: athrow
    //   1034: astore #10
    //   1036: aload #10
    //   1038: invokevirtual getMessage : ()Ljava/lang/String;
    //   1041: astore #11
    //   1043: new java/lang/StringBuilder
    //   1046: astore #12
    //   1048: aload #12
    //   1050: invokespecial <init> : ()V
    //   1053: aload #12
    //   1055: ldc_w 'Failed to load remote module: '
    //   1058: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload #12
    //   1064: aload #11
    //   1066: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: ldc 'DynamiteModule'
    //   1072: aload #12
    //   1074: invokevirtual toString : ()Ljava/lang/String;
    //   1077: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   1080: pop
    //   1081: aload #7
    //   1083: getfield localVersion : I
    //   1086: istore #9
    //   1088: iload #9
    //   1090: ifeq -> 1173
    //   1093: new com/google/android/gms/dynamite/zzo
    //   1096: astore #7
    //   1098: aload #7
    //   1100: iload #9
    //   1102: iconst_0
    //   1103: invokespecial <init> : (II)V
    //   1106: aload_1
    //   1107: aload_0
    //   1108: aload_2
    //   1109: aload #7
    //   1111: invokeinterface selectModule : (Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/dynamite/DynamiteModule$VersionPolicy$IVersions;)Lcom/google/android/gms/dynamite/DynamiteModule$VersionPolicy$SelectionResult;
    //   1116: getfield selection : I
    //   1119: iconst_m1
    //   1120: if_icmpne -> 1173
    //   1123: aload_0
    //   1124: aload_2
    //   1125: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   1128: astore_1
    //   1129: lload #5
    //   1131: lconst_0
    //   1132: lcmp
    //   1133: ifne -> 1145
    //   1136: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   1139: invokevirtual remove : ()V
    //   1142: goto -> 1156
    //   1145: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   1148: lload #5
    //   1150: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1153: invokevirtual set : (Ljava/lang/Object;)V
    //   1156: aload #4
    //   1158: getfield zza : Landroid/database/Cursor;
    //   1161: astore_2
    //   1162: aload_1
    //   1163: astore_0
    //   1164: aload_2
    //   1165: ifnull -> 274
    //   1168: aload_1
    //   1169: astore_0
    //   1170: goto -> 268
    //   1173: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1176: astore_0
    //   1177: aload_0
    //   1178: ldc_w 'Remote load failed. No local fallback found.'
    //   1181: aload #10
    //   1183: aconst_null
    //   1184: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzp;)V
    //   1187: aload_0
    //   1188: athrow
    //   1189: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1192: astore_0
    //   1193: new java/lang/StringBuilder
    //   1196: astore_1
    //   1197: aload_1
    //   1198: invokespecial <init> : ()V
    //   1201: aload_1
    //   1202: ldc_w 'VersionPolicy returned invalid code:'
    //   1205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload_1
    //   1210: iload #9
    //   1212: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload_0
    //   1217: aload_1
    //   1218: invokevirtual toString : ()Ljava/lang/String;
    //   1221: aconst_null
    //   1222: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   1225: aload_0
    //   1226: athrow
    //   1227: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1230: astore_0
    //   1231: aload #7
    //   1233: getfield localVersion : I
    //   1236: istore #8
    //   1238: aload #7
    //   1240: getfield remoteVersion : I
    //   1243: istore #9
    //   1245: new java/lang/StringBuilder
    //   1248: astore_1
    //   1249: aload_1
    //   1250: invokespecial <init> : ()V
    //   1253: aload_1
    //   1254: ldc_w 'No acceptable module '
    //   1257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: pop
    //   1261: aload_1
    //   1262: aload_2
    //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload_1
    //   1268: ldc_w ' found. Local version is '
    //   1271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: pop
    //   1275: aload_1
    //   1276: iload #8
    //   1278: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_1
    //   1283: ldc_w ' and remote version is '
    //   1286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload_1
    //   1291: iload #9
    //   1293: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload_1
    //   1298: ldc_w '.'
    //   1301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_0
    //   1306: aload_1
    //   1307: invokevirtual toString : ()Ljava/lang/String;
    //   1310: aconst_null
    //   1311: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   1314: aload_0
    //   1315: athrow
    //   1316: astore_0
    //   1317: goto -> 1321
    //   1320: astore_0
    //   1321: lload #5
    //   1323: lconst_0
    //   1324: lcmp
    //   1325: ifne -> 1337
    //   1328: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   1331: invokevirtual remove : ()V
    //   1334: goto -> 1348
    //   1337: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   1340: lload #5
    //   1342: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1345: invokevirtual set : (Ljava/lang/Object;)V
    //   1348: aload #4
    //   1350: getfield zza : Landroid/database/Cursor;
    //   1353: astore_1
    //   1354: aload_1
    //   1355: ifnull -> 1364
    //   1358: aload_1
    //   1359: invokeinterface close : ()V
    //   1364: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   1367: aload_3
    //   1368: invokevirtual set : (Ljava/lang/Object;)V
    //   1371: aload_0
    //   1372: athrow
    // Exception table:
    //   from	to	target	type
    //   42	175	1320	finally
    //   190	198	1320	finally
    //   207	215	1320	finally
    //   221	227	1320	finally
    //   289	296	1034	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   289	296	1320	finally
    //   296	299	1013	android/os/RemoteException
    //   296	299	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   296	299	980	finally
    //   299	314	972	finally
    //   319	384	1013	android/os/RemoteException
    //   319	384	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   319	384	980	finally
    //   384	392	624	finally
    //   397	408	1013	android/os/RemoteException
    //   397	408	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   397	408	980	finally
    //   413	442	1013	android/os/RemoteException
    //   413	442	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   413	442	980	finally
    //   442	449	582	finally
    //   458	461	582	finally
    //   461	501	1013	android/os/RemoteException
    //   461	501	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   461	501	980	finally
    //   504	533	1013	android/os/RemoteException
    //   504	533	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   504	533	980	finally
    //   533	543	1013	android/os/RemoteException
    //   533	543	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   533	543	980	finally
    //   548	559	1013	android/os/RemoteException
    //   548	559	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   548	559	980	finally
    //   565	582	1013	android/os/RemoteException
    //   565	582	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   565	582	980	finally
    //   584	587	582	finally
    //   587	590	1013	android/os/RemoteException
    //   587	590	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   587	590	980	finally
    //   590	607	1013	android/os/RemoteException
    //   590	607	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   590	607	980	finally
    //   607	624	1013	android/os/RemoteException
    //   607	624	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   607	624	980	finally
    //   626	629	624	finally
    //   629	632	1013	android/os/RemoteException
    //   629	632	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   629	632	980	finally
    //   632	692	1013	android/os/RemoteException
    //   632	692	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   632	692	980	finally
    //   697	704	1013	android/os/RemoteException
    //   697	704	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   697	704	980	finally
    //   710	721	1013	android/os/RemoteException
    //   710	721	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   710	721	980	finally
    //   726	748	1013	android/os/RemoteException
    //   726	748	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   726	748	980	finally
    //   751	768	1013	android/os/RemoteException
    //   751	768	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   751	768	980	finally
    //   774	797	1013	android/os/RemoteException
    //   774	797	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   774	797	980	finally
    //   800	823	1013	android/os/RemoteException
    //   800	823	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   800	823	980	finally
    //   823	830	1013	android/os/RemoteException
    //   823	830	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   823	830	980	finally
    //   835	849	1013	android/os/RemoteException
    //   835	849	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   835	849	980	finally
    //   904	921	1013	android/os/RemoteException
    //   904	921	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   904	921	980	finally
    //   921	938	1013	android/os/RemoteException
    //   921	938	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   921	938	980	finally
    //   938	955	1013	android/os/RemoteException
    //   938	955	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   938	955	980	finally
    //   955	972	972	finally
    //   974	977	972	finally
    //   977	980	1013	android/os/RemoteException
    //   977	980	1008	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   977	980	980	finally
    //   982	1008	1034	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   982	1008	1316	finally
    //   1010	1013	1034	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1010	1013	1316	finally
    //   1015	1034	1034	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   1015	1034	1316	finally
    //   1036	1088	1316	finally
    //   1093	1129	1316	finally
    //   1173	1189	1316	finally
    //   1189	1227	1316	finally
    //   1227	1316	1316	finally
  }
  
  public static int zza(@NonNull Context paramContext, @NonNull String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Ljava/lang/Boolean;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore #4
    //   10: aconst_null
    //   11: astore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: aload_3
    //   17: astore #7
    //   19: aload_3
    //   20: ifnonnull -> 375
    //   23: aload_0
    //   24: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   27: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   30: ldc com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader
    //   32: invokevirtual getName : ()Ljava/lang/String;
    //   35: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   38: ldc_w 'sClassLoader'
    //   41: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   44: astore #8
    //   46: aload #8
    //   48: invokevirtual getDeclaringClass : ()Ljava/lang/Class;
    //   51: astore_3
    //   52: aload_3
    //   53: monitorenter
    //   54: aload #8
    //   56: aconst_null
    //   57: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast java/lang/ClassLoader
    //   63: astore #7
    //   65: aload #7
    //   67: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   70: if_acmpne -> 81
    //   73: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   76: astore #7
    //   78: goto -> 308
    //   81: aload #7
    //   83: ifnull -> 99
    //   86: aload #7
    //   88: invokestatic zzd : (Ljava/lang/ClassLoader;)V
    //   91: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   94: astore #7
    //   96: goto -> 308
    //   99: aload_0
    //   100: invokestatic zzf : (Landroid/content/Context;)Z
    //   103: ifne -> 113
    //   106: aload_3
    //   107: monitorexit
    //   108: ldc com/google/android/gms/dynamite/DynamiteModule
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: getstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Z
    //   116: ifne -> 294
    //   119: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   122: aconst_null
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: istore #9
    //   128: iload #9
    //   130: ifeq -> 136
    //   133: goto -> 294
    //   136: aload_0
    //   137: aload_1
    //   138: iload_2
    //   139: iconst_1
    //   140: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;ZZ)I
    //   143: istore #10
    //   145: getstatic com/google/android/gms/dynamite/DynamiteModule.zzc : Ljava/lang/String;
    //   148: astore #7
    //   150: aload #7
    //   152: ifnull -> 267
    //   155: aload #7
    //   157: invokevirtual isEmpty : ()Z
    //   160: ifeq -> 166
    //   163: goto -> 267
    //   166: invokestatic zza : ()Ljava/lang/ClassLoader;
    //   169: astore #7
    //   171: aload #7
    //   173: ifnull -> 179
    //   176: goto -> 240
    //   179: getstatic android/os/Build$VERSION.SDK_INT : I
    //   182: bipush #29
    //   184: if_icmplt -> 215
    //   187: getstatic com/google/android/gms/dynamite/DynamiteModule.zzc : Ljava/lang/String;
    //   190: astore #7
    //   192: aload #7
    //   194: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: new dalvik/system/DelegateLastClassLoader
    //   201: dup
    //   202: aload #7
    //   204: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   207: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   210: astore #7
    //   212: goto -> 240
    //   215: getstatic com/google/android/gms/dynamite/DynamiteModule.zzc : Ljava/lang/String;
    //   218: astore #7
    //   220: aload #7
    //   222: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: new com/google/android/gms/dynamite/zzc
    //   229: dup
    //   230: aload #7
    //   232: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   235: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   238: astore #7
    //   240: aload #7
    //   242: invokestatic zzd : (Ljava/lang/ClassLoader;)V
    //   245: aload #8
    //   247: aconst_null
    //   248: aload #7
    //   250: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   253: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   256: putstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Ljava/lang/Boolean;
    //   259: aload_3
    //   260: monitorexit
    //   261: ldc com/google/android/gms/dynamite/DynamiteModule
    //   263: monitorexit
    //   264: iload #10
    //   266: ireturn
    //   267: aload_3
    //   268: monitorexit
    //   269: ldc com/google/android/gms/dynamite/DynamiteModule
    //   271: monitorexit
    //   272: iload #10
    //   274: ireturn
    //   275: astore #7
    //   277: aload #8
    //   279: aconst_null
    //   280: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   283: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   286: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   289: astore #7
    //   291: goto -> 308
    //   294: aload #8
    //   296: aconst_null
    //   297: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   300: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   303: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   306: astore #7
    //   308: aload_3
    //   309: monitorexit
    //   310: goto -> 370
    //   313: astore #7
    //   315: aload_3
    //   316: monitorexit
    //   317: aload #7
    //   319: athrow
    //   320: astore #7
    //   322: aload #7
    //   324: invokevirtual toString : ()Ljava/lang/String;
    //   327: astore_3
    //   328: new java/lang/StringBuilder
    //   331: astore #7
    //   333: aload #7
    //   335: invokespecial <init> : ()V
    //   338: aload #7
    //   340: ldc_w 'Failed to load module via V2: '
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload #7
    //   349: aload_3
    //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 'DynamiteModule'
    //   356: aload #7
    //   358: invokevirtual toString : ()Ljava/lang/String;
    //   361: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   368: astore #7
    //   370: aload #7
    //   372: putstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Ljava/lang/Boolean;
    //   375: ldc com/google/android/gms/dynamite/DynamiteModule
    //   377: monitorexit
    //   378: aload #7
    //   380: invokevirtual booleanValue : ()Z
    //   383: istore #9
    //   385: iload #9
    //   387: ifeq -> 444
    //   390: aload_0
    //   391: aload_1
    //   392: iload_2
    //   393: iconst_0
    //   394: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;ZZ)I
    //   397: istore #10
    //   399: iload #10
    //   401: ireturn
    //   402: astore_1
    //   403: aload_1
    //   404: invokevirtual getMessage : ()Ljava/lang/String;
    //   407: astore #7
    //   409: new java/lang/StringBuilder
    //   412: astore_1
    //   413: aload_1
    //   414: invokespecial <init> : ()V
    //   417: aload_1
    //   418: ldc_w 'Failed to retrieve remote module version: '
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: aload #7
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 'DynamiteModule'
    //   434: aload_1
    //   435: invokevirtual toString : ()Ljava/lang/String;
    //   438: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   441: pop
    //   442: iconst_0
    //   443: ireturn
    //   444: aload_0
    //   445: invokestatic zzg : (Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzq;
    //   448: astore #7
    //   450: aload #7
    //   452: ifnonnull -> 462
    //   455: iload #6
    //   457: istore #10
    //   459: goto -> 775
    //   462: aload #7
    //   464: invokevirtual zze : ()I
    //   467: istore #10
    //   469: iload #10
    //   471: iconst_3
    //   472: if_icmplt -> 643
    //   475: getstatic com/google/android/gms/dynamite/DynamiteModule.zzg : Ljava/lang/ThreadLocal;
    //   478: invokevirtual get : ()Ljava/lang/Object;
    //   481: checkcast com/google/android/gms/dynamite/zzn
    //   484: astore_3
    //   485: aload_3
    //   486: ifnull -> 510
    //   489: aload_3
    //   490: getfield zza : Landroid/database/Cursor;
    //   493: astore_3
    //   494: aload_3
    //   495: ifnull -> 510
    //   498: aload_3
    //   499: iconst_0
    //   500: invokeinterface getInt : (I)I
    //   505: istore #10
    //   507: goto -> 775
    //   510: aload #7
    //   512: aload_0
    //   513: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   516: aload_1
    //   517: iload_2
    //   518: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   521: invokevirtual get : ()Ljava/lang/Object;
    //   524: checkcast java/lang/Long
    //   527: invokevirtual longValue : ()J
    //   530: invokevirtual zzk : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ZJ)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   533: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   536: checkcast android/database/Cursor
    //   539: astore_1
    //   540: aload_1
    //   541: ifnull -> 603
    //   544: aload_1
    //   545: invokeinterface moveToFirst : ()Z
    //   550: ifne -> 556
    //   553: goto -> 603
    //   556: aload_1
    //   557: iconst_0
    //   558: invokeinterface getInt : (I)I
    //   563: istore #10
    //   565: aload_1
    //   566: astore #7
    //   568: iload #10
    //   570: ifle -> 588
    //   573: aload_1
    //   574: invokestatic zze : (Landroid/database/Cursor;)Z
    //   577: istore_2
    //   578: aload_1
    //   579: astore #7
    //   581: iload_2
    //   582: ifeq -> 588
    //   585: aconst_null
    //   586: astore #7
    //   588: aload #7
    //   590: ifnull -> 600
    //   593: aload #7
    //   595: invokeinterface close : ()V
    //   600: goto -> 775
    //   603: ldc 'DynamiteModule'
    //   605: ldc_w 'Failed to retrieve remote module version.'
    //   608: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   611: pop
    //   612: iload #6
    //   614: istore #10
    //   616: aload_1
    //   617: ifnull -> 775
    //   620: aload_1
    //   621: invokeinterface close : ()V
    //   626: iload #6
    //   628: istore #10
    //   630: goto -> 775
    //   633: astore #7
    //   635: goto -> 780
    //   638: astore #7
    //   640: goto -> 712
    //   643: iload #10
    //   645: iconst_2
    //   646: if_icmpne -> 674
    //   649: ldc 'DynamiteModule'
    //   651: ldc_w 'IDynamite loader version = 2, no high precision latency measurement.'
    //   654: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   657: pop
    //   658: aload #7
    //   660: aload_0
    //   661: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   664: aload_1
    //   665: iload_2
    //   666: invokevirtual zzg : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;Z)I
    //   669: istore #10
    //   671: goto -> 775
    //   674: ldc 'DynamiteModule'
    //   676: ldc_w 'IDynamite loader version < 2, falling back to getModuleVersion2'
    //   679: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   682: pop
    //   683: aload #7
    //   685: aload_0
    //   686: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   689: aload_1
    //   690: iload_2
    //   691: invokevirtual zzf : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;Z)I
    //   694: istore #10
    //   696: goto -> 775
    //   699: astore #7
    //   701: aload #4
    //   703: astore_1
    //   704: goto -> 780
    //   707: astore #7
    //   709: aload #5
    //   711: astore_1
    //   712: aload #7
    //   714: invokevirtual getMessage : ()Ljava/lang/String;
    //   717: astore #7
    //   719: new java/lang/StringBuilder
    //   722: astore #5
    //   724: aload #5
    //   726: invokespecial <init> : ()V
    //   729: aload #5
    //   731: ldc_w 'Failed to retrieve remote module version: '
    //   734: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload #5
    //   740: aload #7
    //   742: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: ldc 'DynamiteModule'
    //   748: aload #5
    //   750: invokevirtual toString : ()Ljava/lang/String;
    //   753: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   756: pop
    //   757: iload #6
    //   759: istore #10
    //   761: aload_1
    //   762: ifnull -> 775
    //   765: aload_1
    //   766: invokeinterface close : ()V
    //   771: iload #6
    //   773: istore #10
    //   775: iload #10
    //   777: ireturn
    //   778: astore #7
    //   780: aload_1
    //   781: ifnull -> 790
    //   784: aload_1
    //   785: invokeinterface close : ()V
    //   790: aload #7
    //   792: athrow
    //   793: astore_1
    //   794: ldc com/google/android/gms/dynamite/DynamiteModule
    //   796: monitorexit
    //   797: aload_1
    //   798: athrow
    //   799: astore_1
    //   800: aload_0
    //   801: aload_1
    //   802: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   805: pop
    //   806: aload_1
    //   807: athrow
    //   808: astore #7
    //   810: goto -> 91
    // Exception table:
    //   from	to	target	type
    //   0	3	799	finally
    //   3	7	793	finally
    //   23	54	320	java/lang/ClassNotFoundException
    //   23	54	320	java/lang/IllegalAccessException
    //   23	54	320	java/lang/NoSuchFieldException
    //   23	54	793	finally
    //   54	78	313	finally
    //   86	91	808	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   86	91	313	finally
    //   91	96	313	finally
    //   99	108	313	finally
    //   108	111	793	finally
    //   113	128	313	finally
    //   136	150	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   136	150	313	finally
    //   155	163	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   155	163	313	finally
    //   166	171	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   166	171	313	finally
    //   179	212	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   179	212	313	finally
    //   215	240	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   215	240	313	finally
    //   240	259	275	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   240	259	313	finally
    //   259	261	313	finally
    //   261	264	793	finally
    //   267	269	313	finally
    //   269	272	793	finally
    //   277	291	313	finally
    //   294	308	313	finally
    //   308	310	313	finally
    //   315	317	313	finally
    //   317	320	320	java/lang/ClassNotFoundException
    //   317	320	320	java/lang/IllegalAccessException
    //   317	320	320	java/lang/NoSuchFieldException
    //   317	320	793	finally
    //   322	370	793	finally
    //   370	375	793	finally
    //   375	378	793	finally
    //   378	385	799	finally
    //   390	399	402	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   390	399	799	finally
    //   403	442	799	finally
    //   444	450	799	finally
    //   462	469	707	android/os/RemoteException
    //   462	469	699	finally
    //   475	485	707	android/os/RemoteException
    //   475	485	699	finally
    //   489	494	707	android/os/RemoteException
    //   489	494	699	finally
    //   498	507	707	android/os/RemoteException
    //   498	507	699	finally
    //   510	540	707	android/os/RemoteException
    //   510	540	699	finally
    //   544	553	638	android/os/RemoteException
    //   544	553	633	finally
    //   556	565	638	android/os/RemoteException
    //   556	565	633	finally
    //   573	578	638	android/os/RemoteException
    //   573	578	633	finally
    //   593	600	799	finally
    //   603	612	638	android/os/RemoteException
    //   603	612	633	finally
    //   620	626	799	finally
    //   649	671	707	android/os/RemoteException
    //   649	671	699	finally
    //   674	696	707	android/os/RemoteException
    //   674	696	699	finally
    //   712	757	778	finally
    //   765	771	799	finally
    //   784	790	799	finally
    //   790	793	799	finally
    //   794	797	793	finally
    //   797	799	799	finally
  }
  
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2) throws LoadingException {
    // Byte code:
    //   0: getstatic com/google/android/gms/dynamite/DynamiteModule.zzh : Ljava/lang/ThreadLocal;
    //   3: invokevirtual get : ()Ljava/lang/Object;
    //   6: checkcast java/lang/Long
    //   9: invokevirtual longValue : ()J
    //   12: lstore #4
    //   14: aload_0
    //   15: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   18: astore #6
    //   20: ldc_w 'api_force_staging'
    //   23: astore_0
    //   24: iconst_1
    //   25: iload_2
    //   26: if_icmpeq -> 33
    //   29: ldc_w 'api'
    //   32: astore_0
    //   33: new android/net/Uri$Builder
    //   36: astore #7
    //   38: aload #7
    //   40: invokespecial <init> : ()V
    //   43: aload #6
    //   45: aload #7
    //   47: ldc_w 'content'
    //   50: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   53: ldc_w 'com.google.android.gms.chimera'
    //   56: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   59: aload_0
    //   60: invokevirtual path : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   63: aload_1
    //   64: invokevirtual appendPath : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   67: ldc_w 'requestStartTime'
    //   70: lload #4
    //   72: invokestatic valueOf : (J)Ljava/lang/String;
    //   75: invokevirtual appendQueryParameter : (Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   78: invokevirtual build : ()Landroid/net/Uri;
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull -> 282
    //   93: aload_1
    //   94: invokeinterface moveToFirst : ()Z
    //   99: ifeq -> 282
    //   102: iconst_0
    //   103: istore_2
    //   104: iconst_0
    //   105: istore #8
    //   107: iconst_0
    //   108: istore #9
    //   110: aload_1
    //   111: iconst_0
    //   112: invokeinterface getInt : (I)I
    //   117: istore #10
    //   119: aload_1
    //   120: astore_0
    //   121: iload #10
    //   123: ifle -> 235
    //   126: ldc com/google/android/gms/dynamite/DynamiteModule
    //   128: monitorenter
    //   129: aload_1
    //   130: iconst_2
    //   131: invokeinterface getString : (I)Ljava/lang/String;
    //   136: putstatic com/google/android/gms/dynamite/DynamiteModule.zzc : Ljava/lang/String;
    //   139: aload_1
    //   140: ldc_w 'loaderVersion'
    //   143: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   148: istore #11
    //   150: iload #11
    //   152: iflt -> 166
    //   155: aload_1
    //   156: iload #11
    //   158: invokeinterface getInt : (I)I
    //   163: putstatic com/google/android/gms/dynamite/DynamiteModule.zze : I
    //   166: aload_1
    //   167: ldc_w 'disableStandaloneDynamiteLoader2'
    //   170: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   175: istore #11
    //   177: iload #11
    //   179: iflt -> 202
    //   182: iload #9
    //   184: istore_2
    //   185: aload_1
    //   186: iload #11
    //   188: invokeinterface getInt : (I)I
    //   193: ifeq -> 198
    //   196: iconst_1
    //   197: istore_2
    //   198: iload_2
    //   199: putstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Z
    //   202: ldc com/google/android/gms/dynamite/DynamiteModule
    //   204: monitorexit
    //   205: aload_1
    //   206: invokestatic zze : (Landroid/database/Cursor;)Z
    //   209: istore #9
    //   211: aload_1
    //   212: astore_0
    //   213: iload_2
    //   214: istore #8
    //   216: iload #9
    //   218: ifeq -> 235
    //   221: aconst_null
    //   222: astore_0
    //   223: iload_2
    //   224: istore #8
    //   226: goto -> 235
    //   229: astore_0
    //   230: ldc com/google/android/gms/dynamite/DynamiteModule
    //   232: monitorexit
    //   233: aload_0
    //   234: athrow
    //   235: iload_3
    //   236: ifeq -> 269
    //   239: iload #8
    //   241: ifne -> 247
    //   244: goto -> 269
    //   247: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   250: astore_1
    //   251: aload_1
    //   252: ldc_w 'forcing fallback to container DynamiteLoader impl'
    //   255: aconst_null
    //   256: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: goto -> 362
    //   265: astore_1
    //   266: goto -> 334
    //   269: aload_0
    //   270: ifnull -> 279
    //   273: aload_0
    //   274: invokeinterface close : ()V
    //   279: iload #10
    //   281: ireturn
    //   282: ldc 'DynamiteModule'
    //   284: ldc_w 'Failed to retrieve remote module version.'
    //   287: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   290: pop
    //   291: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   294: astore_0
    //   295: aload_0
    //   296: ldc_w 'Failed to connect to dynamite module ContentResolver.'
    //   299: aconst_null
    //   300: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzp;)V
    //   303: aload_0
    //   304: athrow
    //   305: astore #6
    //   307: aload_1
    //   308: astore_0
    //   309: aload #6
    //   311: astore_1
    //   312: goto -> 362
    //   315: astore #6
    //   317: aload_1
    //   318: astore_0
    //   319: aload #6
    //   321: astore_1
    //   322: goto -> 334
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -> 362
    //   331: astore_1
    //   332: aconst_null
    //   333: astore_0
    //   334: aload_1
    //   335: instanceof com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   338: ifeq -> 343
    //   341: aload_1
    //   342: athrow
    //   343: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   346: astore #6
    //   348: aload #6
    //   350: ldc_w 'V2 version check failed'
    //   353: aload_1
    //   354: aconst_null
    //   355: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzp;)V
    //   358: aload #6
    //   360: athrow
    //   361: astore_1
    //   362: aload_0
    //   363: ifnull -> 372
    //   366: aload_0
    //   367: invokeinterface close : ()V
    //   372: aload_1
    //   373: athrow
    // Exception table:
    //   from	to	target	type
    //   0	20	331	java/lang/Exception
    //   0	20	325	finally
    //   33	89	331	java/lang/Exception
    //   33	89	325	finally
    //   93	102	315	java/lang/Exception
    //   93	102	305	finally
    //   110	119	315	java/lang/Exception
    //   110	119	305	finally
    //   126	129	315	java/lang/Exception
    //   126	129	305	finally
    //   129	150	229	finally
    //   155	166	229	finally
    //   166	177	229	finally
    //   185	196	229	finally
    //   198	202	229	finally
    //   202	205	229	finally
    //   205	211	315	java/lang/Exception
    //   205	211	305	finally
    //   230	233	229	finally
    //   233	235	315	java/lang/Exception
    //   233	235	305	finally
    //   247	261	265	java/lang/Exception
    //   247	261	261	finally
    //   282	305	315	java/lang/Exception
    //   282	305	305	finally
    //   334	343	361	finally
    //   343	361	361	finally
  }
  
  private static DynamiteModule zzc(Context paramContext, String paramString) {
    Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(paramString)));
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  @GuardedBy("DynamiteModule.class")
  private static void zzd(ClassLoader paramClassLoader) throws LoadingException {
    try {
      IInterface iInterface;
      IBinder iBinder = paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
      if (iBinder == null) {
        paramClassLoader = null;
      } else {
        iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if (iInterface instanceof zzr) {
          iInterface = iInterface;
        } else {
          iInterface = new zzr(iBinder);
        } 
      } 
      zzl = (zzr)iInterface;
      return;
    } catch (ClassNotFoundException|IllegalAccessException|InstantiationException|java.lang.reflect.InvocationTargetException|NoSuchMethodException classNotFoundException) {
      throw new LoadingException("Failed to instantiate dynamite loader", classNotFoundException, null);
    } 
  }
  
  private static boolean zze(Cursor paramCursor) {
    zzn zzn = zzg.get();
    if (zzn != null && zzn.zza == null) {
      zzn.zza = paramCursor;
      return true;
    } 
    return false;
  }
  
  @GuardedBy("DynamiteModule.class")
  private static boolean zzf(Context paramContext) {
    if (Boolean.TRUE.equals(null))
      return true; 
    if (Boolean.TRUE.equals(zzf))
      return true; 
    Boolean bool = zzf;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool == null) {
      ProviderInfo providerInfo = paramContext.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
      bool1 = bool2;
      if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 10000000) == 0) {
        bool1 = bool2;
        if (providerInfo != null) {
          bool1 = bool2;
          if ("com.google.android.gms".equals(providerInfo.packageName))
            bool1 = true; 
        } 
      } 
      Boolean bool3 = Boolean.valueOf(bool1);
      zzf = bool3;
      bool2 = bool3.booleanValue();
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
        if (providerInfo != null) {
          bool1 = bool2;
          if (providerInfo.applicationInfo != null) {
            bool1 = bool2;
            if ((providerInfo.applicationInfo.flags & 0x81) == 0) {
              Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
              zzd = true;
              bool1 = bool2;
            } 
          } 
        } 
      } 
    } 
    if (!bool1)
      Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled."); 
    return bool1;
  }
  
  @Nullable
  private static zzq zzg(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzk : Lcom/google/android/gms/dynamite/zzq;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 16
    //   11: ldc com/google/android/gms/dynamite/DynamiteModule
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: ldc_w 'com.google.android.gms'
    //   20: iconst_3
    //   21: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   24: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   27: ldc_w 'com.google.android.gms.chimera.container.DynamiteLoaderImpl'
    //   30: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   33: invokevirtual newInstance : ()Ljava/lang/Object;
    //   36: checkcast android/os/IBinder
    //   39: astore_0
    //   40: aload_0
    //   41: ifnonnull -> 49
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -> 83
    //   49: aload_0
    //   50: ldc_w 'com.google.android.gms.dynamite.IDynamiteLoader'
    //   53: invokeinterface queryLocalInterface : (Ljava/lang/String;)Landroid/os/IInterface;
    //   58: astore_1
    //   59: aload_1
    //   60: instanceof com/google/android/gms/dynamite/zzq
    //   63: ifeq -> 74
    //   66: aload_1
    //   67: checkcast com/google/android/gms/dynamite/zzq
    //   70: astore_0
    //   71: goto -> 83
    //   74: new com/google/android/gms/dynamite/zzq
    //   77: dup
    //   78: aload_0
    //   79: invokespecial <init> : (Landroid/os/IBinder;)V
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull -> 134
    //   87: aload_0
    //   88: putstatic com/google/android/gms/dynamite/DynamiteModule.zzk : Lcom/google/android/gms/dynamite/zzq;
    //   91: ldc com/google/android/gms/dynamite/DynamiteModule
    //   93: monitorexit
    //   94: aload_0
    //   95: areturn
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual getMessage : ()Ljava/lang/String;
    //   101: astore_1
    //   102: new java/lang/StringBuilder
    //   105: astore_0
    //   106: aload_0
    //   107: invokespecial <init> : ()V
    //   110: aload_0
    //   111: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 'DynamiteModule'
    //   126: aload_0
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   133: pop
    //   134: ldc com/google/android/gms/dynamite/DynamiteModule
    //   136: monitorexit
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: ldc com/google/android/gms/dynamite/DynamiteModule
    //   142: monitorexit
    //   143: aload_0
    //   144: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	139	finally
    //   11	14	139	finally
    //   16	40	96	java/lang/Exception
    //   16	40	139	finally
    //   49	71	96	java/lang/Exception
    //   49	71	139	finally
    //   74	83	96	java/lang/Exception
    //   74	83	139	finally
    //   87	91	96	java/lang/Exception
    //   87	91	139	finally
    //   91	94	139	finally
    //   97	134	139	finally
    //   134	137	139	finally
    //   140	143	139	finally
  }
  
  @NonNull
  @KeepForSdk
  public Context getModuleContext() {
    return this.zzj;
  }
  
  @NonNull
  @KeepForSdk
  public IBinder instantiate(@NonNull String paramString) throws LoadingException {
    try {
      return (IBinder)this.zzj.getClassLoader().loadClass(paramString).newInstance();
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException classNotFoundException) {
      throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(paramString)), classNotFoundException, null);
    } 
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader {
    @Nullable
    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
  }
  
  @KeepForSdk
  public static class LoadingException extends Exception {}
  
  public static interface VersionPolicy {
    @NonNull
    @KeepForSdk
    SelectionResult selectModule(@NonNull Context param1Context, @NonNull String param1String, @NonNull IVersions param1IVersions) throws DynamiteModule.LoadingException;
    
    @KeepForSdk
    public static interface IVersions {
      int zza(@NonNull Context param2Context, @NonNull String param2String);
      
      int zzb(@NonNull Context param2Context, @NonNull String param2String, boolean param2Boolean) throws DynamiteModule.LoadingException;
    }
    
    @KeepForSdk
    public static class SelectionResult {
      @KeepForSdk
      public int localVersion = 0;
      
      @KeepForSdk
      public int remoteVersion = 0;
      
      @KeepForSdk
      public int selection = 0;
    }
  }
  
  @KeepForSdk
  public static interface IVersions {
    int zza(@NonNull Context param1Context, @NonNull String param1String);
    
    int zzb(@NonNull Context param1Context, @NonNull String param1String, boolean param1Boolean) throws DynamiteModule.LoadingException;
  }
  
  @KeepForSdk
  public static class SelectionResult {
    @KeepForSdk
    public int localVersion = 0;
    
    @KeepForSdk
    public int remoteVersion = 0;
    
    @KeepForSdk
    public int selection = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */