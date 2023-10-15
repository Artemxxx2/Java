package com.alexdisler.inapppurchases;

import android.app.Activity;
import android.util.Log;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.List;

class null implements SkuDetailsResponseListener {
  public void onSkuDetailsResponse(BillingResult paramBillingResult, List<SkuDetails> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("purch skus: ");
    stringBuilder.append(paramList);
    Log.d("google.payments Helper", stringBuilder.toString());
    for (SkuDetails skuDetails : paramList) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sku deets: ");
      stringBuilder1.append(skuDetails);
      Log.d("google.payments Helper", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sku id: ");
      stringBuilder1.append(skuDetails.getSku());
      Log.d("google.payments Helper", stringBuilder1.toString());
      if (sku.equals(skuDetails.getSku())) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("got sku: ");
        stringBuilder1.append(skuDetails);
        Log.d("google.payments Helper", stringBuilder1.toString());
        BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
        IabHelper.this.billingClient.launchBillingFlow(act, billingFlowParams);
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */