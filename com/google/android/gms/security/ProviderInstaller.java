package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
  @NonNull
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  
  private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
  
  private static final Object zzb = new Object();
  
  @GuardedBy("ProviderInstaller.lock")
  private static Method zzc = null;
  
  @GuardedBy("ProviderInstaller.lock")
  private static Method zzd = null;
  
  public static void installIfNeeded(@NonNull Context paramContext) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zza.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    synchronized (zzb) {
      GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException;
      Context context;
      long l = SystemClock.elapsedRealtime();
      try {
        context = DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
      } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
        Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(loadingException.getMessage())));
        loadingException = null;
      } 
      if (loadingException == null) {
        long l1 = SystemClock.elapsedRealtime();
        context = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
        if (context != null)
          try {
            if (zzd == null)
              zzd = zzb(context, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[] { Context.class, long.class, long.class }); 
            zzd.invoke(null, new Object[] { paramContext, Long.valueOf(l), Long.valueOf(l1) });
          } catch (Exception exception) {
            Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(exception.getMessage())));
          }  
        if (context != null) {
          zzc(context, paramContext, "com.google.android.gms.common.security.ProviderInstallerImpl");
          return;
        } 
        Log.e("ProviderInstaller", "Failed to get remote context");
        googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException();
        this(8);
        throw googlePlayServicesNotAvailableException;
      } 
      zzc(context, (Context)googlePlayServicesNotAvailableException, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
      return;
    } 
  }
  
  public static void installIfNeededAsync(@NonNull Context paramContext, @NonNull ProviderInstallListener paramProviderInstallListener) {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    (new zza(paramContext, paramProviderInstallListener)).execute((Object[])new Void[0]);
  }
  
  private static Method zzb(Context paramContext, String paramString1, String paramString2, Class[] paramArrayOfClass) throws ClassNotFoundException, NoSuchMethodException {
    return paramContext.getClassLoader().loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
  }
  
  @GuardedBy("ProviderInstaller.lock")
  private static void zzc(Context paramContext1, Context paramContext2, String paramString) throws GooglePlayServicesNotAvailableException {
    try {
      if (zzc == null)
        zzc = zzb(paramContext1, paramString, "insertProvider", new Class[] { Context.class }); 
      zzc.invoke(null, new Object[] { paramContext1 });
      return;
    } catch (Exception exception) {
      Throwable throwable = exception.getCause();
      if (Log.isLoggable("ProviderInstaller", 6)) {
        String str;
        if (throwable == null) {
          str = exception.getMessage();
        } else {
          str = str.getMessage();
        } 
        Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(str)));
      } 
      throw new GooglePlayServicesNotAvailableException(8);
    } 
  }
  
  public static interface ProviderInstallListener {
    void onProviderInstallFailed(int param1Int, @Nullable Intent param1Intent);
    
    void onProviderInstalled();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */