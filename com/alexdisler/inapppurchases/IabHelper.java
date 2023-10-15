package com.alexdisler.inapppurchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONException;

public class IabHelper implements PurchasesUpdatedListener {
  public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
  
  public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
  
  public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
  
  public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
  
  public static final int BILLING_RESPONSE_RESULT_OK = 0;
  
  public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
  
  public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
  
  public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
  
  public static final int IABHELPER_BAD_RESPONSE = -1002;
  
  public static final int IABHELPER_ERROR_BASE = -1000;
  
  public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
  
  public static final int IABHELPER_MISSING_TOKEN = -1007;
  
  public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
  
  public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
  
  public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
  
  public static final int IABHELPER_UNKNOWN_ERROR = -1008;
  
  public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
  
  public static final int IABHELPER_USER_CANCELLED = -1005;
  
  public static final int IABHELPER_VERIFICATION_FAILED = -1003;
  
  public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
  
  public static final String ITEM_TYPE_INAPP = "inapp";
  
  public static final String ITEM_TYPE_SUBS = "subs";
  
  public static final int QUERY_SKU_DETAILS_BATCH_SIZE = 20;
  
  public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
  
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  
  public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
  
  public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
  
  public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  
  public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
  
  public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
  
  public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
  
  protected static final String TAG = "google.payments Helper";
  
  BillingClient billingClient;
  
  boolean mAsyncInProgress = false;
  
  String mAsyncOperation = "";
  
  Context mContext;
  
  boolean mDebugLog = false;
  
  String mDebugTag = "IabHelper";
  
  boolean mDisposed = false;
  
  OnIabPurchaseFinishedListener mPurchaseListener;
  
  String mPurchasingItemType;
  
  int mRequestCode;
  
  boolean mSetupDone = false;
  
  String mSignatureBase64 = null;
  
  private boolean mSkipPurchaseVerification = false;
  
  boolean mSubscriptionsSupported = false;
  
  public IabHelper(Context paramContext, String paramString) {
    this.mContext = paramContext.getApplicationContext();
    this.mSignatureBase64 = paramString;
    Log.d("google.payments Helper", "IAB helper created.");
  }
  
  private void checkNotDisposed() {
    if (!this.mDisposed)
      return; 
    throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
  }
  
  public static String getResponseDesc(int paramInt) {
    StringBuilder stringBuilder;
    String[] arrayOfString1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
    String[] arrayOfString2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
    if (paramInt <= -1000) {
      int i = -1000 - paramInt;
      if (i >= 0 && i < arrayOfString2.length)
        return arrayOfString2[i]; 
      stringBuilder = new StringBuilder();
      stringBuilder.append(String.valueOf(paramInt));
      stringBuilder.append(":Unknown IAB Helper Error");
      return stringBuilder.toString();
    } 
    if (paramInt < 0 || paramInt >= stringBuilder.length) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(String.valueOf(paramInt));
      stringBuilder.append(":Unknown");
      return stringBuilder.toString();
    } 
    return (String)stringBuilder[paramInt];
  }
  
  void acknowledgeAsync(final IabPurchase purchase, final OnAcknowledgeFinishedListener singleListener) {
    new Handler();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("acknowledgeAsync: ");
    stringBuilder.append(purchase);
    Log.d("google.payments Helper", stringBuilder.toString());
    flagStartAsync("acknowledge");
    (new Thread(new Runnable() {
          public void run() {
            StringBuilder stringBuilder1;
            IabResult iabResult;
            AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener = new AcknowledgePurchaseResponseListener() {
                public void onAcknowledgePurchaseResponse(BillingResult param2BillingResult) {
                  IabResult iabResult;
                  if (param2BillingResult.getResponseCode() == 0) {
                    Log.d("google.payments Helper", "Successfully acknowledged purchase");
                    iabResult = new IabResult(0, "Successful acknowledge of purchase");
                  } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error acknowledging purchase. ");
                    stringBuilder.append(iabResult.getDebugMessage());
                    Log.d("google.payments Helper", stringBuilder.toString());
                    iabResult = new IabResult(iabResult.getResponseCode(), "Error acknowledging purchase.");
                  } 
                  IabHelper.this.flagEndAsync();
                  singleListener.onAcknowledgeFinished(purchase, iabResult);
                }
              };
            String str1 = purchase.getToken();
            String str2 = purchase.getSku();
            if (str1 == null || str1.equals("")) {
              IabHelper iabHelper = IabHelper.this;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Can't consume ");
              stringBuilder.append(str2);
              stringBuilder.append(". No token.");
              iabHelper.logError(stringBuilder.toString());
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("PurchaseInfo is missing token for sku: ");
              stringBuilder1.append(str2);
              iabResult = new IabResult(6, stringBuilder1.toString());
              IabHelper.this.flagEndAsync();
              singleListener.onAcknowledgeFinished(purchase, iabResult);
              return;
            } 
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Acknowledging sku: ");
            stringBuilder2.append((String)iabResult);
            stringBuilder2.append(", token: ");
            stringBuilder2.append(str1);
            Log.d("google.payments Helper", stringBuilder2.toString());
            AcknowledgePurchaseParams acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getToken()).build();
            IabHelper.this.billingClient.acknowledgePurchase(acknowledgePurchaseParams, (AcknowledgePurchaseResponseListener)stringBuilder1);
          }
        })).start();
  }
  
  void checkSetupDone(String paramString) {
    if (this.mSetupDone)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal state for operation (");
    stringBuilder.append(paramString);
    stringBuilder.append("): IAB helper is not set up.");
    logError(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("IAB helper is not set up. Can't perform operation: ");
    stringBuilder.append(paramString);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void consumeAsync(IabPurchase paramIabPurchase, OnConsumeFinishedListener paramOnConsumeFinishedListener) {
    checkNotDisposed();
    checkSetupDone("consume");
    ArrayList<IabPurchase> arrayList = new ArrayList();
    arrayList.add(paramIabPurchase);
    consumeAsyncInternal(arrayList, paramOnConsumeFinishedListener, null);
  }
  
  public void consumeAsync(List<IabPurchase> paramList, OnConsumeMultiFinishedListener paramOnConsumeMultiFinishedListener) {
    checkNotDisposed();
    checkSetupDone("consume");
    consumeAsyncInternal(paramList, null, paramOnConsumeMultiFinishedListener);
  }
  
  void consumeAsyncInternal(final List<IabPurchase> purchases, final OnConsumeFinishedListener singleListener, final OnConsumeMultiFinishedListener multiListener) {
    final Handler handler = new Handler();
    flagStartAsync("consume");
    (new Thread(new Runnable() {
          public void run() {
            final ArrayList<IabResult> results = new ArrayList();
            IabHelper.ConsumeAsyncFinishedListener consumeAsyncFinishedListener = new IabHelper.ConsumeAsyncFinishedListener() {
                public void onConsumeFinished() {
                  if (this.allConsumesStarted && this.consumesCompleted == this.totalConsumes) {
                    IabHelper.this.flagEndAsync();
                    if (!IabHelper.this.mDisposed && singleListener != null)
                      handler.post(new Runnable() {
                            public void run() {
                              singleListener.onConsumeFinished(purchases.get(0), results.get(0));
                            }
                          }); 
                    if (!IabHelper.this.mDisposed && multiListener != null)
                      handler.post(new Runnable() {
                            public void run() {
                              multiListener.onConsumeMultiFinished(purchases, results);
                            }
                          }); 
                  } 
                }
                
                public void onConsumeResponse(BillingResult param2BillingResult, String param2String) {
                  List<IabResult> list;
                  if (param2BillingResult.getResponseCode() == 0) {
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("Successfully consumed purchase: ");
                    stringBuilder1.append(param2String);
                    Log.d("google.payments Helper", stringBuilder1.toString());
                    list = results;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Successful consume of purchase ");
                    stringBuilder2.append(param2String);
                    list.add(new IabResult(0, stringBuilder2.toString()));
                  } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Error consuming consuming purchase ");
                    stringBuilder2.append(param2String);
                    stringBuilder2.append(". ");
                    stringBuilder2.append(list.getDebugMessage());
                    Log.d("google.payments Helper", stringBuilder2.toString());
                    List<IabResult> list1 = results;
                    int i = list.getResponseCode();
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("Error consuming purchase ");
                    stringBuilder1.append(param2String);
                    list1.add(new IabResult(i, stringBuilder1.toString()));
                  } 
                  this.consumesCompleted++;
                  onConsumeFinished();
                }
              };
            for (IabPurchase iabPurchase : purchases) {
              StringBuilder stringBuilder1;
              IabHelper iabHelper;
              String str1 = iabPurchase.getToken();
              String str2 = iabPurchase.getSku();
              if (str1 == null || str1.equals("")) {
                iabHelper = IabHelper.this;
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Can't consume ");
                stringBuilder1.append(str2);
                stringBuilder1.append(". No token.");
                iabHelper.logError(stringBuilder1.toString());
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("PurchaseInfo is missing token for sku: ");
                stringBuilder1.append(str2);
                arrayList.add(new IabResult(6, stringBuilder1.toString()));
                continue;
              } 
              consumeAsyncFinishedListener.totalConsumes++;
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("Consuming sku: ");
              stringBuilder2.append(str2);
              stringBuilder2.append(", token: ");
              stringBuilder2.append((String)iabHelper);
              Log.d("google.payments Helper", stringBuilder2.toString());
              ConsumeParams consumeParams = ConsumeParams.newBuilder().setPurchaseToken(stringBuilder1.getToken()).build();
              IabHelper.this.billingClient.consumeAsync(consumeParams, consumeAsyncFinishedListener);
            } 
            consumeAsyncFinishedListener.allConsumesStarted = true;
          }
        })).start();
  }
  
  public void dispose() {
    Log.d("google.payments Helper", "Disposing.");
    this.mSetupDone = false;
    this.mDisposed = true;
    this.mContext = null;
    this.mPurchaseListener = null;
  }
  
  public void enableDebugLogging(boolean paramBoolean) {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
  }
  
  public void enableDebugLogging(boolean paramBoolean, String paramString) {
    checkNotDisposed();
    this.mDebugLog = paramBoolean;
    this.mDebugTag = paramString;
  }
  
  void flagEndAsync() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ending async operation: ");
    stringBuilder.append(this.mAsyncOperation);
    Log.d("google.payments Helper", stringBuilder.toString());
    this.mAsyncOperation = "";
    this.mAsyncInProgress = false;
  }
  
  void flagStartAsync(String paramString) {
    if (!this.mAsyncInProgress) {
      this.mAsyncOperation = paramString;
      this.mAsyncInProgress = true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Starting async operation: ");
      stringBuilder1.append(paramString);
      Log.d("google.payments Helper", stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't start async operation (");
    stringBuilder.append(paramString);
    stringBuilder.append(") because another async operation(");
    stringBuilder.append(this.mAsyncOperation);
    stringBuilder.append(") is in progress.");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  int getResponseCodeFromBundle(Bundle paramBundle) {
    Object object = paramBundle.get("RESPONSE_CODE");
    if (object == null) {
      Log.d("google.payments Helper", "Bundle with null response code, assuming OK (known issue)");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof Long)
      return (int)((Long)object).longValue(); 
    logError("Unexpected type for bundle response code.");
    logError(object.getClass().getName());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected type for bundle response code: ");
    stringBuilder.append(object.getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  int getResponseCodeFromIntent(Intent paramIntent) {
    Object object = paramIntent.getExtras().get("RESPONSE_CODE");
    if (object == null) {
      logError("Intent with no response code, assuming OK (known issue)");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    if (object instanceof Long)
      return (int)((Long)object).longValue(); 
    logError("Unexpected type for intent response code.");
    logError(object.getClass().getName());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected type for intent response code: ");
    stringBuilder.append(object.getClass().getName());
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    return true;
  }
  
  public void launchPurchaseFlow(final Activity act, final String sku, String paramString2, OnIabPurchaseFinishedListener paramOnIabPurchaseFinishedListener, String paramString3) {
    checkNotDisposed();
    checkSetupDone("launchPurchaseFlow");
    flagStartAsync("launchPurchaseFlow");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("launchPurchaseFlow:");
    stringBuilder.append(sku);
    stringBuilder.append(" ");
    stringBuilder.append(paramString2);
    Log.d("google.payments Helper", stringBuilder.toString());
    if (paramString2.equals("subs") && !this.mSubscriptionsSupported) {
      new IabResult(-1009, "Subscriptions are not available.");
      flagEndAsync();
    } 
    this.mPurchaseListener = paramOnIabPurchaseFinishedListener;
    this.mPurchasingItemType = paramString2;
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(sku);
    SkuDetailsParams.Builder builder = SkuDetailsParams.newBuilder();
    builder.setSkusList(arrayList).setType(paramString2);
    this.billingClient.querySkuDetailsAsync(builder.build(), new SkuDetailsResponseListener() {
          public void onSkuDetailsResponse(BillingResult param1BillingResult, List<SkuDetails> param1List) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("purch skus: ");
            stringBuilder.append(param1List);
            Log.d("google.payments Helper", stringBuilder.toString());
            for (SkuDetails skuDetails : param1List) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("sku deets: ");
              stringBuilder1.append(skuDetails);
              Log.d("google.payments Helper", stringBuilder1.toString());
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("sku id: ");
              stringBuilder1.append(skuDetails.getSku());
              Log.d("google.payments Helper", stringBuilder1.toString());
              if (sku.equals(skuDetails.getSku())) {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("got sku: ");
                stringBuilder1.append(skuDetails);
                Log.d("google.payments Helper", stringBuilder1.toString());
                BillingFlowParams billingFlowParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
                IabHelper.this.billingClient.launchBillingFlow(act, billingFlowParams);
              } 
            } 
          }
        });
  }
  
  void logError(String paramString) {
    String str = this.mDebugTag;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In-app billing error: ");
    stringBuilder.append(paramString);
    Log.e(str, stringBuilder.toString());
  }
  
  void logWarn(String paramString) {
    String str = this.mDebugTag;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("In-app billing warning: ");
    stringBuilder.append(paramString);
    Log.w(str, stringBuilder.toString());
  }
  
  public void onPurchasesUpdated(BillingResult paramBillingResult, List<Purchase> paramList) {
    OnIabPurchaseFinishedListener onIabPurchaseFinishedListener;
    IabResult iabResult;
    Log.d("google.payments Helper", "IabHelper onPurchasesUpdated");
    new Inventory();
    checkNotDisposed();
    checkSetupDone("handleActivityResult");
    flagEndAsync();
    if (paramBillingResult.getResponseCode() != 0) {
      logError("Error response for purchases");
      IabResult iabResult1 = new IabResult(-1002, "Error response for purchases");
      onIabPurchaseFinishedListener = this.mPurchaseListener;
      if (onIabPurchaseFinishedListener != null)
        onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult1, null); 
      return;
    } 
    if (onIabPurchaseFinishedListener == null) {
      logError("Null data in IAB activity result.");
      iabResult = new IabResult(-1002, "Null data in IAB result");
      OnIabPurchaseFinishedListener onIabPurchaseFinishedListener1 = this.mPurchaseListener;
      if (onIabPurchaseFinishedListener1 != null)
        onIabPurchaseFinishedListener1.onIabPurchaseFinished(iabResult, null); 
      return;
    } 
    for (Purchase purchase : iabResult) {
      final boolean skipPurchaseVerification;
      if (this.mSkipPurchaseVerification && ((this.mContext.getApplicationInfo()).flags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      final ArrayList<String> skus = purchase.getSkus();
      queryInventoryAsync(true, arrayList, new QueryInventoryFinishedListener() {
            public void onQueryInventoryFinished(IabResult param1IabResult, Inventory param1Inventory) {
              Iterator<String> iterator = skus.iterator();
              while (iterator.hasNext()) {
                String str = iterator.next();
                IabSkuDetails iabSkuDetails = param1Inventory.getIabSkuDetails(str);
                try {
                  IabPurchase iabPurchase = new IabPurchase();
                  this(iabSkuDetails.getType(), purchase.getOriginalJson(), purchase.getSignature());
                  if (!skipPurchaseVerification) {
                    if (!Security.verifyPurchase(IabHelper.this.mSignatureBase64, purchase.getOriginalJson(), purchase.getSignature())) {
                      IabHelper iabHelper = IabHelper.this;
                      StringBuilder stringBuilder = new StringBuilder();
                      this();
                      stringBuilder.append("Purchase signature verification FAILED for sku ");
                      stringBuilder.append(str);
                      iabHelper.logError(stringBuilder.toString());
                      IabResult iabResult = new IabResult();
                      stringBuilder = new StringBuilder();
                      this();
                      stringBuilder.append("Signature verification failed for sku ");
                      stringBuilder.append(str);
                      this(-1003, stringBuilder.toString());
                      if (IabHelper.this.mPurchaseListener != null)
                        IabHelper.this.mPurchaseListener.onIabPurchaseFinished(iabResult, iabPurchase); 
                      return;
                    } 
                    Log.d("google.payments Helper", "Purchase signature successfully verified.");
                  } 
                  if (IabHelper.this.mPurchaseListener != null) {
                    IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = IabHelper.this.mPurchaseListener;
                    IabResult iabResult = new IabResult();
                    this(0, "Success");
                    onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, iabPurchase);
                  } 
                } catch (JSONException jSONException) {
                  IabResult iabResult = new IabResult(-1003, "Failed to parse purchase data.");
                  if (IabHelper.this.mPurchaseListener != null)
                    IabHelper.this.mPurchaseListener.onIabPurchaseFinished(iabResult, null); 
                  return;
                } 
              } 
            }
          });
    } 
  }
  
  int queryAllPurchasesAsync(Inventory paramInventory, List<String> paramList, final OnQueryAllPurchasesFinishedListener listener) throws RemoteException {
    OnQueryPurchasesFinishedListener onQueryPurchasesFinishedListener = new OnQueryPurchasesFinishedListener() {
        ArrayList<IabPurchase> iabPurchasesList = new ArrayList<IabPurchase>();
        
        boolean inappFinished = false;
        
        boolean subsFinished = false;
        
        public void onAllFinished() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("queryAllPurchasesAsync onAllFinished");
          stringBuilder.append(this.inappFinished);
          stringBuilder.append(" ");
          stringBuilder.append(this.subsFinished);
          Log.d("google.payments Helper", stringBuilder.toString());
          if (this.inappFinished && this.subsFinished)
            listener.onQueryAllPurchasesFinished(this.iabPurchasesList); 
        }
        
        public void onQueryPurchasesFinished(List<IabPurchase> param1List, String param1String) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onQueryPurchasesFinished: ");
          stringBuilder.append(param1List);
          stringBuilder.append(" ");
          stringBuilder.append(param1String);
          Log.d("google.payments Helper", stringBuilder.toString());
          if (param1String.equals("inapp")) {
            this.inappFinished = true;
          } else if (param1String.equals("subs")) {
            this.subsFinished = true;
          } 
          this.iabPurchasesList.addAll(param1List);
          onAllFinished();
        }
      };
    queryPurchasesAsync("inapp", paramInventory, paramList, onQueryPurchasesFinishedListener);
    queryPurchasesAsync("subs", paramInventory, paramList, onQueryPurchasesFinishedListener);
    return 0;
  }
  
  int queryIabSkuDetails(final String itemType, final Inventory inv, List<String> paramList) throws RemoteException, JSONException {
    Object object;
    Log.d("google.payments Helper", "queryIabSkuDetails() Querying SKU details.");
    TreeSet<String> treeSet = new TreeSet();
    inv.getAllOwnedSkus(itemType);
    treeSet.addAll(inv.getAllOwnedSkus(itemType));
    if (paramList != null)
      for (String str : paramList) {
        if (!treeSet.contains(str))
          treeSet.add(str); 
      }  
    if (treeSet.size() == 0) {
      Log.d("google.payments Helper", "queryIabSkuDetails(): nothing to do because there are no SKUs.");
      return 0;
    } 
    ArrayList<List<String>> arrayList = new ArrayList();
    paramList = new ArrayList<String>(20);
    Iterator<String> iterator = treeSet.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      paramList.add(iterator.next());
      int i = object + 1;
      if (paramList.size() != 20) {
        int j = i;
        if (i == treeSet.size())
          continue; 
        continue;
      } 
      continue;
      arrayList.add(paramList);
      paramList = new ArrayList<String>(20);
      object = SYNTHETIC_LOCAL_VARIABLE_8;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("queryIabSkuDetails() batches: ");
    stringBuilder.append(arrayList.size());
    stringBuilder.append(", ");
    stringBuilder.append(arrayList);
    Log.d("google.payments Helper", stringBuilder.toString());
    for (ArrayList arrayList1 : arrayList) {
      String str;
      SkuDetailsParams.Builder builder = SkuDetailsParams.newBuilder();
      if (itemType == "inapp") {
        str = "inapp";
      } else {
        str = "subs";
      } 
      builder.setSkusList(arrayList1).setType(str);
      this.billingClient.querySkuDetailsAsync(builder.build(), new SkuDetailsResponseListener() {
            public void onSkuDetailsResponse(BillingResult param1BillingResult, List<SkuDetails> param1List) {
              Log.d("google.payments Helper", "onIabSkuDetailsResponse");
              for (SkuDetails skuDetails : param1List) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got sku details: ");
                stringBuilder.append(skuDetails);
                Log.d("google.payments Helper", stringBuilder.toString());
                IabSkuDetails iabSkuDetails = new IabSkuDetails(itemType, skuDetails);
                inv.addIabSkuDetails(iabSkuDetails);
              } 
            }
          });
    } 
    return 0;
  }
  
  int queryIabSkuDetailsAsync(final String itemType, final Inventory inv, List<String> paramList, final OnQueryIabSkuDetailsFinishedListener listener) throws RemoteException {
    Log.d("google.payments Helper", "queryIabSkuDetailsAsync() Querying SKU details.");
    SkuDetailsParams.Builder builder = SkuDetailsParams.newBuilder();
    if (itemType != null && !itemType.equals(""))
      builder.setType(itemType); 
    if (paramList != null) {
      builder.setSkusList(paramList);
    } else {
      builder.setSkusList(inv.getAllOwnedSkus());
    } 
    SkuDetailsParams skuDetailsParams = builder.build();
    this.billingClient.querySkuDetailsAsync(skuDetailsParams, new SkuDetailsResponseListener() {
          public void onSkuDetailsResponse(BillingResult param1BillingResult, List<SkuDetails> param1List) {
            ArrayList<IabSkuDetails> arrayList = new ArrayList();
            for (SkuDetails skuDetails : param1List) {
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("onSkuDetailsResponse: ");
              stringBuilder2.append(param1List);
              Log.d("google.payments Helper", stringBuilder2.toString());
              IabSkuDetails iabSkuDetails = new IabSkuDetails(itemType, skuDetails);
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("isd origin: ");
              stringBuilder1.append(iabSkuDetails);
              Log.d("google.payments Helper", stringBuilder1.toString());
              inv.addIabSkuDetails(iabSkuDetails);
              arrayList.add(iabSkuDetails);
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSkuDetailsResponse: ");
            stringBuilder.append(arrayList);
            Log.d("google.payments Helper", stringBuilder.toString());
            listener.onQueryIabSkuDetailsFinished(arrayList, itemType);
          }
        });
    return 0;
  }
  
  public void queryInventoryAsync(QueryInventoryFinishedListener paramQueryInventoryFinishedListener) {
    queryInventoryAsync(true, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(boolean paramBoolean, QueryInventoryFinishedListener paramQueryInventoryFinishedListener) {
    queryInventoryAsync(paramBoolean, null, paramQueryInventoryFinishedListener);
  }
  
  public void queryInventoryAsync(final boolean queryIabSkuDetails, final List<String> moreSkus, final QueryInventoryFinishedListener listener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IabHelper queryInventoryAsync");
    stringBuilder.append(queryIabSkuDetails);
    stringBuilder.append(" ");
    stringBuilder.append(moreSkus);
    Log.d("google.payments Helper", stringBuilder.toString());
    final Handler handler = new Handler();
    checkNotDisposed();
    checkSetupDone("queryInventory");
    flagStartAsync("refresh inventory");
    (new Thread(new Runnable() {
          public void run() {
            new IabResult(0, "Inventory refresh successful.");
            Inventory inventory = new Inventory();
            try {
              IabHelper iabHelper = IabHelper.this;
              List<String> list = moreSkus;
              IabHelper.OnQueryAllPurchasesFinishedListener onQueryAllPurchasesFinishedListener = new IabHelper.OnQueryAllPurchasesFinishedListener() {
                  public void onQueryAllPurchasesFinished(List<IabPurchase> param2List) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onQueryAllPurchasesFinished: ");
                    stringBuilder.append(param2List);
                    Log.d("google.payments Helper", stringBuilder.toString());
                    try {
                      if (queryIabSkuDetails) {
                        IabHelper.OnQueryIabSkuDetailsFinishedListener onQueryIabSkuDetailsFinishedListener = new IabHelper.OnQueryIabSkuDetailsFinishedListener() {
                            protected boolean itemsProcessed = false;
                            
                            protected boolean subsProcessed = false;
                            
                            public void onAllProcessed() {
                              StringBuilder stringBuilder = new StringBuilder();
                              stringBuilder.append("oqapf onAllProcessed: ");
                              stringBuilder.append(this.subsProcessed);
                              stringBuilder.append(" ");
                              stringBuilder.append(this.itemsProcessed);
                              Log.d("google.payments Helper", stringBuilder.toString());
                              if (this.subsProcessed && this.itemsProcessed) {
                                IabHelper.this.flagEndAsync();
                                final IabResult result_f = new IabResult(0, "Inventory refresh successful.");
                                final Inventory inv_f = inv;
                                if (!IabHelper.this.mDisposed && listener != null)
                                  handler.post(new Runnable() {
                                        public void run() {
                                          listener.onQueryInventoryFinished(result_f, inv_f);
                                        }
                                      }); 
                              } 
                            }
                            
                            public void onQueryIabSkuDetailsFinished(List<IabSkuDetails> param3List, String param3String) {
                              StringBuilder stringBuilder = new StringBuilder();
                              stringBuilder.append("listener:  ");
                              stringBuilder.append(param3String);
                              stringBuilder.append(param3List);
                              Log.d("google.payments Helper", stringBuilder.toString());
                              for (IabSkuDetails iabSkuDetails : param3List) {
                                StringBuilder stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("isd: ");
                                stringBuilder1.append(iabSkuDetails);
                                Log.d("google.payments Helper", stringBuilder1.toString());
                              } 
                              if (param3String == "subs") {
                                this.subsProcessed = true;
                              } else if (param3String == "inapp") {
                                this.itemsProcessed = true;
                              } 
                              onAllProcessed();
                            }
                          };
                        super(this);
                        try {
                          IabHelper.this.queryIabSkuDetailsAsync("inapp", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
                          IabHelper.this.queryIabSkuDetailsAsync("subs", inv, moreSkus, onQueryIabSkuDetailsFinishedListener);
                        } catch (RemoteException remoteException) {
                          IabException iabException = new IabException();
                          this(-1001, "Remote exception while refreshing inventory.", (Exception)remoteException);
                          throw iabException;
                        } 
                      } else {
                        IabHelper.this.flagEndAsync();
                        final IabResult result_f = new IabResult();
                        this(0, "Inventory refresh successful.");
                        final Inventory inv_f = inv;
                        if (!IabHelper.this.mDisposed && listener != null) {
                          Handler handler = handler;
                          Runnable runnable = new Runnable() {
                              public void run() {
                                listener.onQueryInventoryFinished(result_f, inv_f);
                              }
                            };
                          super(this, iabResult, inventory);
                          handler.post(runnable);
                        } 
                      } 
                    } catch (IabException iabException) {
                      final IabResult result_f = iabException.getResult();
                      IabHelper.this.flagEndAsync();
                      final Inventory inv_f = inv;
                      if (!IabHelper.this.mDisposed && listener != null)
                        handler.post(new Runnable() {
                              public void run() {
                                listener.onQueryInventoryFinished(result_f, inv_f);
                              }
                            }); 
                    } 
                  }
                };
              super(this, inventory);
              iabHelper.queryAllPurchasesAsync(inventory, list, onQueryAllPurchasesFinishedListener);
            } catch (RemoteException remoteException) {
              IabException iabException = new IabException();
              this(-1001, "Remote exception while refreshing inventory.", (Exception)remoteException);
              throw iabException;
            } catch (NullPointerException nullPointerException) {
              IabException iabException = new IabException();
              this(-1008, "NullPointerException while refreshing inventory.", nullPointerException);
              throw iabException;
            } catch (IabException iabException) {}
          }
        })).start();
  }
  
  int queryPurchasesAsync(final String itemType, final Inventory inv, List<String> paramList, final OnQueryPurchasesFinishedListener listener) throws RemoteException {
    Log.d("google.payments Helper", "queryPurchasesAsync() Querying SKU details.");
    this.billingClient.queryPurchasesAsync(itemType, new PurchasesResponseListener() {
          public void onQueryPurchasesResponse(BillingResult param1BillingResult, List<Purchase> param1List) {
            ArrayList<IabPurchase> arrayList = new ArrayList();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onQueryPurchasesResponse: ");
            stringBuilder2.append(itemType);
            stringBuilder2.append(" ");
            stringBuilder2.append(param1List);
            Log.d("google.payments Helper", stringBuilder2.toString());
            for (Purchase purchase : param1List) {
              try {
                IabPurchase iabPurchase = new IabPurchase();
                this(itemType, purchase.getOriginalJson(), purchase.getSignature());
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("isd origin: ");
                stringBuilder.append(iabPurchase);
                Log.d("google.payments Helper", stringBuilder.toString());
                inv.addPurchase(iabPurchase);
                arrayList.add(iabPurchase);
              } catch (JSONException jSONException) {
                Log.e("google.payments Helper", "onQueryPurchasesResponse: JSON exception");
              } 
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("onPurchasesResponse: ");
            stringBuilder1.append(arrayList);
            Log.d("google.payments Helper", stringBuilder1.toString());
            listener.onQueryPurchasesFinished(arrayList, itemType);
          }
        });
    return 0;
  }
  
  public void setSkipPurchaseVerification(boolean paramBoolean) {
    this.mSkipPurchaseVerification = paramBoolean;
  }
  
  public void startSetup(final OnIabSetupFinishedListener listener) {
    checkNotDisposed();
    if (!this.mSetupDone) {
      this.billingClient = BillingClient.newBuilder(this.mContext).setListener(this).enablePendingPurchases().build();
      this.billingClient.startConnection(new BillingClientStateListener() {
            public void onBillingServiceDisconnected() {
              Log.d("google.payments Helper", "Billing service disconnected.");
            }
            
            public void onBillingSetupFinished(BillingResult param1BillingResult) {
              if (IabHelper.this.mDisposed)
                return; 
              Log.d("google.payments Helper", "Billing service connected.");
              String str = IabHelper.this.mContext.getPackageName();
              Log.d("google.payments Helper", "Checking for in-app billing 6 support.");
              int i = param1BillingResult.getResponseCode();
              if (i != 0) {
                IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener1 = listener;
                if (onIabSetupFinishedListener1 != null)
                  onIabSetupFinishedListener1.onIabSetupFinished(new IabResult(i, "Error checking for billing v6 support.")); 
                IabHelper.this.mSubscriptionsSupported = false;
                return;
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("In-app billing version 6 supported for ");
              stringBuilder.append(str);
              Log.d("google.payments Helper", stringBuilder.toString());
              i = IabHelper.this.billingClient.isFeatureSupported("subscriptions").getResponseCode();
              if (i == 0) {
                Log.d("google.payments Helper", "Subscriptions AVAILABLE.");
                IabHelper.this.mSubscriptionsSupported = true;
              } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Subscriptions NOT AVAILABLE. Response: ");
                stringBuilder.append(i);
                Log.d("google.payments Helper", stringBuilder.toString());
              } 
              IabHelper.this.mSetupDone = true;
              IabHelper.OnIabSetupFinishedListener onIabSetupFinishedListener = listener;
              if (onIabSetupFinishedListener != null)
                onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful.")); 
            }
          });
      return;
    } 
    throw new IllegalStateException("IAB helper is already set up.");
  }
  
  public boolean subscriptionsSupported() {
    checkNotDisposed();
    return this.mSubscriptionsSupported;
  }
  
  public abstract class ConsumeAsyncFinishedListener implements ConsumeResponseListener {
    public boolean allConsumesStarted = false;
    
    public int consumesCompleted = 0;
    
    public int totalConsumes = 0;
    
    public abstract void onConsumeFinished();
  }
  
  public static interface OnAcknowledgeFinishedListener {
    void onAcknowledgeFinished(IabPurchase param1IabPurchase, IabResult param1IabResult);
  }
  
  public static interface OnConsumeFinishedListener {
    void onConsumeFinished(IabPurchase param1IabPurchase, IabResult param1IabResult);
  }
  
  public static interface OnConsumeMultiFinishedListener {
    void onConsumeMultiFinished(List<IabPurchase> param1List, List<IabResult> param1List1);
  }
  
  public static interface OnIabPurchaseFinishedListener {
    void onIabPurchaseFinished(IabResult param1IabResult, IabPurchase param1IabPurchase);
  }
  
  public static interface OnIabSetupFinishedListener {
    void onIabSetupFinished(IabResult param1IabResult);
  }
  
  public static interface OnQueryAllPurchasesFinishedListener {
    void onQueryAllPurchasesFinished(List<IabPurchase> param1List);
  }
  
  public static interface OnQueryIabSkuDetailsFinishedListener {
    void onQueryIabSkuDetailsFinished(List<IabSkuDetails> param1List, String param1String);
  }
  
  public static interface OnQueryPurchasesFinishedListener {
    void onQueryPurchasesFinished(List<IabPurchase> param1List, String param1String);
  }
  
  public static interface QueryInventoryFinishedListener {
    void onQueryInventoryFinished(IabResult param1IabResult, Inventory param1Inventory);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\IabHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */