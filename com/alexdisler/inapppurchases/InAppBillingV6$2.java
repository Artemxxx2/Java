package com.alexdisler.inapppurchases;

import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

class null implements IabHelper.OnIabPurchaseFinishedListener {
  public void onIabPurchaseFinished(IabResult paramIabResult, IabPurchase paramIabPurchase) {
    CallbackContext callbackContext;
    if (paramIabResult.isFailure()) {
      int i = paramIabResult.getResponse();
      if (i == -1002 || i == -1008) {
        callbackContext.error(InAppBillingV6.this.makeError("Could not complete purchase", Integer.valueOf(-6), paramIabResult));
        return;
      } 
      if (i == -1003) {
        callbackContext.error(InAppBillingV6.this.makeError("Could not complete purchase", Integer.valueOf(-6), paramIabResult));
      } else if (i == -1005) {
        callbackContext.error(InAppBillingV6.this.makeError("Purchase Cancelled", Integer.valueOf(-5), paramIabResult));
      } else if (i == 7) {
        callbackContext.error(InAppBillingV6.this.makeError("Item already owned", Integer.valueOf(-9), paramIabResult));
      } else {
        callbackContext = callbackContext;
        InAppBillingV6 inAppBillingV6 = InAppBillingV6.this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error completing purchase: ");
        stringBuilder.append(i);
        callbackContext.error(inAppBillingV6.makeError(stringBuilder.toString(), Integer.valueOf(-4), paramIabResult));
      } 
    } else {
      try {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put("orderId", callbackContext.getOrderId());
        jSONObject.put("packageName", callbackContext.getPackageName());
        jSONObject.put("productId", callbackContext.getSku());
        jSONObject.put("purchaseTime", callbackContext.getPurchaseTime());
        jSONObject.put("purchaseState", callbackContext.getPurchaseState());
        jSONObject.put("purchaseToken", callbackContext.getToken());
        jSONObject.put("signature", callbackContext.getSignature());
        jSONObject.put("type", callbackContext.getItemType());
        jSONObject.put("receipt", callbackContext.getOriginalJson());
        callbackContext.success(jSONObject);
      } catch (JSONException jSONException) {
        callbackContext.error("Purchase succeeded but success handler failed");
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */