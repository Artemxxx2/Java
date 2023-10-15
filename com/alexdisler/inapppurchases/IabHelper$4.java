package com.alexdisler.inapppurchases;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import java.util.List;

class null implements Runnable {
  public void run() {
    new IabResult(0, "Inventory refresh successful.");
    Inventory inventory = new Inventory();
    try {
      IabHelper iabHelper = IabHelper.this;
      List<String> list = moreSkus;
      IabHelper.OnQueryAllPurchasesFinishedListener onQueryAllPurchasesFinishedListener = new IabHelper.OnQueryAllPurchasesFinishedListener() {
          public void onQueryAllPurchasesFinished(List<IabPurchase> param2List) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onQueryAllPurchasesFinished: ");
            stringBuilder.append(param2List);
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
                        IabHelper.this.flagEndAsync();
                        final IabResult result_f = new IabResult(0, "Inventory refresh successful.");
                        final Inventory inv_f = inv;
                        if (!IabHelper.this.mDisposed && listener != null)
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
                  IabHelper.this.queryIabSkuDetailsAsync("inapp", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
                  IabHelper.this.queryIabSkuDetailsAsync("subs", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
                } catch (RemoteException remoteException) {
                  IabException iabException = new IabException();
                  this(-1001, "Remote exception while refreshing inventory.", (Exception)remoteException);
                  throw iabException;
                } 
              } else {
                IabHelper.this.flagEndAsync();
                final IabResult result_f = new IabResult();
                this(0, "Inventory refresh successful.");
                final Inventory inv_f = inv;
                if (!IabHelper.this.mDisposed && listener != null) {
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
              IabHelper.this.flagEndAsync();
              final Inventory inv_f = inv;
              if (!IabHelper.this.mDisposed && listener != null)
                handler.post(new Runnable() {
                      public void run() {
                        listener.onQueryInventoryFinished(result_f, inv_f);
                      }
                    }); 
            } 
          }
        };
      super(this, inventory);
      iabHelper.queryAllPurchasesAsync(inventory, list, onQueryAllPurchasesFinishedListener);
    } catch (RemoteException remoteException) {
      IabException iabException = new IabException();
      this(-1001, "Remote exception while refreshing inventory.", (Exception)remoteException);
      throw iabException;
    } catch (NullPointerException nullPointerException) {
      IabException iabException = new IabException();
      this(-1008, "NullPointerException while refreshing inventory.", nullPointerException);
      throw iabException;
    } catch (IabException iabException) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */