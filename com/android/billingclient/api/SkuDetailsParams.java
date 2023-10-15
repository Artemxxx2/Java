package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class SkuDetailsParams {
  private String zza;
  
  private List zzb;
  
  @NonNull
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  @NonNull
  public String getSkuType() {
    return this.zza;
  }
  
  @NonNull
  public List<String> getSkusList() {
    return this.zzb;
  }
  
  public static class Builder {
    private String zza;
    
    private List zzb;
    
    private Builder() {}
    
    @NonNull
    public SkuDetailsParams build() {
      String str = this.zza;
      if (str != null) {
        if (this.zzb != null) {
          SkuDetailsParams skuDetailsParams = new SkuDetailsParams();
          SkuDetailsParams.zza(skuDetailsParams, str);
          SkuDetailsParams.zzb(skuDetailsParams, this.zzb);
          return skuDetailsParams;
        } 
        throw new IllegalArgumentException("SKU list or SkuWithOffer list must be set");
      } 
      throw new IllegalArgumentException("SKU type must be set");
    }
    
    @NonNull
    public Builder setSkusList(@NonNull List<String> param1List) {
      this.zzb = new ArrayList<String>(param1List);
      return this;
    }
    
    @NonNull
    public Builder setType(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\SkuDetailsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */