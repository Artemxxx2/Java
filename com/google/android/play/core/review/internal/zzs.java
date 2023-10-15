package com.google.android.play.core.review.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class zzs implements ServiceConnection {
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    zzt.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceConnected(%s)", new Object[] { paramComponentName });
    zzt zzt1 = this.zza;
    zzp zzp = new zzp(this, paramIBinder);
    zzt1.zzc().post(zzp);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    zzt.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", new Object[] { paramComponentName });
    zzt zzt1 = this.zza;
    zzq zzq = new zzq(this);
    zzt1.zzc().post(zzq);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */