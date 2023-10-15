package com.google.android.play.core.review;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.internal.zzi;
import com.google.android.play.core.review.internal.zzt;
import com.google.android.play.core.review.internal.zzw;

@SuppressLint({"RestrictedApi"})
public final class zzi {
  private static final zzi zzb = new zzi("ReviewService");
  
  @Nullable
  @VisibleForTesting
  zzt zza;
  
  private final String zzc;
  
  public zzi(Context paramContext) {
    this.zzc = paramContext.getPackageName();
    if (zzw.zza(paramContext)) {
      Intent intent = (new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE")).setPackage("com.android.vending");
      this.zza = new zzt(paramContext, zzb, "com.google.android.finsky.inappreviewservice.InAppReviewService", intent, zze.zza, null, null);
    } 
  }
  
  public final Task zza() {
    zzb.zzd("requestInAppReview (%s)", new Object[] { this.zzc });
    if (this.zza == null) {
      zzb.zzb("Play Store app is either not installed or not the official version", new Object[0]);
      return Tasks.forException((Exception)new ReviewException(-1));
    } 
    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
    this.zza.zzp(new zzf(this, taskCompletionSource, taskCompletionSource), taskCompletionSource);
    return taskCompletionSource.getTask();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */