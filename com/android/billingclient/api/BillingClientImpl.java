package com.android.billingclient.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzg;
import com.google.android.gms.internal.play_billing.zzu;
import com.google.android.gms.internal.play_billing.zzz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

class BillingClientImpl extends BillingClient {
  private volatile int zza = 0;
  
  private final String zzb;
  
  private final Handler zzc = new Handler(Looper.getMainLooper());
  
  private volatile zzo zzd;
  
  private Context zze;
  
  private volatile zze zzf;
  
  private volatile zzap zzg;
  
  private boolean zzh;
  
  private boolean zzi;
  
  private int zzj = 0;
  
  private boolean zzk;
  
  private boolean zzl;
  
  private boolean zzm;
  
  private boolean zzn;
  
  private boolean zzo;
  
  private boolean zzp;
  
  private boolean zzq;
  
  private boolean zzr;
  
  private boolean zzs;
  
  private boolean zzt;
  
  private boolean zzu;
  
  private ExecutorService zzv;
  
  private BillingClientImpl(Activity paramActivity, boolean paramBoolean, String paramString) {
    this(paramActivity.getApplicationContext(), paramBoolean, new zzat(), paramString, null, null);
  }
  
  @AnyThread
  private BillingClientImpl(Context paramContext, boolean paramBoolean, PurchasesUpdatedListener paramPurchasesUpdatedListener, String paramString1, String paramString2, @Nullable zzc paramzzc) {
    this.zzb = paramString1;
    initialize(paramContext, paramPurchasesUpdatedListener, paramBoolean, null);
  }
  
  private BillingClientImpl(String paramString) {
    this.zzb = paramString;
  }
  
  @AnyThread
  BillingClientImpl(@Nullable String paramString, boolean paramBoolean, Context paramContext, PurchasesUpdatedListener paramPurchasesUpdatedListener, @Nullable zzc paramzzc) {
    this(paramContext, paramBoolean, paramPurchasesUpdatedListener, zzI(), null, null);
  }
  
  @AnyThread
  BillingClientImpl(@Nullable String paramString, boolean paramBoolean, Context paramContext, zzbe paramzzbe) {
    this.zzb = zzI();
    this.zze = paramContext.getApplicationContext();
    this.zzd = new zzo(this.zze, null);
    this.zzt = paramBoolean;
  }
  
  private void initialize(Context paramContext, PurchasesUpdatedListener paramPurchasesUpdatedListener, boolean paramBoolean, @Nullable zzc paramzzc) {
    this.zze = paramContext.getApplicationContext();
    this.zzd = new zzo(this.zze, paramPurchasesUpdatedListener, paramzzc);
    this.zzt = paramBoolean;
    if (paramzzc != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.zzu = paramBoolean;
  }
  
  private int launchBillingFlowCpp(Activity paramActivity, BillingFlowParams paramBillingFlowParams) {
    return launchBillingFlow(paramActivity, paramBillingFlowParams).getResponseCode();
  }
  
  @zzi
  private void launchPriceChangeConfirmationFlow(Activity paramActivity, PriceChangeFlowParams paramPriceChangeFlowParams, long paramLong) {
    launchPriceChangeConfirmationFlow(paramActivity, paramPriceChangeFlowParams, new zzat(paramLong));
  }
  
  private void startConnection(long paramLong) {
    zzat zzat = new zzat(paramLong);
    if (isReady()) {
      zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
      zzat.onBillingSetupFinished(zzbb.zzl);
      return;
    } 
    if (this.zza == 1) {
      zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
      zzat.onBillingSetupFinished(zzbb.zzd);
      return;
    } 
    if (this.zza == 3) {
      zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
      zzat.onBillingSetupFinished(zzbb.zzm);
      return;
    } 
    this.zza = 1;
    this.zzd.zze();
    zzb.zzn("BillingClient", "Starting in-app billing setup.");
    this.zzg = new zzap(this, zzat, null);
    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    intent.setPackage("com.android.vending");
    List<ResolveInfo> list = this.zze.getPackageManager().queryIntentServices(intent, 0);
    if (list != null && !list.isEmpty()) {
      ResolveInfo resolveInfo = list.get(0);
      if (resolveInfo.serviceInfo != null) {
        String str1 = resolveInfo.serviceInfo.packageName;
        String str2 = resolveInfo.serviceInfo.name;
        if ("com.android.vending".equals(str1) && str2 != null) {
          ComponentName componentName = new ComponentName(str1, str2);
          intent = new Intent(intent);
          intent.setComponent(componentName);
          intent.putExtra("playBillingLibraryVersion", this.zzb);
          if (this.zze.bindService(intent, this.zzg, 1)) {
            zzb.zzn("BillingClient", "Service was bonded successfully.");
            return;
          } 
          zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
        } else {
          zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
        } 
      } 
    } 
    this.zza = 0;
    zzb.zzn("BillingClient", "Billing service unavailable on device.");
    zzat.onBillingSetupFinished(zzbb.zzc);
  }
  
  private final Handler zzF() {
    Handler handler;
    if (Looper.myLooper() == null) {
      handler = this.zzc;
    } else {
      handler = new Handler(Looper.myLooper());
    } 
    return handler;
  }
  
  private final BillingResult zzG(BillingResult paramBillingResult) {
    if (Thread.interrupted())
      return paramBillingResult; 
    this.zzc.post(new zzag(this, paramBillingResult));
    return paramBillingResult;
  }
  
  private final BillingResult zzH() {
    return (this.zza == 0 || this.zza == 3) ? zzbb.zzm : zzbb.zzj;
  }
  
  @SuppressLint({"PrivateApi"})
  private static String zzI() {
    try {
      return (String)Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
    } catch (Exception exception) {
      return "5.0.0";
    } 
  }
  
  @Nullable
  private final Future zzJ(Callable<?> paramCallable, long paramLong, @Nullable Runnable paramRunnable, Handler paramHandler) {
    double d = paramLong;
    Double.isNaN(d);
    paramLong = (long)(d * 0.95D);
    if (this.zzv == null)
      this.zzv = Executors.newFixedThreadPool(zzb.zza, new zzal(this)); 
    try {
      Future<?> future = this.zzv.submit(paramCallable);
      paramHandler.postDelayed(new zzaf(future, paramRunnable), paramLong);
      return future;
    } catch (Exception exception) {
      zzb.zzp("BillingClient", "Async task throws exception!", exception);
      return null;
    } 
  }
  
  private final void zzK(BillingResult paramBillingResult, PriceChangeConfirmationListener paramPriceChangeConfirmationListener) {
    if (Thread.interrupted())
      return; 
    this.zzc.post(new zzx(paramPriceChangeConfirmationListener, paramBillingResult));
  }
  
  private final void zzL(String paramString, PurchaseHistoryResponseListener paramPurchaseHistoryResponseListener) {
    if (!isReady()) {
      paramPurchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbb.zzm, null);
      return;
    } 
    if (zzJ(new zzaj(this, paramString, paramPurchaseHistoryResponseListener), 30000L, new zzw(paramPurchaseHistoryResponseListener), zzF()) == null)
      paramPurchaseHistoryResponseListener.onPurchaseHistoryResponse(zzH(), null); 
  }
  
  private final void zzM(String paramString, PurchasesResponseListener paramPurchasesResponseListener) {
    if (!isReady()) {
      paramPurchasesResponseListener.onQueryPurchasesResponse(zzbb.zzm, (List<Purchase>)zzu.zzl());
      return;
    } 
    if (TextUtils.isEmpty(paramString)) {
      zzb.zzo("BillingClient", "Please provide a valid product type.");
      paramPurchasesResponseListener.onQueryPurchasesResponse(zzbb.zzg, (List<Purchase>)zzu.zzl());
      return;
    } 
    if (zzJ(new zzai(this, paramString, paramPurchasesResponseListener), 30000L, new zzad(paramPurchasesResponseListener), zzF()) == null)
      paramPurchasesResponseListener.onQueryPurchasesResponse(zzH(), (List<Purchase>)zzu.zzl()); 
  }
  
  public final void acknowledgePurchase(AcknowledgePurchaseParams paramAcknowledgePurchaseParams, AcknowledgePurchaseResponseListener paramAcknowledgePurchaseResponseListener) {
    if (!isReady()) {
      paramAcknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbb.zzm);
      return;
    } 
    if (TextUtils.isEmpty(paramAcknowledgePurchaseParams.getPurchaseToken())) {
      zzb.zzo("BillingClient", "Please provide a valid purchase token.");
      paramAcknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbb.zzi);
      return;
    } 
    if (!this.zzm) {
      paramAcknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbb.zzb);
      return;
    } 
    if (zzJ(new zzy(this, paramAcknowledgePurchaseParams, paramAcknowledgePurchaseResponseListener), 30000L, new zzz(paramAcknowledgePurchaseResponseListener), zzF()) == null)
      paramAcknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzH()); 
  }
  
  public final void consumeAsync(ConsumeParams paramConsumeParams, ConsumeResponseListener paramConsumeResponseListener) {
    if (!isReady()) {
      paramConsumeResponseListener.onConsumeResponse(zzbb.zzm, paramConsumeParams.getPurchaseToken());
      return;
    } 
    if (zzJ(new zzu(this, paramConsumeParams, paramConsumeResponseListener), 30000L, new zzv(paramConsumeResponseListener, paramConsumeParams), zzF()) == null)
      paramConsumeResponseListener.onConsumeResponse(zzH(), paramConsumeParams.getPurchaseToken()); 
  }
  
  public final void endConnection() {
    Exception exception;
    try {
      this.zzd.zzd();
      if (this.zzg != null)
        this.zzg.zzc(); 
      if (this.zzg != null && this.zzf != null) {
        zzb.zzn("BillingClient", "Unbinding from service.");
        this.zze.unbindService(this.zzg);
        this.zzg = null;
      } 
      this.zzf = null;
      ExecutorService executorService = this.zzv;
      if (executorService != null) {
        executorService.shutdownNow();
        this.zzv = null;
      } 
      this.zza = 3;
      return;
    } catch (Exception null) {
      zzb.zzp("BillingClient", "There was an exception while ending connection!", exception);
      this.zza = 3;
      return;
    } finally {}
    this.zza = 3;
    throw exception;
  }
  
  public final int getConnectionState() {
    return this.zza;
  }
  
  public final BillingResult isFeatureSupported(String paramString) {
    BillingResult billingResult;
    byte b;
    if (!isReady())
      return zzbb.zzm; 
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1987365622:
        if (paramString.equals("subscriptions")) {
          b = 0;
          break;
        } 
      case 207616302:
        if (paramString.equals("priceChangeConfirmation")) {
          b = 2;
          break;
        } 
      case 101286:
        if (paramString.equals("fff")) {
          b = 8;
          break;
        } 
      case 100293:
        if (paramString.equals("eee")) {
          b = 7;
          break;
        } 
      case 99300:
        if (paramString.equals("ddd")) {
          b = 5;
          break;
        } 
      case 98307:
        if (paramString.equals("ccc")) {
          b = 6;
          break;
        } 
      case 97314:
        if (paramString.equals("bbb")) {
          b = 3;
          break;
        } 
      case 96321:
        if (paramString.equals("aaa")) {
          b = 4;
          break;
        } 
      case -422092961:
        if (paramString.equals("subscriptionsUpdate")) {
          b = 1;
          break;
        } 
    } 
    switch (b) {
      default:
        zzb.zzo("BillingClient", "Unsupported feature: ".concat(String.valueOf(paramString)));
        return zzbb.zzy;
      case 8:
        if (this.zzs) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzv;
        } 
        return billingResult;
      case 6:
      case 7:
        if (this.zzr) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzt;
        } 
        return billingResult;
      case 5:
        if (this.zzp) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzu;
        } 
        return billingResult;
      case 4:
        if (this.zzq) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzs;
        } 
        return billingResult;
      case 3:
        if (this.zzo) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzw;
        } 
        return billingResult;
      case 2:
        if (this.zzl) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzr;
        } 
        return billingResult;
      case 1:
        if (this.zzi) {
          billingResult = zzbb.zzl;
        } else {
          billingResult = zzbb.zzp;
        } 
        return billingResult;
      case 0:
        break;
    } 
    if (this.zzh) {
      billingResult = zzbb.zzl;
    } else {
      billingResult = zzbb.zzo;
    } 
    return billingResult;
  }
  
  public final boolean isReady() {
    return (this.zza == 2 && this.zzf != null && this.zzg != null);
  }
  
  public final BillingResult launchBillingFlow(Activity paramActivity, BillingFlowParams paramBillingFlowParams) {
    String str1;
    String str2;
    if (!isReady()) {
      billingResult = zzbb.zzm;
      zzG(billingResult);
      return billingResult;
    } 
    ArrayList<SkuDetails> arrayList = paramBillingFlowParams.zze();
    List<BillingFlowParams.ProductDetailsParams> list = paramBillingFlowParams.zzf();
    SkuDetails skuDetails = (SkuDetails)zzz.zza(arrayList, null);
    BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams)zzz.zza(list, null);
    if (skuDetails != null) {
      str1 = skuDetails.getSku();
      str2 = skuDetails.getType();
    } else {
      str1 = productDetailsParams.zza().getProductId();
      str2 = productDetailsParams.zza().getProductType();
    } 
    if (!str2.equals("subs") || this.zzh) {
      if (!paramBillingFlowParams.zzo() || this.zzk) {
        if (arrayList.size() <= 1 || this.zzr) {
          if (list.isEmpty() || this.zzs) {
            Future<Bundle> future;
            if (this.zzk) {
              Bundle bundle = zzb.zzf(paramBillingFlowParams, this.zzm, this.zzt, this.zzu, this.zzb);
              if (!arrayList.isEmpty()) {
                ArrayList<String> arrayList1 = new ArrayList();
                ArrayList<String> arrayList2 = new ArrayList();
                ArrayList<String> arrayList3 = new ArrayList();
                ArrayList<Integer> arrayList4 = new ArrayList();
                ArrayList<String> arrayList5 = new ArrayList();
                Iterator<SkuDetails> iterator = arrayList.iterator();
                int i = 0;
                int j = 0;
                int k = 0;
                int m = 0;
                while (iterator.hasNext()) {
                  SkuDetails skuDetails1 = iterator.next();
                  if (!skuDetails1.zzf().isEmpty())
                    arrayList1.add(skuDetails1.zzf()); 
                  String str4 = skuDetails1.zzc();
                  String str5 = skuDetails1.zzb();
                  int n = skuDetails1.zza();
                  String str3 = skuDetails1.zze();
                  arrayList2.add(str4);
                  i |= TextUtils.isEmpty(str4) ^ true;
                  arrayList3.add(str5);
                  int i1 = j | TextUtils.isEmpty(str5) ^ true;
                  arrayList4.add(Integer.valueOf(n));
                  if (n != 0) {
                    j = 1;
                  } else {
                    j = 0;
                  } 
                  k |= j;
                  m |= TextUtils.isEmpty(str3) ^ true;
                  arrayList5.add(str3);
                  j = i1;
                } 
                if (!arrayList1.isEmpty())
                  bundle.putStringArrayList("skuDetailsTokens", arrayList1); 
                if (i != 0)
                  bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2); 
                if (j != 0)
                  bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList3); 
                if (k != 0)
                  bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList4); 
                if (m != 0)
                  bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5); 
                if (arrayList.size() > 1) {
                  ArrayList<String> arrayList6 = new ArrayList(arrayList.size() - 1);
                  arrayList5 = new ArrayList<String>(arrayList.size() - 1);
                  for (m = 1; m < arrayList.size(); m++) {
                    arrayList6.add(((SkuDetails)arrayList.get(m)).getSku());
                    arrayList5.add(((SkuDetails)arrayList.get(m)).getType());
                  } 
                  bundle.putStringArrayList("additionalSkus", arrayList6);
                  bundle.putStringArrayList("additionalSkuTypes", arrayList5);
                } 
              } else {
                ArrayList<String> arrayList2 = new ArrayList(list.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList(list.size() - 1);
                ArrayList<String> arrayList1 = new ArrayList();
                arrayList = new ArrayList<SkuDetails>();
                for (byte b1 = 0; b1 < list.size(); b1++) {
                  BillingFlowParams.ProductDetailsParams productDetailsParams1 = list.get(b1);
                  ProductDetails productDetails = productDetailsParams1.zza();
                  if (!productDetails.zzb().isEmpty())
                    arrayList1.add(productDetails.zzb()); 
                  arrayList.add(productDetailsParams1.zzb());
                  if (b1 > 0) {
                    arrayList2.add(((BillingFlowParams.ProductDetailsParams)list.get(b1)).zza().getProductId());
                    arrayList3.add(((BillingFlowParams.ProductDetailsParams)list.get(b1)).zza().getProductType());
                  } 
                } 
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList);
                if (!arrayList1.isEmpty())
                  bundle.putStringArrayList("skuDetailsTokens", arrayList1); 
                if (!arrayList2.isEmpty()) {
                  bundle.putStringArrayList("additionalSkus", arrayList2);
                  bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                } 
              } 
              byte b = 1;
              if (!bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") || this.zzp) {
                if (skuDetails != null && !TextUtils.isEmpty(skuDetails.zzd())) {
                  bundle.putString("skuPackageName", skuDetails.zzd());
                } else if (productDetailsParams != null && !TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                  bundle.putString("skuPackageName", productDetailsParams.zza().zza());
                } else {
                  b = 0;
                } 
                if (!TextUtils.isEmpty(null))
                  bundle.putString("accountName", null); 
                Intent intent = billingResult.getIntent();
                if (intent == null) {
                  zzb.zzo("BillingClient", "Activity's intent is null.");
                } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                  String str = intent.getStringExtra("PROXY_PACKAGE");
                  bundle.putString("proxyPackage", str);
                  try {
                    bundle.putString("proxyPackageVersion", (this.zze.getPackageManager().getPackageInfo(str, 0)).versionName);
                  } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
                    bundle.putString("proxyPackageVersion", "package not found");
                  } 
                } 
                if (this.zzs && !list.isEmpty()) {
                  b = 17;
                } else if (this.zzq && b != 0) {
                  b = 15;
                } else if (this.zzm) {
                  b = 9;
                } else {
                  b = 6;
                } 
                future = zzJ(new zzab(this, b, str1, str2, paramBillingFlowParams, bundle), 5000L, null, this.zzc);
              } else {
                billingResult = zzbb.zzu;
                zzG(billingResult);
                return billingResult;
              } 
            } else {
              future = zzJ(new zzac(this, str1, str2), 5000L, null, this.zzc);
            } 
            try {
              BillingResult billingResult1;
              Bundle bundle = future.get(5000L, TimeUnit.MILLISECONDS);
              int i = zzb.zzb(bundle, "BillingClient");
              String str = zzb.zzk(bundle, "BillingClient");
              if (i != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("Unable to buy item, Error response code: ");
                stringBuilder.append(i);
                zzb.zzo("BillingClient", stringBuilder.toString());
                BillingResult.Builder builder = BillingResult.newBuilder();
                builder.setResponseCode(i);
                builder.setDebugMessage(str);
                billingResult1 = builder.build();
                zzG(billingResult1);
                return billingResult1;
              } 
              Intent intent = new Intent();
              this((Context)billingResult1, ProxyBillingActivity.class);
              intent.putExtra("BUY_INTENT", bundle.getParcelable("BUY_INTENT"));
              billingResult1.startActivity(intent);
              return zzbb.zzl;
            } catch (TimeoutException|java.util.concurrent.CancellationException timeoutException) {
              zzb.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", timeoutException);
              BillingResult billingResult1 = zzbb.zzn;
              zzG(billingResult1);
              return billingResult1;
            } catch (Exception exception) {
              zzb.zzp("BillingClient", "Exception while launching billing flow. Try to reconnect", exception);
              BillingResult billingResult1 = zzbb.zzm;
              zzG(billingResult1);
              return billingResult1;
            } 
          } 
          zzb.zzo("BillingClient", "Current client doesn't support purchases with ProductDetails.");
          billingResult = zzbb.zzv;
          zzG(billingResult);
          return billingResult;
        } 
        zzb.zzo("BillingClient", "Current client doesn't support multi-item purchases.");
        billingResult = zzbb.zzt;
        zzG(billingResult);
        return billingResult;
      } 
      zzb.zzo("BillingClient", "Current client doesn't support extra params for buy intent.");
      billingResult = zzbb.zzh;
      zzG(billingResult);
      return billingResult;
    } 
    zzb.zzo("BillingClient", "Current client doesn't support subscriptions.");
    BillingResult billingResult = zzbb.zzo;
    zzG(billingResult);
    return billingResult;
  }
  
  @zzi
  public void launchPriceChangeConfirmationFlow(Activity paramActivity, PriceChangeFlowParams paramPriceChangeFlowParams, PriceChangeConfirmationListener paramPriceChangeConfirmationListener) {
    if (!isReady()) {
      zzK(zzbb.zzm, paramPriceChangeConfirmationListener);
      return;
    } 
    if (paramPriceChangeFlowParams == null || paramPriceChangeFlowParams.getSkuDetails() == null) {
      zzb.zzo("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
      zzK(zzbb.zzk, paramPriceChangeConfirmationListener);
      return;
    } 
    String str = paramPriceChangeFlowParams.getSkuDetails().getSku();
    if (str == null) {
      zzb.zzo("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
      zzK(zzbb.zzk, paramPriceChangeConfirmationListener);
      return;
    } 
    if (!this.zzl) {
      zzb.zzo("BillingClient", "Current client doesn't support price change confirmation flow.");
      zzK(zzbb.zzr, paramPriceChangeConfirmationListener);
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("playBillingLibraryVersion", this.zzb);
    bundle.putBoolean("subs_price_change", true);
    Future<Bundle> future = zzJ(new zzr(this, str, bundle), 5000L, null, this.zzc);
    try {
      StringBuilder stringBuilder;
      Bundle bundle1 = future.get(5000L, TimeUnit.MILLISECONDS);
      int i = zzb.zzb(bundle1, "BillingClient");
      String str1 = zzb.zzk(bundle1, "BillingClient");
      BillingResult.Builder builder = BillingResult.newBuilder();
      builder.setResponseCode(i);
      builder.setDebugMessage(str1);
      BillingResult billingResult = builder.build();
      if (i != 0) {
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Unable to launch price change flow, error response code: ");
        stringBuilder.append(i);
        zzb.zzo("BillingClient", stringBuilder.toString());
        zzK(billingResult, paramPriceChangeConfirmationListener);
        return;
      } 
      zzah zzah = new zzah();
      this(this, this.zzc, paramPriceChangeConfirmationListener);
      Intent intent = new Intent();
      this((Context)stringBuilder, ProxyBillingActivity.class);
      intent.putExtra("SUBS_MANAGEMENT_INTENT", bundle1.getParcelable("SUBS_MANAGEMENT_INTENT"));
      intent.putExtra("result_receiver", (Parcelable)zzah);
      stringBuilder.startActivity(intent);
      return;
    } catch (TimeoutException|java.util.concurrent.CancellationException timeoutException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Time out while launching Price Change Flow for sku: ");
      stringBuilder.append(str);
      stringBuilder.append("; try to reconnect");
      zzb.zzp("BillingClient", stringBuilder.toString(), timeoutException);
      zzK(zzbb.zzn, paramPriceChangeConfirmationListener);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception caught while launching Price Change Flow for sku: ");
      stringBuilder.append(str);
      stringBuilder.append("; try to reconnect");
      zzb.zzp("BillingClient", stringBuilder.toString(), exception);
      zzK(zzbb.zzm, paramPriceChangeConfirmationListener);
      return;
    } 
  }
  
  @zzj
  public void queryProductDetailsAsync(QueryProductDetailsParams paramQueryProductDetailsParams, ProductDetailsResponseListener paramProductDetailsResponseListener) {
    if (!isReady()) {
      paramProductDetailsResponseListener.onProductDetailsResponse(zzbb.zzm, new ArrayList<ProductDetails>());
      return;
    } 
    if (!this.zzs) {
      zzb.zzo("BillingClient", "Querying product details is not supported.");
      paramProductDetailsResponseListener.onProductDetailsResponse(zzbb.zzv, new ArrayList<ProductDetails>());
      return;
    } 
    if (zzJ(new zzs(this, paramQueryProductDetailsParams, paramProductDetailsResponseListener), 30000L, new zzt(paramProductDetailsResponseListener), zzF()) == null)
      paramProductDetailsResponseListener.onProductDetailsResponse(zzH(), new ArrayList<ProductDetails>()); 
  }
  
  @zzj
  public void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams paramQueryPurchaseHistoryParams, PurchaseHistoryResponseListener paramPurchaseHistoryResponseListener) {
    zzL(paramQueryPurchaseHistoryParams.zza(), paramPurchaseHistoryResponseListener);
  }
  
  public final void queryPurchaseHistoryAsync(String paramString, PurchaseHistoryResponseListener paramPurchaseHistoryResponseListener) {
    zzL(paramString, paramPurchaseHistoryResponseListener);
  }
  
  @zzj
  public void queryPurchasesAsync(QueryPurchasesParams paramQueryPurchasesParams, PurchasesResponseListener paramPurchasesResponseListener) {
    zzM(paramQueryPurchasesParams.zza(), paramPurchasesResponseListener);
  }
  
  @zzk
  public void queryPurchasesAsync(String paramString, PurchasesResponseListener paramPurchasesResponseListener) {
    zzM(paramString, paramPurchasesResponseListener);
  }
  
  public final void querySkuDetailsAsync(SkuDetailsParams paramSkuDetailsParams, SkuDetailsResponseListener paramSkuDetailsResponseListener) {
    if (!isReady()) {
      paramSkuDetailsResponseListener.onSkuDetailsResponse(zzbb.zzm, null);
      return;
    } 
    String str = paramSkuDetailsParams.getSkuType();
    List<String> list = paramSkuDetailsParams.getSkusList();
    if (!TextUtils.isEmpty(str)) {
      if (list != null) {
        ArrayList<zzbv> arrayList = new ArrayList();
        for (String str1 : list) {
          zzbt zzbt = new zzbt(null);
          zzbt.zza(str1);
          arrayList.add(zzbt.zzb());
        } 
        if (zzJ(new zzq(this, str, arrayList, null, paramSkuDetailsResponseListener), 30000L, new zzaa(paramSkuDetailsResponseListener), zzF()) == null)
          paramSkuDetailsResponseListener.onSkuDetailsResponse(zzH(), null); 
        return;
      } 
      zzb.zzo("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
      paramSkuDetailsResponseListener.onSkuDetailsResponse(zzbb.zze, null);
      return;
    } 
    zzb.zzo("BillingClient", "Please fix the input params. SKU type can't be empty.");
    paramSkuDetailsResponseListener.onSkuDetailsResponse(zzbb.zzf, null);
  }
  
  @zzf
  public BillingResult showInAppMessages(Activity paramActivity, InAppMessageParams paramInAppMessageParams, InAppMessageResponseListener paramInAppMessageResponseListener) {
    if (!isReady()) {
      zzb.zzo("BillingClient", "Service disconnected.");
      return zzbb.zzm;
    } 
    if (!this.zzo) {
      zzb.zzo("BillingClient", "Current client doesn't support showing in-app messages.");
      return zzbb.zzw;
    } 
    View view = paramActivity.findViewById(16908290);
    IBinder iBinder = view.getWindowToken();
    Rect rect = new Rect();
    view.getGlobalVisibleRect(rect);
    Bundle bundle = new Bundle();
    BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", iBinder);
    bundle.putInt("KEY_DIMEN_LEFT", rect.left);
    bundle.putInt("KEY_DIMEN_TOP", rect.top);
    bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
    bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
    bundle.putString("playBillingLibraryVersion", this.zzb);
    bundle.putIntegerArrayList("KEY_CATEGORY_IDS", paramInAppMessageParams.getInAppMessageCategoriesToShow());
    zzJ(new zzae(this, bundle, paramActivity, new zzak(this, this.zzc, paramInAppMessageResponseListener)), 5000L, null, this.zzc);
    return zzbb.zzl;
  }
  
  public final void startConnection(BillingClientStateListener paramBillingClientStateListener) {
    if (isReady()) {
      zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
      paramBillingClientStateListener.onBillingSetupFinished(zzbb.zzl);
      return;
    } 
    if (this.zza == 1) {
      zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
      paramBillingClientStateListener.onBillingSetupFinished(zzbb.zzd);
      return;
    } 
    if (this.zza == 3) {
      zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
      paramBillingClientStateListener.onBillingSetupFinished(zzbb.zzm);
      return;
    } 
    this.zza = 1;
    this.zzd.zze();
    zzb.zzn("BillingClient", "Starting in-app billing setup.");
    this.zzg = new zzap(this, paramBillingClientStateListener, null);
    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    intent.setPackage("com.android.vending");
    List<ResolveInfo> list = this.zze.getPackageManager().queryIntentServices(intent, 0);
    if (list != null && !list.isEmpty()) {
      ResolveInfo resolveInfo = list.get(0);
      if (resolveInfo.serviceInfo != null) {
        String str1 = resolveInfo.serviceInfo.packageName;
        String str2 = resolveInfo.serviceInfo.name;
        if ("com.android.vending".equals(str1) && str2 != null) {
          ComponentName componentName = new ComponentName(str1, str2);
          intent = new Intent(intent);
          intent.setComponent(componentName);
          intent.putExtra("playBillingLibraryVersion", this.zzb);
          if (this.zze.bindService(intent, this.zzg, 1)) {
            zzb.zzn("BillingClient", "Service was bonded successfully.");
            return;
          } 
          zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
        } else {
          zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
        } 
      } 
    } 
    this.zza = 0;
    zzb.zzn("BillingClient", "Billing service unavailable on device.");
    paramBillingClientStateListener.onBillingSetupFinished(zzbb.zzc);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\BillingClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */