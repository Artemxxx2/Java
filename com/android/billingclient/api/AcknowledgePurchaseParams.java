package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class AcknowledgePurchaseParams {
  private String zza;
  
  private AcknowledgePurchaseParams() {}
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  @NonNull
  public String getPurchaseToken() {
    return this.zza;
  }
  
  public static final class Builder {
    private String zza;
    
    private Builder() {}
    
    @NonNull
    public AcknowledgePurchaseParams build() {
      String str = this.zza;
      if (str != null) {
        AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
        AcknowledgePurchaseParams.zza(acknowledgePurchaseParams, str);
        return acknowledgePurchaseParams;
      } 
      throw new IllegalArgumentException("Purchase token must be set");
    }
    
    @NonNull
    public Builder setPurchaseToken(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\AcknowledgePurchaseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */