package com.tkyaji.cordova;

import android.net.Uri;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;

public class DecryptResource extends CordovaPlugin {
  private static final String CRYPT_IV = "0Pqcfriahn5MmK/s";
  
  private static final String CRYPT_KEY = "AG7aUKEASdc2yaKoP954jUPI2wF8dPdM";
  
  private static final String[] EXCLUDE_FILES;
  
  private static final String[] INCLUDE_FILES = new String[] { "index\\.html$", "test.*\\.(js|css)$" };
  
  private static final String TAG = "DecryptResource";
  
  static {
    EXCLUDE_FILES = new String[0];
  }
  
  private boolean hasMatch(String paramString, String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (Pattern.compile(paramArrayOfString[b]).matcher(paramString).find())
        return true; 
    } 
    return false;
  }
  
  private boolean isCryptFiles(String paramString) {
    paramString = paramString.replace("file:///android_asset/www/", "");
    return !hasMatch(paramString, INCLUDE_FILES) ? false : (!hasMatch(paramString, EXCLUDE_FILES));
  }
  
  public CordovaResourceApi.OpenForReadResult handleOpenForRead(Uri paramUri) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual fromPluginUri : (Landroid/net/Uri;)Landroid/net/Uri;
    //   5: invokevirtual toString : ()Ljava/lang/String;
    //   8: ldc '/+++/'
    //   10: ldc '/'
    //   12: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   15: ldc '\?'
    //   17: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   20: iconst_0
    //   21: aaload
    //   22: astore_2
    //   23: aload_0
    //   24: getfield webView : Lorg/apache/cordova/CordovaWebView;
    //   27: invokeinterface getResourceApi : ()Lorg/apache/cordova/CordovaResourceApi;
    //   32: aload_2
    //   33: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   36: iconst_1
    //   37: invokevirtual openForRead : (Landroid/net/Uri;Z)Lorg/apache/cordova/CordovaResourceApi$OpenForReadResult;
    //   40: astore_3
    //   41: aload_0
    //   42: aload_2
    //   43: invokespecial isCryptFiles : (Ljava/lang/String;)Z
    //   46: ifne -> 51
    //   49: aload_3
    //   50: areturn
    //   51: new java/io/BufferedReader
    //   54: dup
    //   55: new java/io/InputStreamReader
    //   58: dup
    //   59: aload_3
    //   60: getfield inputStream : Ljava/io/InputStream;
    //   63: invokespecial <init> : (Ljava/io/InputStream;)V
    //   66: invokespecial <init> : (Ljava/io/Reader;)V
    //   69: astore_1
    //   70: new java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #4
    //   79: aload_1
    //   80: invokevirtual readLine : ()Ljava/lang/String;
    //   83: astore #5
    //   85: aload #5
    //   87: ifnull -> 101
    //   90: aload #4
    //   92: aload #5
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: goto -> 79
    //   101: aload_1
    //   102: invokevirtual close : ()V
    //   105: aload #4
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: iconst_0
    //   111: invokestatic decode : (Ljava/lang/String;I)[B
    //   114: astore_1
    //   115: new java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore #4
    //   124: aload #4
    //   126: ldc 'decrypt: '
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload #4
    //   134: aload_2
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 'DecryptResource'
    //   141: aload #4
    //   143: invokevirtual toString : ()Ljava/lang/String;
    //   146: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   149: new javax/crypto/spec/SecretKeySpec
    //   152: astore #5
    //   154: aload #5
    //   156: ldc '0Pqcfriahn5MmK/s0Pqcfriahn5MmK/s'
    //   158: ldc 'UTF-8'
    //   160: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   163: ldc 'AES'
    //   165: invokespecial <init> : ([BLjava/lang/String;)V
    //   168: ldc 'AES/CBC/PKCS5Padding'
    //   170: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   173: astore_2
    //   174: new javax/crypto/spec/IvParameterSpec
    //   177: astore #4
    //   179: aload #4
    //   181: ldc '0Pqcfriahn5MmK/s'
    //   183: ldc 'UTF-8'
    //   185: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   188: invokespecial <init> : ([B)V
    //   191: aload_2
    //   192: iconst_2
    //   193: aload #5
    //   195: aload #4
    //   197: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   200: new java/io/ByteArrayOutputStream
    //   203: astore #4
    //   205: aload #4
    //   207: invokespecial <init> : ()V
    //   210: aload #4
    //   212: aload_2
    //   213: aload_1
    //   214: invokevirtual doFinal : ([B)[B
    //   217: invokevirtual write : ([B)V
    //   220: new java/io/ByteArrayInputStream
    //   223: astore_1
    //   224: aload_1
    //   225: aload #4
    //   227: invokevirtual toByteArray : ()[B
    //   230: invokespecial <init> : ([B)V
    //   233: goto -> 248
    //   236: astore_1
    //   237: ldc 'DecryptResource'
    //   239: aload_1
    //   240: invokevirtual getMessage : ()Ljava/lang/String;
    //   243: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: aconst_null
    //   247: astore_1
    //   248: new org/apache/cordova/CordovaResourceApi$OpenForReadResult
    //   251: dup
    //   252: aload_3
    //   253: getfield uri : Landroid/net/Uri;
    //   256: aload_1
    //   257: aload_3
    //   258: getfield mimeType : Ljava/lang/String;
    //   261: aload_3
    //   262: getfield length : J
    //   265: aload_3
    //   266: getfield assetFd : Landroid/content/res/AssetFileDescriptor;
    //   269: invokespecial <init> : (Landroid/net/Uri;Ljava/io/InputStream;Ljava/lang/String;JLandroid/content/res/AssetFileDescriptor;)V
    //   272: areturn
    // Exception table:
    //   from	to	target	type
    //   149	233	236	java/lang/Exception
  }
  
  public Uri remapUri(Uri paramUri) {
    return (paramUri.toString().indexOf("/+++/") > -1) ? toPluginUri(paramUri) : paramUri;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\tkyaji\cordova\DecryptResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */