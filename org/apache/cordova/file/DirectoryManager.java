package org.apache.cordova.file;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager {
  private static final String LOG_TAG = "DirectoryManager";
  
  private static File constructFilePaths(String paramString1, String paramString2) {
    File file;
    if (paramString2.startsWith(paramString1)) {
      file = new File(paramString2);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)file);
      stringBuilder.append("/");
      stringBuilder.append(paramString2);
      file = new File(stringBuilder.toString());
    } 
    return file;
  }
  
  public static long getFreeExternalStorageSpace() {
    return Environment.getExternalStorageState().equals("mounted") ? (getFreeSpaceInBytes(Environment.getExternalStorageDirectory().getPath()) / 1024L) : -1L;
  }
  
  public static long getFreeSpaceInBytes(String paramString) {
    try {
      StatFs statFs = new StatFs();
      this(paramString);
      long l = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      return i * l;
    } catch (IllegalArgumentException illegalArgumentException) {
      return 0L;
    } 
  }
  
  public static boolean testFileExists(String paramString) {
    boolean bool;
    if (testSaveLocationExists() && !paramString.equals("")) {
      bool = constructFilePaths(Environment.getExternalStorageDirectory().toString(), paramString).exists();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean testSaveLocationExists() {
    return Environment.getExternalStorageState().equals("mounted");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\DirectoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */