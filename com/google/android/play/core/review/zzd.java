package com.google.android.play.core.review;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

@SuppressLint({"RestrictedApi"})
public final class zzd implements ReviewManager {
  private final zzi zza;
  
  private final Handler zzb = new Handler(Looper.getMainLooper());
  
  zzd(zzi paramzzi) {
    this.zza = paramzzi;
  }
  
  @NonNull
  public final Task<Void> launchReviewFlow(@NonNull Activity paramActivity, @NonNull ReviewInfo paramReviewInfo) {
    if (paramReviewInfo.zzb())
      return Tasks.forResult(null); 
    Intent intent = new Intent((Context)paramActivity, PlayCoreDialogWrapperActivity.class);
    intent.putExtra("confirmation_intent", (Parcelable)paramReviewInfo.zza());
    intent.putExtra("window_flags", paramActivity.getWindow().getDecorView().getWindowSystemUiVisibility());
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    intent.putExtra("result_receiver", (Parcelable)new zzc(this, this.zzb, taskCompletionSource));
    paramActivity.startActivity(intent);
    return taskCompletionSource.getTask();
  }
  
  @NonNull
  public final Task<ReviewInfo> requestReviewFlow() {
    return this.zza.zza();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */