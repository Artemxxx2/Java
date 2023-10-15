package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzx {
  private static final zzx zze = new zzx(true, 3, 1, null, null);
  
  final boolean zza;
  
  @Nullable
  final String zzb;
  
  @Nullable
  final Throwable zzc;
  
  final int zzd;
  
  private zzx(boolean paramBoolean, int paramInt1, int paramInt2, @Nullable String paramString, @Nullable Throwable paramThrowable) {
    this.zza = paramBoolean;
    this.zzd = paramInt1;
    this.zzb = paramString;
    this.zzc = paramThrowable;
  }
  
  @Deprecated
  static zzx zzb() {
    return zze;
  }
  
  static zzx zzc(@NonNull String paramString) {
    return new zzx(false, 1, 5, paramString, null);
  }
  
  static zzx zzd(@NonNull String paramString, @NonNull Throwable paramThrowable) {
    return new zzx(false, 1, 5, paramString, paramThrowable);
  }
  
  static zzx zzf(int paramInt) {
    return new zzx(true, paramInt, 1, null, null);
  }
  
  static zzx zzg(int paramInt1, int paramInt2, @NonNull String paramString, @Nullable Throwable paramThrowable) {
    return new zzx(false, paramInt1, paramInt2, paramString, paramThrowable);
  }
  
  @Nullable
  String zza() {
    return this.zzb;
  }
  
  final void zze() {
    if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
      if (this.zzc != null) {
        Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        return;
      } 
      Log.d("GoogleCertificatesRslt", zza());
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */