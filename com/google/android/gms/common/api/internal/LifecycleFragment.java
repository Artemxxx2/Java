package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface LifecycleFragment {
  @KeepForSdk
  void addCallback(@NonNull String paramString, @NonNull LifecycleCallback paramLifecycleCallback);
  
  @Nullable
  @KeepForSdk
  <T extends LifecycleCallback> T getCallbackOrNull(@NonNull String paramString, @NonNull Class<T> paramClass);
  
  @Nullable
  @KeepForSdk
  Activity getLifecycleActivity();
  
  @KeepForSdk
  boolean isCreated();
  
  @KeepForSdk
  boolean isStarted();
  
  @KeepForSdk
  void startActivityForResult(@NonNull Intent paramIntent, int paramInt);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\LifecycleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */