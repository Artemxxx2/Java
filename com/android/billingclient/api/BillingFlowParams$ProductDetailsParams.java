package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzm;

@zzj
public final class ProductDetailsParams {
  private final ProductDetails zza;
  
  private final String zzb;
  
  @NonNull
  @zzj
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  @NonNull
  public final ProductDetails zza() {
    return this.zza;
  }
  
  @NonNull
  public final String zzb() {
    return this.zzb;
  }
  
  @zzj
  public static class Builder {
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
    public Builder setOfferToken(@NonNull String param2String) {
      this.zzb = param2String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setProductDetails(@NonNull ProductDetails param2ProductDetails) {
      this.zza = param2ProductDetails;
      if (param2ProductDetails.getOneTimePurchaseOfferDetails() != null)
        if (param2ProductDetails.getOneTimePurchaseOfferDetails() != null) {
          this.zzb = param2ProductDetails.getOneTimePurchaseOfferDetails().zza();
        } else {
          throw null;
        }  
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingFlowParams$ProductDetailsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */