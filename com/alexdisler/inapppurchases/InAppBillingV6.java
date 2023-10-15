package com.alexdisler.inapppurchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppBillingV6 extends CordovaPlugin {
  public static final int BAD_RESPONSE_FROM_SERVER = -6;
  
  public static final int BILLING_API_VERSION = 6;
  
  public static final int BILLING_NOT_INITIALIZED = -3;
  
  public static final int CONSUME_FAILED = -11;
  
  public static final int INVALID_ARGUMENTS = -1;
  
  public static final int ITEM_ALREADY_OWNED = -9;
  
  public static final int ITEM_NOT_OWNED = -10;
  
  public static final int ITEM_UNAVAILABLE = -8;
  
  public static final int OK = 0;
  
  public static final int PURCHASE_CANCELLED = 1;
  
  public static final int PURCHASE_PURCHASED = 0;
  
  public static final int PURCHASE_REFUNDED = 2;
  
  protected static final String TAG = "google.payments";
  
  public static final int UNABLE_TO_INITIALIZE = -2;
  
  public static final int UNKNOWN_ERROR = -4;
  
  public static final int USER_CANCELLED = -5;
  
  public static final int VERIFICATION_FAILED = -7;
  
  boolean billingInitialized = false;
  
  private IabHelper iabHelper = null;
  
  private JSONObject manifestObject = null;
  
  AtomicInteger orderSerial = new AtomicInteger(0);
  
  private List<String> convertJsonArrayToList(JSONArray paramJSONArray) throws JSONException {
    ArrayList<String> arrayList = new ArrayList();
    for (byte b = 0; b < paramJSONArray.length(); b++)
      arrayList.add(paramJSONArray.getString(b)); 
    return arrayList;
  }
  
  private JSONObject getManifestContents() {
    JSONObject jSONObject = this.manifestObject;
    if (jSONObject != null)
      return jSONObject; 
    try {
      InputStream inputStream2 = getManifestFileInputStream("www");
      InputStream inputStream1 = inputStream2;
      if (inputStream2 == null)
        inputStream1 = getManifestFileInputStream("public"); 
      if (inputStream1 != null) {
        String str;
        Scanner scanner2 = new Scanner();
        this(inputStream1);
        Scanner scanner1 = scanner2.useDelimiter("\\A");
        if (scanner1.hasNext()) {
          str = scanner1.next();
        } else {
          str = "";
        } 
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("manifest:");
        stringBuilder.append(str);
        Log.d("google.payments", stringBuilder.toString());
        JSONObject jSONObject1 = new JSONObject();
        this(str);
        this.manifestObject = jSONObject1;
      } else {
        this.manifestObject = null;
      } 
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to parse manifest file:");
      stringBuilder.append(jSONException.toString());
      Log.d("google.payments", stringBuilder.toString());
      this.manifestObject = null;
    } 
    return this.manifestObject;
  }
  
  private InputStream getManifestFileInputStream(String paramString) {
    InputStream inputStream;
    Activity activity = this.cordova.getActivity();
    try {
      AssetManager assetManager = activity.getAssets();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramString);
      stringBuilder.append("/manifest.json");
      InputStream inputStream1 = assetManager.open(stringBuilder.toString());
      inputStream = inputStream1;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Can not load manifest file on path: ");
      stringBuilder.append((String)inputStream);
      stringBuilder.append("/manifest.json");
      Log.d("google.payments", stringBuilder.toString());
      inputStream = null;
    } 
    return inputStream;
  }
  
  protected boolean acknowledgePurchase(JSONArray paramJSONArray, final CallbackContext callbackContext) {
    try {
      IabPurchase iabPurchase = new IabPurchase(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2));
      IabHelper iabHelper = this.iabHelper;
      if (iabHelper == null || !this.billingInitialized) {
        callbackContext.error(makeError("Billing is not initialized", Integer.valueOf(-3)));
        return false;
      } 
      iabHelper.acknowledgeAsync(iabPurchase, new IabHelper.OnAcknowledgeFinishedListener() {
            public void onAcknowledgeFinished(IabPurchase param1IabPurchase, IabResult param1IabResult) {
              if (param1IabResult.isFailure()) {
                if (param1IabResult.getResponse() == 8) {
                  callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-10), param1IabResult));
                } else {
                  callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-11), param1IabResult));
                } 
              } else {
                try {
                  JSONObject jSONObject = new JSONObject();
                  this();
                  jSONObject.put("transactionId", param1IabPurchase.getOrderId());
                  jSONObject.put("productId", param1IabPurchase.getSku());
                  jSONObject.put("token", param1IabPurchase.getToken());
                  callbackContext.success(jSONObject);
                } catch (JSONException jSONException) {
                  callbackContext.error("Acknowledge succeeded but success handler failed");
                } 
              } 
            }
          });
      return true;
    } catch (JSONException jSONException) {
      callbackContext.error(makeError("Unable to parse purchase token", Integer.valueOf(-1)));
      return false;
    } 
  }
  
  protected boolean buy(JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    return runPayment(paramJSONArray, paramCallbackContext, false);
  }
  
  protected boolean consumePurchase(JSONArray paramJSONArray, final CallbackContext callbackContext) {
    try {
      IabPurchase iabPurchase = new IabPurchase(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2));
      IabHelper iabHelper = this.iabHelper;
      if (iabHelper == null || !this.billingInitialized) {
        callbackContext.error(makeError("Billing is not initialized", Integer.valueOf(-3)));
        return false;
      } 
      iabHelper.consumeAsync(iabPurchase, new IabHelper.OnConsumeFinishedListener() {
            public void onConsumeFinished(IabPurchase param1IabPurchase, IabResult param1IabResult) {
              if (param1IabResult.isFailure()) {
                if (param1IabResult.getResponse() == 8) {
                  callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-10), param1IabResult));
                } else {
                  callbackContext.error(InAppBillingV6.this.makeError("Error consuming purchase", Integer.valueOf(-11), param1IabResult));
                } 
              } else {
                try {
                  JSONObject jSONObject = new JSONObject();
                  this();
                  jSONObject.put("transactionId", param1IabPurchase.getOrderId());
                  jSONObject.put("productId", param1IabPurchase.getSku());
                  jSONObject.put("token", param1IabPurchase.getToken());
                  callbackContext.success(jSONObject);
                } catch (JSONException jSONException) {
                  callbackContext.error("Consume succeeded but success handler failed");
                } 
              } 
            }
          });
      return true;
    } catch (JSONException jSONException) {
      callbackContext.error(makeError("Unable to parse purchase token", Integer.valueOf(-1)));
      return false;
    } 
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("executing on android");
    stringBuilder.append(paramString);
    Log.d("google.payments", stringBuilder.toString());
    return "init".equals(paramString) ? init(paramJSONArray, paramCallbackContext) : ("buy".equals(paramString) ? buy(paramJSONArray, paramCallbackContext) : ("subscribe".equals(paramString) ? subscribe(paramJSONArray, paramCallbackContext) : ("consumePurchase".equals(paramString) ? consumePurchase(paramJSONArray, paramCallbackContext) : ("getSkuDetails".equals(paramString) ? getSkuDetails(paramJSONArray, paramCallbackContext) : ("restorePurchases".equals(paramString) ? restorePurchases(paramJSONArray, paramCallbackContext) : ("acknowledgePurchase".equals(paramString) ? acknowledgePurchase(paramJSONArray, paramCallbackContext) : false))))));
  }
  
  protected String getBase64EncodedPublicKey() {
    JSONObject jSONObject = getManifestContents();
    return (jSONObject != null) ? jSONObject.optString("play_store_key") : null;
  }
  
  protected boolean getSkuDetails(JSONArray paramJSONArray, final CallbackContext callbackContext) {
    final ArrayList<String> moreSkus = new ArrayList();
    byte b = 0;
    try {
      while (b < paramJSONArray.length()) {
        arrayList.add(paramJSONArray.getString(b));
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("get sku:");
        stringBuilder.append(paramJSONArray.getString(b));
        Log.d("google.payments", stringBuilder.toString());
        b++;
      } 
      IabHelper iabHelper = this.iabHelper;
      if (iabHelper == null || !this.billingInitialized) {
        callbackContext.error(makeError("Billing is not initialized", Integer.valueOf(-3)));
        return false;
      } 
      iabHelper.queryInventoryAsync(true, arrayList, new IabHelper.QueryInventoryFinishedListener() {
            public void onQueryInventoryFinished(IabResult param1IabResult, Inventory param1Inventory) {
              if (param1IabResult.isFailure()) {
                callbackContext.error("Error retrieving SKU details");
                return;
              } 
              JSONArray jSONArray = new JSONArray();
              try {
                Iterator<String> iterator = moreSkus.iterator();
                while (iterator.hasNext()) {
                  IabSkuDetails iabSkuDetails = param1Inventory.getIabSkuDetails(iterator.next());
                  if (iabSkuDetails != null) {
                    JSONObject jSONObject = new JSONObject();
                    this();
                    jSONObject.put("productId", iabSkuDetails.getSku());
                    jSONObject.put("title", iabSkuDetails.getTitle());
                    jSONObject.put("description", iabSkuDetails.getDescription());
                    jSONObject.put("priceAsDecimal", iabSkuDetails.getPriceAsDecimal());
                    jSONObject.put("price", iabSkuDetails.getPrice());
                    jSONObject.put("priceRaw", iabSkuDetails.getPriceRaw());
                    jSONObject.put("currency", iabSkuDetails.getPriceCurrency());
                    jSONObject.put("country", "-");
                    jSONObject.put("type", iabSkuDetails.getType());
                    jSONObject.put("currency", iabSkuDetails.getPriceCurrency());
                    jSONArray.put(jSONObject);
                  } 
                } 
              } catch (JSONException jSONException) {
                callbackContext.error(jSONException.getMessage());
              } 
              callbackContext.success(jSONArray);
            }
          });
      return true;
    } catch (JSONException jSONException) {
      callbackContext.error(makeError("Invalid SKU", Integer.valueOf(-1)));
      return false;
    } 
  }
  
  protected boolean init(JSONArray paramJSONArray, final CallbackContext callbackContext) {
    if (this.billingInitialized) {
      Log.d("google.payments", "Billing already initialized");
      callbackContext.success();
    } else {
      IabHelper iabHelper = this.iabHelper;
      if (iabHelper == null) {
        callbackContext.error(makeError("Billing cannot be initialized", Integer.valueOf(-2)));
      } else {
        iabHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
              public void onIabSetupFinished(IabResult param1IabResult) {
                if (!param1IabResult.isSuccess()) {
                  CallbackContext callbackContext = callbackContext;
                  InAppBillingV6 inAppBillingV6 = InAppBillingV6.this;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Unable to initialize billing: ");
                  stringBuilder.append(param1IabResult.toString());
                  callbackContext.error(inAppBillingV6.makeError(stringBuilder.toString(), Integer.valueOf(-2), param1IabResult));
                } else {
                  Log.d("google.payments", "Billing initialized");
                  InAppBillingV6.this.billingInitialized = true;
                  callbackContext.success();
                } 
              }
            });
      } 
    } 
    return true;
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView) {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    initializeBillingHelper();
  }
  
  protected boolean initializeBillingHelper() {
    if (this.iabHelper != null) {
      Log.d("google.payments", "Billing already initialized");
      return true;
    } 
    Activity activity = this.cordova.getActivity();
    String str = getBase64EncodedPublicKey();
    boolean bool = shouldSkipPurchaseVerification();
    if (str != null) {
      this.iabHelper = new IabHelper((Context)activity, str);
      this.iabHelper.setSkipPurchaseVerification(bool);
      this.billingInitialized = false;
      return true;
    } 
    Log.d("google.payments", "Unable to initialize billing");
    return false;
  }
  
  protected JSONObject makeError(String paramString) {
    return makeError(paramString, null, null, null);
  }
  
  protected JSONObject makeError(String paramString, Integer paramInteger) {
    return makeError(paramString, paramInteger, null, null);
  }
  
  protected JSONObject makeError(String paramString, Integer paramInteger, IabResult paramIabResult) {
    return makeError(paramString, paramInteger, paramIabResult.getMessage(), Integer.valueOf(paramIabResult.getResponse()));
  }
  
  protected JSONObject makeError(String paramString1, Integer paramInteger1, String paramString2, Integer paramInteger2) {
    if (paramString1 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error: ");
      stringBuilder.append(paramString1);
      Log.d("google.payments", stringBuilder.toString());
    } 
    JSONObject jSONObject = new JSONObject();
    if (paramInteger1 != null) {
      try {
        jSONObject.put("code", paramInteger1.intValue());
        if (paramString1 != null)
          jSONObject.put("message", paramString1); 
        if (paramString2 != null)
          jSONObject.put("text", paramString2); 
        if (paramInteger2 != null)
          jSONObject.put("response", paramInteger2); 
      } catch (JSONException jSONException) {}
      return jSONObject;
    } 
    if (jSONException != null)
      jSONObject.put("message", jSONException); 
    if (paramString2 != null)
      jSONObject.put("text", paramString2); 
    if (paramInteger2 != null)
      jSONObject.put("response", paramInteger2); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (!this.iabHelper.handleActivityResult(paramInt1, paramInt2, paramIntent))
      super.onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public void onDestroy() {
    IabHelper iabHelper = this.iabHelper;
    if (iabHelper != null)
      iabHelper.dispose(); 
    this.iabHelper = null;
    this.billingInitialized = false;
  }
  
  protected boolean restorePurchases(JSONArray paramJSONArray, final CallbackContext callbackContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("restorePurchases: ");
    stringBuilder.append(paramJSONArray);
    Log.d("google.payments", stringBuilder.toString());
    IabHelper iabHelper = this.iabHelper;
    if (iabHelper == null || !this.billingInitialized) {
      callbackContext.error(makeError("Billing is not initialized", Integer.valueOf(-3)));
      return true;
    } 
    iabHelper.queryInventoryAsync(new IabHelper.QueryInventoryFinishedListener() {
          public void onQueryInventoryFinished(IabResult param1IabResult, Inventory param1Inventory) {
            if (param1IabResult.isFailure()) {
              callbackContext.error("Error retrieving purchase details");
              return;
            } 
            JSONArray jSONArray = new JSONArray();
            try {
              for (IabPurchase iabPurchase : param1Inventory.getAllPurchases()) {
                if (iabPurchase != null) {
                  JSONObject jSONObject = new JSONObject();
                  this();
                  jSONObject.put("orderId", iabPurchase.getOrderId());
                  jSONObject.put("packageName", iabPurchase.getPackageName());
                  jSONObject.put("productId", iabPurchase.getSku());
                  jSONObject.put("purchaseTime", iabPurchase.getPurchaseTime());
                  jSONObject.put("purchaseState", iabPurchase.getPurchaseState());
                  jSONObject.put("purchaseToken", iabPurchase.getToken());
                  jSONObject.put("signature", iabPurchase.getSignature());
                  jSONObject.put("type", iabPurchase.getItemType());
                  jSONObject.put("receipt", iabPurchase.getOriginalJson());
                  jSONArray.put(jSONObject);
                } 
              } 
            } catch (JSONException jSONException) {
              callbackContext.error(jSONException.getMessage());
            } 
            callbackContext.success(jSONArray);
          }
        });
    return true;
  }
  
  protected boolean runPayment(JSONArray paramJSONArray, final CallbackContext callbackContext, boolean paramBoolean) {
    StringBuilder stringBuilder;
    Log.d("google.payments", "runPayment");
    try {
      String str1;
      String str2 = paramJSONArray.getString(0);
      if (paramJSONArray.length() > 1) {
        str1 = paramJSONArray.getString(1);
      } else {
        str1 = "";
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("runPayment: ");
      stringBuilder1.append(str2);
      Log.d("google.payments", stringBuilder1.toString());
      if (this.iabHelper == null || !this.billingInitialized) {
        callbackContext.error(makeError("Billing is not initialized", Integer.valueOf(-3)));
        return false;
      } 
      Activity activity = this.cordova.getActivity();
      IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
          public void onIabPurchaseFinished(IabResult param1IabResult, IabPurchase param1IabPurchase) {
            CallbackContext callbackContext;
            if (param1IabResult.isFailure()) {
              int i = param1IabResult.getResponse();
              if (i == -1002 || i == -1008) {
                callbackContext.error(InAppBillingV6.this.makeError("Could not complete purchase", Integer.valueOf(-6), param1IabResult));
                return;
              } 
              if (i == -1003) {
                callbackContext.error(InAppBillingV6.this.makeError("Could not complete purchase", Integer.valueOf(-6), param1IabResult));
              } else if (i == -1005) {
                callbackContext.error(InAppBillingV6.this.makeError("Purchase Cancelled", Integer.valueOf(-5), param1IabResult));
              } else if (i == 7) {
                callbackContext.error(InAppBillingV6.this.makeError("Item already owned", Integer.valueOf(-9), param1IabResult));
              } else {
                callbackContext = callbackContext;
                InAppBillingV6 inAppBillingV6 = InAppBillingV6.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error completing purchase: ");
                stringBuilder.append(i);
                callbackContext.error(inAppBillingV6.makeError(stringBuilder.toString(), Integer.valueOf(-4), param1IabResult));
              } 
            } else {
              try {
                JSONObject jSONObject = new JSONObject();
                this();
                jSONObject.put("orderId", callbackContext.getOrderId());
                jSONObject.put("packageName", callbackContext.getPackageName());
                jSONObject.put("productId", callbackContext.getSku());
                jSONObject.put("purchaseTime", callbackContext.getPurchaseTime());
                jSONObject.put("purchaseState", callbackContext.getPurchaseState());
                jSONObject.put("purchaseToken", callbackContext.getToken());
                jSONObject.put("signature", callbackContext.getSignature());
                jSONObject.put("type", callbackContext.getItemType());
                jSONObject.put("receipt", callbackContext.getOriginalJson());
                callbackContext.success(jSONObject);
              } catch (JSONException jSONException) {
                callbackContext.error("Purchase succeeded but success handler failed");
              } 
            } 
          }
        };
      stringBuilder = new StringBuilder();
      stringBuilder.append("runPayment subscribe: ");
      stringBuilder.append(paramBoolean);
      Log.d("google.payments", stringBuilder.toString());
      if (paramBoolean) {
        this.iabHelper.launchPurchaseFlow(activity, str2, "subs", onIabPurchaseFinishedListener, str1);
      } else {
        this.iabHelper.launchPurchaseFlow(activity, str2, "inapp", onIabPurchaseFinishedListener, str1);
      } 
      return true;
    } catch (JSONException jSONException) {
      stringBuilder.error(makeError("Invalid SKU", Integer.valueOf(-1)));
      return false;
    } 
  }
  
  protected boolean shouldSkipPurchaseVerification() {
    JSONObject jSONObject = getManifestContents();
    return (jSONObject != null) ? jSONObject.optBoolean("skip_purchase_verification") : false;
  }
  
  protected boolean subscribe(JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    return runPayment(paramJSONArray, paramCallbackContext, true);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\alexdisler\inapppurchases\InAppBillingV6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */