package com.google.android.play.core.review;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

public interface ReviewManager {
  @NonNull
  Task<Void> launchReviewFlow(@NonNull Activity paramActivity, @NonNull ReviewInfo paramReviewInfo);
  
  @NonNull
  Task<ReviewInfo> requestReviewFlow();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\ReviewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */