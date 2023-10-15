package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@Retention(RetentionPolicy.SOURCE)
public @interface SkuType {
  @NonNull
  public static final String INAPP = "inapp";
  
  @NonNull
  public static final String SUBS = "subs";
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient$SkuType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */