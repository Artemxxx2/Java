package com.android.billingclient.api;

import androidx.annotation.NonNull;

public final class Builder {
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
  public Builder setPurchaseToken(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ConsumeParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */