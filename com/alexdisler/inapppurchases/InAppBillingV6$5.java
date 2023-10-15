package com.alexdisler.inapppurchases;

import java.util.Iterator;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements IabHelper.QueryInventoryFinishedListener {
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory) {
    if (paramIabResult.isFailure()) {
      callbackContext.error("Error retrieving SKU details");
      return;
    } 
    JSONArray jSONArray = new JSONArray();
    try {
      Iterator<String> iterator = moreSkus.iterator();
      while (iterator.hasNext()) {
        IabSkuDetails iabSkuDetails = paramInventory.getIabSkuDetails(iterator.next());
        if (iabSkuDetails != null) {
          JSONObject jSONObject = new JSONObject();
          this();
          jSONObject.put("productId", iabSkuDetails.getSku());
          jSONObject.put("title", iabSkuDetails.getTitle());
          jSONObject.put("description", iabSkuDetails.getDescription());
          jSONObject.put("priceAsDecimal", iabSkuDetails.getPriceAsDecimal());
          jSONObject.put("price", iabSkuDetails.getPrice());
          jSONObject.put("priceRaw", iabSkuDetails.getPriceRaw());
          jSONObject.put("currency", iabSkuDetails.getPriceCurrency());
          jSONObject.put("country", "-");
          jSONObject.put("type", iabSkuDetails.getType());
          jSONObject.put("currency", iabSkuDetails.getPriceCurrency());
          jSONArray.put(jSONObject);
        } 
      } 
    } catch (JSONException jSONException) {
      callbackContext.error(jSONException.getMessage());
    } 
    callbackContext.success(jSONArray);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */