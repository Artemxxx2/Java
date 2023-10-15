package com.android.billingclient.api;

import androidx.annotation.NonNull;

@zzj
public class Builder {
  private String zza;
  
  private Builder() {}
  
  @NonNull
  @zzj
  public QueryPurchaseHistoryParams build() {
    if (this.zza != null)
      return new QueryPurchaseHistoryParams(this, null); 
    throw new IllegalArgumentException("Product type must be set");
  }
  
  @NonNull
  @zzj
  public Builder setProductType(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\QueryPurchaseHistoryParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */