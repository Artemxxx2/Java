package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzd;

@KeepForSdk
@ShowFirstParty
public class GoogleApiAvailabilityLight {
  @NonNull
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  @NonNull
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @KeepForSdk
  static final String TRACKING_SOURCE_DIALOG = "d";
  
  @KeepForSdk
  static final String TRACKING_SOURCE_NOTIFICATION = "n";
  
  private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();
  
  @NonNull
  @KeepForSdk
  public static GoogleApiAvailabilityLight getInstance() {
    return zza;
  }
  
  @KeepForSdk
  public void cancelAvailabilityErrorNotifications(@NonNull Context paramContext) {
    GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(paramContext);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int getApkVersion(@NonNull Context paramContext) {
    return GooglePlayServicesUtilLight.getApkVersion(paramContext);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public int getClientVersion(@NonNull Context paramContext) {
    return GooglePlayServicesUtilLight.getClientVersion(paramContext);
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(int paramInt) {
    return getErrorResolutionIntent(null, paramInt, null);
  }
  
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public Intent getErrorResolutionIntent(@Nullable Context paramContext, int paramInt, @Nullable String paramString) {
    switch (paramInt) {
      default:
        return null;
      case 3:
        return zzt.zzc("com.google.android.gms");
      case 1:
      case 2:
        break;
    } 
    if (paramContext == null || !DeviceProperties.isWearableWithoutPlayStore(paramContext)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("gcore_");
      stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
      stringBuilder.append("-");
      if (!TextUtils.isEmpty(paramString))
        stringBuilder.append(paramString); 
      stringBuilder.append("-");
      if (paramContext != null)
        stringBuilder.append(paramContext.getPackageName()); 
      stringBuilder.append("-");
      if (paramContext != null)
        try {
          stringBuilder.append((Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getPackageName(), 0)).versionCode);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {} 
      return zzt.zzb("com.google.android.gms", stringBuilder.toString());
    } 
    return zzt.zza();
  }
  
  @Nullable
  @KeepForSdk
  public PendingIntent getErrorResolutionPendingIntent(@NonNull Context paramContext, int paramInt1, int paramInt2) {
    return getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2, null);
  }
  
  @Nullable
  @KeepForSdk
  @ShowFirstParty
  public PendingIntent getErrorResolutionPendingIntent(@NonNull Context paramContext, int paramInt1, int paramInt2, @Nullable String paramString) {
    Intent intent = getErrorResolutionIntent(paramContext, paramInt1, paramString);
    return (intent == null) ? null : PendingIntent.getActivity(paramContext, paramInt2, intent, zzd.zza | 0x8000000);
  }
  
  @NonNull
  @KeepForSdk
  public String getErrorString(int paramInt) {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }
  
  @KeepForSdk
  @HideFirstParty
  public int isGooglePlayServicesAvailable(@NonNull Context paramContext) {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  @KeepForSdk
  public int isGooglePlayServicesAvailable(@NonNull Context paramContext, int paramInt) {
    paramInt = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
    return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt) ? 18 : paramInt;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayServicesPossiblyUpdating(@NonNull Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt);
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPlayStorePossiblyUpdating(@NonNull Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt);
  }
  
  @KeepForSdk
  public boolean isUninstalledAppPossiblyUpdating(@NonNull Context paramContext, @NonNull String paramString) {
    return GooglePlayServicesUtilLight.zza(paramContext, paramString);
  }
  
  @KeepForSdk
  public boolean isUserResolvableError(int paramInt) {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }
  
  @KeepForSdk
  public void verifyGooglePlayServicesIsAvailable(@NonNull Context paramContext, int paramInt) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GoogleApiAvailabilityLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */