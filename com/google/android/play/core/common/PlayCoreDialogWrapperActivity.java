package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;

public class PlayCoreDialogWrapperActivity extends Activity {
  @Nullable
  private ResultReceiver zza;
  
  private final void zza() {
    ResultReceiver resultReceiver = this.zza;
    if (resultReceiver != null)
      resultReceiver.send(3, new Bundle()); 
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0) {
      ResultReceiver resultReceiver = this.zza;
      if (resultReceiver != null)
        if (paramInt2 == -1) {
          resultReceiver.send(1, new Bundle());
        } else if (paramInt2 == 0) {
          resultReceiver.send(2, new Bundle());
        }  
    } 
    finish();
  }
  
  protected final void onCreate(Bundle paramBundle) {
    Intent intent;
    int i = getIntent().getIntExtra("window_flags", 0);
    if (i != 0) {
      getWindow().getDecorView().setSystemUiVisibility(i);
      intent = new Intent();
      intent.putExtra("window_flags", i);
    } else {
      intent = null;
    } 
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      this.zza = (ResultReceiver)getIntent().getParcelableExtra("result_receiver");
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {
        zza();
        finish();
      } 
      PendingIntent pendingIntent = (PendingIntent)paramBundle.get("confirmation_intent");
      try {
        startIntentSenderForResult(pendingIntent.getIntentSender(), 0, intent, 0, 0, 0);
        return;
      } catch (android.content.IntentSender.SendIntentException sendIntentException) {
        zza();
        finish();
        return;
      } 
    } 
    this.zza = (ResultReceiver)sendIntentException.getParcelable("result_receiver");
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putParcelable("result_receiver", (Parcelable)this.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\common\PlayCoreDialogWrapperActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */