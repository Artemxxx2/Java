package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
public class StatsUtils {
  @NonNull
  @KeepForSdk
  public static String getEventKey(@NonNull PowerManager.WakeLock paramWakeLock, @NonNull String paramString) {
    long l1 = Process.myPid();
    long l2 = System.identityHashCode(paramWakeLock);
    if (true == TextUtils.isEmpty(paramString))
      paramString = ""; 
    return String.valueOf(String.valueOf(l1 << 32L | l2)).concat(String.valueOf(paramString));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\stats\StatsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */