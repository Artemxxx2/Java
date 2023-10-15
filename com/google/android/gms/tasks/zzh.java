package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class zzh implements zzq {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  @Nullable
  @GuardedBy("mLock")
  private OnCanceledListener zzc;
  
  public zzh(@NonNull Executor paramExecutor, @NonNull OnCanceledListener paramOnCanceledListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnCanceledListener;
  }
  
  public final void zzc() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zzd(@NonNull Task paramTask) {
    if (paramTask.isCanceled())
      synchronized (this.zzb) {
        if (this.zzc == null)
          return; 
        this.zza.execute(new zzg(this));
        return;
      }  
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */