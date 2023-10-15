package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class SkuDetails {
  private final String zza;
  
  private final JSONObject zzb;
  
  public SkuDetails(@NonNull String paramString) throws JSONException {
    this.zza = paramString;
    this.zzb = new JSONObject(this.zza);
    if (!TextUtils.isEmpty(this.zzb.optString("productId"))) {
      if (!TextUtils.isEmpty(this.zzb.optString("type")))
        return; 
      throw new IllegalArgumentException("SkuType cannot be empty.");
    } 
    throw new IllegalArgumentException("SKU cannot be empty.");
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof SkuDetails))
      return false; 
    paramObject = paramObject;
    return TextUtils.equals(this.zza, ((SkuDetails)paramObject).zza);
  }
  
  @NonNull
  public String getDescription() {
    return this.zzb.optString("description");
  }
  
  @NonNull
  public String getFreeTrialPeriod() {
    return this.zzb.optString("freeTrialPeriod");
  }
  
  @NonNull
  public String getIconUrl() {
    return this.zzb.optString("iconUrl");
  }
  
  @NonNull
  public String getIntroductoryPrice() {
    return this.zzb.optString("introductoryPrice");
  }
  
  public long getIntroductoryPriceAmountMicros() {
    return this.zzb.optLong("introductoryPriceAmountMicros");
  }
  
  public int getIntroductoryPriceCycles() {
    return this.zzb.optInt("introductoryPriceCycles");
  }
  
  @NonNull
  public String getIntroductoryPricePeriod() {
    return this.zzb.optString("introductoryPricePeriod");
  }
  
  @NonNull
  public String getOriginalJson() {
    return this.zza;
  }
  
  @NonNull
  public String getOriginalPrice() {
    return this.zzb.has("original_price") ? this.zzb.optString("original_price") : getPrice();
  }
  
  public long getOriginalPriceAmountMicros() {
    return this.zzb.has("original_price_micros") ? this.zzb.optLong("original_price_micros") : getPriceAmountMicros();
  }
  
  @NonNull
  public String getPrice() {
    return this.zzb.optString("price");
  }
  
  public long getPriceAmountMicros() {
    return this.zzb.optLong("price_amount_micros");
  }
  
  @NonNull
  public String getPriceCurrencyCode() {
    return this.zzb.optString("price_currency_code");
  }
  
  @NonNull
  public String getSku() {
    return this.zzb.optString("productId");
  }
  
  @NonNull
  public String getSubscriptionPeriod() {
    return this.zzb.optString("subscriptionPeriod");
  }
  
  @NonNull
  public String getTitle() {
    return this.zzb.optString("title");
  }
  
  @NonNull
  public String getType() {
    return this.zzb.optString("type");
  }
  
  public int hashCode() {
    return this.zza.hashCode();
  }
  
  @NonNull
  public String toString() {
    return "SkuDetails: ".concat(String.valueOf(this.zza));
  }
  
  public int zza() {
    return this.zzb.optInt("offer_type");
  }
  
  @NonNull
  public String zzb() {
    return this.zzb.optString("offer_id");
  }
  
  @NonNull
  public String zzc() {
    String str1 = this.zzb.optString("offerIdToken");
    String str2 = str1;
    if (str1.isEmpty())
      str2 = this.zzb.optString("offer_id_token"); 
    return str2;
  }
  
  @NonNull
  public final String zzd() {
    return this.zzb.optString("packageName");
  }
  
  @NonNull
  public String zze() {
    return this.zzb.optString("serializedDocid");
  }
  
  final String zzf() {
    return this.zzb.optString("skuDetailsToken");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */