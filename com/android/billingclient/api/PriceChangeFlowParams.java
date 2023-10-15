package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;

@zzi
public class PriceChangeFlowParams {
  private SkuDetails skuDetails;
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder();
  }
  
  @NonNull
  public SkuDetails getSkuDetails() {
    return this.skuDetails;
  }
  
  @zzi
  public static class Builder {
    private SkuDetails skuDetails;
    
    private Builder setSkuDetails(String param1String) {
      try {
        SkuDetails skuDetails = new SkuDetails();
        this(param1String);
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
    public Builder setSkuDetails(@NonNull SkuDetails param1SkuDetails) {
      this.skuDetails = param1SkuDetails;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\PriceChangeFlowParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */