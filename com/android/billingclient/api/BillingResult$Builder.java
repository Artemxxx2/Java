package com.android.billingclient.api;

import androidx.annotation.NonNull;

public class Builder {
  private int zza;
  
  private String zzb = "";
  
  private Builder() {}
  
  @NonNull
  public BillingResult build() {
    BillingResult billingResult = new BillingResult();
    BillingResult.zzb(billingResult, this.zza);
    BillingResult.zza(billingResult, this.zzb);
    return billingResult;
  }
  
  @NonNull
  public Builder setDebugMessage(@NonNull String paramString) {
    this.zzb = paramString;
    return this;
  }
  
  @NonNull
  public Builder setResponseCode(int paramInt) {
    this.zza = paramInt;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingResult$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */