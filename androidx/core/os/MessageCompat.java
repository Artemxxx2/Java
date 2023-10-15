package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;

public final class MessageCompat {
  private static boolean sTryIsAsynchronous = true;
  
  private static boolean sTrySetAsynchronous = true;
  
  @SuppressLint({"NewApi"})
  public static boolean isAsynchronous(@NonNull Message paramMessage) {
    if (Build.VERSION.SDK_INT >= 22)
      return paramMessage.isAsynchronous(); 
    if (sTryIsAsynchronous && Build.VERSION.SDK_INT >= 16)
      try {
        return paramMessage.isAsynchronous();
      } catch (NoSuchMethodError noSuchMethodError) {
        sTryIsAsynchronous = false;
      }  
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void setAsynchronous(@NonNull Message paramMessage, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 22) {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    } 
    if (sTrySetAsynchronous && Build.VERSION.SDK_INT >= 16)
      try {
        paramMessage.setAsynchronous(paramBoolean);
      } catch (NoSuchMethodError noSuchMethodError) {
        sTrySetAsynchronous = false;
      }  
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\MessageCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */