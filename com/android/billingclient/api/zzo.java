package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;

final class zzo {
  private final Context zza;
  
  private final zzn zzb;
  
  zzo(Context paramContext, PurchasesUpdatedListener paramPurchasesUpdatedListener, zzc paramzzc) {
    this.zza = paramContext;
    this.zzb = new zzn(this, paramPurchasesUpdatedListener, paramzzc, null);
  }
  
  zzo(Context paramContext, zzbe paramzzbe) {
    this.zza = paramContext;
    this.zzb = new zzn(this, null, null);
  }
  
  @Nullable
  final zzbe zzb() {
    zzn.zza(this.zzb);
    return null;
  }
  
  @Nullable
  final PurchasesUpdatedListener zzc() {
    return zzn.zzb(this.zzb);
  }
  
  final void zzd() {
    this.zzb.zzd(this.zza);
  }
  
  final void zze() {
    IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
    intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
    this.zzb.zzc(this.zza, intentFilter);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */