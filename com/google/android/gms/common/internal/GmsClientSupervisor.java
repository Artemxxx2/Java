package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClientSupervisor {
  @Nullable
  @VisibleForTesting
  static HandlerThread zza;
  
  private static int zzb = 4225;
  
  private static final Object zzc = new Object();
  
  @Nullable
  private static zzr zzd;
  
  private static boolean zze = false;
  
  @KeepForSdk
  public static int getDefaultBindFlags() {
    return zzb;
  }
  
  @NonNull
  @KeepForSdk
  public static GmsClientSupervisor getInstance(@NonNull Context paramContext) {
    synchronized (zzc) {
      if (zzd == null) {
        Looper looper;
        zzr zzr1 = new zzr();
        Context context = paramContext.getApplicationContext();
        if (zze) {
          looper = getOrStartHandlerThread().getLooper();
        } else {
          looper = looper.getMainLooper();
        } 
        this(context, looper);
        zzd = zzr1;
      } 
      return zzd;
    } 
  }
  
  @NonNull
  @KeepForSdk
  public static HandlerThread getOrStartHandlerThread() {
    synchronized (zzc) {
      HandlerThread handlerThread = zza;
      if (handlerThread != null)
        return handlerThread; 
      handlerThread = new HandlerThread();
      this("GoogleApiHandler", 9);
      zza = handlerThread;
      zza.start();
      handlerThread = zza;
      return handlerThread;
    } 
  }
  
  @KeepForSdk
  public static void setUseHandlerThreadForCallbacks() {
    synchronized (zzc) {
      zzr zzr1 = zzd;
      if (zzr1 != null && !zze)
        zzr1.zzi(getOrStartHandlerThread().getLooper()); 
      zze = true;
      return;
    } 
  }
  
  @KeepForSdk
  public boolean bindService(@NonNull ComponentName paramComponentName, @NonNull ServiceConnection paramServiceConnection, @NonNull String paramString) {
    return zzc(new zzn(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString, null);
  }
  
  @KeepForSdk
  public boolean bindService(@NonNull String paramString1, @NonNull ServiceConnection paramServiceConnection, @NonNull String paramString2) {
    return zzc(new zzn(paramString1, getDefaultBindFlags(), false), paramServiceConnection, paramString2, null);
  }
  
  @KeepForSdk
  public void unbindService(@NonNull ComponentName paramComponentName, @NonNull ServiceConnection paramServiceConnection, @NonNull String paramString) {
    zza(new zzn(paramComponentName, getDefaultBindFlags()), paramServiceConnection, paramString);
  }
  
  @KeepForSdk
  public void unbindService(@NonNull String paramString1, @NonNull ServiceConnection paramServiceConnection, @NonNull String paramString2) {
    zza(new zzn(paramString1, getDefaultBindFlags(), false), paramServiceConnection, paramString2);
  }
  
  protected abstract void zza(zzn paramzzn, ServiceConnection paramServiceConnection, String paramString);
  
  public final void zzb(@NonNull String paramString1, @NonNull String paramString2, int paramInt, @NonNull ServiceConnection paramServiceConnection, @NonNull String paramString3, boolean paramBoolean) {
    zza(new zzn(paramString1, paramString2, paramInt, paramBoolean), paramServiceConnection, paramString3);
  }
  
  protected abstract boolean zzc(zzn paramzzn, ServiceConnection paramServiceConnection, String paramString, @Nullable Executor paramExecutor);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\GmsClientSupervisor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */