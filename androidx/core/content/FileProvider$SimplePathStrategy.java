package androidx.core.content;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class SimplePathStrategy implements FileProvider.PathStrategy {
  private final String mAuthority;
  
  private final HashMap<String, File> mRoots = new HashMap<String, File>();
  
  SimplePathStrategy(String paramString) {
    this.mAuthority = paramString;
  }
  
  void addRoot(String paramString, File paramFile) {
    if (!TextUtils.isEmpty(paramString))
      try {
        File file = paramFile.getCanonicalFile();
        this.mRoots.put(paramString, file);
        return;
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to resolve canonical path for ");
        stringBuilder.append(paramFile);
        throw new IllegalArgumentException(stringBuilder.toString(), iOException);
      }  
    throw new IllegalArgumentException("Name must not be empty");
  }
  
  public File getFileForUri(Uri paramUri) {
    File file1;
    String str1 = paramUri.getEncodedPath();
    int i = str1.indexOf('/', 1);
    String str2 = Uri.decode(str1.substring(1, i));
    str1 = Uri.decode(str1.substring(i + 1));
    File file2 = this.mRoots.get(str2);
    if (file2 != null) {
      file1 = new File(file2, str1);
      try {
        File file = file1.getCanonicalFile();
        if (file.getPath().startsWith(file2.getPath()))
          return file; 
        throw new SecurityException("Resolved path jumped beyond configured root");
      } catch (IOException iOException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Failed to resolve canonical path for ");
        stringBuilder1.append(file1);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to find configured root for ");
    stringBuilder.append(file1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Uri getUriForFile(File paramFile) {
    StringBuilder stringBuilder;
    try {
      Map.Entry<String, File> entry;
      StringBuilder stringBuilder1;
      String str = paramFile.getCanonicalPath();
      paramFile = null;
      for (Map.Entry<String, File> entry1 : this.mRoots.entrySet()) {
        String str1 = ((File)entry1.getValue()).getPath();
        if (str.startsWith(str1) && (paramFile == null || str1.length() > ((File)paramFile.getValue()).getPath().length()))
          entry = entry1; 
      } 
      if (entry != null) {
        String str2 = ((File)entry.getValue()).getPath();
        if (str2.endsWith("/")) {
          str2 = str.substring(str2.length());
        } else {
          str2 = str.substring(str2.length() + 1);
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(Uri.encode(entry.getKey()));
        stringBuilder1.append('/');
        stringBuilder1.append(Uri.encode(str2, "/"));
        String str1 = stringBuilder1.toString();
        return (new Uri.Builder()).scheme("content").authority(this.mAuthority).encodedPath(str1).build();
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to find configured root that contains ");
      stringBuilder.append((String)stringBuilder1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } catch (IOException iOException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Failed to resolve canonical path for ");
      stringBuilder1.append(stringBuilder);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\FileProvider$SimplePathStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */