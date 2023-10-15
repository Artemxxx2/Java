package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

final class zzb extends CancellationToken {
  private final zzw zza = new zzw();
  
  public final boolean isCancellationRequested() {
    return this.zza.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener paramOnTokenCanceledListener) {
    zzw zzw1 = this.zza;
    zza zza = new zza(this, paramOnTokenCanceledListener);
    zzw1.addOnSuccessListener(TaskExecutors.MAIN_THREAD, zza);
    return this;
  }
  
  public final void zza() {
    this.zza.zze(null);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */