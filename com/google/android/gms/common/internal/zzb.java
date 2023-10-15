package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.common.zzi;

final class zzb extends zzi {
  public zzb(BaseGmsClient paramBaseGmsClient, Looper paramLooper) {
    super(paramLooper);
  }
  
  private static final void zza(Message paramMessage) {
    zzc zzc = (zzc)paramMessage.obj;
    zzc.zzc();
    zzc.zzg();
  }
  
  private static final boolean zzb(Message paramMessage) {
    return (paramMessage.what == 2 || paramMessage.what == 1 || paramMessage.what == 7);
  }
  
  public final void handleMessage(Message paramMessage) {
    Exception exception;
    if (this.zza.zzd.get() != paramMessage.arg1) {
      if (zzb(paramMessage))
        zza(paramMessage); 
      return;
    } 
    if ((paramMessage.what != 1 && paramMessage.what != 7 && (paramMessage.what != 4 || this.zza.enableLocalFallback()) && paramMessage.what != 5) || this.zza.isConnecting()) {
      ConnectionResult connectionResult;
      int i = paramMessage.what;
      PendingIntent pendingIntent = null;
      if (i == 4) {
        BaseGmsClient.zzg(this.zza, new ConnectionResult(paramMessage.arg2));
        if (BaseGmsClient.zzo(this.zza)) {
          BaseGmsClient baseGmsClient1 = this.zza;
          if (!BaseGmsClient.zzm(baseGmsClient1)) {
            BaseGmsClient.zzi(baseGmsClient1, 3, null);
            return;
          } 
        } 
        BaseGmsClient baseGmsClient = this.zza;
        if (BaseGmsClient.zza(baseGmsClient) != null) {
          connectionResult = BaseGmsClient.zza(baseGmsClient);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zza.zzc.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 5) {
        BaseGmsClient baseGmsClient = this.zza;
        if (BaseGmsClient.zza(baseGmsClient) != null) {
          connectionResult = BaseGmsClient.zza(baseGmsClient);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zza.zzc.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 3) {
        if (((Message)connectionResult).obj instanceof PendingIntent)
          pendingIntent = (PendingIntent)((Message)connectionResult).obj; 
        connectionResult = new ConnectionResult(((Message)connectionResult).arg2, pendingIntent);
        this.zza.zzc.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 6) {
        BaseGmsClient.zzi(this.zza, 5, null);
        BaseGmsClient baseGmsClient = this.zza;
        if (BaseGmsClient.zzb(baseGmsClient) != null)
          BaseGmsClient.zzb(baseGmsClient).onConnectionSuspended(((Message)connectionResult).arg2); 
        this.zza.onConnectionSuspended(((Message)connectionResult).arg2);
        BaseGmsClient.zzn(this.zza, 5, 1, null);
        return;
      } 
      if (((Message)connectionResult).what != 2 || this.zza.isConnected()) {
        if (zzb((Message)connectionResult)) {
          ((zzc)((Message)connectionResult).obj).zze();
          return;
        } 
        i = ((Message)connectionResult).what;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(i);
        exception = new Exception();
        Log.wtf("GmsClient", stringBuilder.toString(), exception);
        return;
      } 
      zza((Message)exception);
      return;
    } 
    zza((Message)exception);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */