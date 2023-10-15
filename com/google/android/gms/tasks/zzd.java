package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzd implements zzq {
  private final Executor zza;
  
  private final Continuation zzb;
  
  private final zzw zzc;
  
  public zzd(@NonNull Executor paramExecutor, @NonNull Continuation paramContinuation, @NonNull zzw paramzzw) {
    this.zza = paramExecutor;
    this.zzb = paramContinuation;
    this.zzc = paramzzw;
  }
  
  public final void zzc() {
    throw new UnsupportedOperationException();
  }
  
  public final void zzd(@NonNull Task paramTask) {
    this.zza.execute(new zzc(this, paramTask));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */