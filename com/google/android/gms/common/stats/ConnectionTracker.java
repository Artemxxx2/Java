package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@KeepForSdk
public class ConnectionTracker {
  private static final Object zzb = new Object();
  
  @Nullable
  private static volatile ConnectionTracker zzc;
  
  @NonNull
  @VisibleForTesting
  public ConcurrentHashMap zza = new ConcurrentHashMap<Object, Object>();
  
  @NonNull
  @KeepForSdk
  public static ConnectionTracker getInstance() {
    if (zzc == null)
      synchronized (zzb) {
        if (zzc == null) {
          ConnectionTracker connectionTracker1 = new ConnectionTracker();
          this();
          zzc = connectionTracker1;
        } 
      }  
    ConnectionTracker connectionTracker = zzc;
    Preconditions.checkNotNull(connectionTracker);
    return connectionTracker;
  }
  
  private static void zzb(Context paramContext, ServiceConnection paramServiceConnection) {
    try {
      paramContext.unbindService(paramServiceConnection);
    } catch (IllegalArgumentException|IllegalStateException|java.util.NoSuchElementException illegalArgumentException) {}
  }
  
  private final boolean zzc(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt, boolean paramBoolean, @Nullable Executor paramExecutor) {
    ComponentName componentName = paramIntent.getComponent();
    if (componentName != null) {
      String str = componentName.getPackageName();
      "com.google.android.gms".equals(str);
      try {
        int i = (Wrappers.packageManager(paramContext).getApplicationInfo(str, 0)).flags;
        if ((i & 0x200000) != 0) {
          Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
          return false;
        } 
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    } 
    if (zzd(paramServiceConnection)) {
      ServiceConnection serviceConnection = this.zza.putIfAbsent(paramServiceConnection, paramServiceConnection);
      if (serviceConnection != null && paramServiceConnection != serviceConnection)
        Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[] { paramServiceConnection, paramString, paramIntent.getAction() })); 
      try {
        paramBoolean = zze(paramContext, paramIntent, paramServiceConnection, paramInt, paramExecutor);
      } finally {
        this.zza.remove(paramServiceConnection, paramServiceConnection);
      } 
    } else {
      paramBoolean = zze(paramContext, paramIntent, paramServiceConnection, paramInt, paramExecutor);
    } 
    return paramBoolean;
  }
  
  private static boolean zzd(ServiceConnection paramServiceConnection) {
    return !(paramServiceConnection instanceof com.google.android.gms.common.internal.zzs);
  }
  
  private static final boolean zze(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt, @Nullable Executor paramExecutor) {
    return (PlatformVersion.isAtLeastQ() && paramExecutor != null) ? paramContext.bindService(paramIntent, paramInt, paramExecutor, paramServiceConnection) : paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  @KeepForSdk
  public boolean bindService(@NonNull Context paramContext, @NonNull Intent paramIntent, @NonNull ServiceConnection paramServiceConnection, int paramInt) {
    return zzc(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt, true, null);
  }
  
  @KeepForSdk
  public void unbindService(@NonNull Context paramContext, @NonNull ServiceConnection paramServiceConnection) {
    if (zzd(paramServiceConnection) && this.zza.containsKey(paramServiceConnection))
      try {
        zzb(paramContext, (ServiceConnection)this.zza.get(paramServiceConnection));
        return;
      } finally {
        this.zza.remove(paramServiceConnection);
      }  
    zzb(paramContext, paramServiceConnection);
  }
  
  @KeepForSdk
  public void unbindServiceSafe(@NonNull Context paramContext, @NonNull ServiceConnection paramServiceConnection) {
    try {
      unbindService(paramContext, paramServiceConnection);
    } catch (IllegalArgumentException illegalArgumentException) {}
  }
  
  public final boolean zza(@NonNull Context paramContext, @NonNull String paramString, @NonNull Intent paramIntent, @NonNull ServiceConnection paramServiceConnection, int paramInt, @Nullable Executor paramExecutor) {
    return zzc(paramContext, paramString, paramIntent, paramServiceConnection, paramInt, true, paramExecutor);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\stats\ConnectionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */