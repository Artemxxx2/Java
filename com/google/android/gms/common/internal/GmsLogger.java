package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

@KeepForSdk
public final class GmsLogger {
  private final String zza;
  
  @Nullable
  private final String zzb;
  
  @KeepForSdk
  public GmsLogger(@NonNull String paramString) {
    this(paramString, null);
  }
  
  @KeepForSdk
  public GmsLogger(@NonNull String paramString1, @Nullable String paramString2) {
    boolean bool;
    Preconditions.checkNotNull(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
    this.zza = paramString1;
    if (paramString2 == null || paramString2.length() <= 0) {
      this.zzb = null;
      return;
    } 
    this.zzb = paramString2;
  }
  
  private final String zza(String paramString) {
    String str = this.zzb;
    return (str == null) ? paramString : str.concat(paramString);
  }
  
  @FormatMethod
  private final String zzb(String paramString, Object... paramVarArgs) {
    String str = String.format(paramString, paramVarArgs);
    paramString = this.zzb;
    return (paramString == null) ? str : paramString.concat(str);
  }
  
  @KeepForSdk
  public boolean canLog(int paramInt) {
    return Log.isLoggable(this.zza, paramInt);
  }
  
  @KeepForSdk
  public boolean canLogPii() {
    return false;
  }
  
  @KeepForSdk
  public void d(@NonNull String paramString1, @NonNull String paramString2) {
    if (canLog(3))
      Log.d(paramString1, zza(paramString2)); 
  }
  
  @KeepForSdk
  public void d(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(3))
      Log.d(paramString1, zza(paramString2), paramThrowable); 
  }
  
  @KeepForSdk
  public void e(@NonNull String paramString1, @NonNull String paramString2) {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2)); 
  }
  
  @KeepForSdk
  public void e(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(6))
      Log.e(paramString1, zza(paramString2), paramThrowable); 
  }
  
  @KeepForSdk
  @FormatMethod
  public void efmt(@NonNull String paramString1, @NonNull @FormatString String paramString2, @NonNull Object... paramVarArgs) {
    if (canLog(6))
      Log.e(paramString1, zzb(paramString2, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void i(@NonNull String paramString1, @NonNull String paramString2) {
    if (canLog(4))
      Log.i(paramString1, zza(paramString2)); 
  }
  
  @KeepForSdk
  public void i(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(4))
      Log.i(paramString1, zza(paramString2), paramThrowable); 
  }
  
  @KeepForSdk
  public void pii(@NonNull String paramString1, @NonNull String paramString2) {}
  
  @KeepForSdk
  public void pii(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {}
  
  @KeepForSdk
  public void v(@NonNull String paramString1, @NonNull String paramString2) {
    if (canLog(2))
      Log.v(paramString1, zza(paramString2)); 
  }
  
  @KeepForSdk
  public void v(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(2))
      Log.v(paramString1, zza(paramString2), paramThrowable); 
  }
  
  @KeepForSdk
  public void w(@NonNull String paramString1, @NonNull String paramString2) {
    if (canLog(5))
      Log.w(paramString1, zza(paramString2)); 
  }
  
  @KeepForSdk
  public void w(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(5))
      Log.w(paramString1, zza(paramString2), paramThrowable); 
  }
  
  @KeepForSdk
  @FormatMethod
  public void wfmt(@NonNull String paramString1, @NonNull @FormatString String paramString2, @NonNull Object... paramVarArgs) {
    if (canLog(5))
      Log.w(this.zza, zzb(paramString2, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void wtf(@NonNull String paramString1, @NonNull String paramString2, @NonNull Throwable paramThrowable) {
    if (canLog(7)) {
      Log.e(paramString1, zza(paramString2), paramThrowable);
      Log.wtf(paramString1, zza(paramString2), paramThrowable);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\GmsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */