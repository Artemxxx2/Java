package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface ConnectionProgressReportCallbacks {
  @KeepForSdk
  void onReportServiceBinding(@NonNull ConnectionResult paramConnectionResult);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\BaseGmsClient$ConnectionProgressReportCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */