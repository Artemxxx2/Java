package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;

class null implements AcknowledgePurchaseResponseListener {
  public void onAcknowledgePurchaseResponse(BillingResult paramBillingResult) {
    IabResult iabResult;
    if (paramBillingResult.getResponseCode() == 0) {
      Log.d("google.payments Helper", "Successfully acknowledged purchase");
      iabResult = new IabResult(0, "Successful acknowledge of purchase");
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error acknowledging purchase. ");
      stringBuilder.append(iabResult.getDebugMessage());
      Log.d("google.payments Helper", stringBuilder.toString());
      iabResult = new IabResult(iabResult.getResponseCode(), "Error acknowledging purchase.");
    } 
    this.this$1.this$0.flagEndAsync();
    singleListener.onAcknowledgeFinished(purchase, iabResult);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$9$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */