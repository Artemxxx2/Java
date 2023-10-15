package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzm;

@zzj
public class Builder {
  private ProductDetails zza;
  
  private String zzb;
  
  private Builder() {}
  
  @NonNull
  @zzj
  public BillingFlowParams.ProductDetailsParams build() {
    zzm.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
    zzm.zzc(this.zzb, "offerToken is required for constructing ProductDetailsParams.");
    return new BillingFlowParams.ProductDetailsParams(this, null);
  }
  
  @NonNull
  @zzj
  public Builder setOfferToken(@NonNull String paramString) {
    this.zzb = paramString;
    return this;
  }
  
  @NonNull
  @zzj
  public Builder setProductDetails(@NonNull ProductDetails paramProductDetails) {
    this.zza = paramProductDetails;
    if (paramProductDetails.getOneTimePurchaseOfferDetails() != null)
      if (paramProductDetails.getOneTimePurchaseOfferDetails() != null) {
        this.zzb = paramProductDetails.getOneTimePurchaseOfferDetails().zza();
      } else {
        throw null;
      }  
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingFlowParams$ProductDetailsParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */