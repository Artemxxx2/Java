package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class ConsumeParams {
  private String zza;
  
  private ConsumeParams() {}
  
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
    public ConsumeParams build() {
      String str = this.zza;
      if (str != null) {
        ConsumeParams consumeParams = new ConsumeParams(null);
        ConsumeParams.zza(consumeParams, str);
        return consumeParams;
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ConsumeParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */