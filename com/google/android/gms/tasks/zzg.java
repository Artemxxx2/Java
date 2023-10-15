package com.google.android.gms.tasks;

final class zzg implements Runnable {
  zzg(zzh paramzzh) {}
  
  public final void run() {
    synchronized (zzh.zzb(this.zza)) {
      zzh zzh1 = this.zza;
      if (zzh.zza(zzh1) != null)
        zzh.zza(zzh1).onCanceled(); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */