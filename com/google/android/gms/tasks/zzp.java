package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzp<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {
  private final Executor zza;
  
  private final SuccessContinuation zzb;
  
  private final zzw zzc;
  
  public zzp(@NonNull Executor paramExecutor, @NonNull SuccessContinuation paramSuccessContinuation, @NonNull zzw paramzzw) {
    this.zza = paramExecutor;
    this.zzb = paramSuccessContinuation;
    this.zzc = paramzzw;
  }
  
  public final void onCanceled() {
    this.zzc.zzc();
  }
  
  public final void onFailure(@NonNull Exception paramException) {
    this.zzc.zza(paramException);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult) {
    this.zzc.zzb(paramTContinuationResult);
  }
  
  public final void zzc() {
    throw new UnsupportedOperationException();
  }
  
  public final void zzd(@NonNull Task paramTask) {
    this.zza.execute(new zzo(this, paramTask));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */