package com.alexdisler.inapppurchases;

import android.util.Log;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;

class null implements BillingClientStateListener {
  public void onBillingServiceDisconnected() {
    Log.d("google.payments Helper", "Billing service disconnected.");
  }
  
  public void onBillingSetupFinished(BillingResult paramBillingResult) {
    if (IabHelper.this.mDisposed)
      return; 
    Log.d("google.payments Helper", "Billing service connected.");
    String str = IabHelper.this.mContext.getPackageName();
    Log.d("google.payments Helper", "Checking for in-app billing 6 support.");
    int i = paramBillingResult.getResponseCode();
    if (i != 0) {
      IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener1 = listener;
      if (onIabSetupFinishedListener1 != null)
        onIabSetupFinishedListener1.onIabSetupFinished(new IabResult(i, "Error checking for billing v6 support.")); 
      IabHelper.this.mSubscriptionsSupported = false;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In-app billing version 6 supported for ");
    stringBuilder.append(str);
    Log.d("google.payments Helper", stringBuilder.toString());
    i = IabHelper.this.billingClient.isFeatureSupported("subscriptions").getResponseCode();
    if (i == 0) {
      Log.d("google.payments Helper", "Subscriptions AVAILABLE.");
      IabHelper.this.mSubscriptionsSupported = true;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Subscriptions NOT AVAILABLE. Response: ");
      stringBuilder.append(i);
      Log.d("google.payments Helper", stringBuilder.toString());
    } 
    IabHelper.this.mSetupDone = true;
    IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = listener;
    if (onIabSetupFinishedListener != null)
      onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful.")); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */