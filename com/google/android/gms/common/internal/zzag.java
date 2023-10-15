package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

public final class zzag {
  private static final Object zza = new Object();
  
  @GuardedBy("sLock")
  private static boolean zzb;
  
  @Nullable
  private static String zzc;
  
  private static int zzd;
  
  public static int zza(Context paramContext) {
    zzc(paramContext);
    return zzd;
  }
  
  @Nullable
  public static String zzb(Context paramContext) {
    zzc(paramContext);
    return zzc;
  }
  
  private static void zzc(Context paramContext) {
    synchronized (zza) {
      if (zzb)
        return; 
      zzb = true;
      String str = paramContext.getPackageName();
      PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(paramContext);
      try {
        Bundle bundle = (packageManagerWrapper.getApplicationInfo(str, 128)).metaData;
        if (bundle == null)
          return; 
        zzc = bundle.getString("com.google.app.id");
        zzd = bundle.getInt("com.google.android.gms.version");
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)nameNotFoundException);
      } 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */