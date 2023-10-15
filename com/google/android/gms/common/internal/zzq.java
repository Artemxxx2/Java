package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class zzq implements Handler.Callback {
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return false;
      case 1:
        synchronized (zzr.zzh(this.zza)) {
          zzn zzn = (zzn)paramMessage.obj;
          zzo zzo = (zzo)zzr.zzh(this.zza).get(zzn);
          if (zzo != null && zzo.zza() == 3) {
            String str = String.valueOf(zzn);
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Timeout waiting for ServiceConnection callback ");
            stringBuilder.append(str);
            Exception exception = new Exception();
            this();
            Log.e("GmsClientSupervisor", stringBuilder.toString(), exception);
            ComponentName componentName2 = zzo.zzb();
            ComponentName componentName1 = componentName2;
            if (componentName2 == null)
              componentName1 = zzn.zzb(); 
            componentName2 = componentName1;
            if (componentName1 == null) {
              componentName2 = new ComponentName();
              String str1 = zzn.zzd();
              Preconditions.checkNotNull(str1);
              this(str1, "unknown");
            } 
            zzo.onServiceDisconnected(componentName2);
          } 
          return true;
        } 
      case 0:
        break;
    } 
    synchronized (zzr.zzh(this.zza)) {
      zzn zzn = (zzn)paramMessage.obj;
      zzo zzo = (zzo)zzr.zzh(this.zza).get(zzn);
      if (zzo != null && zzo.zzi()) {
        if (zzo.zzj())
          zzo.zzg("GmsClientSupervisor"); 
        zzr.zzh(this.zza).remove(zzn);
      } 
      return true;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */