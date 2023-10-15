package com.alexdisler.inapppurchases;

import com.android.billingclient.api.ConsumeResponseListener;

public abstract class ConsumeAsyncFinishedListener implements ConsumeResponseListener {
  public boolean allConsumesStarted = false;
  
  public int consumesCompleted = 0;
  
  public int totalConsumes = 0;
  
  public abstract void onConsumeFinished();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$ConsumeAsyncFinishedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */