package com.google.android.gms.tasks;

final class zzc implements Runnable {
  zzc(zzd paramzzd, Task paramTask) {}
  
  public final void run() {
    if (this.zza.isCanceled()) {
      zzd.zzb(this.zzb).zzc();
      return;
    } 
    try {
      Object object = zzd.zza(this.zzb).then(this.zza);
      zzd.zzb(this.zzb).zzb(object);
      return;
    } catch (RuntimeExecutionException runtimeExecutionException) {
      if (runtimeExecutionException.getCause() instanceof Exception) {
        zzd.zzb(this.zzb).zza((Exception)runtimeExecutionException.getCause());
        return;
      } 
      zzd.zzb(this.zzb).zza(runtimeExecutionException);
      return;
    } catch (Exception exception) {
      zzd.zzb(this.zzb).zza(exception);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */