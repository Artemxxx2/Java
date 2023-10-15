package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.NonNull;

public class ResolvableApiException extends ApiException {
  public ResolvableApiException(@NonNull Status paramStatus) {
    super(paramStatus);
  }
  
  @NonNull
  public PendingIntent getResolution() {
    return getStatus().getResolution();
  }
  
  public void startResolutionForResult(@NonNull Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    getStatus().startResolutionForResult(paramActivity, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\ResolvableApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */