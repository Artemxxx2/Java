package com.google.android.play.core.review.internal;

import android.os.IBinder;
import java.util.Iterator;

final class zzp extends zzj {
  zzp(zzs paramzzs, IBinder paramIBinder) {}
  
  public final void zza() {
    zzt.zzk(this.zzb.zza, zze.zzb(this.zza));
    zzt.zzn(this.zzb.zza);
    zzt.zzj(this.zzb.zza, false);
    Iterator<Runnable> iterator = zzt.zzg(this.zzb.zza).iterator();
    while (iterator.hasNext())
      ((Runnable)iterator.next()).run(); 
    zzt.zzg(this.zzb.zza).clear();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */