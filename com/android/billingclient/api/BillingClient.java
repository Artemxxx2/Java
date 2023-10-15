package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class BillingClient {
  @AnyThread
  @NonNull
  public static Builder newBuilder(@NonNull Context paramContext) {
    return new Builder(paramContext, null);
  }
  
  @AnyThread
  public abstract void acknowledgePurchase(@NonNull AcknowledgePurchaseParams paramAcknowledgePurchaseParams, @NonNull AcknowledgePurchaseResponseListener paramAcknowledgePurchaseResponseListener);
  
  @AnyThread
  public abstract void consumeAsync(@NonNull ConsumeParams paramConsumeParams, @NonNull ConsumeResponseListener paramConsumeResponseListener);
  
  @AnyThread
  public abstract void endConnection();
  
  @AnyThread
  public abstract int getConnectionState();
  
  @AnyThread
  @NonNull
  public abstract BillingResult isFeatureSupported(@NonNull String paramString);
  
  @AnyThread
  public abstract boolean isReady();
  
  @NonNull
  @UiThread
  public abstract BillingResult launchBillingFlow(@NonNull Activity paramActivity, @NonNull BillingFlowParams paramBillingFlowParams);
  
  @Deprecated
  @UiThread
  @zzi
  public abstract void launchPriceChangeConfirmationFlow(@NonNull Activity paramActivity, @NonNull PriceChangeFlowParams paramPriceChangeFlowParams, @NonNull PriceChangeConfirmationListener paramPriceChangeConfirmationListener);
  
  @AnyThread
  @zzj
  public abstract void queryProductDetailsAsync(@NonNull QueryProductDetailsParams paramQueryProductDetailsParams, @NonNull ProductDetailsResponseListener paramProductDetailsResponseListener);
  
  @AnyThread
  @zzj
  public abstract void queryPurchaseHistoryAsync(@NonNull QueryPurchaseHistoryParams paramQueryPurchaseHistoryParams, @NonNull PurchaseHistoryResponseListener paramPurchaseHistoryResponseListener);
  
  @Deprecated
  @AnyThread
  public abstract void queryPurchaseHistoryAsync(@NonNull String paramString, @NonNull PurchaseHistoryResponseListener paramPurchaseHistoryResponseListener);
  
  @AnyThread
  @zzj
  public abstract void queryPurchasesAsync(@NonNull QueryPurchasesParams paramQueryPurchasesParams, @NonNull PurchasesResponseListener paramPurchasesResponseListener);
  
  @Deprecated
  @AnyThread
  @zzk
  public abstract void queryPurchasesAsync(@NonNull String paramString, @NonNull PurchasesResponseListener paramPurchasesResponseListener);
  
  @Deprecated
  @AnyThread
  public abstract void querySkuDetailsAsync(@NonNull SkuDetailsParams paramSkuDetailsParams, @NonNull SkuDetailsResponseListener paramSkuDetailsResponseListener);
  
  @NonNull
  @UiThread
  @zzf
  public abstract BillingResult showInAppMessages(@NonNull Activity paramActivity, @NonNull InAppMessageParams paramInAppMessageParams, @NonNull InAppMessageResponseListener paramInAppMessageResponseListener);
  
  @AnyThread
  public abstract void startConnection(@NonNull BillingClientStateListener paramBillingClientStateListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BillingResponseCode {
    public static final int BILLING_UNAVAILABLE = 3;
    
    public static final int DEVELOPER_ERROR = 5;
    
    public static final int ERROR = 6;
    
    public static final int FEATURE_NOT_SUPPORTED = -2;
    
    public static final int ITEM_ALREADY_OWNED = 7;
    
    public static final int ITEM_NOT_OWNED = 8;
    
    public static final int ITEM_UNAVAILABLE = 4;
    
    public static final int OK = 0;
    
    public static final int SERVICE_DISCONNECTED = -1;
    
    public static final int SERVICE_TIMEOUT = -3;
    
    public static final int SERVICE_UNAVAILABLE = 2;
    
    public static final int USER_CANCELED = 1;
  }
  
  @AnyThread
  public static final class Builder {
    private volatile String zza;
    
    private volatile boolean zzb;
    
    private final Context zzc;
    
    private volatile PurchasesUpdatedListener zzd;
    
    private volatile zzbe zze;
    
    private volatile zzc zzf;
    
    @NonNull
    public BillingClient build() {
      if (this.zzc != null) {
        if (this.zzd != null) {
          if (this.zzd != null)
            zzbe zzbe2 = this.zze; 
          if (this.zzb) {
            if (this.zzd == null)
              zzc zzc1 = this.zzf; 
            if (this.zzd != null) {
              String str1 = this.zza;
              boolean bool1 = this.zzb;
              Context context1 = this.zzc;
              PurchasesUpdatedListener purchasesUpdatedListener = this.zzd;
              zzc zzc1 = this.zzf;
              return new BillingClientImpl(null, bool1, context1, purchasesUpdatedListener, null);
            } 
            String str = this.zza;
            boolean bool = this.zzb;
            Context context = this.zzc;
            zzbe zzbe2 = this.zze;
            return new BillingClientImpl(null, bool, context, null);
          } 
          throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
        } 
        zzbe zzbe1 = this.zze;
        throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
      } 
      throw new IllegalArgumentException("Please provide a valid Context.");
    }
    
    @NonNull
    public Builder enablePendingPurchases() {
      this.zzb = true;
      return this;
    }
    
    @NonNull
    public Builder setListener(@NonNull PurchasesUpdatedListener param1PurchasesUpdatedListener) {
      this.zzd = param1PurchasesUpdatedListener;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ConnectionState {
    public static final int CLOSED = 3;
    
    public static final int CONNECTED = 2;
    
    public static final int CONNECTING = 1;
    
    public static final int DISCONNECTED = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FeatureType {
    @NonNull
    @zzf
    public static final String IN_APP_MESSAGING = "bbb";
    
    @NonNull
    public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
    
    @NonNull
    @zzj
    public static final String PRODUCT_DETAILS = "fff";
    
    @NonNull
    public static final String SUBSCRIPTIONS = "subscriptions";
    
    @NonNull
    public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @zzj
  public static @interface ProductType {
    @NonNull
    @zzj
    public static final String INAPP = "inapp";
    
    @NonNull
    @zzj
    public static final String SUBS = "subs";
  }
  
  @Deprecated
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SkuType {
    @NonNull
    public static final String INAPP = "inapp";
    
    @NonNull
    public static final String SUBS = "subs";
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */