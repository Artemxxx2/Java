package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TaskCompletionSource<TResult> {
  private final zzw zza = new zzw();
  
  public TaskCompletionSource() {}
  
  public TaskCompletionSource(@NonNull CancellationToken paramCancellationToken) {
    paramCancellationToken.onCanceledRequested(new zzs(this));
  }
  
  @NonNull
  public Task<TResult> getTask() {
    return this.zza;
  }
  
  public void setException(@NonNull Exception paramException) {
    this.zza.zza(paramException);
  }
  
  public void setResult(@Nullable TResult paramTResult) {
    this.zza.zzb(paramTResult);
  }
  
  public boolean trySetException(@NonNull Exception paramException) {
    return this.zza.zzd(paramException);
  }
  
  public boolean trySetResult(@Nullable TResult paramTResult) {
    return this.zza.zze(paramTResult);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\TaskCompletionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */