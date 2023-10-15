package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt) {
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int i = arrayOfFontFileResourceEntry.length;
    boolean bool = false;
    paramContext = null;
    char c = Character.MIN_VALUE;
    while (true) {
      FontFamily.Builder builder;
      boolean bool1 = true;
      if (c < i) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = arrayOfFontFileResourceEntry[c];
        try {
          Font.Builder builder1 = new Font.Builder();
          this(paramResources, fontFileResourceEntry.getResourceId());
          builder1 = builder1.setWeight(fontFileResourceEntry.getWeight());
          if (!fontFileResourceEntry.isItalic())
            bool1 = false; 
          Font font = builder1.setSlant(bool1).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
          if (paramContext == null) {
            FontFamily.Builder builder2 = new FontFamily.Builder();
            this(font);
            builder = builder2;
          } else {
            builder.addFont(font);
          } 
        } catch (IOException iOException) {}
        c++;
        continue;
      } 
      if (builder == null)
        return null; 
      if ((paramInt & 0x1) != 0) {
        c = 'ʼ';
      } else {
        c = 'Ɛ';
      } 
      bool1 = bool;
      if ((paramInt & 0x2) != 0)
        bool1 = true; 
      FontStyle fontStyle = new FontStyle(c, bool1);
      return (new Typeface.CustomFallbackBuilder(builder.build())).setStyle(fontStyle).build();
    } 
  }
  
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore #5
    //   6: aload_3
    //   7: arraylength
    //   8: istore #6
    //   10: iconst_0
    //   11: istore #7
    //   13: aconst_null
    //   14: astore_1
    //   15: iconst_0
    //   16: istore #8
    //   18: iconst_1
    //   19: istore #9
    //   21: iload #8
    //   23: iload #6
    //   25: if_icmpge -> 250
    //   28: aload_3
    //   29: iload #8
    //   31: aaload
    //   32: astore #10
    //   34: aload_1
    //   35: astore #11
    //   37: aload #5
    //   39: aload #10
    //   41: invokevirtual getUri : ()Landroid/net/Uri;
    //   44: ldc 'r'
    //   46: aload_2
    //   47: invokevirtual openFileDescriptor : (Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   50: astore #12
    //   52: aload #12
    //   54: ifnonnull -> 79
    //   57: aload_1
    //   58: astore #11
    //   60: aload #12
    //   62: ifnull -> 241
    //   65: aload_1
    //   66: astore #11
    //   68: aload #12
    //   70: invokevirtual close : ()V
    //   73: aload_1
    //   74: astore #11
    //   76: goto -> 241
    //   79: new android/graphics/fonts/Font$Builder
    //   82: astore #11
    //   84: aload #11
    //   86: aload #12
    //   88: invokespecial <init> : (Landroid/os/ParcelFileDescriptor;)V
    //   91: aload #11
    //   93: aload #10
    //   95: invokevirtual getWeight : ()I
    //   98: invokevirtual setWeight : (I)Landroid/graphics/fonts/Font$Builder;
    //   101: astore #11
    //   103: aload #10
    //   105: invokevirtual isItalic : ()Z
    //   108: ifeq -> 114
    //   111: goto -> 117
    //   114: iconst_0
    //   115: istore #9
    //   117: aload #11
    //   119: iload #9
    //   121: invokevirtual setSlant : (I)Landroid/graphics/fonts/Font$Builder;
    //   124: aload #10
    //   126: invokevirtual getTtcIndex : ()I
    //   129: invokevirtual setTtcIndex : (I)Landroid/graphics/fonts/Font$Builder;
    //   132: invokevirtual build : ()Landroid/graphics/fonts/Font;
    //   135: astore #11
    //   137: aload_1
    //   138: ifnonnull -> 158
    //   141: new android/graphics/fonts/FontFamily$Builder
    //   144: dup
    //   145: aload #11
    //   147: invokespecial <init> : (Landroid/graphics/fonts/Font;)V
    //   150: astore #11
    //   152: aload #11
    //   154: astore_1
    //   155: goto -> 165
    //   158: aload_1
    //   159: aload #11
    //   161: invokevirtual addFont : (Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   164: pop
    //   165: aload_1
    //   166: astore #11
    //   168: aload #12
    //   170: ifnull -> 241
    //   173: goto -> 65
    //   176: astore #10
    //   178: aconst_null
    //   179: astore #13
    //   181: goto -> 191
    //   184: astore #13
    //   186: aload #13
    //   188: athrow
    //   189: astore #10
    //   191: aload #12
    //   193: ifnull -> 235
    //   196: aload #13
    //   198: ifnull -> 227
    //   201: aload_1
    //   202: astore #11
    //   204: aload #12
    //   206: invokevirtual close : ()V
    //   209: goto -> 235
    //   212: astore #12
    //   214: aload_1
    //   215: astore #11
    //   217: aload #13
    //   219: aload #12
    //   221: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
    //   224: goto -> 235
    //   227: aload_1
    //   228: astore #11
    //   230: aload #12
    //   232: invokevirtual close : ()V
    //   235: aload_1
    //   236: astore #11
    //   238: aload #10
    //   240: athrow
    //   241: iinc #8, 1
    //   244: aload #11
    //   246: astore_1
    //   247: goto -> 18
    //   250: aload_1
    //   251: ifnonnull -> 256
    //   254: aconst_null
    //   255: areturn
    //   256: iload #4
    //   258: iconst_1
    //   259: iand
    //   260: ifeq -> 271
    //   263: sipush #700
    //   266: istore #8
    //   268: goto -> 276
    //   271: sipush #400
    //   274: istore #8
    //   276: iload #7
    //   278: istore #9
    //   280: iload #4
    //   282: iconst_2
    //   283: iand
    //   284: ifeq -> 290
    //   287: iconst_1
    //   288: istore #9
    //   290: new android/graphics/fonts/FontStyle
    //   293: dup
    //   294: iload #8
    //   296: iload #9
    //   298: invokespecial <init> : (II)V
    //   301: astore_2
    //   302: new android/graphics/Typeface$CustomFallbackBuilder
    //   305: dup
    //   306: aload_1
    //   307: invokevirtual build : ()Landroid/graphics/fonts/FontFamily;
    //   310: invokespecial <init> : (Landroid/graphics/fonts/FontFamily;)V
    //   313: aload_2
    //   314: invokevirtual setStyle : (Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   317: invokevirtual build : ()Landroid/graphics/Typeface;
    //   320: areturn
    //   321: astore_1
    //   322: goto -> 241
    // Exception table:
    //   from	to	target	type
    //   37	52	321	java/io/IOException
    //   68	73	321	java/io/IOException
    //   79	111	184	java/lang/Throwable
    //   79	111	176	finally
    //   117	137	184	java/lang/Throwable
    //   117	137	176	finally
    //   141	152	184	java/lang/Throwable
    //   141	152	176	finally
    //   158	165	184	java/lang/Throwable
    //   158	165	176	finally
    //   186	189	189	finally
    //   204	209	212	java/lang/Throwable
    //   204	209	321	java/io/IOException
    //   217	224	321	java/io/IOException
    //   230	235	321	java/io/IOException
    //   238	241	321	java/io/IOException
  }
  
  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream) {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2) {
    try {
      FontFamily.Builder builder1 = new FontFamily.Builder();
      Font.Builder builder = new Font.Builder();
      this(paramResources, paramInt1);
      this(builder.build());
      FontFamily fontFamily = builder1.build();
      if ((paramInt2 & 0x1) != 0) {
        paramInt1 = 700;
      } else {
        paramInt1 = 400;
      } 
      if ((paramInt2 & 0x2) != 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      } 
      FontStyle fontStyle = new FontStyle(paramInt1, paramInt2);
      return (new Typeface.CustomFallbackBuilder(fontFamily)).setStyle(fontStyle).build();
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt) {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\TypefaceCompatApi29Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */