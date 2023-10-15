package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONObject;

@zzj
public final class PricingPhase {
  private final int billingCycleCount;
  
  private final String billingPeriod;
  
  private final String formattedPrice;
  
  private final long priceAmountMicros;
  
  private final String priceCurrencyCode;
  
  private final int recurrenceMode;
  
  PricingPhase(JSONObject paramJSONObject) {
    this.billingPeriod = paramJSONObject.optString("billingPeriod");
    this.priceCurrencyCode = paramJSONObject.optString("priceCurrencyCode");
    this.formattedPrice = paramJSONObject.optString("formattedPrice");
    this.priceAmountMicros = paramJSONObject.optLong("priceAmountMicros");
    this.recurrenceMode = paramJSONObject.optInt("recurrenceMode");
    this.billingCycleCount = paramJSONObject.optInt("billingCycleCount");
  }
  
  public int getBillingCycleCount() {
    return this.billingCycleCount;
  }
  
  @NonNull
  public String getBillingPeriod() {
    return this.billingPeriod;
  }
  
  @NonNull
  public String getFormattedPrice() {
    return this.formattedPrice;
  }
  
  public long getPriceAmountMicros() {
    return this.priceAmountMicros;
  }
  
  @NonNull
  public String getPriceCurrencyCode() {
    return this.priceCurrencyCode;
  }
  
  public int getRecurrenceMode() {
    return this.recurrenceMode;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails$PricingPhase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */