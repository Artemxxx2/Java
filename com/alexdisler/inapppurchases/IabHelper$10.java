package com.alexdisler.inapppurchases;

import android.os.Handler;
import android.util.Log;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import java.util.ArrayList;
import java.util.List;

class null implements Runnable {
  public void run() {
    final ArrayList<IabResult> results = new ArrayList();
    IabHelper.ConsumeAsyncFinishedListener consumeAsyncFinishedListener = new IabHelper.ConsumeAsyncFinishedListener() {
        public void onConsumeFinished() {
          if (this.allConsumesStarted && this.consumesCompleted == this.totalConsumes) {
            IabHelper.this.flagEndAsync();
            if (!IabHelper.this.mDisposed && singleListener != null)
              handler.post(new Runnable() {
                    public void run() {
                      singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                    }
                  }); 
            if (!IabHelper.this.mDisposed && multiListener != null)
              handler.post(new Runnable() {
                    public void run() {
                      multiListener.onConsumeMultiFinished(purchases, results);
                    }
                  }); 
          } 
        }
        
        public void onConsumeResponse(BillingResult param2BillingResult, String param2String) {
          List<IabResult> list;
          if (param2BillingResult.getResponseCode() == 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Successfully consumed purchase: ");
            stringBuilder1.append(param2String);
            Log.d("google.payments Helper", stringBuilder1.toString());
            list = results;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Successful consume of purchase ");
            stringBuilder2.append(param2String);
            list.add(new IabResult(0, stringBuilder2.toString()));
          } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error consuming consuming purchase ");
            stringBuilder2.append(param2String);
            stringBuilder2.append(". ");
            stringBuilder2.append(list.getDebugMessage());
            Log.d("google.payments Helper", stringBuilder2.toString());
            List<IabResult> list1 = results;
            int i = list.getResponseCode();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Error consuming purchase ");
            stringBuilder1.append(param2String);
            list1.add(new IabResult(i, stringBuilder1.toString()));
          } 
          this.consumesCompleted++;
          onConsumeFinished();
        }
      };
    for (IabPurchase iabPurchase : purchases) {
      StringBuilder stringBuilder1;
      IabHelper iabHelper;
      String str1 = iabPurchase.getToken();
      String str2 = iabPurchase.getSku();
      if (str1 == null || str1.equals("")) {
        iabHelper = IabHelper.this;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Can't consume ");
        stringBuilder1.append(str2);
        stringBuilder1.append(". No token.");
        iabHelper.logError(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("PurchaseInfo is missing token for sku: ");
        stringBuilder1.append(str2);
        arrayList.add(new IabResult(6, stringBuilder1.toString()));
        continue;
      } 
      consumeAsyncFinishedListener.totalConsumes++;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Consuming sku: ");
      stringBuilder2.append(str2);
      stringBuilder2.append(", token: ");
      stringBuilder2.append((String)iabHelper);
      Log.d("google.payments Helper", stringBuilder2.toString());
      ConsumeParams consumeParams = ConsumeParams.newBuilder().setPurchaseToken(stringBuilder1.getToken()).build();
      IabHelper.this.billingClient.consumeAsync(consumeParams, consumeAsyncFinishedListener);
    } 
    consumeAsyncFinishedListener.allConsumesStarted = true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */