package org.apache.cordova.file;

import android.content.res.AssetManager;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetFilesystem extends Filesystem {
  private static final String LOG_TAG = "AssetFilesystem";
  
  private static Map<String, Long> lengthCache;
  
  private static Map<String, String[]> listCache;
  
  private static boolean listCacheFromFile;
  
  private static Object listCacheLock = new Object();
  
  private final AssetManager assetManager;
  
  public AssetFilesystem(AssetManager paramAssetManager, CordovaResourceApi paramCordovaResourceApi) {
    super(Uri.parse("file:///android_asset/"), "assets", paramCordovaResourceApi);
    this.assetManager = paramAssetManager;
  }
  
  private long getAssetSize(String paramString) throws FileNotFoundException {
    CordovaResourceApi.OpenForReadResult openForReadResult1;
    String str = paramString;
    if (paramString.startsWith("/"))
      str = paramString.substring(1); 
    lazyInitCaches();
    Map<String, Long> map = lengthCache;
    if (map != null) {
      Long long_ = map.get(str);
      if (long_ != null)
        return long_.longValue(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Asset not found: ");
      stringBuilder.append(str);
      throw new FileNotFoundException(stringBuilder.toString());
    } 
    CordovaResourceApi.OpenForReadResult openForReadResult2 = null;
    map = null;
    try {
      CordovaResourceApi.OpenForReadResult openForReadResult = this.resourceApi.openForRead(nativeUriForFullPath(str));
      openForReadResult1 = openForReadResult;
      openForReadResult2 = openForReadResult;
      long l1 = openForReadResult.length;
      long l2 = l1;
      if (l1 < 0L) {
        openForReadResult1 = openForReadResult;
        openForReadResult2 = openForReadResult;
        int i = openForReadResult.inputStream.available();
        l2 = i;
      } 
      if (openForReadResult != null)
        try {
          openForReadResult.inputStream.close();
        } catch (IOException iOException) {
          LOG.d("AssetFilesystem", iOException.getLocalizedMessage());
        }  
      return l2;
    } catch (IOException iOException) {
      openForReadResult1 = openForReadResult2;
      FileNotFoundException fileNotFoundException = new FileNotFoundException();
      openForReadResult1 = openForReadResult2;
      StringBuilder stringBuilder = new StringBuilder();
      openForReadResult1 = openForReadResult2;
      this();
      openForReadResult1 = openForReadResult2;
      stringBuilder.append("File not found: ");
      openForReadResult1 = openForReadResult2;
      stringBuilder.append(str);
      openForReadResult1 = openForReadResult2;
      this(stringBuilder.toString());
      openForReadResult1 = openForReadResult2;
      fileNotFoundException.initCause(iOException);
      openForReadResult1 = openForReadResult2;
      throw fileNotFoundException;
    } finally {}
    if (openForReadResult1 != null)
      try {
        openForReadResult1.inputStream.close();
      } catch (IOException iOException) {
        LOG.d("AssetFilesystem", iOException.getLocalizedMessage());
      }  
    throw openForReadResult2;
  }
  
  private boolean isDirectory(String paramString) {
    boolean bool = false;
    try {
      int i = (listAssets(paramString)).length;
      if (i != 0)
        bool = true; 
      return bool;
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  private void lazyInitCaches() {
    // Byte code:
    //   0: getstatic org/apache/cordova/file/AssetFilesystem.listCacheLock : Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic org/apache/cordova/file/AssetFilesystem.listCache : Ljava/util/Map;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull -> 210
    //   14: new java/io/ObjectInputStream
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: getfield assetManager : Landroid/content/res/AssetManager;
    //   23: ldc 'cdvasset.manifest'
    //   25: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   28: invokespecial <init> : (Ljava/io/InputStream;)V
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: invokevirtual readObject : ()Ljava/lang/Object;
    //   37: checkcast java/util/Map
    //   40: putstatic org/apache/cordova/file/AssetFilesystem.listCache : Ljava/util/Map;
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: invokevirtual readObject : ()Ljava/lang/Object;
    //   49: checkcast java/util/Map
    //   52: putstatic org/apache/cordova/file/AssetFilesystem.lengthCache : Ljava/util/Map;
    //   55: aload_3
    //   56: astore_2
    //   57: iconst_1
    //   58: putstatic org/apache/cordova/file/AssetFilesystem.listCacheFromFile : Z
    //   61: aload_3
    //   62: invokevirtual close : ()V
    //   65: goto -> 152
    //   68: astore_2
    //   69: aload_2
    //   70: invokevirtual getLocalizedMessage : ()Ljava/lang/String;
    //   73: astore_2
    //   74: ldc 'AssetFilesystem'
    //   76: aload_2
    //   77: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   80: goto -> 152
    //   83: astore_2
    //   84: goto -> 101
    //   87: astore #4
    //   89: goto -> 125
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_3
    //   95: goto -> 187
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull -> 152
    //   105: aload_3
    //   106: invokevirtual close : ()V
    //   109: goto -> 152
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual getLocalizedMessage : ()Ljava/lang/String;
    //   117: astore_2
    //   118: goto -> 74
    //   121: astore #4
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: astore_2
    //   127: aload #4
    //   129: invokevirtual printStackTrace : ()V
    //   132: aload_3
    //   133: ifnull -> 152
    //   136: aload_3
    //   137: invokevirtual close : ()V
    //   140: goto -> 152
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual getLocalizedMessage : ()Ljava/lang/String;
    //   148: astore_2
    //   149: goto -> 74
    //   152: getstatic org/apache/cordova/file/AssetFilesystem.listCache : Ljava/util/Map;
    //   155: ifnonnull -> 210
    //   158: ldc 'AssetFilesystem'
    //   160: ldc 'Asset manifest not found. Recursive copies and directory listing will be slow.'
    //   162: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   165: new java/util/HashMap
    //   168: astore_2
    //   169: aload_2
    //   170: invokespecial <init> : ()V
    //   173: aload_2
    //   174: putstatic org/apache/cordova/file/AssetFilesystem.listCache : Ljava/util/Map;
    //   177: goto -> 210
    //   180: astore #4
    //   182: aload_2
    //   183: astore_3
    //   184: aload #4
    //   186: astore_2
    //   187: aload_3
    //   188: ifnull -> 208
    //   191: aload_3
    //   192: invokevirtual close : ()V
    //   195: goto -> 208
    //   198: astore_3
    //   199: ldc 'AssetFilesystem'
    //   201: aload_3
    //   202: invokevirtual getLocalizedMessage : ()Ljava/lang/String;
    //   205: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_2
    //   209: athrow
    //   210: aload_1
    //   211: monitorexit
    //   212: return
    //   213: astore_2
    //   214: aload_1
    //   215: monitorexit
    //   216: aload_2
    //   217: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	213	finally
    //   14	31	121	java/lang/ClassNotFoundException
    //   14	31	98	java/io/IOException
    //   14	31	92	finally
    //   33	43	87	java/lang/ClassNotFoundException
    //   33	43	83	java/io/IOException
    //   33	43	180	finally
    //   45	55	87	java/lang/ClassNotFoundException
    //   45	55	83	java/io/IOException
    //   45	55	180	finally
    //   57	61	87	java/lang/ClassNotFoundException
    //   57	61	83	java/io/IOException
    //   57	61	180	finally
    //   61	65	68	java/io/IOException
    //   61	65	213	finally
    //   69	74	213	finally
    //   74	80	213	finally
    //   105	109	112	java/io/IOException
    //   105	109	213	finally
    //   113	118	213	finally
    //   127	132	180	finally
    //   136	140	143	java/io/IOException
    //   136	140	213	finally
    //   144	149	213	finally
    //   152	177	213	finally
    //   191	195	198	java/io/IOException
    //   191	195	213	finally
    //   199	208	213	finally
    //   208	210	213	finally
    //   210	212	213	finally
    //   214	216	213	finally
  }
  
  private String[] listAssets(String paramString) throws IOException {
    String str1 = paramString;
    if (paramString.startsWith("/"))
      str1 = paramString.substring(1); 
    String str2 = str1;
    if (str1.endsWith("/"))
      str2 = str1.substring(0, str1.length() - 1); 
    lazyInitCaches();
    String[] arrayOfString2 = listCache.get(str2);
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null)
      if (listCacheFromFile) {
        arrayOfString1 = new String[0];
      } else {
        arrayOfString1 = this.assetManager.list(str2);
        listCache.put(str2, arrayOfString1);
      }  
    return arrayOfString1;
  }
  
  LocalFilesystemURL URLforFilesystemPath(String paramString) {
    return null;
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return false;
  }
  
  String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return (new File(this.rootUri.getPath(), paramLocalFilesystemURL.path)).toString();
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
    if (paramJSONObject == null || !paramJSONObject.optBoolean("create")) {
      String str = paramString;
      if (paramBoolean) {
        str = paramString;
        if (!paramString.endsWith("/")) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString);
          stringBuilder.append("/");
          str = stringBuilder.toString();
        } 
      } 
      if (str.startsWith("/")) {
        paramLocalFilesystemURL = localUrlforFullPath(normalizePath(str));
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramLocalFilesystemURL.path);
        stringBuilder.append("/");
        stringBuilder.append(str);
        paramLocalFilesystemURL = localUrlforFullPath(normalizePath(stringBuilder.toString()));
      } 
      getFileMetadataForLocalURL(paramLocalFilesystemURL);
      boolean bool = isDirectory(paramLocalFilesystemURL.path);
      if (!paramBoolean || bool) {
        if (paramBoolean || !bool)
          return makeEntryForURL(paramLocalFilesystemURL); 
        throw new TypeMismatchException("path doesn't exist or is directory");
      } 
      throw new TypeMismatchException("path doesn't exist or is file");
    } 
    throw new UnsupportedOperationException("Assets are read-only");
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    long l;
    JSONObject jSONObject = new JSONObject();
    if (paramLocalFilesystemURL.isDirectory) {
      l = 0L;
    } else {
      l = getAssetSize(paramLocalFilesystemURL.path);
    } 
    try {
      String str;
      jSONObject.put("size", l);
      if (paramLocalFilesystemURL.isDirectory) {
        str = "text/directory";
      } else {
        str = this.resourceApi.getMimeType(toNativeUri(paramLocalFilesystemURL));
      } 
      jSONObject.put("type", str);
      File file = new File();
      this(paramLocalFilesystemURL.path);
      jSONObject.put("name", file.getName());
      jSONObject.put("fullPath", paramLocalFilesystemURL.path);
      jSONObject.put("lastModifiedDate", 0);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    String str1 = paramLocalFilesystemURL.path.substring(1);
    boolean bool = str1.endsWith("/");
    byte b = 0;
    String str2 = str1;
    if (bool)
      str2 = str1.substring(0, str1.length() - 1); 
    try {
      String[] arrayOfString = listAssets(str2);
      LocalFilesystemURL[] arrayOfLocalFilesystemURL = new LocalFilesystemURL[arrayOfString.length];
      while (b < arrayOfString.length) {
        arrayOfLocalFilesystemURL[b] = localUrlforFullPath((new File(paramLocalFilesystemURL.path, arrayOfString[b])).getPath());
        b++;
      } 
      return arrayOfLocalFilesystemURL;
    } catch (IOException iOException) {
      FileNotFoundException fileNotFoundException = new FileNotFoundException();
      fileNotFoundException.initCause(iOException);
      throw fileNotFoundException;
    } 
  }
  
  boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws NoModificationAllowedException {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws InvalidModificationException, NoModificationAllowedException {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri) {
    if (!"file".equals(paramUri.getScheme()))
      return null; 
    Uri uri = Uri.fromFile(new File(paramUri.getPath()));
    String str2 = this.rootUri.getEncodedPath();
    str2 = str2.substring(0, str2.length() - 1);
    if (!uri.getEncodedPath().startsWith(str2))
      return null; 
    str2 = uri.getEncodedPath().substring(str2.length());
    String str1 = str2;
    if (!str2.isEmpty())
      str1 = str2.substring(1); 
    Uri.Builder builder = (new Uri.Builder()).scheme("cdvfile").authority("localhost").path(this.name);
    if (!str1.isEmpty())
      builder.appendEncodedPath(str1); 
    if (isDirectory(str1) || paramUri.getPath().endsWith("/"))
      builder.appendEncodedPath(""); 
    return LocalFilesystemURL.parse(builder.build());
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL) {
    return nativeUriForFullPath(paramLocalFilesystemURL.path);
  }
  
  long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong) throws IOException, NoModificationAllowedException {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean) throws NoModificationAllowedException, IOException {
    throw new NoModificationAllowedException("Assets are read-only");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\AssetFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */