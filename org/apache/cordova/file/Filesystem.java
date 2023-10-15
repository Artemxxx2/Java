package org.apache.cordova.file;

import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Filesystem {
  public final String name;
  
  protected final CordovaResourceApi resourceApi;
  
  private JSONObject rootEntry;
  
  protected final Uri rootUri;
  
  public Filesystem(Uri paramUri, String paramString, CordovaResourceApi paramCordovaResourceApi) {
    this.rootUri = paramUri;
    this.name = paramString;
    this.resourceApi = paramCordovaResourceApi;
  }
  
  public static JSONObject makeEntryForURL(LocalFilesystemURL paramLocalFilesystemURL, Uri paramUri) {
    try {
      String str2 = paramLocalFilesystemURL.path;
      boolean bool = str2.endsWith("/");
      boolean bool1 = true;
      if (bool) {
        b = 1;
      } else {
        b = 0;
      } 
      String[] arrayOfString = str2.substring(0, str2.length() - b).split("/+");
      String str3 = arrayOfString[arrayOfString.length - 1];
      JSONObject jSONObject = new JSONObject();
      this();
      if (!paramLocalFilesystemURL.isDirectory) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("isFile", bool);
      jSONObject.put("isDirectory", paramLocalFilesystemURL.isDirectory);
      jSONObject.put("name", str3);
      jSONObject.put("fullPath", str2);
      jSONObject.put("filesystemName", paramLocalFilesystemURL.fsName);
      byte b = bool1;
      if ("temporary".equals(paramLocalFilesystemURL.fsName))
        b = 0; 
      jSONObject.put("filesystem", b);
      str2 = paramUri.toString();
      String str1 = str2;
      if (paramLocalFilesystemURL.isDirectory) {
        str1 = str2;
        if (!str2.endsWith("/")) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append(str2);
          stringBuilder.append("/");
          str1 = stringBuilder.toString();
        } 
      } 
      jSONObject.put("nativeURL", str1);
      return jSONObject;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      throw new RuntimeException(jSONException);
    } 
  }
  
  protected static String normalizePath(String paramString) {
    boolean bool = paramString.startsWith("/");
    String str = paramString;
    if (bool)
      str = paramString.replaceFirst("/+", ""); 
    ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])str.split("/+")));
    for (int i = 0; i < arrayList.size(); i = j + 1) {
      int j = i;
      if (((String)arrayList.get(i)).equals("..")) {
        arrayList.remove(i);
        j = i;
        if (i > 0) {
          arrayList.remove(i - 1);
          j = i - 1;
        } 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    for (String str1 : arrayList) {
      stringBuilder.append("/");
      stringBuilder.append(str1);
    } 
    return bool ? stringBuilder.toString() : stringBuilder.toString().substring(1);
  }
  
  abstract LocalFilesystemURL URLforFilesystemPath(String paramString);
  
  abstract boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL);
  
  public JSONObject copyFileToURL(LocalFilesystemURL paramLocalFilesystemURL1, String paramString, Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
    if (!paramBoolean || paramFilesystem.canRemoveFileAtLocalURL(paramLocalFilesystemURL2)) {
      paramLocalFilesystemURL1 = makeDestinationURL(paramString, paramLocalFilesystemURL2, paramLocalFilesystemURL1, paramLocalFilesystemURL2.isDirectory);
      Uri uri = paramFilesystem.toNativeUri(paramLocalFilesystemURL2);
      CordovaResourceApi.OpenForReadResult openForReadResult = this.resourceApi.openForRead(uri);
      try {
        OutputStream outputStream = getOutputStreamForURL(paramLocalFilesystemURL1);
        this.resourceApi.copyResource(openForReadResult, outputStream);
        if (paramBoolean)
          paramFilesystem.removeFileAtLocalURL(paramLocalFilesystemURL2); 
        return getEntryForLocalURL(paramLocalFilesystemURL1);
      } catch (IOException iOException) {
        openForReadResult.inputStream.close();
        throw iOException;
      } 
    } 
    throw new NoModificationAllowedException("Cannot move file at source URL");
  }
  
  public boolean exists(LocalFilesystemURL paramLocalFilesystemURL) {
    try {
      getFileMetadataForLocalURL(paramLocalFilesystemURL);
      return true;
    } catch (FileNotFoundException fileNotFoundException) {
      return false;
    } 
  }
  
  abstract String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL);
  
  public JSONObject getEntryForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws IOException {
    return makeEntryForURL(paramLocalFilesystemURL);
  }
  
  abstract JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException;
  
  abstract JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException;
  
  public long getFreeSpaceInBytes() {
    return 0L;
  }
  
  public OutputStream getOutputStreamForURL(LocalFilesystemURL paramLocalFilesystemURL) throws IOException {
    return this.resourceApi.openOutputStream(toNativeUri(paramLocalFilesystemURL));
  }
  
  public JSONObject getParentForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws IOException {
    Uri uri = paramLocalFilesystemURL.uri;
    String str = (new File(paramLocalFilesystemURL.uri.getPath())).getParent();
    if (!"/".equals(str)) {
      Uri.Builder builder = paramLocalFilesystemURL.uri.buildUpon();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append('/');
      uri = builder.path(stringBuilder.toString()).build();
    } 
    return getEntryForLocalURL(LocalFilesystemURL.parse(uri));
  }
  
  public JSONObject getRootEntry() {
    if (this.rootEntry == null)
      this.rootEntry = makeEntryForNativeUri(this.rootUri); 
    return this.rootEntry;
  }
  
  public Uri getRootUri() {
    return this.rootUri;
  }
  
  abstract LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException;
  
  public LocalFilesystemURL localUrlforFullPath(String paramString) {
    Uri uri = nativeUriForFullPath(paramString);
    return (uri != null) ? toLocalUri(uri) : null;
  }
  
  protected LocalFilesystemURL makeDestinationURL(String paramString, LocalFilesystemURL paramLocalFilesystemURL1, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean) {
    // Byte code:
    //   0: ldc_w 'null'
    //   3: aload_1
    //   4: invokevirtual equals : (Ljava/lang/Object;)Z
    //   7: ifne -> 22
    //   10: aload_1
    //   11: astore #5
    //   13: ldc ''
    //   15: aload_1
    //   16: invokevirtual equals : (Ljava/lang/Object;)Z
    //   19: ifeq -> 31
    //   22: aload_2
    //   23: getfield uri : Landroid/net/Uri;
    //   26: invokevirtual getLastPathSegment : ()Ljava/lang/String;
    //   29: astore #5
    //   31: aload_3
    //   32: getfield uri : Landroid/net/Uri;
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: ldc '/'
    //   42: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   45: ifeq -> 77
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_1
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: aload #5
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: astore_1
    //   74: goto -> 110
    //   77: new java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial <init> : ()V
    //   84: astore_2
    //   85: aload_2
    //   86: aload_1
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: ldc '/'
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: aload #5
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: invokevirtual toString : ()Ljava/lang/String;
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: iload #4
    //   114: ifeq -> 143
    //   117: new java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial <init> : ()V
    //   124: astore_2
    //   125: aload_2
    //   126: aload_1
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: bipush #47
    //   134: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: astore_2
    //   143: aload_2
    //   144: invokestatic parse : (Ljava/lang/String;)Lorg/apache/cordova/file/LocalFilesystemURL;
    //   147: areturn
  }
  
  public JSONObject makeEntryForFile(File paramFile) {
    return makeEntryForNativeUri(Uri.fromFile(paramFile));
  }
  
  public JSONObject makeEntryForNativeUri(Uri paramUri) {
    JSONObject jSONObject;
    LocalFilesystemURL localFilesystemURL = toLocalUri(paramUri);
    if (localFilesystemURL == null) {
      paramUri = null;
    } else {
      jSONObject = makeEntryForURL(localFilesystemURL, paramUri);
    } 
    return jSONObject;
  }
  
  public JSONObject makeEntryForURL(LocalFilesystemURL paramLocalFilesystemURL) {
    JSONObject jSONObject;
    Uri uri = toNativeUri(paramLocalFilesystemURL);
    if (uri == null) {
      paramLocalFilesystemURL = null;
    } else {
      jSONObject = makeEntryForURL(paramLocalFilesystemURL, uri);
    } 
    return jSONObject;
  }
  
  public Uri nativeUriForFullPath(String paramString) {
    if (paramString != null) {
      String str = Uri.fromFile(new File(paramString)).getEncodedPath();
      paramString = str;
      if (str.startsWith("/"))
        paramString = str.substring(1); 
      Uri uri = this.rootUri.buildUpon().appendEncodedPath(paramString).build();
    } else {
      paramString = null;
    } 
    return (Uri)paramString;
  }
  
  public final JSONArray readEntriesAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    LocalFilesystemURL[] arrayOfLocalFilesystemURL = listChildren(paramLocalFilesystemURL);
    JSONArray jSONArray = new JSONArray();
    if (arrayOfLocalFilesystemURL != null) {
      int i = arrayOfLocalFilesystemURL.length;
      for (byte b = 0; b < i; b++)
        jSONArray.put(makeEntryForURL(arrayOfLocalFilesystemURL[b])); 
    } 
    return jSONArray;
  }
  
  public void readFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong1, long paramLong2, ReadFileCallback paramReadFileCallback) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield resourceApi : Lorg/apache/cordova/CordovaResourceApi;
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual toNativeUri : (Lorg/apache/cordova/file/LocalFilesystemURL;)Landroid/net/Uri;
    //   9: invokevirtual openForRead : (Landroid/net/Uri;)Lorg/apache/cordova/CordovaResourceApi$OpenForReadResult;
    //   12: astore #7
    //   14: lload #4
    //   16: lstore #8
    //   18: lload #4
    //   20: lconst_0
    //   21: lcmp
    //   22: ifge -> 32
    //   25: aload #7
    //   27: getfield length : J
    //   30: lstore #8
    //   32: lload_2
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle -> 48
    //   38: aload #7
    //   40: getfield inputStream : Ljava/io/InputStream;
    //   43: lload_2
    //   44: invokevirtual skip : (J)J
    //   47: pop2
    //   48: aload #7
    //   50: getfield inputStream : Ljava/io/InputStream;
    //   53: astore #10
    //   55: aload #10
    //   57: astore_1
    //   58: lload #8
    //   60: aload #7
    //   62: getfield length : J
    //   65: lcmp
    //   66: ifge -> 84
    //   69: new org/apache/cordova/file/Filesystem$LimitedInputStream
    //   72: astore_1
    //   73: aload_1
    //   74: aload_0
    //   75: aload #10
    //   77: lload #8
    //   79: lload_2
    //   80: lsub
    //   81: invokespecial <init> : (Lorg/apache/cordova/file/Filesystem;Ljava/io/InputStream;J)V
    //   84: aload #6
    //   86: aload_1
    //   87: aload #7
    //   89: getfield mimeType : Ljava/lang/String;
    //   92: invokeinterface handleData : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   97: aload #7
    //   99: getfield inputStream : Ljava/io/InputStream;
    //   102: invokevirtual close : ()V
    //   105: return
    //   106: astore_1
    //   107: aload #7
    //   109: getfield inputStream : Ljava/io/InputStream;
    //   112: invokevirtual close : ()V
    //   115: aload_1
    //   116: athrow
    // Exception table:
    //   from	to	target	type
    //   38	48	106	finally
    //   48	55	106	finally
    //   58	84	106	finally
    //   84	97	106	finally
  }
  
  abstract boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileExistsException, NoModificationAllowedException;
  
  abstract boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws InvalidModificationException, NoModificationAllowedException;
  
  public abstract LocalFilesystemURL toLocalUri(Uri paramUri);
  
  public abstract Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL);
  
  abstract long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong) throws IOException, NoModificationAllowedException;
  
  abstract long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean) throws NoModificationAllowedException, IOException;
  
  protected class LimitedInputStream extends FilterInputStream {
    long numBytesToRead;
    
    public LimitedInputStream(InputStream param1InputStream, long param1Long) {
      super(param1InputStream);
      this.numBytesToRead = param1Long;
    }
    
    public int read() throws IOException {
      long l = this.numBytesToRead;
      if (l <= 0L)
        return -1; 
      this.numBytesToRead = l - 1L;
      return this.in.read();
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      long l = this.numBytesToRead;
      if (l <= 0L)
        return -1; 
      int i = param1Int2;
      if (param1Int2 > l)
        i = (int)l; 
      param1Int1 = this.in.read(param1ArrayOfbyte, param1Int1, i);
      this.numBytesToRead -= param1Int1;
      return param1Int1;
    }
  }
  
  public static interface ReadFileCallback {
    void handleData(InputStream param1InputStream, String param1String) throws IOException;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\Filesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */