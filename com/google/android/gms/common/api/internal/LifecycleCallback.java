package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
  @NonNull
  @KeepForSdk
  protected final LifecycleFragment mLifecycleFragment;
  
  @KeepForSdk
  protected LifecycleCallback(@NonNull LifecycleFragment paramLifecycleFragment) {
    this.mLifecycleFragment = paramLifecycleFragment;
  }
  
  @Keep
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity) {
    throw new IllegalStateException("Method not available in SDK.");
  }
  
  @NonNull
  @KeepForSdk
  public static LifecycleFragment getFragment(@NonNull Activity paramActivity) {
    return getFragment(new LifecycleActivity(paramActivity));
  }
  
  @NonNull
  @KeepForSdk
  public static LifecycleFragment getFragment(@NonNull ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  @KeepForSdk
  protected static LifecycleFragment getFragment(@NonNull LifecycleActivity paramLifecycleActivity) {
    if (paramLifecycleActivity.zzd())
      return zzd.zzc(paramLifecycleActivity.zzb()); 
    if (paramLifecycleActivity.zzc())
      return zzb.zzc(paramLifecycleActivity.zza()); 
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  @MainThread
  @KeepForSdk
  public void dump(@NonNull String paramString, @NonNull FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @NonNull String[] paramArrayOfString) {}
  
  @NonNull
  @KeepForSdk
  public Activity getActivity() {
    Activity activity = this.mLifecycleFragment.getLifecycleActivity();
    Preconditions.checkNotNull(activity);
    return activity;
  }
  
  @MainThread
  @KeepForSdk
  public void onActivityResult(int paramInt1, int paramInt2, @NonNull Intent paramIntent) {}
  
  @MainThread
  @KeepForSdk
  public void onCreate(@Nullable Bundle paramBundle) {}
  
  @MainThread
  @KeepForSdk
  public void onDestroy() {}
  
  @MainThread
  @KeepForSdk
  public void onResume() {}
  
  @MainThread
  @KeepForSdk
  public void onSaveInstanceState(@NonNull Bundle paramBundle) {}
  
  @MainThread
  @KeepForSdk
  public void onStart() {}
  
  @MainThread
  @KeepForSdk
  public void onStop() {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\LifecycleCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */