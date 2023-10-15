package org.apache.cordova;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class CordovaResourceApi {
  private static final String[] LOCAL_FILE_PROJECTION = new String[] { "_data" };
  
  private static final String LOG_TAG = "CordovaResourceApi";
  
  public static final String PLUGIN_URI_SCHEME = "cdvplugin";
  
  public static final int URI_TYPE_ASSET = 1;
  
  public static final int URI_TYPE_CONTENT = 2;
  
  public static final int URI_TYPE_DATA = 4;
  
  public static final int URI_TYPE_FILE = 0;
  
  public static final int URI_TYPE_HTTP = 5;
  
  public static final int URI_TYPE_HTTPS = 6;
  
  public static final int URI_TYPE_PLUGIN = 7;
  
  public static final int URI_TYPE_RESOURCE = 3;
  
  public static final int URI_TYPE_UNKNOWN = -1;
  
  public static Thread jsThread;
  
  private final AssetManager assetManager;
  
  private final ContentResolver contentResolver;
  
  private final PluginManager pluginManager;
  
  private boolean threadCheckingEnabled = true;
  
  public CordovaResourceApi(Context paramContext, PluginManager paramPluginManager) {
    this.contentResolver = paramContext.getContentResolver();
    this.assetManager = paramContext.getAssets();
    this.pluginManager = paramPluginManager;
  }
  
  private void assertBackgroundThread() {
    if (this.threadCheckingEnabled) {
      Thread thread = Thread.currentThread();
      if (thread != Looper.getMainLooper().getThread()) {
        if (thread == jsThread)
          throw new IllegalStateException("Tried to perform an IO operation on the WebCore thread. Use CordovaInterface.getThreadPool() instead."); 
      } else {
        throw new IllegalStateException("Do not perform IO operations on the UI thread. Use CordovaInterface.getThreadPool() instead.");
      } 
    } 
  }
  
  private static void assertNonRelative(Uri paramUri) {
    if (paramUri.isAbsolute())
      return; 
    throw new IllegalArgumentException("Relative URIs are not supported.");
  }
  
  private String getDataUriMimeType(Uri paramUri) {
    String str = paramUri.getSchemeSpecificPart();
    int i = str.indexOf(',');
    if (i == -1)
      return null; 
    String[] arrayOfString = str.substring(0, i).split(";");
    return (arrayOfString.length > 0) ? arrayOfString[0] : null;
  }
  
  private String getMimeTypeFromPath(String paramString) {
    int i = paramString.lastIndexOf('.');
    String str = paramString;
    if (i != -1)
      str = paramString.substring(i + 1); 
    paramString = str.toLowerCase(Locale.getDefault());
    return paramString.equals("3ga") ? "audio/3gpp" : (paramString.equals("js") ? "text/javascript" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString));
  }
  
  public static int getUriType(Uri paramUri) {
    assertNonRelative(paramUri);
    String str = paramUri.getScheme();
    return "content".equalsIgnoreCase(str) ? 2 : ("android.resource".equalsIgnoreCase(str) ? 3 : ("file".equalsIgnoreCase(str) ? (paramUri.getPath().startsWith("/android_asset/") ? 1 : 0) : ("data".equalsIgnoreCase(str) ? 4 : ("http".equalsIgnoreCase(str) ? 5 : ("https".equalsIgnoreCase(str) ? 6 : ("cdvplugin".equalsIgnoreCase(str) ? 7 : -1))))));
  }
  
  private OpenForReadResult readDataUri(Uri paramUri) {
    byte[] arrayOfByte;
    String str2;
    String str1 = paramUri.getSchemeSpecificPart();
    int i = str1.indexOf(',');
    if (i == -1)
      return null; 
    String[] arrayOfString = str1.substring(0, i).split(";");
    if (arrayOfString.length > 0) {
      str2 = arrayOfString[0];
    } else {
      str2 = null;
    } 
    byte b = 1;
    boolean bool = false;
    while (b < arrayOfString.length) {
      if ("base64".equalsIgnoreCase(arrayOfString[b]))
        bool = true; 
      b++;
    } 
    str1 = str1.substring(i + 1);
    if (bool) {
      arrayOfByte = Base64.decode(str1, 0);
    } else {
      try {
        arrayOfByte = str1.getBytes("UTF-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        arrayOfByte = str1.getBytes();
      } 
    } 
    return new OpenForReadResult(paramUri, new ByteArrayInputStream(arrayOfByte), str2, arrayOfByte.length, null);
  }
  
  public void copyResource(Uri paramUri1, Uri paramUri2) throws IOException {
    copyResource(openForRead(paramUri1), openOutputStream(paramUri2));
  }
  
  public void copyResource(Uri paramUri, OutputStream paramOutputStream) throws IOException {
    copyResource(openForRead(paramUri), paramOutputStream);
  }
  
  public void copyResource(OpenForReadResult paramOpenForReadResult, OutputStream paramOutputStream) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial assertBackgroundThread : ()V
    //   4: aload_1
    //   5: getfield inputStream : Ljava/io/InputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: instanceof java/io/FileInputStream
    //   13: ifeq -> 88
    //   16: aload_2
    //   17: instanceof java/io/FileOutputStream
    //   20: ifeq -> 88
    //   23: aload_1
    //   24: getfield inputStream : Ljava/io/InputStream;
    //   27: checkcast java/io/FileInputStream
    //   30: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   33: astore_3
    //   34: aload_2
    //   35: checkcast java/io/FileOutputStream
    //   38: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   41: astore #4
    //   43: lconst_0
    //   44: lstore #5
    //   46: aload_1
    //   47: getfield length : J
    //   50: lstore #7
    //   52: aload_1
    //   53: getfield assetFd : Landroid/content/res/AssetFileDescriptor;
    //   56: ifnull -> 68
    //   59: aload_1
    //   60: getfield assetFd : Landroid/content/res/AssetFileDescriptor;
    //   63: invokevirtual getStartOffset : ()J
    //   66: lstore #5
    //   68: aload_3
    //   69: lload #5
    //   71: invokevirtual position : (J)Ljava/nio/channels/FileChannel;
    //   74: pop
    //   75: aload #4
    //   77: aload_3
    //   78: lconst_0
    //   79: lload #7
    //   81: invokevirtual transferFrom : (Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   84: pop2
    //   85: goto -> 112
    //   88: sipush #8192
    //   91: newarray byte
    //   93: astore #4
    //   95: aload_3
    //   96: aload #4
    //   98: iconst_0
    //   99: sipush #8192
    //   102: invokevirtual read : ([BII)I
    //   105: istore #9
    //   107: iload #9
    //   109: ifgt -> 128
    //   112: aload_1
    //   113: getfield inputStream : Ljava/io/InputStream;
    //   116: invokevirtual close : ()V
    //   119: aload_2
    //   120: ifnull -> 127
    //   123: aload_2
    //   124: invokevirtual close : ()V
    //   127: return
    //   128: aload_2
    //   129: aload #4
    //   131: iconst_0
    //   132: iload #9
    //   134: invokevirtual write : ([BII)V
    //   137: goto -> 95
    //   140: astore #4
    //   142: aload_1
    //   143: getfield inputStream : Ljava/io/InputStream;
    //   146: invokevirtual close : ()V
    //   149: aload_2
    //   150: ifnull -> 157
    //   153: aload_2
    //   154: invokevirtual close : ()V
    //   157: aload #4
    //   159: athrow
    // Exception table:
    //   from	to	target	type
    //   4	43	140	finally
    //   46	52	140	finally
    //   52	68	140	finally
    //   68	85	140	finally
    //   88	95	140	finally
    //   95	107	140	finally
    //   128	137	140	finally
  }
  
  public HttpURLConnection createHttpConnection(Uri paramUri) throws IOException {
    assertBackgroundThread();
    return (HttpURLConnection)(new URL(paramUri.toString())).openConnection();
  }
  
  public String getMimeType(Uri paramUri) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic getUriType : (Landroid/net/Uri;)I
    //   4: tableswitch default -> 48, 0 -> 123, 1 -> 123, 2 -> 114, 3 -> 114, 4 -> 108, 5 -> 51, 6 -> 51
    //   48: goto -> 132
    //   51: new java/net/URL
    //   54: astore_2
    //   55: aload_2
    //   56: aload_1
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokespecial <init> : (Ljava/lang/String;)V
    //   63: aload_2
    //   64: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   67: checkcast java/net/HttpURLConnection
    //   70: astore_1
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual setDoInput : (Z)V
    //   76: aload_1
    //   77: ldc_w 'HEAD'
    //   80: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   83: aload_1
    //   84: ldc_w 'Content-Type'
    //   87: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull -> 106
    //   97: aload_2
    //   98: ldc ';'
    //   100: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   103: iconst_0
    //   104: aaload
    //   105: astore_1
    //   106: aload_1
    //   107: areturn
    //   108: aload_0
    //   109: aload_1
    //   110: invokespecial getDataUriMimeType : (Landroid/net/Uri;)Ljava/lang/String;
    //   113: areturn
    //   114: aload_0
    //   115: getfield contentResolver : Landroid/content/ContentResolver;
    //   118: aload_1
    //   119: invokevirtual getType : (Landroid/net/Uri;)Ljava/lang/String;
    //   122: areturn
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual getPath : ()Ljava/lang/String;
    //   128: invokespecial getMimeTypeFromPath : (Ljava/lang/String;)Ljava/lang/String;
    //   131: areturn
    //   132: aconst_null
    //   133: areturn
    //   134: astore_1
    //   135: goto -> 132
    // Exception table:
    //   from	to	target	type
    //   51	91	134	java/io/IOException
    //   97	106	134	java/io/IOException
  }
  
  public boolean isThreadCheckingEnabled() {
    return this.threadCheckingEnabled;
  }
  
  public File mapUriToFile(Uri paramUri) {
    Cursor cursor;
    assertBackgroundThread();
    int i = getUriType(paramUri);
    if (i != 0) {
      if (i == 2) {
        cursor = this.contentResolver.query(paramUri, LOCAL_FILE_PROJECTION, null, null, null);
        if (cursor != null)
          try {
            i = cursor.getColumnIndex(LOCAL_FILE_PROJECTION[0]);
            if (i != -1 && cursor.getCount() > 0) {
              cursor.moveToFirst();
              String str = cursor.getString(i);
              if (str != null)
                return new File(str); 
            } 
          } finally {
            cursor.close();
          }  
      } 
      return null;
    } 
    return new File(cursor.getPath());
  }
  
  public OpenForReadResult openForRead(Uri paramUri) throws IOException {
    return openForRead(paramUri, false);
  }
  
  public OpenForReadResult openForRead(Uri paramUri, boolean paramBoolean) throws IOException {
    StringBuilder stringBuilder2;
    String str2;
    CordovaPlugin cordovaPlugin;
    StringBuilder stringBuilder1;
    String str1;
    OpenForReadResult openForReadResult;
    AssetFileDescriptor assetFileDescriptor;
    HttpURLConnection httpURLConnection;
    String str3;
    InputStream inputStream;
    int i;
    String str4;
    long l;
    if (!paramBoolean)
      assertBackgroundThread(); 
    switch (getUriType(paramUri)) {
      default:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("URI not supported by CordovaResourceApi: ");
        stringBuilder2.append(paramUri);
        throw new FileNotFoundException(stringBuilder2.toString());
      case 7:
        str2 = paramUri.getHost();
        cordovaPlugin = this.pluginManager.getPlugin(str2);
        if (cordovaPlugin != null)
          return cordovaPlugin.handleOpenForRead(paramUri); 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Invalid plugin ID in URI: ");
        stringBuilder1.append(paramUri);
        throw new FileNotFoundException(stringBuilder1.toString());
      case 5:
      case 6:
        httpURLConnection = (HttpURLConnection)(new URL(paramUri.toString())).openConnection();
        httpURLConnection.setDoInput(true);
        str1 = httpURLConnection.getHeaderField("Content-Type");
        if (str1 != null)
          str1 = str1.split(";")[0]; 
        i = httpURLConnection.getContentLength();
        return new OpenForReadResult(paramUri, httpURLConnection.getInputStream(), str1, i, null);
      case 4:
        openForReadResult = readDataUri(paramUri);
        if (openForReadResult != null)
          return openForReadResult; 
      case 2:
      case 3:
        str3 = this.contentResolver.getType(paramUri);
        assetFileDescriptor = this.contentResolver.openAssetFileDescriptor(paramUri, "r");
        return new OpenForReadResult(paramUri, assetFileDescriptor.createInputStream(), str3, assetFileDescriptor.getLength(), assetFileDescriptor);
      case 1:
        str4 = paramUri.getPath().substring(15);
        assetFileDescriptor = null;
        try {
          AssetFileDescriptor assetFileDescriptor1 = this.assetManager.openFd(str4);
          assetFileDescriptor = assetFileDescriptor1;
          FileInputStream fileInputStream1 = assetFileDescriptor1.createInputStream();
          assetFileDescriptor = assetFileDescriptor1;
          l = assetFileDescriptor1.getLength();
          assetFileDescriptor = assetFileDescriptor1;
          inputStream = fileInputStream1;
        } catch (FileNotFoundException fileNotFoundException) {
          inputStream = this.assetManager.open(str4);
          l = inputStream.available();
        } 
        return new OpenForReadResult(paramUri, inputStream, getMimeTypeFromPath(str4), l, assetFileDescriptor);
      case 0:
        break;
    } 
    FileInputStream fileInputStream = new FileInputStream(paramUri.getPath());
    return new OpenForReadResult(paramUri, fileInputStream, getMimeTypeFromPath(paramUri.getPath()), fileInputStream.getChannel().size(), null);
  }
  
  public OutputStream openOutputStream(Uri paramUri) throws IOException {
    return openOutputStream(paramUri, false);
  }
  
  public OutputStream openOutputStream(Uri paramUri, boolean paramBoolean) throws IOException {
    assertBackgroundThread();
    int i = getUriType(paramUri);
    if (i != 0) {
      StringBuilder stringBuilder;
      String str;
      switch (i) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("URI not supported by CordovaResourceApi: ");
          stringBuilder.append(paramUri);
          throw new FileNotFoundException(stringBuilder.toString());
        case 2:
        case 3:
          break;
      } 
      ContentResolver contentResolver = this.contentResolver;
      if (paramBoolean) {
        str = "wa";
      } else {
        str = "w";
      } 
      return contentResolver.openAssetFileDescriptor(paramUri, str).createOutputStream();
    } 
    File file2 = new File(paramUri.getPath());
    File file1 = file2.getParentFile();
    if (file1 != null)
      file1.mkdirs(); 
    return new FileOutputStream(file2, paramBoolean);
  }
  
  public String remapPath(String paramString) {
    return remapUri(Uri.fromFile(new File(paramString))).getPath();
  }
  
  public Uri remapUri(Uri paramUri) {
    assertNonRelative(paramUri);
    Uri uri = this.pluginManager.remapUri(paramUri);
    if (uri != null)
      paramUri = uri; 
    return paramUri;
  }
  
  public void setThreadCheckingEnabled(boolean paramBoolean) {
    this.threadCheckingEnabled = paramBoolean;
  }
  
  public static final class OpenForReadResult {
    public final AssetFileDescriptor assetFd;
    
    public final InputStream inputStream;
    
    public final long length;
    
    public final String mimeType;
    
    public final Uri uri;
    
    public OpenForReadResult(Uri param1Uri, InputStream param1InputStream, String param1String, long param1Long, AssetFileDescriptor param1AssetFileDescriptor) {
      this.uri = param1Uri;
      this.inputStream = param1InputStream;
      this.mimeType = param1String;
      this.length = param1Long;
      this.assetFd = param1AssetFileDescriptor;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaResourceApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */