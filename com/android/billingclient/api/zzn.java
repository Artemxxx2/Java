package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzn extends BroadcastReceiver {
  private final PurchasesUpdatedListener zzb;
  
  private final zzbe zzc;
  
  private final zzc zzd;
  
  private boolean zze;
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    List<Purchase> list;
    BillingResult billingResult = zzb.zzi(paramIntent, "BillingBroadcastManager");
    String str = paramIntent.getAction();
    if (str.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
      list = zzb.zzm(paramIntent.getExtras());
      this.zzb.onPurchasesUpdated(billingResult, list);
      return;
    } 
    if (str.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
      Bundle bundle = list.getExtras();
      if (billingResult.getResponseCode() != 0) {
        this.zzb.onPurchasesUpdated(billingResult, (List<Purchase>)zzu.zzl());
        return;
      } 
      if (this.zzd == null) {
        zzb.zzo("BillingBroadcastManager", "AlternativeBillingListener is null.");
        this.zzb.onPurchasesUpdated(zzbb.zzj, (List<Purchase>)zzu.zzl());
        return;
      } 
      if (bundle == null) {
        zzb.zzo("BillingBroadcastManager", "Bundle is null.");
        this.zzb.onPurchasesUpdated(zzbb.zzj, (List<Purchase>)zzu.zzl());
        return;
      } 
      String str1 = bundle.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
      if (str1 != null)
        try {
          JSONObject jSONObject = new JSONObject();
          this(str1);
          JSONArray jSONArray = jSONObject.optJSONArray("products");
          ArrayList<zze> arrayList = new ArrayList();
          this();
          if (jSONArray != null)
            for (byte b = 0; b < jSONArray.length(); b++) {
              JSONObject jSONObject1 = jSONArray.optJSONObject(b);
              if (jSONObject1 != null) {
                zze zze = new zze();
                this(jSONObject1, null);
                arrayList.add(zze);
              } 
            }  
          this.zzd.zza();
          return;
        } catch (JSONException jSONException) {
          zzb.zzo("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", new Object[] { str1 }));
          this.zzb.onPurchasesUpdated(zzbb.zzj, (List<Purchase>)zzu.zzl());
          return;
        }  
      zzb.zzo("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
      this.zzb.onPurchasesUpdated(zzbb.zzj, (List<Purchase>)zzu.zzl());
    } 
  }
  
  public final void zzc(Context paramContext, IntentFilter paramIntentFilter) {
    if (!this.zze) {
      paramContext.registerReceiver(zzo.zza(this.zza), paramIntentFilter);
      this.zze = true;
    } 
  }
  
  public final void zzd(Context paramContext) {
    if (this.zze) {
      paramContext.unregisterReceiver(zzo.zza(this.zza));
      this.zze = false;
      return;
    } 
    zzb.zzo("BillingBroadcastManager", "Receiver is not registered.");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */