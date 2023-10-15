package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BillingResponseCode {
  public static final int BILLING_UNAVAILABLE = 3;
  
  public static final int DEVELOPER_ERROR = 5;
  
  public static final int ERROR = 6;
  
  public static final int FEATURE_NOT_SUPPORTED = -2;
  
  public static final int ITEM_ALREADY_OWNED = 7;
  
  public static final int ITEM_NOT_OWNED = 8;
  
  public static final int ITEM_UNAVAILABLE = 4;
  
  public static final int OK = 0;
  
  public static final int SERVICE_DISCONNECTED = -1;
  
  public static final int SERVICE_TIMEOUT = -3;
  
  public static final int SERVICE_UNAVAILABLE = 2;
  
  public static final int USER_CANCELED = 1;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient$BillingResponseCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */