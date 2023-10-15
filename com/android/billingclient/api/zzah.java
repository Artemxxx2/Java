package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;

final class zzah extends ResultReceiver {
  zzah(BillingClientImpl paramBillingClientImpl, Handler paramHandler, PriceChangeConfirmationListener paramPriceChangeConfirmationListener) {
    super(paramHandler);
  }
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle) {
    BillingResult.Builder builder = BillingResult.newBuilder();
    builder.setResponseCode(paramInt);
    builder.setDebugMessage(zzb.zzk(paramBundle, "BillingClient"));
    BillingResult billingResult = builder.build();
    this.zza.onPriceChangeConfirmationResult(billingResult);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */