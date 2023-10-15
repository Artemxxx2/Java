package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;

public final class zzw {
  private static final zzi zza = new zzi("PhoneskyVerificationUtils");
  
  public static boolean zza(Context paramContext) {
    try {
      if ((paramContext.getPackageManager().getApplicationInfo("com.android.vending", 0)).enabled) {
        Signature[] arrayOfSignature = (paramContext.getPackageManager().getPackageInfo("com.android.vending", 64)).signatures;
        if (arrayOfSignature != null) {
          int i = arrayOfSignature.length;
          if (i == 0)
            zza.zze("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]); 
          byte b = 0;
          while (b < i) {
            String str = zzv.zza(arrayOfSignature[b].toByteArray());
            if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(str) && ((!Build.TAGS.contains("dev-keys") && !Build.TAGS.contains("test-keys")) || !"GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(str))) {
              b++;
              continue;
            } 
            return true;
          } 
          return false;
        } 
      } else {
        return false;
      } 
      zza.zze("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */