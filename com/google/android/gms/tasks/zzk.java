package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

final class zzk implements Runnable {
  zzk(zzl paramzzl, Task paramTask) {}
  
  public final void run() {
    synchronized (zzl.zzb(this.zzb)) {
      zzl zzl1 = this.zzb;
      if (zzl.zza(zzl1) != null)
        zzl.zza(zzl1).onFailure((Exception)Preconditions.checkNotNull(this.zza.getException())); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */