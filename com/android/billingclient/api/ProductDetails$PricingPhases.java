package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzj
public class PricingPhases {
  private final List<ProductDetails.PricingPhase> pricingPhaseList;
  
  PricingPhases(JSONArray paramJSONArray) {
    ArrayList<ProductDetails.PricingPhase> arrayList = new ArrayList();
    if (paramJSONArray != null)
      for (byte b = 0; b < paramJSONArray.length(); b++) {
        JSONObject jSONObject = paramJSONArray.optJSONObject(b);
        if (jSONObject != null)
          arrayList.add(new ProductDetails.PricingPhase(jSONObject)); 
      }  
    this.pricingPhaseList = arrayList;
  }
  
  @NonNull
  public List<ProductDetails.PricingPhase> getPricingPhaseList() {
    return this.pricingPhaseList;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails$PricingPhases.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */