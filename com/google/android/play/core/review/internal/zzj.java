package com.google.android.play.core.review.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzj implements Runnable {
  @Nullable
  private final TaskCompletionSource zza = null;
  
  zzj() {}
  
  public zzj(@Nullable TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void run() {
    try {
      zza();
      return;
    } catch (Exception exception) {
      zzc(exception);
      return;
    } 
  }
  
  protected abstract void zza();
  
  @Nullable
  final TaskCompletionSource zzb() {
    return this.zza;
  }
  
  public final void zzc(Exception paramException) {
    TaskCompletionSource taskCompletionSource = this.zza;
    if (taskCompletionSource != null)
      taskCompletionSource.trySetException(paramException); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */