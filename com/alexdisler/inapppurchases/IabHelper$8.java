package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.List;

class null implements SkuDetailsResponseListener {
  public void onSkuDetailsResponse(BillingResult paramBillingResult, List<SkuDetails> paramList) {
    Log.d("google.payments Helper", "onIabSkuDetailsResponse");
    for (SkuDetails skuDetails : paramList) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Got sku details: ");
      stringBuilder.append(skuDetails);
      Log.d("google.payments Helper", stringBuilder.toString());
      IabSkuDetails iabSkuDetails = new IabSkuDetails(itemType, skuDetails);
      inv.addIabSkuDetails(iabSkuDetails);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */