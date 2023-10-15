package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ConnectionState {
  public static final int CLOSED = 3;
  
  public static final int CONNECTED = 2;
  
  public static final int CONNECTING = 1;
  
  public static final int DISCONNECTED = 0;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient$ConnectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */