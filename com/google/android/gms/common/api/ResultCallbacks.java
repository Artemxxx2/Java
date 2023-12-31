package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
  public abstract void onFailure(@NonNull Status paramStatus);
  
  @KeepForSdk
  public final void onResult(@NonNull R paramR) {
    Status status = paramR.getStatus();
    if (status.isSuccess()) {
      onSuccess(paramR);
      return;
    } 
    onFailure(status);
    if (paramR instanceof Releasable)
      try {
        ((Releasable)paramR).release();
        return;
      } catch (RuntimeException runtimeException) {
        Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(String.valueOf(paramR))), runtimeException);
        return;
      }  
  }
  
  public abstract void onSuccess(@NonNull R paramR);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */