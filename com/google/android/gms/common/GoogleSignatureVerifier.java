package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier {
  @Nullable
  private static GoogleSignatureVerifier zza;
  
  @Nullable
  private static volatile Set zzb;
  
  private final Context zzc;
  
  private volatile String zzd;
  
  public GoogleSignatureVerifier(@NonNull Context paramContext) {
    this.zzc = paramContext.getApplicationContext();
  }
  
  @NonNull
  @KeepForSdk
  public static GoogleSignatureVerifier getInstance(@NonNull Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   7: monitorenter
    //   8: getstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   11: ifnonnull -> 31
    //   14: aload_0
    //   15: invokestatic zze : (Landroid/content/Context;)V
    //   18: new com/google/android/gms/common/GoogleSignatureVerifier
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokespecial <init> : (Landroid/content/Context;)V
    //   27: aload_1
    //   28: putstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   31: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   33: monitorexit
    //   34: getstatic com/google/android/gms/common/GoogleSignatureVerifier.zza : Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   37: areturn
    //   38: astore_0
    //   39: ldc com/google/android/gms/common/GoogleSignatureVerifier
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   8	31	38	finally
    //   31	34	38	finally
    //   39	42	38	finally
  }
  
  @Nullable
  static final zzj zza(PackageInfo paramPackageInfo, zzj... paramVarArgs) {
    if (paramPackageInfo.signatures == null)
      return null; 
    if (paramPackageInfo.signatures.length != 1) {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    } 
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    byte b = 0;
    zzk zzk = new zzk(arrayOfSignature[0].toByteArray());
    while (b < paramVarArgs.length) {
      if (paramVarArgs[b].equals(zzk))
        return paramVarArgs[b]; 
      b++;
    } 
    return null;
  }
  
  public static final boolean zzb(@NonNull PackageInfo paramPackageInfo, boolean paramBoolean) {
    // Byte code:
    //   0: iload_1
    //   1: istore_2
    //   2: iload_1
    //   3: ifeq -> 70
    //   6: iload_1
    //   7: istore_2
    //   8: aload_0
    //   9: ifnull -> 70
    //   12: ldc 'com.android.vending'
    //   14: aload_0
    //   15: getfield packageName : Ljava/lang/String;
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifne -> 38
    //   24: iload_1
    //   25: istore_2
    //   26: ldc 'com.google.android.gms'
    //   28: aload_0
    //   29: getfield packageName : Ljava/lang/String;
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 70
    //   38: aload_0
    //   39: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull -> 52
    //   47: iconst_0
    //   48: istore_2
    //   49: goto -> 70
    //   52: aload_3
    //   53: getfield flags : I
    //   56: sipush #129
    //   59: iand
    //   60: ifeq -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: aload_0
    //   71: ifnull -> 119
    //   74: aload_0
    //   75: getfield signatures : [Landroid/content/pm/Signature;
    //   78: ifnull -> 119
    //   81: iload_2
    //   82: ifeq -> 96
    //   85: aload_0
    //   86: getstatic com/google/android/gms/common/zzm.zza : [Lcom/google/android/gms/common/zzj;
    //   89: invokestatic zza : (Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzj;)Lcom/google/android/gms/common/zzj;
    //   92: astore_0
    //   93: goto -> 113
    //   96: aload_0
    //   97: iconst_1
    //   98: anewarray com/google/android/gms/common/zzj
    //   101: dup
    //   102: iconst_0
    //   103: getstatic com/google/android/gms/common/zzm.zza : [Lcom/google/android/gms/common/zzj;
    //   106: iconst_0
    //   107: aaload
    //   108: aastore
    //   109: invokestatic zza : (Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzj;)Lcom/google/android/gms/common/zzj;
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull -> 119
    //   117: iconst_1
    //   118: ireturn
    //   119: iconst_0
    //   120: ireturn
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  private final zzx zzc(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    Set set = zzb;
    if (paramString == null)
      return zzx.zzc("null pkg"); 
    if (!paramString.equals(this.zzd)) {
      if (zzn.zzg()) {
        zzx zzx = zzn.zzb(paramString, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
      } else {
        try {
          zzx zzx;
          PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(paramString, 64);
          paramBoolean1 = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
          if (packageInfo == null) {
            zzx = zzx.zzc("null pkg");
          } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
            zzx = zzx.zzc("single cert required");
          } else {
            zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
            String str = packageInfo.packageName;
            zzx = zzn.zza(str, zzk, paramBoolean1, false);
            if (zzx.zza && packageInfo.applicationInfo != null && (packageInfo.applicationInfo.flags & 0x2) != 0 && (zzn.zza(str, zzk, false, true)).zza)
              zzx = zzx.zzc("debuggable release cert app rejected"); 
          } 
          if (zzx.zza)
            this.zzd = paramString; 
          return zzx;
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          return zzx.zzd("no pkg ".concat(paramString), (Throwable)nameNotFoundException);
        } 
      } 
    } else {
      return zzx.zzb();
    } 
    if (((zzx)nameNotFoundException).zza)
      this.zzd = paramString; 
    return (zzx)nameNotFoundException;
  }
  
  @KeepForSdk
  public boolean isGooglePublicSignedPackage(@NonNull PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null)
      return false; 
    if (zzb(paramPackageInfo, false))
      return true; 
    if (zzb(paramPackageInfo, true)) {
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc))
        return true; 
      Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    } 
    return false;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPackageGoogleSigned(@NonNull String paramString) {
    zzx zzx = zzc(paramString, false, false);
    zzx.zze();
    return zzx.zza;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isUidGoogleSigned(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzc : Landroid/content/Context;
    //   4: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   7: iload_1
    //   8: invokevirtual getPackagesForUid : (I)[Ljava/lang/String;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull -> 73
    //   16: aload_2
    //   17: arraylength
    //   18: istore_3
    //   19: iload_3
    //   20: ifne -> 26
    //   23: goto -> 73
    //   26: aconst_null
    //   27: astore #4
    //   29: iconst_0
    //   30: istore_1
    //   31: iload_1
    //   32: iload_3
    //   33: if_icmpge -> 64
    //   36: aload_0
    //   37: aload_2
    //   38: iload_1
    //   39: aaload
    //   40: iconst_0
    //   41: iconst_0
    //   42: invokespecial zzc : (Ljava/lang/String;ZZ)Lcom/google/android/gms/common/zzx;
    //   45: astore #4
    //   47: aload #4
    //   49: getfield zza : Z
    //   52: ifeq -> 58
    //   55: goto -> 80
    //   58: iinc #1, 1
    //   61: goto -> 31
    //   64: aload #4
    //   66: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: goto -> 80
    //   73: ldc 'no pkgs'
    //   75: invokestatic zzc : (Ljava/lang/String;)Lcom/google/android/gms/common/zzx;
    //   78: astore #4
    //   80: aload #4
    //   82: invokevirtual zze : ()V
    //   85: aload #4
    //   87: getfield zza : Z
    //   90: ireturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GoogleSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */