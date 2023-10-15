package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public abstract class GservicesValue<T> {
  private static final Object zzc = new Object();
  
  @NonNull
  protected final String zza;
  
  @NonNull
  protected final Object zzb;
  
  @Nullable
  private Object zzd = null;
  
  protected GservicesValue(@NonNull String paramString, @NonNull Object paramObject) {
    this.zza = paramString;
    this.zzb = paramObject;
  }
  
  @KeepForSdk
  public static boolean isInitialized() {
    synchronized (zzc) {
      return false;
    } 
  }
  
  @NonNull
  @KeepForSdk
  public static GservicesValue<Float> value(@NonNull String paramString, @NonNull Float paramFloat) {
    return new zzd(paramString, paramFloat);
  }
  
  @NonNull
  @KeepForSdk
  public static GservicesValue<Integer> value(@NonNull String paramString, @NonNull Integer paramInteger) {
    return new zzc(paramString, paramInteger);
  }
  
  @NonNull
  @KeepForSdk
  public static GservicesValue<Long> value(@NonNull String paramString, @NonNull Long paramLong) {
    return new zzb(paramString, paramLong);
  }
  
  @NonNull
  @KeepForSdk
  public static GservicesValue<String> value(@NonNull String paramString1, @NonNull String paramString2) {
    return new zze(paramString1, paramString2);
  }
  
  @NonNull
  @KeepForSdk
  public static GservicesValue<Boolean> value(@NonNull String paramString, boolean paramBoolean) {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }
  
  @NonNull
  @KeepForSdk
  public final T get() {
    null = this.zzd;
    if (null != null)
      return (T)null; 
    null = StrictMode.allowThreadDiskReads();
    synchronized (zzc) {
      synchronized (zzc) {
        try {
          null = zza(this.zza);
          StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)null);
          return (T)null;
        } catch (SecurityException null) {
          long l = Binder.clearCallingIdentity();
          try {
            Object object = zza(this.zza);
            Binder.restoreCallingIdentity(l);
            return (T)object;
          } finally {
            Binder.restoreCallingIdentity(l);
          } 
        } finally {}
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)null);
        throw null;
      } 
    } 
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public final T getBinderSafe() {
    return get();
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void override(@NonNull T paramT) {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzd = paramT;
    synchronized (zzc) {
      synchronized (zzc) {
        return;
      } 
    } 
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void resetOverride() {
    this.zzd = null;
  }
  
  @NonNull
  protected abstract Object zza(@NonNull String paramString);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\config\GservicesValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */