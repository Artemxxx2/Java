package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class PackageManagerWrapper {
  @NonNull
  protected final Context zza;
  
  public PackageManagerWrapper(@NonNull Context paramContext) {
    this.zza = paramContext;
  }
  
  @KeepForSdk
  public int checkCallingOrSelfPermission(@NonNull String paramString) {
    return this.zza.checkCallingOrSelfPermission(paramString);
  }
  
  @KeepForSdk
  public int checkPermission(@NonNull String paramString1, @NonNull String paramString2) {
    return this.zza.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  @NonNull
  @KeepForSdk
  public ApplicationInfo getApplicationInfo(@NonNull String paramString, int paramInt) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  @NonNull
  @KeepForSdk
  public CharSequence getApplicationLabel(@NonNull String paramString) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  @NonNull
  @KeepForSdk
  public Pair<CharSequence, Drawable> getApplicationLabelAndIcon(@NonNull String paramString) throws PackageManager.NameNotFoundException {
    ApplicationInfo applicationInfo = this.zza.getPackageManager().getApplicationInfo(paramString, 0);
    return Pair.create(this.zza.getPackageManager().getApplicationLabel(applicationInfo), this.zza.getPackageManager().getApplicationIcon(applicationInfo));
  }
  
  @NonNull
  @KeepForSdk
  public PackageInfo getPackageInfo(@NonNull String paramString, int paramInt) throws PackageManager.NameNotFoundException {
    return this.zza.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  @KeepForSdk
  public boolean isCallerInstantApp() {
    if (Binder.getCallingUid() == Process.myUid())
      return InstantApps.isInstantApp(this.zza); 
    if (PlatformVersion.isAtLeastO()) {
      String str = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null)
        return this.zza.getPackageManager().isInstantApp(str); 
    } 
    return false;
  }
  
  @TargetApi(19)
  public final boolean zza(int paramInt, @NonNull String paramString) {
    if (PlatformVersion.isAtLeastKitKat())
      try {
        AppOpsManager appOpsManager = (AppOpsManager)this.zza.getSystemService("appops");
        if (appOpsManager != null) {
          appOpsManager.checkPackage(paramInt, paramString);
          return true;
        } 
        NullPointerException nullPointerException = new NullPointerException();
        this("context.getSystemService(Context.APP_OPS_SERVICE) is null");
        throw nullPointerException;
      } catch (SecurityException securityException) {
        return false;
      }  
    String[] arrayOfString = this.zza.getPackageManager().getPackagesForUid(paramInt);
    if (securityException != null && arrayOfString != null)
      for (paramInt = 0; paramInt < arrayOfString.length; paramInt++) {
        if (securityException.equals(arrayOfString[paramInt]))
          return true; 
      }  
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\wrappers\PackageManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */