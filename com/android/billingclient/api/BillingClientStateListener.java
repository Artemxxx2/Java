package com.android.billingclient.api;

import androidx.annotation.NonNull;

public interface BillingClientStateListener {
  void onBillingServiceDisconnected();
  
  void onBillingSetupFinished(@NonNull BillingResult paramBillingResult);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClientStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */