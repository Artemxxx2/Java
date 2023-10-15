package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.ArrayList;
import java.util.List;

class null implements SkuDetailsResponseListener {
  public void onSkuDetailsResponse(BillingResult paramBillingResult, List<SkuDetails> paramList) {
    ArrayList<IabSkuDetails> arrayList = new ArrayList();
    for (SkuDetails skuDetails : paramList) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("onSkuDetailsResponse: ");
      stringBuilder2.append(paramList);
      Log.d("google.payments Helper", stringBuilder2.toString());
      IabSkuDetails iabSkuDetails = new IabSkuDetails(itemType, skuDetails);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("isd origin: ");
      stringBuilder1.append(iabSkuDetails);
      Log.d("google.payments Helper", stringBuilder1.toString());
      inv.addIabSkuDetails(iabSkuDetails);
      arrayList.add(iabSkuDetails);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSkuDetailsResponse: ");
    stringBuilder.append(arrayList);
    Log.d("google.payments Helper", stringBuilder.toString());
    listener.onQueryIabSkuDetailsFinished(arrayList, itemType);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */