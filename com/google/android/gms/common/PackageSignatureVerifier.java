package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class PackageSignatureVerifier {
  @Nullable
  private static zzad zza;
  
  private volatile zzac zzb;
  
  private static zzad zza() {
    // Byte code:
    //   0: ldc com/google/android/gms/common/zzad
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/PackageSignatureVerifier.zza : Lcom/google/android/gms/common/zzad;
    //   6: ifnonnull -> 21
    //   9: new com/google/android/gms/common/zzad
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/google/android/gms/common/PackageSignatureVerifier.zza : Lcom/google/android/gms/common/zzad;
    //   21: getstatic com/google/android/gms/common/PackageSignatureVerifier.zza : Lcom/google/android/gms/common/zzad;
    //   24: astore_0
    //   25: ldc com/google/android/gms/common/zzad
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/google/android/gms/common/zzad
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	28	30	finally
    //   31	34	30	finally
  }
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context paramContext, @NonNull String paramString) {
    boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(paramContext);
    zza();
    if (zzn.zzf()) {
      String str1;
      PackageVerificationResult packageVerificationResult;
      if (true != bool) {
        str1 = "-0";
      } else {
        str1 = "-1";
      } 
      String str2 = String.valueOf(paramString).concat(str1);
      if (this.zzb != null && zzac.zzb(this.zzb).equals(str2)) {
        packageVerificationResult = zzac.zza(this.zzb);
      } else {
        zza();
        zzx zzx = zzn.zzc(paramString, bool, false, false);
        if (zzx.zza) {
          this.zzb = new zzac(str2, PackageVerificationResult.zzd(paramString, zzx.zzd));
          packageVerificationResult = zzac.zza(this.zzb);
        } else {
          Preconditions.checkNotNull(((zzx)packageVerificationResult).zzb);
          packageVerificationResult = PackageVerificationResult.zza(paramString, ((zzx)packageVerificationResult).zzb, ((zzx)packageVerificationResult).zzc);
        } 
      } 
      return packageVerificationResult;
    } 
    throw new zzae();
  }
  
  @NonNull
  @KeepForSdk
  @ShowFirstParty
  public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context paramContext, @NonNull String paramString) {
    PackageVerificationResult packageVerificationResult;
    try {
      PackageVerificationResult packageVerificationResult1 = queryPackageSignatureVerified(paramContext, paramString);
      packageVerificationResult1.zzb();
      packageVerificationResult = packageVerificationResult1;
    } catch (SecurityException securityException) {
      PackageVerificationResult packageVerificationResult1 = queryPackageSignatureVerified((Context)packageVerificationResult, paramString);
      packageVerificationResult = packageVerificationResult1;
      if (packageVerificationResult1.zzc()) {
        Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", securityException);
        return packageVerificationResult1;
      } 
    } 
    return packageVerificationResult;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\PackageSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */