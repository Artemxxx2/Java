package com.android.billingclient.api;

import java.util.Collections;
import java.util.List;

final class zzat implements AcknowledgePurchaseResponseListener, BillingClientStateListener, ConsumeResponseListener, PriceChangeConfirmationListener, PurchaseHistoryResponseListener, PurchasesResponseListener, PurchasesUpdatedListener, SkuDetailsResponseListener {
  private final long zza = 0L;
  
  zzat() {}
  
  zzat(long paramLong) {}
  
  public static native void nativeOnAcknowledgePurchaseResponse(int paramInt, String paramString, long paramLong);
  
  public static native void nativeOnBillingServiceDisconnected();
  
  public static native void nativeOnBillingSetupFinished(int paramInt, String paramString, long paramLong);
  
  public static native void nativeOnConsumePurchaseResponse(int paramInt, String paramString1, String paramString2, long paramLong);
  
  public static native void nativeOnPriceChangeConfirmationResult(int paramInt, String paramString, long paramLong);
  
  public static native void nativeOnPurchaseHistoryResponse(int paramInt, String paramString, PurchaseHistoryRecord[] paramArrayOfPurchaseHistoryRecord, long paramLong);
  
  public static native void nativeOnPurchasesUpdated(int paramInt, String paramString, Purchase[] paramArrayOfPurchase);
  
  public static native void nativeOnQueryPurchasesResponse(int paramInt, String paramString, Purchase[] paramArrayOfPurchase, long paramLong);
  
  public static native void nativeOnSkuDetailsResponse(int paramInt, String paramString, SkuDetails[] paramArrayOfSkuDetails, long paramLong);
  
  public final void onAcknowledgePurchaseResponse(BillingResult paramBillingResult) {
    nativeOnAcknowledgePurchaseResponse(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), this.zza);
  }
  
  public final void onBillingServiceDisconnected() {
    nativeOnBillingServiceDisconnected();
  }
  
  public final void onBillingSetupFinished(BillingResult paramBillingResult) {
    nativeOnBillingSetupFinished(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), this.zza);
  }
  
  public final void onConsumeResponse(BillingResult paramBillingResult, String paramString) {
    nativeOnConsumePurchaseResponse(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), paramString, this.zza);
  }
  
  public final void onPriceChangeConfirmationResult(BillingResult paramBillingResult) {
    nativeOnPriceChangeConfirmationResult(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), this.zza);
  }
  
  public final void onPurchaseHistoryResponse(BillingResult paramBillingResult, List<PurchaseHistoryRecord> paramList) {
    List<PurchaseHistoryRecord> list = paramList;
    if (paramList == null)
      list = Collections.emptyList(); 
    PurchaseHistoryRecord[] arrayOfPurchaseHistoryRecord = list.<PurchaseHistoryRecord>toArray(new PurchaseHistoryRecord[list.size()]);
    nativeOnPurchaseHistoryResponse(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), arrayOfPurchaseHistoryRecord, this.zza);
  }
  
  public final void onPurchasesUpdated(BillingResult paramBillingResult, List<Purchase> paramList) {
    List<Purchase> list = paramList;
    if (paramList == null)
      list = Collections.emptyList(); 
    Purchase[] arrayOfPurchase = list.<Purchase>toArray(new Purchase[list.size()]);
    nativeOnPurchasesUpdated(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), arrayOfPurchase);
  }
  
  public final void onQueryPurchasesResponse(BillingResult paramBillingResult, List<Purchase> paramList) {
    Purchase[] arrayOfPurchase = paramList.<Purchase>toArray(new Purchase[paramList.size()]);
    nativeOnQueryPurchasesResponse(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), arrayOfPurchase, this.zza);
  }
  
  public final void onSkuDetailsResponse(BillingResult paramBillingResult, List<SkuDetails> paramList) {
    List<SkuDetails> list = paramList;
    if (paramList == null)
      list = Collections.emptyList(); 
    SkuDetails[] arrayOfSkuDetails = list.<SkuDetails>toArray(new SkuDetails[list.size()]);
    nativeOnSkuDetailsResponse(paramBillingResult.getResponseCode(), paramBillingResult.getDebugMessage(), arrayOfSkuDetails, this.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */