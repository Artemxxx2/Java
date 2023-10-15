package com.alexdisler.inapppurchases;

import android.util.Log;
import java.util.List;

class null implements IabHelper.OnQueryIabSkuDetailsFinishedListener {
  protected boolean itemsProcessed = false;
  
  protected boolean subsProcessed = false;
  
  public void onAllProcessed() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("oqapf onAllProcessed: ");
    stringBuilder.append(this.subsProcessed);
    stringBuilder.append(" ");
    stringBuilder.append(this.itemsProcessed);
    Log.d("google.payments Helper", stringBuilder.toString());
    if (this.subsProcessed && this.itemsProcessed) {
      this.this$2.this$1.this$0.flagEndAsync();
      final IabResult result_f = new IabResult(0, "Inventory refresh successful.");
      final Inventory inv_f = inv;
      if (!this.this$2.this$1.this$0.mDisposed && listener != null)
        handler.post(new Runnable() {
              public void run() {
                listener.onQueryInventoryFinished(result_f, inv_f);
              }
            }); 
    } 
  }
  
  public void onQueryIabSkuDetailsFinished(List<IabSkuDetails> paramList, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("listener:  ");
    stringBuilder.append(paramString);
    stringBuilder.append(paramList);
    Log.d("google.payments Helper", stringBuilder.toString());
    for (IabSkuDetails iabSkuDetails : paramList) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("isd: ");
      stringBuilder1.append(iabSkuDetails);
      Log.d("google.payments Helper", stringBuilder1.toString());
    } 
    if (paramString == "subs") {
      this.subsProcessed = true;
    } else if (paramString == "inapp") {
      this.itemsProcessed = true;
    } 
    onAllProcessed();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$4$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */