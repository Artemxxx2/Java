package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat {
  public static final String MEDIA_UNKNOWN = "unknown";
  
  private static final String TAG = "EnvironmentCompat";
  
  @NonNull
  public static String getStorageState(@NonNull File paramFile) {
    if (Build.VERSION.SDK_INT >= 21)
      return Environment.getExternalStorageState(paramFile); 
    if (Build.VERSION.SDK_INT >= 19)
      return Environment.getStorageState(paramFile); 
    try {
      if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
        return Environment.getExternalStorageState(); 
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to resolve canonical path: ");
      stringBuilder.append(iOException);
      Log.w("EnvironmentCompat", stringBuilder.toString());
    } 
    return "unknown";
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\EnvironmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */