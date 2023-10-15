package com.alexdisler.inapppurchases;

import android.util.Log;
import org.apache.cordova.CallbackContext;

class null implements IabHelper.OnIabSetupFinishedListener {
  public void onIabSetupFinished(IabResult paramIabResult) {
    if (!paramIabResult.isSuccess()) {
      CallbackContext callbackContext = callbackContext;
      InAppBillingV6 inAppBillingV6 = InAppBillingV6.this;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to initialize billing: ");
      stringBuilder.append(paramIabResult.toString());
      callbackContext.error(inAppBillingV6.makeError(stringBuilder.toString(), Integer.valueOf(-2), paramIabResult));
    } else {
      Log.d("google.payments", "Billing initialized");
      InAppBillingV6.this.billingInitialized = true;
      callbackContext.success();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */