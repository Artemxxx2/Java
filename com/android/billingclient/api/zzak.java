package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzb;

final class zzak extends ResultReceiver {
  zzak(BillingClientImpl paramBillingClientImpl, Handler paramHandler, InAppMessageResponseListener paramInAppMessageResponseListener) {
    super(paramHandler);
  }
  
  public final void onReceiveResult(int paramInt, @Nullable Bundle paramBundle) {
    this.zza.onInAppMessageResponse(zzb.zzj(paramBundle, "BillingClient"));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */