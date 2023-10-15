package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
public class Logger {
  private final String zza;
  
  private final String zzb;
  
  private final GmsLogger zzc;
  
  private final int zzd;
  
  @KeepForSdk
  public Logger(@NonNull String paramString, @NonNull String... paramVarArgs) {
    String str;
    this.zzb = str;
    this.zza = paramString;
    this.zzc = new GmsLogger(paramString);
    byte b;
    for (b = 2; b <= 7 && !Log.isLoggable(this.zza, b); b++);
    this.zzd = b;
  }
  
  @KeepForSdk
  public void d(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    if (isLoggable(3))
      Log.d(this.zza, format(paramString, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void e(@NonNull String paramString, @NonNull Throwable paramThrowable, @NonNull Object... paramVarArgs) {
    Log.e(this.zza, format(paramString, paramVarArgs), paramThrowable);
  }
  
  @KeepForSdk
  public void e(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    Log.e(this.zza, format(paramString, paramVarArgs));
  }
  
  @NonNull
  @KeepForSdk
  protected String format(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    String str = paramString;
    if (paramVarArgs != null) {
      str = paramString;
      if (paramVarArgs.length > 0)
        str = String.format(Locale.US, paramString, paramVarArgs); 
    } 
    return this.zzb.concat(str);
  }
  
  @NonNull
  @KeepForSdk
  public String getTag() {
    return this.zza;
  }
  
  @KeepForSdk
  public void i(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    Log.i(this.zza, format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public boolean isLoggable(int paramInt) {
    return (this.zzd <= paramInt);
  }
  
  @KeepForSdk
  public void v(@NonNull String paramString, @NonNull Throwable paramThrowable, @NonNull Object... paramVarArgs) {
    if (isLoggable(2))
      Log.v(this.zza, format(paramString, paramVarArgs), paramThrowable); 
  }
  
  @KeepForSdk
  public void v(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    if (isLoggable(2))
      Log.v(this.zza, format(paramString, paramVarArgs)); 
  }
  
  @KeepForSdk
  public void w(@NonNull String paramString, @NonNull Object... paramVarArgs) {
    Log.w(this.zza, format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public void wtf(@NonNull String paramString, @NonNull Throwable paramThrowable, @NonNull Object... paramVarArgs) {
    Log.wtf(this.zza, format(paramString, paramVarArgs), paramThrowable);
  }
  
  @KeepForSdk
  public void wtf(@NonNull Throwable paramThrowable) {
    Log.wtf(this.zza, paramThrowable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\logging\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */