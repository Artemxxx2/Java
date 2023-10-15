package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DefaultClock implements Clock {
  private static final DefaultClock zza = new DefaultClock();
  
  @NonNull
  @KeepForSdk
  public static Clock getInstance() {
    return zza;
  }
  
  public final long currentThreadTimeMillis() {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public final long currentTimeMillis() {
    return System.currentTimeMillis();
  }
  
  public final long elapsedRealtime() {
    return SystemClock.elapsedRealtime();
  }
  
  public final long nanoTime() {
    return System.nanoTime();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\DefaultClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */