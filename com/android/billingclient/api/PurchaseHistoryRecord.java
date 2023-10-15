package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseHistoryRecord {
  private final String zza;
  
  private final String zzb;
  
  private final JSONObject zzc;
  
  public PurchaseHistoryRecord(@NonNull String paramString1, @NonNull String paramString2) throws JSONException {
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
    if (!(paramObject instanceof PurchaseHistoryRecord))
      return false; 
    paramObject = paramObject;
    return (TextUtils.equals(this.zza, paramObject.getOriginalJson()) && TextUtils.equals(this.zzb, paramObject.getSignature()));
  }
  
  @NonNull
  public String getDeveloperPayload() {
    return this.zzc.optString("developerPayload");
  }
  
  @NonNull
  public String getOriginalJson() {
    return this.zza;
  }
  
  @NonNull
  @zzj
  public List<String> getProducts() {
    return zza();
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
  
  @NonNull
  public String toString() {
    return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.zza));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\PurchaseHistoryRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */