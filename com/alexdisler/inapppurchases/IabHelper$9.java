package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingResult;

class null implements Runnable {
  public void run() {
    StringBuilder stringBuilder1;
    IabResult iabResult;
    AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
        public void onAcknowledgePurchaseResponse(BillingResult param2BillingResult) {
          IabResult iabResult;
          if (param2BillingResult.getResponseCode() == 0) {
            Log.d("google.payments Helper", "Successfully acknowledged purchase");
            iabResult = new IabResult(0, "Successful acknowledge of purchase");
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error acknowledging purchase. ");
            stringBuilder.append(iabResult.getDebugMessage());
            Log.d("google.payments Helper", stringBuilder.toString());
            iabResult = new IabResult(iabResult.getResponseCode(), "Error acknowledging purchase.");
          } 
          IabHelper.this.flagEndAsync();
          singleListener.onAcknowledgeFinished(purchase, iabResult);
        }
      };
    String str1 = purchase.getToken();
    String str2 = purchase.getSku();
    if (str1 == null || str1.equals("")) {
      IabHelper iabHelper = IabHelper.this;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can't consume ");
      stringBuilder.append(str2);
      stringBuilder.append(". No token.");
      iabHelper.logError(stringBuilder.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("PurchaseInfo is missing token for sku: ");
      stringBuilder1.append(str2);
      iabResult = new IabResult(6, stringBuilder1.toString());
      IabHelper.this.flagEndAsync();
      singleListener.onAcknowledgeFinished(purchase, iabResult);
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Acknowledging sku: ");
    stringBuilder2.append((String)iabResult);
    stringBuilder2.append(", token: ");
    stringBuilder2.append(str1);
    Log.d("google.payments Helper", stringBuilder2.toString());
    AcknowledgePurchaseParams acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getToken()).build();
    IabHelper.this.billingClient.acknowledgePurchase(acknowledgePurchaseParams, (AcknowledgePurchaseResponseListener)stringBuilder1);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */