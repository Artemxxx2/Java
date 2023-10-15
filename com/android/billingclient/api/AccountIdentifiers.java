package com.android.billingclient.api;

import androidx.annotation.Nullable;

public final class AccountIdentifiers {
  @Nullable
  private final String zza;
  
  @Nullable
  private final String zzb;
  
  AccountIdentifiers(@Nullable String paramString1, @Nullable String paramString2) {
    this.zza = paramString1;
    this.zzb = paramString2;
  }
  
  @Nullable
  public String getObfuscatedAccountId() {
    return this.zza;
  }
  
  @Nullable
  public String getObfuscatedProfileId() {
    return this.zzb;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\AccountIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */