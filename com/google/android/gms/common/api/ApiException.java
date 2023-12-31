package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiException extends Exception {
  @Deprecated
  @NonNull
  protected final Status mStatus;
  
  public ApiException(@NonNull Status paramStatus) {
    super(stringBuilder.toString());
    String str;
    this.mStatus = paramStatus;
  }
  
  @NonNull
  public Status getStatus() {
    return this.mStatus;
  }
  
  public int getStatusCode() {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  @Nullable
  public String getStatusMessage() {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */