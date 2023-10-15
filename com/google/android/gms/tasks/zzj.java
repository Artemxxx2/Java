package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class zzj implements zzq {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  @Nullable
  @GuardedBy("mLock")
  private OnCompleteListener zzc;
  
  public zzj(@NonNull Executor paramExecutor, @NonNull OnCompleteListener paramOnCompleteListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnCompleteListener;
  }
  
  public final void zzc() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zzd(@NonNull Task paramTask) {
    synchronized (this.zzb) {
      if (this.zzc == null)
        return; 
      this.zza.execute(new zzi(this, paramTask));
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */