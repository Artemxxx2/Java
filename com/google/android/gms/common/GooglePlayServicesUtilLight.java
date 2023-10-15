package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight {
  @KeepForSdk
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  
  @KeepForSdk
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  
  @NonNull
  @KeepForSdk
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @Deprecated
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  
  @NonNull
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @KeepForSdk
  @VisibleForTesting
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  
  @VisibleForTesting
  static boolean zza = false;
  
  private static boolean zzb = false;
  
  private static final AtomicBoolean zzc = new AtomicBoolean();
  
  @Deprecated
  @KeepForSdk
  public static void cancelAvailabilityErrorNotifications(@NonNull Context paramContext) {
    if (sCanceledAvailabilityNotification.getAndSet(true))
      return; 
    try {
      NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if (notificationManager != null)
        notificationManager.cancel(10436); 
    } catch (SecurityException securityException) {}
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static void enableUsingApkIndependentContext() {
    zzc.set(true);
  }
  
  @Deprecated
  @KeepForSdk
  public static void ensurePlayServicesAvailable(@NonNull Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0) {
      Intent intent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("GooglePlayServices not available due to error ");
      stringBuilder.append(paramInt);
      Log.e("GooglePlayServicesUtil", stringBuilder.toString());
      if (intent == null)
        throw new GooglePlayServicesNotAvailableException(paramInt); 
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", intent);
    } 
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getApkVersion(@NonNull Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return packageInfo.versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 0;
    } 
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getClientVersion(@NonNull Context paramContext) {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public static PendingIntent getErrorPendingIntent(int paramInt1, @NonNull Context paramContext, int paramInt2) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  @VisibleForTesting
  public static String getErrorString(int paramInt) {
    return ConnectionResult.zza(paramInt);
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt) {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  @Nullable
  @KeepForSdk
  public static Context getRemoteContext(@NonNull Context paramContext) {
    try {
      return paramContext.createPackageContext("com.google.android.gms", 3);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @Nullable
  @KeepForSdk
  public static Resources getRemoteResource(@NonNull Context paramContext) {
    try {
      return paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static boolean honorsDebugCertificates(@NonNull Context paramContext) {
    if (!zza)
      try {
        PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
        GoogleSignatureVerifier.getInstance(paramContext);
        if (packageInfo != null && !GoogleSignatureVerifier.zzb(packageInfo, false) && GoogleSignatureVerifier.zzb(packageInfo, true)) {
          zzb = true;
        } else {
          zzb = false;
        } 
        zza = true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)nameNotFoundException);
        zza = true;
      } finally {} 
    return (zzb || !DeviceProperties.isUserBuild());
  }
  
  @Deprecated
  @KeepForSdk
  @HideFirstParty
  public static int isGooglePlayServicesAvailable(@NonNull Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @Deprecated
  @KeepForSdk
  public static int isGooglePlayServicesAvailable(@NonNull Context paramContext, int paramInt) {
    PackageInfo packageInfo;
    int i;
    try {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
    } finally {
      packageInfo = null;
    } 
    boolean bool = DeviceProperties.isWearableWithoutPlayStore(paramContext);
    boolean bool1 = true;
    if (!bool && !DeviceProperties.zzb(paramContext)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    String str = paramContext.getPackageName();
    PackageManager packageManager = paramContext.getPackageManager();
    if (i) {
      try {
        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires the Google Play Store, but it is missing."));
        paramInt = 9;
      } 
    } else {
      packageInfo = null;
    } 
    try {
      PackageInfo packageInfo1 = packageManager.getPackageInfo("com.google.android.gms", 64);
      GoogleSignatureVerifier.getInstance((Context)nameNotFoundException);
      if (!GoogleSignatureVerifier.zzb(packageInfo1, true)) {
        Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but their signature is invalid."));
        paramInt = 9;
      } else {
        if (i) {
          Preconditions.checkNotNull(packageInfo);
          if (!GoogleSignatureVerifier.zzb(packageInfo, true)) {
            Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play Store, but its signature is invalid."));
            return 9;
          } 
        } 
        if (i && packageInfo != null && !packageInfo.signatures[0].equals(packageInfo1.signatures[0])) {
          Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
          paramInt = 9;
        } else if (zza.zza(packageInfo1.versionCode) < zza.zza(paramInt)) {
          i = packageInfo1.versionCode;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Google Play services out of date for ");
          stringBuilder.append(str);
          stringBuilder.append(".  Requires ");
          stringBuilder.append(paramInt);
          stringBuilder.append(" but found ");
          stringBuilder.append(i);
          Log.w("GooglePlayServicesUtil", stringBuilder.toString());
          paramInt = 2;
        } else {
          ApplicationInfo applicationInfo2 = packageInfo1.applicationInfo;
          ApplicationInfo applicationInfo1 = applicationInfo2;
          if (applicationInfo2 == null)
            try {
              applicationInfo1 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
              Log.wtf("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but they're missing when getting application info."), (Throwable)nameNotFoundException1);
              paramInt = bool1;
            }  
          if (!((ApplicationInfo)nameNotFoundException1).enabled) {
            paramInt = 3;
          } else {
            return 0;
          } 
        } 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException1) {
      Log.w("GooglePlayServicesUtil", String.valueOf(str).concat(" requires Google Play services, but they are missing."));
      paramInt = bool1;
    } 
    return paramInt;
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isGooglePlayServicesUid(@NonNull Context paramContext, int paramInt) {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayServicesPossiblyUpdating(@NonNull Context paramContext, int paramInt) {
    return (paramInt == 18) ? true : ((paramInt == 1) ? zza(paramContext, "com.google.android.gms") : false);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayStorePossiblyUpdating(@NonNull Context paramContext, int paramInt) {
    return (paramInt == 9) ? zza(paramContext, "com.android.vending") : false;
  }
  
  @TargetApi(18)
  @KeepForSdk
  public static boolean isRestrictedUserProfile(@NonNull Context paramContext) {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {
      Object object = paramContext.getSystemService("user");
      Preconditions.checkNotNull(object);
      Bundle bundle = ((UserManager)object).getApplicationRestrictions(paramContext.getPackageName());
      if (bundle != null && "true".equals(bundle.getString("restricted_profile")))
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static boolean isSidewinderDevice(@NonNull Context paramContext) {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isUserRecoverableError(int paramInt) {
    if (paramInt != 9)
      switch (paramInt) {
        default:
          return false;
        case 1:
        case 2:
        case 3:
          break;
      }  
    return true;
  }
  
  @Deprecated
  @TargetApi(19)
  @KeepForSdk
  public static boolean uidHasPackageName(@NonNull Context paramContext, int paramInt, @NonNull String paramString) {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
  
  @TargetApi(21)
  static boolean zza(Context paramContext, String paramString) {
    boolean bool = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop())
      try {
        List list = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        Iterator<PackageInstaller.SessionInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
          if (paramString.equals(((PackageInstaller.SessionInfo)iterator.next()).getAppPackageName()))
            return true; 
        } 
      } catch (Exception exception) {
        return false;
      }  
    PackageManager packageManager = exception.getPackageManager();
    try {
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramString, 8192);
      if (bool)
        return applicationInfo.enabled; 
      if (applicationInfo.enabled) {
        bool = isRestrictedUserProfile((Context)exception);
        if (!bool)
          return true; 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */