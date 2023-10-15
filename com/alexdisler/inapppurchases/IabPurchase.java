package com.alexdisler.inapppurchases;

import org.json.JSONException;
import org.json.JSONObject;

public class IabPurchase {
  String mDeveloperPayload;
  
  String mItemType;
  
  String mOrderId;
  
  String mOriginalJson;
  
  String mPackageName;
  
  int mPurchaseState;
  
  long mPurchaseTime;
  
  String mSignature;
  
  String mSku;
  
  String mToken;
  
  public IabPurchase(String paramString1, String paramString2, String paramString3) throws JSONException {
    this.mItemType = paramString1;
    this.mOriginalJson = paramString2;
    JSONObject jSONObject = new JSONObject(this.mOriginalJson);
    this.mOrderId = jSONObject.optString("orderId");
    this.mPackageName = jSONObject.optString("packageName");
    this.mSku = jSONObject.optString("productId");
    this.mPurchaseTime = jSONObject.optLong("purchaseTime");
    this.mPurchaseState = jSONObject.optInt("purchaseState");
    this.mDeveloperPayload = jSONObject.optString("developerPayload");
    this.mToken = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    this.mSignature = paramString3;
  }
  
  public String getDeveloperPayload() {
    return this.mDeveloperPayload;
  }
  
  public String getItemType() {
    return this.mItemType;
  }
  
  public String getOrderId() {
    return this.mOrderId;
  }
  
  public String getOriginalJson() {
    return this.mOriginalJson;
  }
  
  public String getPackageName() {
    return this.mPackageName;
  }
  
  public int getPurchaseState() {
    return this.mPurchaseState;
  }
  
  public long getPurchaseTime() {
    return this.mPurchaseTime;
  }
  
  public String getSignature() {
    return this.mSignature;
  }
  
  public String getSku() {
    return this.mSku;
  }
  
  public String getToken() {
    return this.mToken;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PurchaseInfo(type:");
    stringBuilder.append(this.mItemType);
    stringBuilder.append("):");
    stringBuilder.append(this.mOriginalJson);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabPurchase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */