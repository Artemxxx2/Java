package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;

final class zzbi {
  static BillingResult zza(Bundle paramBundle, String paramString1, String paramString2) {
    BillingResult billingResult1 = zzbb.zzj;
    if (paramBundle == null) {
      zzb.zzo("BillingClient", String.format("%s got null owned items list", new Object[] { paramString2 }));
      return billingResult1;
    } 
    int i = zzb.zzb(paramBundle, "BillingClient");
    String str = zzb.zzk(paramBundle, "BillingClient");
    BillingResult.Builder builder = BillingResult.newBuilder();
    builder.setResponseCode(i);
    builder.setDebugMessage(str);
    BillingResult billingResult2 = builder.build();
    if (i != 0) {
      zzb.zzo("BillingClient", String.format("%s failed. Response code: %s", new Object[] { paramString2, Integer.valueOf(i) }));
      return billingResult2;
    } 
    if (!paramBundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !paramBundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !paramBundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
      zzb.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[] { paramString2 }));
      return billingResult1;
    } 
    ArrayList arrayList2 = paramBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
    ArrayList arrayList3 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    ArrayList arrayList1 = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    if (arrayList2 == null) {
      zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[] { paramString2 }));
      return billingResult1;
    } 
    if (arrayList3 == null) {
      zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[] { paramString2 }));
      return billingResult1;
    } 
    if (arrayList1 == null) {
      zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[] { paramString2 }));
      return billingResult1;
    } 
    return zzbb.zzl;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */