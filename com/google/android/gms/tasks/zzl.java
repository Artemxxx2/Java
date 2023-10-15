package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class zzl implements zzq {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  @Nullable
  @GuardedBy("mLock")
  private OnFailureListener zzc;
  
  public zzl(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnFailureListener;
  }
  
  public final void zzc() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zzd(@NonNull Task paramTask) {
    if (!paramTask.isSuccessful() && !paramTask.isCanceled())
      synchronized (this.zzb) {
        if (this.zzc == null)
          return; 
        this.zza.execute(new zzk(this, paramTask));
        return;
      }  
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */