package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface BaseConnectionCallbacks {
  @KeepForSdk
  public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
  
  @KeepForSdk
  public static final int CAUSE_SERVICE_DISCONNECTED = 1;
  
  @KeepForSdk
  void onConnected(@Nullable Bundle paramBundle);
  
  @KeepForSdk
  void onConnectionSuspended(int paramInt);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\BaseGmsClient$BaseConnectionCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */