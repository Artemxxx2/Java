package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzd;

final class zzap implements ServiceConnection {
  private final Object zzb = new Object();
  
  private boolean zzc = false;
  
  private BillingClientStateListener zzd;
  
  private final void zzd(BillingResult paramBillingResult) {
    synchronized (this.zzb) {
      BillingClientStateListener billingClientStateListener = this.zzd;
      if (billingClientStateListener != null)
        billingClientStateListener.onBillingSetupFinished(paramBillingResult); 
      return;
    } 
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    zzb.zzn("BillingClient", "Billing service connected.");
    BillingClientImpl.zzB(this.zza, zzd.zzo(paramIBinder));
    BillingClientImpl billingClientImpl = this.zza;
    if (BillingClientImpl.zzp(billingClientImpl, new zzam(this), 30000L, new zzan(this), BillingClientImpl.zzf(billingClientImpl)) == null)
      zzd(BillingClientImpl.zzh(this.zza)); 
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    zzb.zzo("BillingClient", "Billing service disconnected.");
    BillingClientImpl.zzB(this.zza, null);
    BillingClientImpl.zzq(this.zza, 0);
    synchronized (this.zzb) {
      BillingClientStateListener billingClientStateListener = this.zzd;
      if (billingClientStateListener != null)
        billingClientStateListener.onBillingServiceDisconnected(); 
      return;
    } 
  }
  
  final void zzc() {
    synchronized (this.zzb) {
      this.zzd = null;
      this.zzc = true;
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */