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

public class Purchase {
  private final String zza;
  
  private final String zzb;
  
  private final JSONObject zzc;
  
  public Purchase(@NonNull String paramString1, @NonNull String paramString2) throws JSONException {
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = new JSONObject(this.zza);
  }
  
  private final ArrayList zza() {
    ArrayList<String> arrayList = new ArrayList();
    if (this.zzc.has("productIds")) {
      JSONArray jSONArray = this.zzc.optJSONArray("productIds");
      if (jSONArray != null)
        for (byte b = 0; b < jSONArray.length(); b++)
          arrayList.add(jSONArray.optString(b));  
    } else if (this.zzc.has("productId")) {
      arrayList.add(this.zzc.optString("productId"));
    } 
    return arrayList;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Purchase))
      return false; 
    paramObject = paramObject;
    return (TextUtils.equals(this.zza, paramObject.getOriginalJson()) && TextUtils.equals(this.zzb, paramObject.getSignature()));
  }
  
  @Nullable
  public AccountIdentifiers getAccountIdentifiers() {
    String str1 = this.zzc.optString("obfuscatedAccountId");
    String str2 = this.zzc.optString("obfuscatedProfileId");
    return (str1 == null && str2 == null) ? null : new AccountIdentifiers(str1, str2);
  }
  
  @NonNull
  public String getDeveloperPayload() {
    return this.zzc.optString("developerPayload");
  }
  
  @NonNull
  public String getOrderId() {
    return this.zzc.optString("orderId");
  }
  
  @NonNull
  public String getOriginalJson() {
    return this.zza;
  }
  
  @NonNull
  public String getPackageName() {
    return this.zzc.optString("packageName");
  }
  
  @NonNull
  @zzj
  public List<String> getProducts() {
    return zza();
  }
  
  public int getPurchaseState() {
    return (this.zzc.optInt("purchaseState", 1) != 4) ? 1 : 2;
  }
  
  public long getPurchaseTime() {
    return this.zzc.optLong("purchaseTime");
  }
  
  @NonNull
  public String getPurchaseToken() {
    JSONObject jSONObject = this.zzc;
    return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
  }
  
  public int getQuantity() {
    return this.zzc.optInt("quantity", 1);
  }
  
  @NonNull
  public String getSignature() {
    return this.zzb;
  }
  
  @Deprecated
  @NonNull
  public ArrayList<String> getSkus() {
    return zza();
  }
  
  public int hashCode() {
    return this.zza.hashCode();
  }
  
  public boolean isAcknowledged() {
    return this.zzc.optBoolean("acknowledged", true);
  }
  
  public boolean isAutoRenewing() {
    return this.zzc.optBoolean("autoRenewing");
  }
  
  @NonNull
  public String toString() {
    return "Purchase. Json: ".concat(String.valueOf(this.zza));
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PurchaseState {
    public static final int PENDING = 2;
    
    public static final int PURCHASED = 1;
    
    public static final int UNSPECIFIED_STATE = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\Purchase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */