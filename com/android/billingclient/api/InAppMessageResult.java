package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@zzf
public final class InAppMessageResult {
  @Nullable
  private final String mPurchaseToken;
  
  private final int mResponseCode;
  
  public InAppMessageResult(int paramInt, @Nullable String paramString) {
    this.mResponseCode = paramInt;
    this.mPurchaseToken = paramString;
  }
  
  @Nullable
  public String getPurchaseToken() {
    return this.mPurchaseToken;
  }
  
  public int getResponseCode() {
    return this.mResponseCode;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @zzf
  public static @interface InAppMessageResponseCode {
    public static final int NO_ACTION_NEEDED = 0;
    
    public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\InAppMessageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */