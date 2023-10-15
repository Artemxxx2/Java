package com.google.android.gms.tasks;

final class zzi implements Runnable {
  zzi(zzj paramzzj, Task paramTask) {}
  
  public final void run() {
    synchronized (zzj.zzb(this.zzb)) {
      zzj zzj1 = this.zzb;
      if (zzj.zza(zzj1) != null)
        zzj.zza(zzj1).onComplete(this.zza); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */