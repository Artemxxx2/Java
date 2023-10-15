package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzc implements Runnable {
  zzc(zzd paramzzd, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    zzd zzd1 = this.zzc;
    if (zzd.zza(zzd1) > 0) {
      LifecycleCallback lifecycleCallback = this.zza;
      if (zzd.zzb(zzd1) != null) {
        Bundle bundle = zzd.zzb(zzd1).getBundle(this.zzb);
      } else {
        zzd1 = null;
      } 
      lifecycleCallback.onCreate((Bundle)zzd1);
    } 
    if (zzd.zza(this.zzc) >= 2)
      this.zza.onStart(); 
    if (zzd.zza(this.zzc) >= 3)
      this.zza.onResume(); 
    if (zzd.zza(this.zzc) >= 4)
      this.zza.onStop(); 
    if (zzd.zza(this.zzc) >= 5)
      this.zza.onDestroy(); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */