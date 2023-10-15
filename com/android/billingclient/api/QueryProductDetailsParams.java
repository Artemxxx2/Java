package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.Iterator;
import java.util.List;

@zzj
public final class QueryProductDetailsParams {
  private final zzu zza;
  
  @NonNull
  @zzj
  public static Builder newBuilder() {
    return new Builder(null);
  }
  
  public final zzu zza() {
    return this.zza;
  }
  
  @NonNull
  public final String zzb() {
    return ((Product)this.zza.get(0)).zzb();
  }
  
  @zzj
  public static class Builder {
    private zzu zza;
    
    private Builder() {}
    
    @NonNull
    @zzj
    public QueryProductDetailsParams build() {
      return new QueryProductDetailsParams(this, null);
    }
    
    @NonNull
    @zzj
    public Builder setProductList(@NonNull List<QueryProductDetailsParams.Product> param1List) {
      if (param1List != null && !param1List.isEmpty()) {
        Iterator<QueryProductDetailsParams.Product> iterator = param1List.iterator();
        boolean bool1 = false;
        boolean bool2;
        for (bool2 = false; iterator.hasNext(); bool2 |= product.zzb().equals("subs")) {
          QueryProductDetailsParams.Product product = iterator.next();
          bool1 |= product.zzb().equals("inapp");
        } 
        if (!bool1 || !bool2) {
          this.zza = zzu.zzk(param1List);
          return this;
        } 
        throw new IllegalArgumentException("All products should be of the same product type.");
      } 
      throw new IllegalArgumentException("Product list cannot be empty.");
    }
  }
  
  @zzj
  public static class Product {
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
    public Builder setProductId(@NonNull String param1String) {
      this.zza = param1String;
      return this;
    }
    
    @NonNull
    @zzj
    public Builder setProductType(@NonNull String param1String) {
      this.zzb = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\QueryProductDetailsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */