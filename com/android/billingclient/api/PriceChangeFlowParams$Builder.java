package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;

@zzi
public class Builder {
  private SkuDetails skuDetails;
  
  private Builder setSkuDetails(String paramString) {
    try {
      SkuDetails skuDetails = new SkuDetails();
      this(paramString);
      this.skuDetails = skuDetails;
      return this;
    } catch (JSONException jSONException) {
      throw new IllegalArgumentException("Incorrect skuDetails JSON object!", jSONException);
    } 
  }
  
  @NonNull
  public PriceChangeFlowParams build() {
    SkuDetails skuDetails = this.skuDetails;
    if (skuDetails != null) {
      PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
      PriceChangeFlowParams.-$$Nest$fputskuDetails(priceChangeFlowParams, skuDetails);
      return priceChangeFlowParams;
    } 
    throw new IllegalArgumentException("SkuDetails must be set");
  }
  
  @NonNull
  public Builder setSkuDetails(@NonNull SkuDetails paramSkuDetails) {
    this.skuDetails = paramSkuDetails;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\PriceChangeFlowParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */