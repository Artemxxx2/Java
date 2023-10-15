package com.alexdisler.inapppurchases;

import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

class null implements IabHelper.OnConsumeFinishedListener {
  public void onConsumeFinished(IabPurchase paramIabPurchase, IabResult paramIabResult) {
    if (paramIabResult.isFailure()) {
      if (paramIabResult.getResponse() == 8) {
        callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-10), paramIabResult));
      } else {
        callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-11), paramIabResult));
      } 
    } else {
      try {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put("transactionId", paramIabPurchase.getOrderId());
        jSONObject.put("productId", paramIabPurchase.getSku());
        jSONObject.put("token", paramIabPurchase.getToken());
        callbackContext.success(jSONObject);
      } catch (JSONException jSONException) {
        callbackContext.error("Consume succeeded but success handler failed");
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */