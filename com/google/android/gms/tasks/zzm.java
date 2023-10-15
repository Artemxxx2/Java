package com.google.android.gms.tasks;

final class zzm implements Runnable {
  zzm(zzn paramzzn, Task paramTask) {}
  
  public final void run() {
    synchronized (zzn.zzb(this.zzb)) {
      zzn zzn1 = this.zzb;
      if (zzn.zza(zzn1) != null)
        zzn.zza(zzn1).onSuccess(this.zza.getResult()); 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */