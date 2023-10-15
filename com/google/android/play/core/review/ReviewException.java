package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.review.model.zza;
import java.util.Locale;

public class ReviewException extends ApiException {
  public ReviewException(int paramInt) {
    super(new Status(paramInt, String.format(Locale.getDefault(), "Review Error(%d): %s", new Object[] { Integer.valueOf(paramInt), zza.zza(paramInt) })));
  }
  
  public int getErrorCode() {
    return getStatusCode();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\ReviewException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */