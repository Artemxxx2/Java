package com.android.billingclient.api;

import android.text.TextUtils;

public final class zzbt {
  private String zza;
  
  private zzbt() {}
  
  public final zzbt zza(String paramString) {
    this.zza = paramString;
    return this;
  }
  
  public final zzbv zzb() {
    if (!TextUtils.isEmpty(this.zza))
      return new zzbv(this.zza, null, null, 0, null); 
    throw new IllegalArgumentException("SKU must be set.");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */