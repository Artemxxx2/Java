package org.apache.cordova.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalFilesystem extends Filesystem {
  private final Context context;
  
  public LocalFilesystem(String paramString, Context paramContext, CordovaResourceApi paramCordovaResourceApi, File paramFile) {
    super(Uri.fromFile(paramFile).buildUpon().appendEncodedPath("").build(), paramString, paramCordovaResourceApi);
    this.context = paramContext;
  }
  
  private void broadcastNewFile(Uri paramUri) {
    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", paramUri);
    this.context.sendBroadcast(intent);
  }
  
  private void copyDirectory(Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL, File paramFile, boolean paramBoolean) throws IOException, NoModificationAllowedException, InvalidModificationException, FileExistsException {
    if (paramBoolean) {
      String str = paramFilesystem.filesystemPathForURL(paramLocalFilesystemURL);
      if (str != null) {
        File file = new File(str);
        if (paramFile.exists())
          if ((paramFile.list()).length <= 0) {
            paramFile.delete();
          } else {
            throw new InvalidModificationException("directory is not empty");
          }  
        if (file.renameTo(paramFile))
          return; 
      } 
    } 
    if (paramFile.exists()) {
      if ((paramFile.list()).length > 0)
        throw new InvalidModificationException("directory is not empty"); 
    } else if (!paramFile.mkdir()) {
      throw new NoModificationAllowedException("Couldn't create the destination directory");
    } 
    for (LocalFilesystemURL localFilesystemURL : paramFilesystem.listChildren(paramLocalFilesystemURL)) {
      File file = new File(paramFile, (new File(localFilesystemURL.path)).getName());
      if (localFilesystemURL.isDirectory) {
        copyDirectory(paramFilesystem, localFilesystemURL, file, false);
      } else {
        copyFile(paramFilesystem, localFilesystemURL, file, false);
      } 
    } 
    if (paramBoolean)
      paramFilesystem.recursiveRemoveFileAtLocalURL(paramLocalFilesystemURL); 
  }
  
  private void copyFile(Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL, File paramFile, boolean paramBoolean) throws IOException, InvalidModificationException, NoModificationAllowedException {
    if (paramBoolean) {
      String str = paramFilesystem.filesystemPathForURL(paramLocalFilesystemURL);
      if (str != null && (new File(str)).renameTo(paramFile))
        return; 
    } 
    copyResource(this.resourceApi.openForRead(paramFilesystem.toNativeUri(paramLocalFilesystemURL)), new FileOutputStream(paramFile));
    if (paramBoolean)
      paramFilesystem.removeFileAtLocalURL(paramLocalFilesystemURL); 
  }
  
  private static void copyResource(CordovaResourceApi.OpenForReadResult paramOpenForReadResult, OutputStream paramOutputStream) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield inputStream : Ljava/io/InputStream;
    //   4: astore_2
    //   5: aload_2
    //   6: instanceof java/io/FileInputStream
    //   9: ifeq -> 82
    //   12: aload_1
    //   13: instanceof java/io/FileOutputStream
    //   16: ifeq -> 82
    //   19: aload_0
    //   20: getfield inputStream : Ljava/io/InputStream;
    //   23: checkcast java/io/FileInputStream
    //   26: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   29: astore_2
    //   30: aload_1
    //   31: checkcast java/io/FileOutputStream
    //   34: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   37: astore_3
    //   38: lconst_0
    //   39: lstore #4
    //   41: aload_0
    //   42: getfield length : J
    //   45: lstore #6
    //   47: aload_0
    //   48: getfield assetFd : Landroid/content/res/AssetFileDescriptor;
    //   51: ifnull -> 63
    //   54: aload_0
    //   55: getfield assetFd : Landroid/content/res/AssetFileDescriptor;
    //   58: invokevirtual getStartOffset : ()J
    //   61: lstore #4
    //   63: aload_2
    //   64: lload #4
    //   66: invokevirtual position : (J)Ljava/nio/channels/FileChannel;
    //   69: pop
    //   70: aload_3
    //   71: aload_2
    //   72: lconst_0
    //   73: lload #6
    //   75: invokevirtual transferFrom : (Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   78: pop2
    //   79: goto -> 104
    //   82: sipush #8192
    //   85: newarray byte
    //   87: astore_3
    //   88: aload_2
    //   89: aload_3
    //   90: iconst_0
    //   91: sipush #8192
    //   94: invokevirtual read : ([BII)I
    //   97: istore #8
    //   99: iload #8
    //   101: ifgt -> 120
    //   104: aload_0
    //   105: getfield inputStream : Ljava/io/InputStream;
    //   108: invokevirtual close : ()V
    //   111: aload_1
    //   112: ifnull -> 119
    //   115: aload_1
    //   116: invokevirtual close : ()V
    //   119: return
    //   120: aload_1
    //   121: aload_3
    //   122: iconst_0
    //   123: iload #8
    //   125: invokevirtual write : ([BII)V
    //   128: goto -> 88
    //   131: astore_3
    //   132: aload_0
    //   133: getfield inputStream : Ljava/io/InputStream;
    //   136: invokevirtual close : ()V
    //   139: aload_1
    //   140: ifnull -> 147
    //   143: aload_1
    //   144: invokevirtual close : ()V
    //   147: aload_3
    //   148: athrow
    // Exception table:
    //   from	to	target	type
    //   0	38	131	finally
    //   41	47	131	finally
    //   47	63	131	finally
    //   63	79	131	finally
    //   82	88	131	finally
    //   88	99	131	finally
    //   120	128	131	finally
  }
  
  private String fullPathForFilesystemPath(String paramString) {
    return (paramString != null && paramString.startsWith(this.rootUri.getPath())) ? paramString.substring(this.rootUri.getPath().length() - 1) : null;
  }
  
  private boolean isPublicDirectory(String paramString) {
    if (Build.VERSION.SDK_INT >= 21)
      for (File file : this.context.getExternalMediaDirs()) {
        if (file != null && paramString.startsWith(file.getAbsolutePath()))
          return true; 
      }  
    return paramString.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
  }
  
  public LocalFilesystemURL URLforFilesystemPath(String paramString) {
    return localUrlforFullPath(fullPathForFilesystemPath(paramString));
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return (new File(filesystemPathForURL(paramLocalFilesystemURL))).exists();
  }
  
  public JSONObject copyFileToURL(LocalFilesystemURL paramLocalFilesystemURL1, String paramString, Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean) throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException {
    if ((new File(filesystemPathForURL(paramLocalFilesystemURL1))).exists()) {
      LocalFilesystemURL localFilesystemURL = makeDestinationURL(paramString, paramLocalFilesystemURL2, paramLocalFilesystemURL1, paramLocalFilesystemURL2.isDirectory);
      Uri uri1 = toNativeUri(localFilesystemURL);
      Uri uri2 = paramFilesystem.toNativeUri(paramLocalFilesystemURL2);
      if (!uri1.equals(uri2)) {
        if (!paramBoolean || paramFilesystem.canRemoveFileAtLocalURL(paramLocalFilesystemURL2)) {
          File file = new File(uri1.getPath());
          if (file.exists())
            if (paramLocalFilesystemURL2.isDirectory || !file.isDirectory()) {
              if (paramLocalFilesystemURL2.isDirectory && file.isFile())
                throw new InvalidModificationException("Can't copy/move a directory to an existing file"); 
            } else {
              throw new InvalidModificationException("Can't copy/move a file to an existing directory");
            }  
          if (paramLocalFilesystemURL2.isDirectory) {
            String str = uri1.toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(uri2.toString());
            stringBuilder.append('/');
            if (!str.startsWith(stringBuilder.toString())) {
              copyDirectory(paramFilesystem, paramLocalFilesystemURL2, file, paramBoolean);
            } else {
              throw new InvalidModificationException("Can't copy directory into itself");
            } 
          } else {
            copyFile(paramFilesystem, paramLocalFilesystemURL2, file, paramBoolean);
          } 
          return makeEntryForURL(localFilesystemURL);
        } 
        throw new InvalidModificationException("Source URL is read-only (cannot move)");
      } 
      throw new InvalidModificationException("Can't copy onto itself");
    } 
    throw new FileNotFoundException("The source does not exist");
  }
  
  public boolean exists(LocalFilesystemURL paramLocalFilesystemURL) {
    return (new File(filesystemPathForURL(paramLocalFilesystemURL))).exists();
  }
  
  public String filesystemPathForFullPath(String paramString) {
    return (new File(this.rootUri.getPath(), paramString)).toString();
  }
  
  public String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL) {
    return filesystemPathForFullPath(paramLocalFilesystemURL.path);
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
    boolean bool1;
    boolean bool = false;
    if (paramJSONObject != null) {
      boolean bool2 = paramJSONObject.optBoolean("create");
      bool1 = bool2;
      if (bool2) {
        bool = paramJSONObject.optBoolean("exclusive");
        bool1 = bool2;
      } 
    } else {
      bool1 = false;
    } 
    if (!paramString.contains(":")) {
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
      File file = new File(filesystemPathForURL(paramLocalFilesystemURL));
      if (bool1) {
        if (!bool || !file.exists()) {
          if (paramBoolean) {
            file.mkdir();
          } else {
            file.createNewFile();
          } 
          if (!file.exists())
            throw new FileExistsException("create fails"); 
          return makeEntryForURL(paramLocalFilesystemURL);
        } 
        throw new FileExistsException("create/exclusive fails");
      } 
      if (file.exists()) {
        if (paramBoolean) {
          if (file.isFile())
            throw new TypeMismatchException("path doesn't exist or is file"); 
        } else if (file.isDirectory()) {
          throw new TypeMismatchException("path doesn't exist or is directory");
        } 
        return makeEntryForURL(paramLocalFilesystemURL);
      } 
      throw new FileNotFoundException("path does not exist");
    } 
    throw new EncodingException("This path has an invalid \":\" in it.");
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    File file = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if (file.exists()) {
      JSONObject jSONObject = new JSONObject();
      try {
        long l;
        if (file.isDirectory()) {
          l = 0L;
        } else {
          l = file.length();
        } 
        jSONObject.put("size", l);
        jSONObject.put("type", this.resourceApi.getMimeType(Uri.fromFile(file)));
        jSONObject.put("name", file.getName());
        jSONObject.put("fullPath", paramLocalFilesystemURL.path);
        jSONObject.put("lastModifiedDate", file.lastModified());
        return jSONObject;
      } catch (JSONException jSONException) {
        return null;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("File at ");
    stringBuilder.append(((LocalFilesystemURL)jSONException).uri);
    stringBuilder.append(" does not exist.");
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  public long getFreeSpaceInBytes() {
    return DirectoryManager.getFreeSpaceInBytes(this.rootUri.getPath());
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL) throws FileNotFoundException {
    File file = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if (file.exists()) {
      File[] arrayOfFile = file.listFiles();
      if (arrayOfFile == null)
        return null; 
      LocalFilesystemURL[] arrayOfLocalFilesystemURL = new LocalFilesystemURL[arrayOfFile.length];
      for (byte b = 0; b < arrayOfFile.length; b++)
        arrayOfLocalFilesystemURL[b] = URLforFilesystemPath(arrayOfFile[b].getPath()); 
      return arrayOfLocalFilesystemURL;
    } 
    throw new FileNotFoundException();
  }
  
  public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws FileExistsException {
    return removeDirRecursively(new File(filesystemPathForURL(paramLocalFilesystemURL)));
  }
  
  protected boolean removeDirRecursively(File paramFile) throws FileExistsException {
    if (paramFile.isDirectory()) {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (byte b = 0; b < i; b++)
        removeDirRecursively(arrayOfFile[b]); 
    } 
    if (paramFile.delete())
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("could not delete: ");
    stringBuilder.append(paramFile.getName());
    throw new FileExistsException(stringBuilder.toString());
  }
  
  public boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL) throws InvalidModificationException {
    File file = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if (!file.isDirectory() || (file.list()).length <= 0)
      return file.delete(); 
    throw new InvalidModificationException("You can't delete a directory that is not empty.");
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri) {
    if (!"file".equals(paramUri.getScheme()))
      return null; 
    File file = new File(paramUri.getPath());
    paramUri = Uri.fromFile(file);
    String str2 = this.rootUri.getEncodedPath();
    str2 = str2.substring(0, str2.length() - 1);
    if (!paramUri.getEncodedPath().startsWith(str2))
      return null; 
    str2 = paramUri.getEncodedPath().substring(str2.length());
    String str1 = str2;
    if (!str2.isEmpty())
      str1 = str2.substring(1); 
    Uri.Builder builder = (new Uri.Builder()).scheme("cdvfile").authority("localhost").path(this.name);
    if (!str1.isEmpty())
      builder.appendEncodedPath(str1); 
    if (file.isDirectory())
      builder.appendEncodedPath(""); 
    return LocalFilesystemURL.parse(builder.build());
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL) {
    return nativeUriForFullPath(paramLocalFilesystemURL.path);
  }
  
  public long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong) throws IOException {
    RandomAccessFile randomAccessFile;
    if ((new File(filesystemPathForURL(paramLocalFilesystemURL))).exists()) {
      randomAccessFile = new RandomAccessFile(filesystemPathForURL(paramLocalFilesystemURL), "rw");
      try {
        if (randomAccessFile.length() >= paramLong) {
          randomAccessFile.getChannel().truncate(paramLong);
          return paramLong;
        } 
        paramLong = randomAccessFile.length();
        return paramLong;
      } finally {
        randomAccessFile.close();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("File at ");
    stringBuilder.append(((LocalFilesystemURL)randomAccessFile).uri);
    stringBuilder.append(" does not exist.");
    throw new FileNotFoundException(stringBuilder.toString());
  }
  
  public long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean) throws IOException, NoModificationAllowedException {
    byte[] arrayOfByte;
    boolean bool;
    if (paramInt > 0) {
      truncateFileAtURL(paramLocalFilesystemURL, paramInt);
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean) {
      arrayOfByte = Base64.decode(paramString, 0);
    } else {
      arrayOfByte = arrayOfByte.getBytes(Charset.defaultCharset());
    } 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    try {
      File file;
      byte[] arrayOfByte1 = new byte[arrayOfByte.length];
      String str = filesystemPathForURL(paramLocalFilesystemURL);
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(str, bool);
      try {
        byteArrayInputStream.read(arrayOfByte1, 0, arrayOfByte1.length);
        fileOutputStream.write(arrayOfByte1, 0, arrayOfByte.length);
        fileOutputStream.flush();
        fileOutputStream.close();
        return arrayOfByte.length;
      } finally {
        file.close();
      } 
    } catch (NullPointerException nullPointerException) {
      NoModificationAllowedException noModificationAllowedException = new NoModificationAllowedException(paramLocalFilesystemURL.toString());
      noModificationAllowedException.initCause(nullPointerException);
      throw noModificationAllowedException;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\LocalFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */