package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

class null implements PurchasesResponseListener {
  public void onQueryPurchasesResponse(BillingResult paramBillingResult, List<Purchase> paramList) {
    ArrayList<IabPurchase> arrayList = new ArrayList();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("onQueryPurchasesResponse: ");
    stringBuilder2.append(itemType);
    stringBuilder2.append(" ");
    stringBuilder2.append(paramList);
    Log.d("google.payments Helper", stringBuilder2.toString());
    for (Purchase purchase : paramList) {
      try {
        IabPurchase iabPurchase = new IabPurchase();
        this(itemType, purchase.getOriginalJson(), purchase.getSignature());
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("isd origin: ");
        stringBuilder.append(iabPurchase);
        Log.d("google.payments Helper", stringBuilder.toString());
        inv.addPurchase(iabPurchase);
        arrayList.add(iabPurchase);
      } catch (JSONException jSONException) {
        Log.e("google.payments Helper", "onQueryPurchasesResponse: JSON exception");
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("onPurchasesResponse: ");
    stringBuilder1.append(arrayList);
    Log.d("google.payments Helper", stringBuilder1.toString());
    listener.onQueryPurchasesFinished(arrayList, itemType);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */