package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class zza implements Runnable {
  private final Runnable zza;
  
  public zza(Runnable paramRunnable, int paramInt) {
    this.zza = paramRunnable;
  }
  
  public final void run() {
    Process.setThreadPriority(0);
    this.zza.run();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\concurrent\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */