package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

public class FakeReviewManager implements ReviewManager {
  private final Context zza;
  
  private ReviewInfo zzb;
  
  public FakeReviewManager(Context paramContext) {
    this.zza = paramContext;
  }
  
  @NonNull
  public Task<Void> launchReviewFlow(@NonNull Activity paramActivity, @NonNull ReviewInfo paramReviewInfo) {
    return (paramReviewInfo != this.zzb) ? Tasks.forException((Exception)new ReviewException(-2)) : Tasks.forResult(null);
  }
  
  @NonNull
  public Task<ReviewInfo> requestReviewFlow() {
    boolean bool;
    Context context = this.zza;
    Intent intent = new Intent();
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zzb = ReviewInfo.zzc(PendingIntent.getBroadcast(context, 0, intent, bool), false);
    return Tasks.forResult(this.zzb);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\testing\FakeReviewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */