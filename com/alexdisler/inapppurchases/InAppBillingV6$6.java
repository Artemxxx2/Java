package com.alexdisler.inapppurchases;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements IabHelper.QueryInventoryFinishedListener {
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory) {
    if (paramIabResult.isFailure()) {
      callbackContext.error("Error retrieving purchase details");
      return;
    } 
    JSONArray jSONArray = new JSONArray();
    try {
      for (IabPurchase iabPurchase : paramInventory.getAllPurchases()) {
        if (iabPurchase != null) {
          JSONObject jSONObject = new JSONObject();
          this();
          jSONObject.put("orderId", iabPurchase.getOrderId());
          jSONObject.put("packageName", iabPurchase.getPackageName());
          jSONObject.put("productId", iabPurchase.getSku());
          jSONObject.put("purchaseTime", iabPurchase.getPurchaseTime());
          jSONObject.put("purchaseState", iabPurchase.getPurchaseState());
          jSONObject.put("purchaseToken", iabPurchase.getToken());
          jSONObject.put("signature", iabPurchase.getSignature());
          jSONObject.put("type", iabPurchase.getItemType());
          jSONObject.put("receipt", iabPurchase.getOriginalJson());
          jSONArray.put(jSONObject);
        } 
      } 
    } catch (JSONException jSONException) {
      callbackContext.error(jSONException.getMessage());
    } 
    callbackContext.success(jSONArray);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */