package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzj
public final class SubscriptionOfferDetails {
  @Nullable
  private final zzbg installmentPlanDetails;
  
  private final List<String> offerTags;
  
  private final String offerToken;
  
  private final ProductDetails.PricingPhases pricingPhases;
  
  SubscriptionOfferDetails(JSONObject paramJSONObject) throws JSONException {
    zzbg zzbg1;
    this.offerToken = paramJSONObject.getString("offerIdToken");
    this.pricingPhases = new ProductDetails.PricingPhases(paramJSONObject.getJSONArray("pricingPhases"));
    JSONObject jSONObject = paramJSONObject.optJSONObject("installmentPlanDetails");
    if (jSONObject == null) {
      jSONObject = null;
    } else {
      zzbg1 = new zzbg(jSONObject);
    } 
    this.installmentPlanDetails = zzbg1;
    ArrayList<String> arrayList = new ArrayList();
    JSONArray jSONArray = paramJSONObject.optJSONArray("offerTags");
    if (jSONArray != null)
      for (byte b = 0; b < jSONArray.length(); b++)
        arrayList.add(jSONArray.getString(b));  
    this.offerTags = arrayList;
  }
  
  @Nullable
  public zzbg getInstallmentPlanDetails() {
    return this.installmentPlanDetails;
  }
  
  @NonNull
  public List<String> getOfferTags() {
    return this.offerTags;
  }
  
  @NonNull
  public String getOfferToken() {
    return this.offerToken;
  }
  
  @NonNull
  public ProductDetails.PricingPhases getPricingPhases() {
    return this.pricingPhases;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails$SubscriptionOfferDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */