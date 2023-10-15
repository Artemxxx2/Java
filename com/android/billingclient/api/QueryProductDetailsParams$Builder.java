package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.Iterator;
import java.util.List;

@zzj
public class Builder {
  private zzu zza;
  
  private Builder() {}
  
  @NonNull
  @zzj
  public QueryProductDetailsParams build() {
    return new QueryProductDetailsParams(this, null);
  }
  
  @NonNull
  @zzj
  public Builder setProductList(@NonNull List<QueryProductDetailsParams.Product> paramList) {
    if (paramList != null && !paramList.isEmpty()) {
      Iterator<QueryProductDetailsParams.Product> iterator = paramList.iterator();
      boolean bool1 = false;
      boolean bool2;
      for (bool2 = false; iterator.hasNext(); bool2 |= product.zzb().equals("subs")) {
        QueryProductDetailsParams.Product product = iterator.next();
        bool1 |= product.zzb().equals("inapp");
      } 
      if (!bool1 || !bool2) {
        this.zza = zzu.zzk(paramList);
        return this;
      } 
      throw new IllegalArgumentException("All products should be of the same product type.");
    } 
    throw new IllegalArgumentException("Product list cannot be empty.");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\QueryProductDetailsParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */