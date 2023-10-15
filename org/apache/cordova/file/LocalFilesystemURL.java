package org.apache.cordova.file;

import android.net.Uri;

public class LocalFilesystemURL {
  public static final String FILESYSTEM_PROTOCOL = "cdvfile";
  
  public final String fsName;
  
  public final boolean isDirectory;
  
  public final String path;
  
  public final Uri uri;
  
  private LocalFilesystemURL(Uri paramUri, String paramString1, String paramString2, boolean paramBoolean) {
    this.uri = paramUri;
    this.fsName = paramString1;
    this.path = paramString2;
    this.isDirectory = paramBoolean;
  }
  
  public static LocalFilesystemURL parse(Uri paramUri) {
    if (!"cdvfile".equals(paramUri.getScheme()))
      return null; 
    String str1 = paramUri.getPath();
    int i = str1.length();
    boolean bool = true;
    if (i < 1)
      return null; 
    i = str1.indexOf('/', 1);
    if (i < 0)
      return null; 
    String str2 = str1.substring(1, i);
    str1 = str1.substring(i);
    if (str1.charAt(str1.length() - 1) != '/')
      bool = false; 
    return new LocalFilesystemURL(paramUri, str2, str1, bool);
  }
  
  public static LocalFilesystemURL parse(String paramString) {
    return parse(Uri.parse(paramString));
  }
  
  public String toString() {
    return this.uri.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\LocalFilesystemURL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */