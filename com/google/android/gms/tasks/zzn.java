package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class zzn implements zzq {
  private final Executor zza;
  
  private final Object zzb = new Object();
  
  @Nullable
  @GuardedBy("mLock")
  private OnSuccessListener zzc;
  
  public zzn(@NonNull Executor paramExecutor, @NonNull OnSuccessListener paramOnSuccessListener) {
    this.zza = paramExecutor;
    this.zzc = paramOnSuccessListener;
  }
  
  public final void zzc() {
    synchronized (this.zzb) {
      this.zzc = null;
      return;
    } 
  }
  
  public final void zzd(@NonNull Task paramTask) {
    if (paramTask.isSuccessful())
      synchronized (this.zzb) {
        if (this.zzc == null)
          return; 
        this.zza.execute(new zzm(this, paramTask));
        return;
      }  
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */