package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;

public class Builder {
  private String zza;
  
  private boolean zzb;
  
  private int zzc = 0;
  
  private Builder() {}
  
  @NonNull
  public BillingFlowParams.SubscriptionUpdateParams build() {
    boolean bool;
    if (TextUtils.isEmpty(this.zza)) {
      if (!TextUtils.isEmpty(null)) {
        bool = true;
      } else {
        bool = false;
      } 
    } else {
      bool = true;
    } 
    int i = true ^ TextUtils.isEmpty(null);
    if (!bool || i == 0) {
      if (this.zzb || bool || i != 0) {
        BillingFlowParams.SubscriptionUpdateParams subscriptionUpdateParams = new BillingFlowParams.SubscriptionUpdateParams(null);
        BillingFlowParams.SubscriptionUpdateParams.zzd(subscriptionUpdateParams, this.zza);
        BillingFlowParams.SubscriptionUpdateParams.zze(subscriptionUpdateParams, this.zzc);
        return subscriptionUpdateParams;
      } 
      throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
    } 
    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
  }
  
  @NonNull
  @zzj
  public Builder setOldPurchaseToken(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
  
  @Deprecated
  @NonNull
  public Builder setOldSkuPurchaseToken(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
  
  @NonNull
  @zzj
  public Builder setReplaceProrationMode(int paramInt) {
    this.zzc = paramInt;
    return this;
  }
  
  @Deprecated
  @NonNull
  public Builder setReplaceSkusProrationMode(int paramInt) {
    this.zzc = paramInt;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingFlowParams$SubscriptionUpdateParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */