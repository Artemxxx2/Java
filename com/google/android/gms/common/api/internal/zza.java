package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zza implements Runnable {
  zza(zzb paramzzb, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run() {
    zzb zzb1 = this.zzc;
    if (zzb.zza(zzb1) > 0) {
      LifecycleCallback lifecycleCallback = this.zza;
      if (zzb.zzb(zzb1) != null) {
        Bundle bundle = zzb.zzb(zzb1).getBundle(this.zzb);
      } else {
        zzb1 = null;
      } 
      lifecycleCallback.onCreate((Bundle)zzb1);
    } 
    if (zzb.zza(this.zzc) >= 2)
      this.zza.onStart(); 
    if (zzb.zza(this.zzc) >= 3)
      this.zza.onResume(); 
    if (zzb.zza(this.zzc) >= 4)
      this.zza.onStop(); 
    if (zzb.zza(this.zzc) >= 5)
      this.zza.onDestroy(); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */