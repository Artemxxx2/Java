package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

final class zzo implements ServiceConnection, zzs {
  private final Map zzb;
  
  private int zzc;
  
  private boolean zzd;
  
  @Nullable
  private IBinder zze;
  
  private final zzn zzf;
  
  private ComponentName zzg;
  
  public zzo(zzr paramzzr, zzn paramzzn) {
    this.zzf = paramzzn;
    this.zzb = new HashMap<Object, Object>();
    this.zzc = 2;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    synchronized (zzr.zzh(this.zza)) {
      zzr.zzf(this.zza).removeMessages(1, this.zzf);
      this.zze = paramIBinder;
      this.zzg = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zzb.values().iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceConnected(paramComponentName, paramIBinder); 
      this.zzc = 1;
      return;
    } 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    synchronized (zzr.zzh(this.zza)) {
      zzr.zzf(this.zza).removeMessages(1, this.zzf);
      this.zze = null;
      this.zzg = paramComponentName;
      Iterator<ServiceConnection> iterator = this.zzb.values().iterator();
      while (iterator.hasNext())
        ((ServiceConnection)iterator.next()).onServiceDisconnected(paramComponentName); 
      this.zzc = 2;
      return;
    } 
  }
  
  public final int zza() {
    return this.zzc;
  }
  
  public final ComponentName zzb() {
    return this.zzg;
  }
  
  @Nullable
  public final IBinder zzc() {
    return this.zze;
  }
  
  public final void zzd(ServiceConnection paramServiceConnection1, ServiceConnection paramServiceConnection2, String paramString) {
    this.zzb.put(paramServiceConnection1, paramServiceConnection2);
  }
  
  public final void zze(String paramString, @Nullable Executor paramExecutor) {
    this.zzc = 3;
    StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
    if (PlatformVersion.isAtLeastS())
      StrictMode.setVmPolicy((new StrictMode.VmPolicy.Builder(vmPolicy)).permitUnsafeIntentLaunch().build()); 
    try {
      zzr zzr1 = this.zza;
      boolean bool = zzr.zzg(zzr1).zza(zzr.zze(zzr1), paramString, this.zzf.zzc(zzr.zze(zzr1)), this, this.zzf.zza(), paramExecutor);
      this.zzd = bool;
      if (bool) {
        Message message = zzr.zzf(this.zza).obtainMessage(1, this.zzf);
        zzr.zzf(this.zza).sendMessageDelayed(message, zzr.zzd(this.zza));
      } else {
        this.zzc = 2;
        try {
          zzr zzr2 = this.zza;
          zzr.zzg(zzr2).unbindService(zzr.zze(zzr2), this);
        } catch (IllegalArgumentException illegalArgumentException) {}
      } 
      return;
    } finally {
      StrictMode.setVmPolicy(vmPolicy);
    } 
  }
  
  public final void zzf(ServiceConnection paramServiceConnection, String paramString) {
    this.zzb.remove(paramServiceConnection);
  }
  
  public final void zzg(String paramString) {
    zzr.zzf(this.zza).removeMessages(1, this.zzf);
    zzr zzr1 = this.zza;
    zzr.zzg(zzr1).unbindService(zzr.zze(zzr1), this);
    this.zzd = false;
    this.zzc = 2;
  }
  
  public final boolean zzh(ServiceConnection paramServiceConnection) {
    return this.zzb.containsKey(paramServiceConnection);
  }
  
  public final boolean zzi() {
    return this.zzb.isEmpty();
  }
  
  public final boolean zzj() {
    return this.zzd;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */