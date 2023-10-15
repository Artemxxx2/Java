package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.zzbv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

public final class zzb {
  public static final int zza = Runtime.getRuntime().availableProcessors();
  
  public static int zza(Intent paramIntent, String paramString) {
    if (paramIntent == null) {
      zzo("ProxyBillingActivity", "Got null intent!");
      return 0;
    } 
    return zzq(paramIntent.getExtras(), "ProxyBillingActivity");
  }
  
  public static int zzb(Bundle paramBundle, String paramString) {
    if (paramBundle == null) {
      zzo(paramString, "Unexpected null bundle received!");
      return 6;
    } 
    Object object = paramBundle.get("RESPONSE_CODE");
    if (object == null) {
      zzn(paramString, "getResponseCodeFromBundle() got null response code, assuming OK");
      return 0;
    } 
    if (object instanceof Integer)
      return ((Integer)object).intValue(); 
    zzo(paramString, "Unexpected type for bundle response code: ".concat(String.valueOf(object.getClass().getName())));
    return 6;
  }
  
  public static Bundle zzc(AcknowledgePurchaseParams paramAcknowledgePurchaseParams, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("playBillingLibraryVersion", paramString);
    return bundle;
  }
  
  public static Bundle zzd(ConsumeParams paramConsumeParams, boolean paramBoolean, String paramString) {
    Bundle bundle = new Bundle();
    if (paramBoolean)
      bundle.putString("playBillingLibraryVersion", paramString); 
    return bundle;
  }
  
  public static Bundle zze(int paramInt, boolean paramBoolean, String paramString1, @Nullable String paramString2, ArrayList<zzbv> paramArrayList) {
    Bundle bundle = new Bundle();
    if (paramInt >= 9)
      bundle.putString("playBillingLibraryVersion", paramString1); 
    if (paramInt >= 9 && paramBoolean)
      bundle.putBoolean("enablePendingPurchases", true); 
    if (paramInt >= 14) {
      ArrayList arrayList1 = new ArrayList();
      ArrayList arrayList2 = new ArrayList();
      ArrayList<Integer> arrayList = new ArrayList();
      int i = paramArrayList.size();
      byte b = 0;
      int j = 0;
      paramInt = 0;
      while (b < i) {
        zzbv zzbv = paramArrayList.get(b);
        arrayList1.add(null);
        j |= TextUtils.isEmpty(null) ^ true;
        arrayList2.add(null);
        paramInt |= TextUtils.isEmpty(null) ^ true;
        arrayList.add(Integer.valueOf(0));
        b++;
      } 
      if (j != 0)
        bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList1); 
      if (paramInt != 0)
        bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList2); 
    } 
    return bundle;
  }
  
  public static Bundle zzf(BillingFlowParams paramBillingFlowParams, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("playBillingLibraryVersion", paramString);
    if (paramBillingFlowParams.zza() != 0)
      bundle.putInt("prorationMode", paramBillingFlowParams.zza()); 
    if (!TextUtils.isEmpty(paramBillingFlowParams.zzb()))
      bundle.putString("accountId", paramBillingFlowParams.zzb()); 
    if (!TextUtils.isEmpty(paramBillingFlowParams.zzc()))
      bundle.putString("obfuscatedProfileId", paramBillingFlowParams.zzc()); 
    if (paramBillingFlowParams.zzn())
      bundle.putBoolean("isOfferPersonalizedByDeveloper", true); 
    if (!TextUtils.isEmpty(null))
      bundle.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList((Object[])new String[] { null }))); 
    if (!TextUtils.isEmpty(paramBillingFlowParams.zzd()))
      bundle.putString("oldSkuPurchaseToken", paramBillingFlowParams.zzd()); 
    if (!TextUtils.isEmpty(null))
      bundle.putString("oldSkuPurchaseId", null); 
    if (!TextUtils.isEmpty(null))
      bundle.putString("originalExternalTransactionId", null); 
    if (!TextUtils.isEmpty(null))
      bundle.putString("paymentsPurchaseParams", null); 
    if (paramBoolean1 && paramBoolean2)
      bundle.putBoolean("enablePendingPurchases", true); 
    if (paramBoolean3)
      bundle.putBoolean("enableAlternativeBilling", true); 
    return bundle;
  }
  
  public static Bundle zzg(String paramString1, ArrayList<QueryProductDetailsParams.Product> paramArrayList, @Nullable String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putString("playBillingLibraryVersion", paramString1);
    bundle.putBoolean("enablePendingPurchases", true);
    bundle.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
    ArrayList arrayList = new ArrayList();
    int i = paramArrayList.size();
    byte b = 0;
    int j = 0;
    while (b < i) {
      QueryProductDetailsParams.Product product = paramArrayList.get(b);
      arrayList.add(null);
      j |= TextUtils.isEmpty(null) ^ true;
      b++;
    } 
    if (j != 0)
      bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList); 
    return bundle;
  }
  
  public static Bundle zzh(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("playBillingLibraryVersion", paramString);
    if (paramBoolean1 && paramBoolean2)
      bundle.putBoolean("enablePendingPurchases", true); 
    return bundle;
  }
  
  public static BillingResult zzi(Intent paramIntent, String paramString) {
    BillingResult.Builder builder1;
    if (paramIntent == null) {
      zzo("BillingHelper", "Got null intent!");
      builder1 = BillingResult.newBuilder();
      builder1.setResponseCode(6);
      builder1.setDebugMessage("An internal error occurred.");
      return builder1.build();
    } 
    BillingResult.Builder builder2 = BillingResult.newBuilder();
    builder2.setResponseCode(zzb(builder1.getExtras(), paramString));
    builder2.setDebugMessage(zzk(builder1.getExtras(), paramString));
    return builder2.build();
  }
  
  public static InAppMessageResult zzj(Bundle paramBundle, String paramString) {
    return (paramBundle == null) ? new InAppMessageResult(0, null) : new InAppMessageResult(zzq(paramBundle, "BillingClient"), paramBundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
  }
  
  public static String zzk(Bundle paramBundle, String paramString) {
    if (paramBundle == null) {
      zzo(paramString, "Unexpected null bundle received!");
      return "";
    } 
    Object object = paramBundle.get("DEBUG_MESSAGE");
    if (object == null) {
      zzn(paramString, "getDebugMessageFromBundle() got null response code, assuming OK");
      return "";
    } 
    if (object instanceof String)
      return (String)object; 
    zzo(paramString, "Unexpected type for debug message: ".concat(String.valueOf(object.getClass().getName())));
    return "";
  }
  
  public static String zzl(int paramInt) {
    return zza.zza(paramInt).toString();
  }
  
  @Nullable
  public static List zzm(Bundle paramBundle) {
    if (paramBundle == null)
      return null; 
    ArrayList<String> arrayList1 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    ArrayList<String> arrayList2 = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    ArrayList<Purchase> arrayList = new ArrayList();
    if (arrayList1 == null || arrayList2 == null) {
      Purchase purchase = zzr(paramBundle.getString("INAPP_PURCHASE_DATA"), paramBundle.getString("INAPP_DATA_SIGNATURE"));
      if (purchase == null) {
        zzn("BillingHelper", "Couldn't find single purchase data as well.");
        return null;
      } 
      arrayList.add(purchase);
      return arrayList;
    } 
    int i = arrayList1.size();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Found purchase list of ");
    stringBuilder.append(i);
    stringBuilder.append(" items");
    zzn("BillingHelper", stringBuilder.toString());
    for (i = 0; i < arrayList1.size() && i < arrayList2.size(); i++) {
      Purchase purchase = zzr(arrayList1.get(i), arrayList2.get(i));
      if (purchase != null)
        arrayList.add(purchase); 
    } 
    return arrayList;
  }
  
  public static void zzn(String paramString1, String paramString2) {
    if (Log.isLoggable(paramString1, 2))
      if (!paramString2.isEmpty()) {
        for (int i = 40000; !paramString2.isEmpty() && i > 0; i -= j) {
          int j = Math.min(paramString2.length(), Math.min(4000, i));
          Log.v(paramString1, paramString2.substring(0, j));
          paramString2 = paramString2.substring(j);
        } 
      } else {
        Log.v(paramString1, paramString2);
      }  
  }
  
  public static void zzo(String paramString1, String paramString2) {
    if (Log.isLoggable(paramString1, 5))
      Log.w(paramString1, paramString2); 
  }
  
  public static void zzp(String paramString1, String paramString2, Throwable paramThrowable) {
    if (Log.isLoggable(paramString1, 5))
      Log.w(paramString1, paramString2, paramThrowable); 
  }
  
  private static int zzq(Bundle paramBundle, String paramString) {
    if (paramBundle == null) {
      zzo(paramString, "Unexpected null bundle received!");
      return 0;
    } 
    return paramBundle.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
  }
  
  @Nullable
  private static Purchase zzr(String paramString1, String paramString2) {
    JSONException jSONException2 = null;
    if (paramString1 == null || paramString2 == null) {
      zzn("BillingHelper", "Received a null purchase data.");
      return null;
    } 
    try {
      Purchase purchase2 = new Purchase();
      this(paramString1, paramString2);
      Purchase purchase1 = purchase2;
    } catch (JSONException jSONException1) {
      zzo("BillingHelper", "Got JSONException while parsing purchase data: ".concat(jSONException1.toString()));
      jSONException1 = jSONException2;
    } 
    return (Purchase)jSONException1;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */