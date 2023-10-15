package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@zzl
@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {
  static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
  
  static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
  
  private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
  
  private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
  
  private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
  
  private static final String TAG = "ProxyBillingActivity";
  
  @Nullable
  private ResultReceiver inAppMessageResultReceiver;
  
  @Nullable
  private ResultReceiver priceChangeResultReceiver;
  
  private boolean sendCancelledBroadcastIfFinished;
  
  private Intent makeAlternativeBillingIntent(String paramString) {
    Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
    intent.setPackage(getApplicationContext().getPackageName());
    intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", paramString);
    return intent;
  }
  
  private Intent makePurchasesUpdatedIntent() {
    Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
    intent.setPackage(getApplicationContext().getPackageName());
    return intent;
  }
  
  @zzl
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
    StringBuilder stringBuilder;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ResultReceiver resultReceiver2 = null;
    ResultReceiver resultReceiver3 = null;
    if (paramInt1 == 100) {
      int i = zzb.zzi(paramIntent, "ProxyBillingActivity").getResponseCode();
      paramInt1 = paramInt2;
      if (paramInt2 == -1)
        if (i != 0) {
          paramInt1 = -1;
        } else {
          paramInt1 = 0;
          resultReceiver2 = this.priceChangeResultReceiver;
        }  
      stringBuilder = new StringBuilder();
      stringBuilder.append("Activity finished with resultCode ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" and billing's responseCode: ");
      stringBuilder.append(i);
      zzb.zzo("ProxyBillingActivity", stringBuilder.toString());
      paramInt1 = i;
    } else {
      if (paramInt1 == 101) {
        paramInt1 = zzb.zza(paramIntent, "ProxyBillingActivity");
        resultReceiver3 = this.inAppMessageResultReceiver;
        if (resultReceiver3 != null) {
          StringBuilder stringBuilder1;
          Bundle bundle;
          if (paramIntent == null) {
            stringBuilder1 = stringBuilder;
          } else {
            bundle = stringBuilder1.getExtras();
          } 
          resultReceiver3.send(paramInt1, bundle);
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Got onActivityResult with wrong requestCode: ");
        stringBuilder1.append(paramInt1);
        stringBuilder1.append("; skipping...");
        zzb.zzo("ProxyBillingActivity", stringBuilder1.toString());
      } 
      this.sendCancelledBroadcastIfFinished = false;
      finish();
    } 
    ResultReceiver resultReceiver1 = this.priceChangeResultReceiver;
  }
  
  @zzl
  protected void onCreate(@Nullable Bundle paramBundle) {
    Intent intent;
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      byte b;
      zzb.zzn("ProxyBillingActivity", "Launching Play Store billing flow");
      if (getIntent().hasExtra("BUY_INTENT")) {
        PendingIntent pendingIntent = (PendingIntent)getIntent().getParcelableExtra("BUY_INTENT");
        b = 100;
      } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
        PendingIntent pendingIntent = (PendingIntent)getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
        this.priceChangeResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("result_receiver");
        b = 100;
      } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
        PendingIntent pendingIntent = (PendingIntent)getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
        this.inAppMessageResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("in_app_message_result_receiver");
        b = 101;
      } else {
        paramBundle = null;
        b = 100;
      } 
      try {
        this.sendCancelledBroadcastIfFinished = true;
        IntentSender intentSender = paramBundle.getIntentSender();
        Intent intent1 = new Intent();
        this();
        startIntentSenderForResult(intentSender, b, intent1, 0, 0, 0);
        return;
      } catch (android.content.IntentSender.SendIntentException sendIntentException) {
        zzb.zzp("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", (Throwable)sendIntentException);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
          resultReceiver.send(6, null);
        } else {
          resultReceiver = this.inAppMessageResultReceiver;
          if (resultReceiver != null) {
            resultReceiver.send(0, null);
          } else {
            intent = makePurchasesUpdatedIntent();
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
            sendBroadcast(intent);
          } 
        } 
        this.sendCancelledBroadcastIfFinished = false;
        finish();
        return;
      } 
    } 
    zzb.zzn("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
    this.sendCancelledBroadcastIfFinished = intent.getBoolean("send_cancelled_broadcast_if_finished", false);
    if (intent.containsKey("result_receiver")) {
      this.priceChangeResultReceiver = (ResultReceiver)intent.getParcelable("result_receiver");
      return;
    } 
    if (intent.containsKey("in_app_message_result_receiver"))
      this.inAppMessageResultReceiver = (ResultReceiver)intent.getParcelable("in_app_message_result_receiver"); 
  }
  
  @zzl
  protected void onDestroy() {
    super.onDestroy();
    if (!isFinishing())
      return; 
    if (!this.sendCancelledBroadcastIfFinished)
      return; 
    Intent intent = makePurchasesUpdatedIntent();
    intent.putExtra("RESPONSE_CODE", 1);
    intent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
    sendBroadcast(intent);
  }
  
  @zzl
  protected void onSaveInstanceState(@NonNull Bundle paramBundle) {
    ResultReceiver resultReceiver = this.priceChangeResultReceiver;
    if (resultReceiver != null)
      paramBundle.putParcelable("result_receiver", (Parcelable)resultReceiver); 
    resultReceiver = this.inAppMessageResultReceiver;
    if (resultReceiver != null)
      paramBundle.putParcelable("in_app_message_result_receiver", (Parcelable)resultReceiver); 
    paramBundle.putBoolean("send_cancelled_broadcast_if_finished", this.sendCancelledBroadcastIfFinished);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\ProxyBillingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */