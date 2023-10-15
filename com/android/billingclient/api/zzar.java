package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzf;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

final class zzar extends zzf {
  final WeakReference zza;
  
  final ResultReceiver zzb;
  
  public final void zza(Bundle paramBundle) throws RemoteException {
    ResultReceiver resultReceiver = this.zzb;
    if (resultReceiver == null) {
      zzb.zzo("BillingClient", "Unable to send result for in-app messaging");
      return;
    } 
    if (paramBundle == null) {
      resultReceiver.send(0, null);
      return;
    } 
    Activity activity = this.zza.get();
    PendingIntent pendingIntent = (PendingIntent)paramBundle.getParcelable("KEY_LAUNCH_INTENT");
    if (activity == null || pendingIntent == null) {
      this.zzb.send(0, null);
      zzb.zzo("BillingClient", "Unable to launch intent for in-app messaging");
      return;
    } 
    try {
      Intent intent = new Intent();
      this((Context)activity, ProxyBillingActivity.class);
      intent.putExtra("in_app_message_result_receiver", (Parcelable)this.zzb);
      intent.putExtra("IN_APP_MESSAGE_INTENT", (Parcelable)pendingIntent);
      activity.startActivity(intent);
      return;
    } catch (CancellationException cancellationException) {
      this.zzb.send(0, null);
      zzb.zzp("BillingClient", "Exception caught while launching intent for in-app messaging.", cancellationException);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */