package com.android.billingclient.api;

import androidx.annotation.NonNull;

@zzj
public class Builder {
  private String zza;
  
  private String zzb;
  
  private Builder() {}
  
  @NonNull
  @zzj
  public QueryProductDetailsParams.Product build() {
    if (this.zza != null) {
      if (this.zzb != null)
        return new QueryProductDetailsParams.Product(this, null); 
      throw new IllegalArgumentException("Product type must be provided.");
    } 
    throw new IllegalArgumentException("Product id must be provided.");
  }
  
  @NonNull
  @zzj
  public Builder setProductId(@NonNull String paramString) {
    this.zza = paramString;
    return this;
  }
  
  @NonNull
  @zzj
  public Builder setProductType(@NonNull String paramString) {
    this.zzb = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\QueryProductDetailsParams$Product$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */