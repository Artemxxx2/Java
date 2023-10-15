package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class PackageVerificationResult {
  private final String zza;
  
  private final boolean zzb;
  
  @Nullable
  private final String zzc;
  
  @Nullable
  private final Throwable zzd;
  
  private PackageVerificationResult(String paramString1, int paramInt, boolean paramBoolean, @Nullable String paramString2, @Nullable Throwable paramThrowable) {
    this.zza = paramString1;
    this.zzb = paramBoolean;
    this.zzc = paramString2;
    this.zzd = paramThrowable;
  }
  
  @NonNull
  public static PackageVerificationResult zza(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable) {
    return new PackageVerificationResult(paramString1, 1, false, paramString2, paramThrowable);
  }
  
  @NonNull
  public static PackageVerificationResult zzd(@NonNull String paramString, int paramInt) {
    return new PackageVerificationResult(paramString, paramInt, true, null, null);
  }
  
  public final void zzb() {
    if (!this.zzb) {
      String str = "PackageVerificationRslt: ".concat(String.valueOf(this.zzc));
      Throwable throwable = this.zzd;
      if (throwable != null)
        throw new SecurityException(str, throwable); 
      throw new SecurityException(str);
    } 
  }
  
  public final boolean zzc() {
    return this.zzb;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\PackageVerificationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */