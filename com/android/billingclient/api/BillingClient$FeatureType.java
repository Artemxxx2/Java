package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface FeatureType {
  @NonNull
  @zzf
  public static final String IN_APP_MESSAGING = "bbb";
  
  @NonNull
  public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
  
  @NonNull
  @zzj
  public static final String PRODUCT_DETAILS = "fff";
  
  @NonNull
  public static final String SUBSCRIPTIONS = "subscriptions";
  
  @NonNull
  public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient$FeatureType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */