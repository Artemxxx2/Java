package org.apache.cordova.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentFilesystem extends Filesystem {
  private final Context context;
  
  public ContentFilesystem(Context paramContext, CordovaResourceApi paramCordovaResourceApi) {
    super(Uri.parse("content://"), "content", paramCordovaResourceApi);
    this.context = paramContext;
  }
  
  private Long resourceSizeForCursor(Cursor paramCursor) {
    int i = paramCursor.getColumnIndex("_size");
    if (i != -1) {
      String str = paramCursor.getString(i);
      if (str != null)
        return Long.valueOf(Long.parseLong(str)); 
    } 
    return null;
  }
  
  public LocalFilesystemURL URLforFilesystemPath(String paramString) {
    return null;
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return true;
  }
  
  public String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL) {
    String str;
    File file = this.resourceApi.mapUriToFile(toNativeUri(paramLocalFilesystemURL));
    if (file == null) {
      file = null;
    } else {
      str = file.getAbsolutePath();
    } 
    return str;
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean) throws IOException, TypeMismatchException, JSONException {
    throw new UnsupportedOperationException("getFile() not supported for content:. Use resolveLocalFileSystemURL instead.");
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual toNativeUri : (Lorg/apache/cordova/file/LocalFilesystemURL;)Landroid/net/Uri;
    //   5: astore_2
    //   6: aload_0
    //   7: getfield resourceApi : Lorg/apache/cordova/CordovaResourceApi;
    //   10: aload_2
    //   11: invokevirtual getMimeType : (Landroid/net/Uri;)Ljava/lang/String;
    //   14: astore_3
    //   15: aload_0
    //   16: aload_2
    //   17: invokevirtual openCursorForURL : (Landroid/net/Uri;)Landroid/database/Cursor;
    //   20: astore #4
    //   22: lconst_0
    //   23: lstore #5
    //   25: aload #4
    //   27: ifnull -> 93
    //   30: aload #4
    //   32: invokeinterface moveToFirst : ()Z
    //   37: ifeq -> 93
    //   40: aload_0
    //   41: aload #4
    //   43: invokespecial resourceSizeForCursor : (Landroid/database/Cursor;)Ljava/lang/Long;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull -> 60
    //   51: aload_2
    //   52: invokevirtual longValue : ()J
    //   55: lstore #7
    //   57: goto -> 65
    //   60: ldc2_w -1
    //   63: lstore #7
    //   65: aload_0
    //   66: aload #4
    //   68: invokevirtual lastModifiedDateForCursor : (Landroid/database/Cursor;)Ljava/lang/Long;
    //   71: astore_2
    //   72: lload #7
    //   74: lstore #9
    //   76: aload_2
    //   77: ifnull -> 106
    //   80: aload_2
    //   81: invokevirtual longValue : ()J
    //   84: lstore #5
    //   86: lload #7
    //   88: lstore #9
    //   90: goto -> 106
    //   93: aload_0
    //   94: getfield resourceApi : Lorg/apache/cordova/CordovaResourceApi;
    //   97: aload_2
    //   98: invokevirtual openForRead : (Landroid/net/Uri;)Lorg/apache/cordova/CordovaResourceApi$OpenForReadResult;
    //   101: getfield length : J
    //   104: lstore #9
    //   106: aload #4
    //   108: ifnull -> 118
    //   111: aload #4
    //   113: invokeinterface close : ()V
    //   118: new org/json/JSONObject
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #4
    //   127: aload #4
    //   129: ldc 'size'
    //   131: lload #9
    //   133: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload #4
    //   139: ldc 'type'
    //   141: aload_3
    //   142: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   145: pop
    //   146: aload #4
    //   148: ldc 'name'
    //   150: aload_0
    //   151: getfield name : Ljava/lang/String;
    //   154: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload #4
    //   160: ldc 'fullPath'
    //   162: aload_1
    //   163: getfield path : Ljava/lang/String;
    //   166: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload #4
    //   172: ldc 'lastModifiedDate'
    //   174: lload #5
    //   176: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload #4
    //   182: areturn
    //   183: astore_1
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: goto -> 207
    //   190: astore_3
    //   191: new java/io/FileNotFoundException
    //   194: astore_1
    //   195: aload_1
    //   196: invokespecial <init> : ()V
    //   199: aload_1
    //   200: aload_3
    //   201: invokevirtual initCause : (Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   204: pop
    //   205: aload_1
    //   206: athrow
    //   207: aload #4
    //   209: ifnull -> 219
    //   212: aload #4
    //   214: invokeinterface close : ()V
    //   219: aload_1
    //   220: athrow
    // Exception table:
    //   from	to	target	type
    //   30	47	190	java/io/IOException
    //   30	47	186	finally
    //   51	57	190	java/io/IOException
    //   51	57	186	finally
    //   65	72	190	java/io/IOException
    //   65	72	186	finally
    //   80	86	190	java/io/IOException
    //   80	86	186	finally
    //   93	106	190	java/io/IOException
    //   93	106	186	finally
    //   127	180	183	org/json/JSONException
    //   191	207	186	finally
  }
  
  protected Long lastModifiedDateForCursor(Cursor paramCursor) {
    int i = paramCursor.getColumnIndex("date_modified");
    int j = i;
    if (i == -1)
      j = paramCursor.getColumnIndex("last_modified"); 
    if (j != -1) {
      String str = paramCursor.getString(j);
      if (str != null)
        return Long.valueOf(Long.parseLong(str)); 
    } 
    return null;
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    throw new UnsupportedOperationException("readEntriesAtLocalURL() not supported for content:. Use resolveLocalFileSystemURL instead.");
  }
  
  protected Cursor openCursorForURL(Uri paramUri) {
    ContentResolver contentResolver = this.context.getContentResolver();
    try {
      return contentResolver.query(paramUri, null, null, null, null);
    } catch (UnsupportedOperationException unsupportedOperationException) {
      return null;
    } 
  }
  
  public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws NoModificationAllowedException {
    throw new NoModificationAllowedException("Cannot remove content url");
  }
  
  public boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws NoModificationAllowedException {
    Uri uri = toNativeUri(paramLocalFilesystemURL);
    try {
      this.context.getContentResolver().delete(uri, null, null);
      return true;
    } catch (UnsupportedOperationException unsupportedOperationException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Deleting not supported for content uri: ");
      stringBuilder.append(uri);
      NoModificationAllowedException noModificationAllowedException = new NoModificationAllowedException(stringBuilder.toString());
      noModificationAllowedException.initCause(unsupportedOperationException);
      throw noModificationAllowedException;
    } 
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri) {
    if (!"content".equals(paramUri.getScheme()))
      return null; 
    String str1 = paramUri.getEncodedPath();
    String str2 = str1;
    if (str1.length() > 0)
      str2 = str1.substring(1); 
    Uri.Builder builder = (new Uri.Builder()).scheme("cdvfile").authority("localhost").path(this.name).appendPath(paramUri.getAuthority());
    if (str2.length() > 0)
      builder.appendEncodedPath(str2); 
    return LocalFilesystemURL.parse(builder.encodedQuery(paramUri.getEncodedQuery()).encodedFragment(paramUri.getEncodedFragment()).build());
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL) {
    String str2 = paramLocalFilesystemURL.uri.getEncodedPath().substring(this.name.length() + 2);
    if (str2.length() < 2)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("content://");
    stringBuilder.append(str2);
    String str3 = stringBuilder.toString();
    String str4 = paramLocalFilesystemURL.uri.getEncodedQuery();
    str2 = str3;
    if (str4 != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3);
      stringBuilder1.append('?');
      stringBuilder1.append(str4);
      str2 = stringBuilder1.toString();
    } 
    str3 = paramLocalFilesystemURL.uri.getEncodedFragment();
    String str1 = str2;
    if (str3 != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append('#');
      stringBuilder1.append(str3);
      str1 = stringBuilder1.toString();
    } 
    return Uri.parse(str1);
  }
  
  public long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong) throws NoModificationAllowedException {
    throw new NoModificationAllowedException("Couldn't truncate file given its content URI");
  }
  
  public long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean) throws NoModificationAllowedException {
    throw new NoModificationAllowedException("Couldn't write to file given its content URI");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\ContentFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */