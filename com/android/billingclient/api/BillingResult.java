package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

public final class BillingResult {
  private int zza;
  
  private String zzb;
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  @NonNull
  public String getDebugMessage() {
    return this.zzb;
  }
  
  public int getResponseCode() {
    return this.zza;
  }
  
  @NonNull
  public String toString() {
    String str1 = zzb.zzl(this.zza);
    String str2 = this.zzb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Response Code: ");
    stringBuilder.append(str1);
    stringBuilder.append(", Debug Message: ");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  public static class Builder {
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
    public Builder setDebugMessage(@NonNull String param1String) {
      this.zzb = param1String;
      return this;
    }
    
    @NonNull
    public Builder setResponseCode(int param1Int) {
      this.zza = param1Int;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */