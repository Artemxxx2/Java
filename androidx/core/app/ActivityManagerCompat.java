package androidx.core.app;

import android.app.ActivityManager;
import android.os.Build;
import androidx.annotation.NonNull;

public final class ActivityManagerCompat {
  public static boolean isLowRamDevice(@NonNull ActivityManager paramActivityManager) {
    return (Build.VERSION.SDK_INT >= 19) ? paramActivityManager.isLowRamDevice() : false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */