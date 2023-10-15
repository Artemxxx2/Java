package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONObject;

@zzg
public final class OneTimePurchaseOfferDetails {
  private final String zza;
  
  private final long zzb;
  
  private final String zzc;
  
  private final String zzd;
  
  private final String zze;
  
  OneTimePurchaseOfferDetails(JSONObject paramJSONObject) {
    this.zza = paramJSONObject.optString("formattedPrice");
    this.zzb = paramJSONObject.optLong("priceAmountMicros");
    this.zzc = paramJSONObject.optString("priceCurrencyCode");
    this.zzd = paramJSONObject.optString("offerIdToken");
    this.zze = paramJSONObject.optString("offerId");
    paramJSONObject.optInt("offerType");
  }
  
  @NonNull
  @zzg
  public String getFormattedPrice() {
    return this.zza;
  }
  
  @zzg
  public long getPriceAmountMicros() {
    return this.zzb;
  }
  
  @NonNull
  @zzg
  public String getPriceCurrencyCode() {
    return this.zzc;
  }
  
  @NonNull
  public final String zza() {
    return this.zzd;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails$OneTimePurchaseOfferDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */