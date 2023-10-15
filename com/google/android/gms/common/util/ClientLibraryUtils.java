package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils {
  @KeepForSdk
  public static int getClientVersion(@NonNull Context paramContext, @NonNull String paramString) {
    PackageInfo packageInfo = getPackageInfo(paramContext, paramString);
    if (packageInfo != null && packageInfo.applicationInfo != null) {
      Bundle bundle = packageInfo.applicationInfo.metaData;
      if (bundle != null)
        return bundle.getInt("com.google.android.gms.version", -1); 
    } 
    return -1;
  }
  
  @Nullable
  @KeepForSdk
  public static PackageInfo getPackageInfo(@NonNull Context paramContext, @NonNull String paramString) {
    try {
      return Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  @KeepForSdk
  public static boolean isPackageSide() {
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\ClientLibraryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */