package com.android.billingclient.api;

import androidx.annotation.NonNull;

@zzj
public class Product {
  private final String zza;
  
  private final String zzb;
  
  @NonNull
  @zzj
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  @NonNull
  public final String zza() {
    return this.zza;
  }
  
  @NonNull
  public final String zzb() {
    return this.zzb;
  }
  
  @zzj
  public static class Builder {
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
    public Builder setProductId(@NonNull String param2String) {
      this.zza = param2String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setProductType(@NonNull String param2String) {
      this.zzb = param2String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\QueryProductDetailsParams$Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */