package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzc extends ResultReceiver {
  zzc(zzd paramzzd, Handler paramHandler, TaskCompletionSource paramTaskCompletionSource) {
    super(paramHandler);
  }
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle) {
    this.zza.trySetResult(null);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */