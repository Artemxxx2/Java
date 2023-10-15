package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzj
public final class ProductDetails {
  private final String zza;
  
  private final JSONObject zzb;
  
  private final String zzc;
  
  private final String zzd;
  
  private final String zze;
  
  private final String zzf;
  
  private final String zzg;
  
  private final String zzh;
  
  @Nullable
  private final List zzi;
  
  ProductDetails(String paramString) throws JSONException {
    this.zza = paramString;
    this.zzb = new JSONObject(this.zza);
    this.zzc = this.zzb.optString("productId");
    this.zzd = this.zzb.optString("type");
    if (!TextUtils.isEmpty(this.zzc)) {
      if (!TextUtils.isEmpty(this.zzd)) {
        this.zze = this.zzb.optString("title");
        this.zzf = this.zzb.optString("name");
        this.zzg = this.zzb.optString("description");
        this.zzh = this.zzb.optString("skuDetailsToken");
        if (!this.zzd.equals("inapp")) {
          ArrayList<SubscriptionOfferDetails> arrayList = new ArrayList();
          JSONArray jSONArray = this.zzb.optJSONArray("subscriptionOfferDetails");
          if (jSONArray != null)
            for (byte b = 0; b < jSONArray.length(); b++)
              arrayList.add(new SubscriptionOfferDetails(jSONArray.getJSONObject(b)));  
          this.zzi = arrayList;
          return;
        } 
        this.zzi = null;
        return;
      } 
      throw new IllegalArgumentException("Product type cannot be empty.");
    } 
    throw new IllegalArgumentException("Product id cannot be empty.");
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ProductDetails))
      return false; 
    paramObject = paramObject;
    return TextUtils.equals(this.zza, ((ProductDetails)paramObject).zza);
  }
  
  @NonNull
  @zzj
  public String getDescription() {
    return this.zzg;
  }
  
  @NonNull
  @zzj
  public String getName() {
    return this.zzf;
  }
  
  @Nullable
  @zzg
  public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
    JSONObject jSONObject = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
    return (jSONObject != null) ? new OneTimePurchaseOfferDetails(jSONObject) : null;
  }
  
  @NonNull
  @zzj
  public String getProductId() {
    return this.zzc;
  }
  
  @NonNull
  @zzj
  public String getProductType() {
    return this.zzd;
  }
  
  @Nullable
  @zzj
  public List<SubscriptionOfferDetails> getSubscriptionOfferDetails() {
    return this.zzi;
  }
  
  @NonNull
  @zzj
  public String getTitle() {
    return this.zze;
  }
  
  public final int hashCode() {
    return this.zza.hashCode();
  }
  
  @NonNull
  public final String toString() {
    String str1 = this.zza;
    String str2 = this.zzb.toString();
    String str3 = this.zzc;
    String str4 = this.zzd;
    String str5 = this.zze;
    String str6 = this.zzh;
    String str7 = String.valueOf(this.zzi);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ProductDetails{jsonString='");
    stringBuilder.append(str1);
    stringBuilder.append("', parsedJson=");
    stringBuilder.append(str2);
    stringBuilder.append(", productId='");
    stringBuilder.append(str3);
    stringBuilder.append("', productType='");
    stringBuilder.append(str4);
    stringBuilder.append("', title='");
    stringBuilder.append(str5);
    stringBuilder.append("', productDetailsToken='");
    stringBuilder.append(str6);
    stringBuilder.append("', subscriptionOfferDetails=");
    stringBuilder.append(str7);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  @NonNull
  public final String zza() {
    return this.zzb.optString("packageName");
  }
  
  final String zzb() {
    return this.zzh;
  }
  
  @zzg
  public static final class OneTimePurchaseOfferDetails {
    private final String zza;
    
    private final long zzb;
    
    private final String zzc;
    
    private final String zzd;
    
    private final String zze;
    
    OneTimePurchaseOfferDetails(JSONObject param1JSONObject) {
      this.zza = param1JSONObject.optString("formattedPrice");
      this.zzb = param1JSONObject.optLong("priceAmountMicros");
      this.zzc = param1JSONObject.optString("priceCurrencyCode");
      this.zzd = param1JSONObject.optString("offerIdToken");
      this.zze = param1JSONObject.optString("offerId");
      param1JSONObject.optInt("offerType");
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
  
  @zzj
  public static final class PricingPhase {
    private final int billingCycleCount;
    
    private final String billingPeriod;
    
    private final String formattedPrice;
    
    private final long priceAmountMicros;
    
    private final String priceCurrencyCode;
    
    private final int recurrenceMode;
    
    PricingPhase(JSONObject param1JSONObject) {
      this.billingPeriod = param1JSONObject.optString("billingPeriod");
      this.priceCurrencyCode = param1JSONObject.optString("priceCurrencyCode");
      this.formattedPrice = param1JSONObject.optString("formattedPrice");
      this.priceAmountMicros = param1JSONObject.optLong("priceAmountMicros");
      this.recurrenceMode = param1JSONObject.optInt("recurrenceMode");
      this.billingCycleCount = param1JSONObject.optInt("billingCycleCount");
    }
    
    public int getBillingCycleCount() {
      return this.billingCycleCount;
    }
    
    @NonNull
    public String getBillingPeriod() {
      return this.billingPeriod;
    }
    
    @NonNull
    public String getFormattedPrice() {
      return this.formattedPrice;
    }
    
    public long getPriceAmountMicros() {
      return this.priceAmountMicros;
    }
    
    @NonNull
    public String getPriceCurrencyCode() {
      return this.priceCurrencyCode;
    }
    
    public int getRecurrenceMode() {
      return this.recurrenceMode;
    }
  }
  
  @zzj
  public static class PricingPhases {
    private final List<ProductDetails.PricingPhase> pricingPhaseList;
    
    PricingPhases(JSONArray param1JSONArray) {
      ArrayList<ProductDetails.PricingPhase> arrayList = new ArrayList();
      if (param1JSONArray != null)
        for (byte b = 0; b < param1JSONArray.length(); b++) {
          JSONObject jSONObject = param1JSONArray.optJSONObject(b);
          if (jSONObject != null)
            arrayList.add(new ProductDetails.PricingPhase(jSONObject)); 
        }  
      this.pricingPhaseList = arrayList;
    }
    
    @NonNull
    public List<ProductDetails.PricingPhase> getPricingPhaseList() {
      return this.pricingPhaseList;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @zzj
  public static @interface RecurrenceMode {
    @zzj
    public static final int FINITE_RECURRING = 2;
    
    @zzj
    public static final int INFINITE_RECURRING = 1;
    
    @zzj
    public static final int NON_RECURRING = 3;
  }
  
  @zzj
  public static final class SubscriptionOfferDetails {
    @Nullable
    private final zzbg installmentPlanDetails;
    
    private final List<String> offerTags;
    
    private final String offerToken;
    
    private final ProductDetails.PricingPhases pricingPhases;
    
    SubscriptionOfferDetails(JSONObject param1JSONObject) throws JSONException {
      zzbg zzbg1;
      this.offerToken = param1JSONObject.getString("offerIdToken");
      this.pricingPhases = new ProductDetails.PricingPhases(param1JSONObject.getJSONArray("pricingPhases"));
      JSONObject jSONObject = param1JSONObject.optJSONObject("installmentPlanDetails");
      if (jSONObject == null) {
        jSONObject = null;
      } else {
        zzbg1 = new zzbg(jSONObject);
      } 
      this.installmentPlanDetails = zzbg1;
      ArrayList<String> arrayList = new ArrayList();
      JSONArray jSONArray = param1JSONObject.optJSONArray("offerTags");
      if (jSONArray != null)
        for (byte b = 0; b < jSONArray.length(); b++)
          arrayList.add(jSONArray.getString(b));  
      this.offerTags = arrayList;
    }
    
    @Nullable
    public zzbg getInstallmentPlanDetails() {
      return this.installmentPlanDetails;
    }
    
    @NonNull
    public List<String> getOfferTags() {
      return this.offerTags;
    }
    
    @NonNull
    public String getOfferToken() {
      return this.offerToken;
    }
    
    @NonNull
    public ProductDetails.PricingPhases getPricingPhases() {
      return this.pricingPhases;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProductDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */