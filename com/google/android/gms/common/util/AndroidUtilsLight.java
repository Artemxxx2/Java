package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
@ShowFirstParty
public class AndroidUtilsLight {
  private static volatile int zza = -1;
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public static byte[] getPackageCertificateHashBytes(@NonNull Context paramContext, @NonNull String paramString) throws PackageManager.NameNotFoundException {
    PackageInfo packageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
      MessageDigest messageDigest = zza("SHA1");
      if (messageDigest != null)
        return messageDigest.digest(packageInfo.signatures[0].toByteArray()); 
    } 
    return null;
  }
  
  @Nullable
  public static MessageDigest zza(@NonNull String paramString) {
    byte b = 0;
    while (true) {
      if (b < 2) {
        try {
          MessageDigest messageDigest = MessageDigest.getInstance(paramString);
          if (messageDigest != null)
            return messageDigest; 
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        b++;
        continue;
      } 
      return null;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\AndroidUtilsLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */