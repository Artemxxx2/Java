package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.BillingResult;
import java.util.List;

class null extends IabHelper.ConsumeAsyncFinishedListener {
  public void onConsumeFinished() {
    if (this.allConsumesStarted && this.consumesCompleted == this.totalConsumes) {
      this.this$1.this$0.flagEndAsync();
      if (!this.this$1.this$0.mDisposed && singleListener != null)
        handler.post(new Runnable() {
              public void run() {
                singleListener.onConsumeFinished(purchases.get(0), results.get(0));
              }
            }); 
      if (!this.this$1.this$0.mDisposed && multiListener != null)
        handler.post(new Runnable() {
              public void run() {
                multiListener.onConsumeMultiFinished(purchases, results);
              }
            }); 
    } 
  }
  
  public void onConsumeResponse(BillingResult paramBillingResult, String paramString) {
    List<IabResult> list;
    if (paramBillingResult.getResponseCode() == 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Successfully consumed purchase: ");
      stringBuilder1.append(paramString);
      Log.d("google.payments Helper", stringBuilder1.toString());
      list = results;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Successful consume of purchase ");
      stringBuilder2.append(paramString);
      list.add(new IabResult(0, stringBuilder2.toString()));
    } else {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Error consuming consuming purchase ");
      stringBuilder2.append(paramString);
      stringBuilder2.append(". ");
      stringBuilder2.append(list.getDebugMessage());
      Log.d("google.payments Helper", stringBuilder2.toString());
      List<IabResult> list1 = results;
      int i = list.getResponseCode();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Error consuming purchase ");
      stringBuilder1.append(paramString);
      list1.add(new IabResult(i, stringBuilder1.toString()));
    } 
    this.consumesCompleted++;
    onConsumeFinished();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$10$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */