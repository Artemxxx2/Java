package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;

@AnyThread
public final class Builder {
  private volatile String zza;
  
  private volatile boolean zzb;
  
  private final Context zzc;
  
  private volatile PurchasesUpdatedListener zzd;
  
  private volatile zzbe zze;
  
  private volatile zzc zzf;
  
  @NonNull
  public BillingClient build() {
    if (this.zzc != null) {
      if (this.zzd != null) {
        if (this.zzd != null)
          zzbe zzbe2 = this.zze; 
        if (this.zzb) {
          if (this.zzd == null)
            zzc zzc1 = this.zzf; 
          if (this.zzd != null) {
            String str1 = this.zza;
            boolean bool1 = this.zzb;
            Context context1 = this.zzc;
            PurchasesUpdatedListener purchasesUpdatedListener = this.zzd;
            zzc zzc1 = this.zzf;
            return new BillingClientImpl(null, bool1, context1, purchasesUpdatedListener, null);
          } 
          String str = this.zza;
          boolean bool = this.zzb;
          Context context = this.zzc;
          zzbe zzbe2 = this.zze;
          return new BillingClientImpl(null, bool, context, null);
        } 
        throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
      } 
      zzbe zzbe1 = this.zze;
      throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
    } 
    throw new IllegalArgumentException("Please provide a valid Context.");
  }
  
  @NonNull
  public Builder enablePendingPurchases() {
    this.zzb = true;
    return this;
  }
  
  @NonNull
  public Builder setListener(@NonNull PurchasesUpdatedListener paramPurchasesUpdatedListener) {
    this.zzd = paramPurchasesUpdatedListener;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */