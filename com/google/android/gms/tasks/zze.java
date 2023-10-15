package com.google.android.gms.tasks;

final class zze implements Runnable {
  zze(zzf paramzzf, Task paramTask) {}
  
  public final void run() {
    try {
      Task task = (Task)zzf.zza(this.zzb).then(this.zza);
      if (task == null) {
        this.zzb.onFailure(new NullPointerException("Continuation returned null"));
        return;
      } 
      task.addOnSuccessListener(TaskExecutors.zza, this.zzb);
      task.addOnFailureListener(TaskExecutors.zza, this.zzb);
      task.addOnCanceledListener(TaskExecutors.zza, this.zzb);
      return;
    } catch (RuntimeExecutionException runtimeExecutionException) {
      if (runtimeExecutionException.getCause() instanceof Exception) {
        zzf.zzb(this.zzb).zza((Exception)runtimeExecutionException.getCause());
        return;
      } 
      zzf.zzb(this.zzb).zza(runtimeExecutionException);
      return;
    } catch (Exception exception) {
      zzf.zzb(this.zzb).zza(exception);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */