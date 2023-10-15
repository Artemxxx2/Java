package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class Builder {
  private String zza;
  
  private Builder() {}
  
  @NonNull
  public AcknowledgePurchaseParams build() {
    String str = this.zza;
    if (str != null) {
      AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
      AcknowledgePurchaseParams.zza(acknowledgePurchaseParams, str);
      return acknowledgePurchaseParams;
    } 
    throw new IllegalArgumentException("Purchase token must be set");
  }
  
  @NonNull
  public Builder setPurchaseToken(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\AcknowledgePurchaseParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */