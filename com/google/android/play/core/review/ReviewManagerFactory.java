package com.google.android.play.core.review;

import android.content.Context;
import androidx.annotation.NonNull;

public class ReviewManagerFactory {
  @NonNull
  public static ReviewManager create(@NonNull Context paramContext) {
    Context context = paramContext.getApplicationContext();
    if (context != null)
      paramContext = context; 
    return new zzd(new zzi(paramContext));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\ReviewManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */