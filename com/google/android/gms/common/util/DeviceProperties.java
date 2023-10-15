package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
  @Nullable
  private static Boolean zza;
  
  @Nullable
  private static Boolean zzb;
  
  @Nullable
  private static Boolean zzc;
  
  @Nullable
  private static Boolean zzd;
  
  @Nullable
  private static Boolean zze;
  
  @Nullable
  private static Boolean zzf;
  
  @Nullable
  private static Boolean zzg;
  
  @Nullable
  private static Boolean zzh;
  
  @Nullable
  private static Boolean zzi;
  
  @Nullable
  private static Boolean zzj;
  
  @Nullable
  private static Boolean zzk;
  
  @Nullable
  private static Boolean zzl;
  
  @KeepForSdk
  public static boolean isAuto(@NonNull Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (zzi == null) {
      boolean bool = PlatformVersion.isAtLeastO();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (packageManager.hasSystemFeature("android.hardware.type.automotive"))
          bool2 = true; 
      } 
      zzi = Boolean.valueOf(bool2);
    } 
    return zzi.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isBstar(@NonNull Context paramContext) {
    if (zzl == null) {
      boolean bool = PlatformVersion.isAtLeastR();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (paramContext.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE"))
          bool2 = true; 
      } 
      zzl = Boolean.valueOf(bool2);
    } 
    return zzl.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isLatchsky(@NonNull Context paramContext) {
    if (zzf == null) {
      PackageManager packageManager = paramContext.getPackageManager();
      boolean bool = packageManager.hasSystemFeature("com.google.android.feature.services_updater");
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (packageManager.hasSystemFeature("cn.google.services"))
          bool2 = true; 
      } 
      zzf = Boolean.valueOf(bool2);
    } 
    return zzf.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isPhone(@NonNull Context paramContext) {
    if (zza == null) {
      boolean bool = isTablet(paramContext);
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (!bool) {
        bool2 = bool1;
        if (!isWearable(paramContext)) {
          bool2 = bool1;
          if (!zzb(paramContext)) {
            if (zzh == null)
              zzh = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("org.chromium.arc")); 
            bool2 = bool1;
            if (!zzh.booleanValue()) {
              bool2 = bool1;
              if (!isAuto(paramContext)) {
                bool2 = bool1;
                if (!isTv(paramContext)) {
                  if (zzk == null)
                    zzk = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")); 
                  bool2 = bool1;
                  if (!zzk.booleanValue()) {
                    bool2 = bool1;
                    if (!isBstar(paramContext))
                      bool2 = true; 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
      zza = Boolean.valueOf(bool2);
    } 
    return zza.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isSevenInchTablet(@NonNull Context paramContext) {
    return zzc(paramContext.getResources());
  }
  
  @TargetApi(21)
  @KeepForSdk
  public static boolean isSidewinder(@NonNull Context paramContext) {
    return zza(paramContext);
  }
  
  @KeepForSdk
  public static boolean isTablet(@NonNull Context paramContext) {
    return isTablet(paramContext.getResources());
  }
  
  @KeepForSdk
  public static boolean isTablet(@NonNull Resources paramResources) {
    if (paramResources == null)
      return false; 
    if (zzb == null) {
      int i = (paramResources.getConfiguration()).screenLayout;
      boolean bool = true;
      if ((i & 0xF) <= 3 && !zzc(paramResources))
        bool = false; 
      zzb = Boolean.valueOf(bool);
    } 
    return zzb.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isTv(@NonNull Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (zzj == null) {
      boolean bool = packageManager.hasSystemFeature("com.google.android.tv");
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (!bool) {
        bool2 = bool1;
        if (!packageManager.hasSystemFeature("android.hardware.type.television"))
          if (packageManager.hasSystemFeature("android.software.leanback")) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }  
      } 
      zzj = Boolean.valueOf(bool2);
    } 
    return zzj.booleanValue();
  }
  
  @KeepForSdk
  public static boolean isUserBuild() {
    int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    return "user".equals(Build.TYPE);
  }
  
  @TargetApi(20)
  @KeepForSdk
  public static boolean isWearable(@NonNull Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (zzd == null) {
      boolean bool = PlatformVersion.isAtLeastKitKatWatch();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (packageManager.hasSystemFeature("android.hardware.type.watch"))
          bool2 = true; 
      } 
      zzd = Boolean.valueOf(bool2);
    } 
    return zzd.booleanValue();
  }
  
  @TargetApi(26)
  @KeepForSdk
  public static boolean isWearableWithoutPlayStore(@NonNull Context paramContext) {
    return ((isWearable(paramContext) && !PlatformVersion.isAtLeastN()) || (zza(paramContext) && (!PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR())));
  }
  
  @TargetApi(21)
  public static boolean zza(@NonNull Context paramContext) {
    if (zze == null) {
      boolean bool = PlatformVersion.isAtLeastLollipop();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (bool) {
        bool2 = bool1;
        if (paramContext.getPackageManager().hasSystemFeature("cn.google"))
          bool2 = true; 
      } 
      zze = Boolean.valueOf(bool2);
    } 
    return zze.booleanValue();
  }
  
  public static boolean zzb(@NonNull Context paramContext) {
    if (zzg == null) {
      boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot");
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (!bool)
        if (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }  
      zzg = Boolean.valueOf(bool2);
    } 
    return zzg.booleanValue();
  }
  
  public static boolean zzc(@NonNull Resources paramResources) {
    boolean bool = false;
    if (paramResources == null)
      return false; 
    if (zzc == null) {
      Configuration configuration = paramResources.getConfiguration();
      boolean bool1 = bool;
      if ((configuration.screenLayout & 0xF) <= 3) {
        bool1 = bool;
        if (configuration.smallestScreenWidthDp >= 600)
          bool1 = true; 
      } 
      zzc = Boolean.valueOf(bool1);
    } 
    return zzc.booleanValue();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\DeviceProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */