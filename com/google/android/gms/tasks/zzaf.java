package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class zzaf<T> implements zzae<T> {
  private final Object zza = new Object();
  
  private final int zzb;
  
  private final zzw zzc;
  
  @GuardedBy("mLock")
  private int zzd;
  
  @GuardedBy("mLock")
  private int zze;
  
  @GuardedBy("mLock")
  private int zzf;
  
  @GuardedBy("mLock")
  private Exception zzg;
  
  @GuardedBy("mLock")
  private boolean zzh;
  
  public zzaf(int paramInt, zzw paramzzw) {
    this.zzb = paramInt;
    this.zzc = paramzzw;
  }
  
  @GuardedBy("mLock")
  private final void zza() {
    int i = this.zzd;
    int j = this.zze;
    int k = this.zzf;
    int m = this.zzb;
    if (i + j + k == m) {
      if (this.zzg != null) {
        zzw zzw1 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append(" out of ");
        stringBuilder.append(m);
        stringBuilder.append(" underlying tasks failed");
        zzw1.zza(new ExecutionException(stringBuilder.toString(), this.zzg));
        return;
      } 
      if (this.zzh) {
        this.zzc.zzc();
        return;
      } 
      this.zzc.zzb(null);
    } 
  }
  
  public final void onCanceled() {
    synchronized (this.zza) {
      this.zzf++;
      this.zzh = true;
      zza();
      return;
    } 
  }
  
  public final void onFailure(@NonNull Exception paramException) {
    synchronized (this.zza) {
      this.zze++;
      this.zzg = paramException;
      zza();
      return;
    } 
  }
  
  public final void onSuccess(T paramT) {
    synchronized (this.zza) {
      this.zzd++;
      zza();
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */