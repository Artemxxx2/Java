package com.alexdisler.inapppurchases;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;

class null implements IabHelper.OnQueryAllPurchasesFinishedListener {
  public void onQueryAllPurchasesFinished(List<IabPurchase> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onQueryAllPurchasesFinished: ");
    stringBuilder.append(paramList);
    Log.d("google.payments Helper", stringBuilder.toString());
    try {
      if (queryIabSkuDetails) {
        IabHelper.OnQueryIabSkuDetailsFinishedListener onQueryIabSkuDetailsFinishedListener = new IabHelper.OnQueryIabSkuDetailsFinishedListener() {
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
            
            public void onQueryIabSkuDetailsFinished(List<IabSkuDetails> param3List, String param3String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("listener:  ");
              stringBuilder.append(param3String);
              stringBuilder.append(param3List);
              Log.d("google.payments Helper", stringBuilder.toString());
              for (IabSkuDetails iabSkuDetails : param3List) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("isd: ");
                stringBuilder1.append(iabSkuDetails);
                Log.d("google.payments Helper", stringBuilder1.toString());
              } 
              if (param3String == "subs") {
                this.subsProcessed = true;
              } else if (param3String == "inapp") {
                this.itemsProcessed = true;
              } 
              onAllProcessed();
            }
          };
        super(this);
        try {
          this.this$1.this$0.queryIabSkuDetailsAsync("inapp", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
          this.this$1.this$0.queryIabSkuDetailsAsync("subs", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
        } catch (RemoteException remoteException) {
          IabException iabException = new IabException();
          this(-1001, "Remote exception while refreshing inventory.", (Exception)remoteException);
          throw iabException;
        } 
      } else {
        this.this$1.this$0.flagEndAsync();
        final IabResult result_f = new IabResult();
        this(0, "Inventory refresh successful.");
        final Inventory inv_f = inv;
        if (!this.this$1.this$0.mDisposed && listener != null) {
          Handler handler = handler;
          Runnable runnable = new Runnable() {
              public void run() {
                listener.onQueryInventoryFinished(result_f, inv_f);
              }
            };
          super(this, iabResult, inventory);
          handler.post(runnable);
        } 
      } 
    } catch (IabException iabException) {
      final IabResult result_f = iabException.getResult();
      this.this$1.this$0.flagEndAsync();
      final Inventory inv_f = inv;
      if (!this.this$1.this$0.mDisposed && listener != null)
        handler.post(new Runnable() {
              public void run() {
                listener.onQueryInventoryFinished(result_f, inv_f);
              }
            }); 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */