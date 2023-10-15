package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zze implements ServiceConnection {
  private final int zzb;
  
  public zze(BaseGmsClient paramBaseGmsClient, int paramInt) {
    this.zzb = paramInt;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    if (paramIBinder == null) {
      BaseGmsClient.zzk(this.zza, 16);
      return;
    } 
    synchronized (BaseGmsClient.zzd(this.zza)) {
      BaseGmsClient baseGmsClient = this.zza;
      IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if (iInterface != null && iInterface instanceof IGmsServiceBroker) {
        iInterface = iInterface;
      } else {
        iInterface = new zzac(paramIBinder);
      } 
      BaseGmsClient.zzh(baseGmsClient, (IGmsServiceBroker)iInterface);
      this.zza.zzl(0, null, this.zzb);
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    synchronized (BaseGmsClient.zzd(this.zza)) {
      BaseGmsClient.zzh(this.zza, null);
      Handler handler = this.zza.zzb;
      handler.sendMessage(handler.obtainMessage(6, this.zzb, 1));
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */