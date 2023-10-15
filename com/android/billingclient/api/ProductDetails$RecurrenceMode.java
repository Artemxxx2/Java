package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@zzj
public @interface RecurrenceMode {
  @zzj
  public static final int FINITE_RECURRING = 2;
  
  @zzj
  public static final int INFINITE_RECURRING = 1;
  
  @zzj
  public static final int NON_RECURRING = 3;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails$RecurrenceMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */