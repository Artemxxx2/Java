package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ProrationMode {
  public static final int DEFERRED = 4;
  
  public static final int IMMEDIATE_AND_CHARGE_FULL_PRICE = 5;
  
  public static final int IMMEDIATE_AND_CHARGE_PRORATED_PRICE = 2;
  
  public static final int IMMEDIATE_WITHOUT_PRORATION = 3;
  
  public static final int IMMEDIATE_WITH_TIME_PRORATION = 1;
  
  public static final int UNKNOWN_SUBSCRIPTION_UPGRADE_DOWNGRADE_POLICY = 0;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingFlowParams$ProrationMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */