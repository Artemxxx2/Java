package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzr {
  private final Object zza = new Object();
  
  @GuardedBy("mLock")
  private Queue zzb;
  
  @GuardedBy("mLock")
  private boolean zzc;
  
  public final void zza(@NonNull zzq paramzzq) {
    synchronized (this.zza) {
      if (this.zzb == null) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this();
        this.zzb = arrayDeque;
      } 
      this.zzb.add(paramzzq);
      return;
    } 
  }
  
  public final void zzb(@NonNull Task paramTask) {
    synchronized (this.zza) {
      if (this.zzb == null || this.zzc)
        return; 
      this.zzc = true;
      while (true) {
        synchronized (this.zza) {
          zzq zzq = this.zzb.poll();
          if (zzq == null) {
            this.zzc = false;
            return;
          } 
          zzq.zzd(paramTask);
        } 
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */