package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzr extends GmsClientSupervisor {
  @GuardedBy("connectionStatus")
  private final HashMap zzb = new HashMap<Object, Object>();
  
  private final Context zzc;
  
  private volatile Handler zzd;
  
  private final zzq zze = new zzq(this, null);
  
  private final ConnectionTracker zzf;
  
  private final long zzg;
  
  private final long zzh;
  
  zzr(Context paramContext, Looper paramLooper) {
    this.zzc = paramContext.getApplicationContext();
    this.zzd = (Handler)new zzi(paramLooper, this.zze);
    this.zzf = ConnectionTracker.getInstance();
    this.zzg = 5000L;
    this.zzh = 300000L;
  }
  
  protected final void zza(zzn paramzzn, ServiceConnection paramServiceConnection, String paramString) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzb) {
      zzo zzo = (zzo)this.zzb.get(paramzzn);
      if (zzo != null) {
        Message message;
        if (zzo.zzh(paramServiceConnection)) {
          zzo.zzf(paramServiceConnection, paramString);
          if (zzo.zzi()) {
            message = this.zzd.obtainMessage(0, paramzzn);
            this.zzd.sendMessageDelayed(message, this.zzg);
          } 
          return;
        } 
        IllegalStateException illegalStateException1 = new IllegalStateException();
        paramString = message.toString();
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        stringBuilder.append(paramString);
        this(stringBuilder.toString());
        throw illegalStateException1;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      paramString = stringBuilder.toString();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Nonexistent connection status for service config: ");
      stringBuilder.append(paramString);
      this(stringBuilder.toString());
      throw illegalStateException;
    } 
  }
  
  protected final boolean zzc(zzn paramzzn, ServiceConnection paramServiceConnection, String paramString, @Nullable Executor paramExecutor) {
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    synchronized (this.zzb) {
      zzo zzo1;
      String str;
      zzo zzo2 = (zzo)this.zzb.get(paramzzn);
      if (zzo2 == null) {
        zzo2 = new zzo();
        this(this, paramzzn);
        zzo2.zzd(paramServiceConnection, paramServiceConnection, paramString);
        zzo2.zze(paramString, paramExecutor);
        this.zzb.put(paramzzn, zzo2);
        zzo1 = zzo2;
      } else {
        this.zzd.removeMessages(0, zzo1);
        if (!zzo2.zzh(paramServiceConnection)) {
          zzo2.zzd(paramServiceConnection, paramServiceConnection, paramString);
          switch (zzo2.zza()) {
            default:
              zzo1 = zzo2;
              bool = zzo1.zzj();
              return bool;
            case 2:
              zzo2.zze(paramString, paramExecutor);
              zzo1 = zzo2;
              bool = zzo1.zzj();
              return bool;
            case 1:
              break;
          } 
          paramServiceConnection.onServiceConnected(zzo2.zzb(), zzo2.zzc());
          zzo1 = zzo2;
          boolean bool = zzo1.zzj();
          return bool;
        } 
        IllegalStateException illegalStateException = new IllegalStateException();
        str = zzo1.toString();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
        stringBuilder.append(str);
        this(stringBuilder.toString());
        throw illegalStateException;
      } 
      return str.zzj();
    } 
  }
  
  final void zzi(Looper paramLooper) {
    synchronized (this.zzb) {
      zzi zzi = new zzi();
      this(paramLooper, this.zze);
      this.zzd = (Handler)zzi;
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */