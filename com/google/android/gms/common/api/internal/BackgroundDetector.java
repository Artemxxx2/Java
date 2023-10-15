package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
  private static final BackgroundDetector zza = new BackgroundDetector();
  
  private final AtomicBoolean zzb = new AtomicBoolean();
  
  private final AtomicBoolean zzc = new AtomicBoolean();
  
  @GuardedBy("sInstance")
  private final ArrayList zzd = new ArrayList();
  
  @GuardedBy("sInstance")
  private boolean zze = false;
  
  @NonNull
  @KeepForSdk
  public static BackgroundDetector getInstance() {
    return zza;
  }
  
  @KeepForSdk
  public static void initialize(@NonNull Application paramApplication) {
    synchronized (zza) {
      BackgroundDetector backgroundDetector = zza;
      if (!backgroundDetector.zze) {
        paramApplication.registerActivityLifecycleCallbacks(backgroundDetector);
        paramApplication.registerComponentCallbacks((ComponentCallbacks)zza);
        zza.zze = true;
      } 
      return;
    } 
  }
  
  private final void zza(boolean paramBoolean) {
    synchronized (zza) {
      Iterator<BackgroundStateChangeListener> iterator = this.zzd.iterator();
      while (iterator.hasNext())
        ((BackgroundStateChangeListener)iterator.next()).onBackgroundStateChanged(paramBoolean); 
      return;
    } 
  }
  
  @KeepForSdk
  public void addListener(@NonNull BackgroundStateChangeListener paramBackgroundStateChangeListener) {
    synchronized (zza) {
      this.zzd.add(paramBackgroundStateChangeListener);
      return;
    } 
  }
  
  @KeepForSdk
  public boolean isInBackground() {
    return this.zzb.get();
  }
  
  public final void onActivityCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle) {
    boolean bool = this.zzb.compareAndSet(true, false);
    this.zzc.set(true);
    if (bool)
      zza(false); 
  }
  
  public final void onActivityDestroyed(@NonNull Activity paramActivity) {}
  
  public final void onActivityPaused(@NonNull Activity paramActivity) {}
  
  public final void onActivityResumed(@NonNull Activity paramActivity) {
    boolean bool = this.zzb.compareAndSet(true, false);
    this.zzc.set(true);
    if (bool)
      zza(false); 
  }
  
  public final void onActivitySaveInstanceState(@NonNull Activity paramActivity, @NonNull Bundle paramBundle) {}
  
  public final void onActivityStarted(@NonNull Activity paramActivity) {}
  
  public final void onActivityStopped(@NonNull Activity paramActivity) {}
  
  public final void onConfigurationChanged(@NonNull Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt) {
    if (paramInt == 20 && this.zzb.compareAndSet(false, true)) {
      this.zzc.set(true);
      zza(true);
    } 
  }
  
  @TargetApi(16)
  @KeepForSdk
  public boolean readCurrentStateIfPossible(boolean paramBoolean) {
    if (!this.zzc.get())
      if (PlatformVersion.isAtLeastJellyBean()) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        if (!this.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100)
          this.zzb.set(true); 
      } else {
        return paramBoolean;
      }  
    return isInBackground();
  }
  
  @KeepForSdk
  public static interface BackgroundStateChangeListener {
    @KeepForSdk
    void onBackgroundStateChanged(boolean param1Boolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\BackgroundDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */