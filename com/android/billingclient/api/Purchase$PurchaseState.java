package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PurchaseState {
  public static final int PENDING = 2;
  
  public static final int PURCHASED = 1;
  
  public static final int UNSPECIFIED_STATE = 0;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\Purchase$PurchaseState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */