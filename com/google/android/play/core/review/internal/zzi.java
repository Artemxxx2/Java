package com.google.android.play.core.review.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class zzi {
  private final String zza;
  
  public zzi(String paramString) {
    int i = Process.myUid();
    int j = Process.myPid();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UID: [");
    stringBuilder.append(i);
    stringBuilder.append("]  PID: [");
    stringBuilder.append(j);
    stringBuilder.append("] ");
    this.zza = stringBuilder.toString().concat(paramString);
  }
  
  private static String zzf(String paramString1, String paramString2, @Nullable Object... paramVarArgs) {
    String str = paramString2;
    if (paramVarArgs.length > 0)
      try {
        str = String.format(Locale.US, paramString2, paramVarArgs);
      } catch (IllegalFormatException illegalFormatException) {
        Log.e("PlayCore", "Unable to format ".concat(paramString2), illegalFormatException);
        str = TextUtils.join(", ", paramVarArgs);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString2);
        stringBuilder1.append(" [");
        stringBuilder1.append(str);
        stringBuilder1.append("]");
        str = stringBuilder1.toString();
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" : ");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public final int zza(String paramString, @Nullable Object... paramVarArgs) {
    return Log.isLoggable("PlayCore", 3) ? Log.d("PlayCore", zzf(this.zza, "Already connected to the service.", paramVarArgs)) : 0;
  }
  
  public final int zzb(String paramString, @Nullable Object... paramVarArgs) {
    return Log.isLoggable("PlayCore", 6) ? Log.e("PlayCore", zzf(this.zza, "Play Store app is either not installed or not the official version", paramVarArgs)) : 0;
  }
  
  public final int zzc(Throwable paramThrowable, String paramString, @Nullable Object... paramVarArgs) {
    return Log.isLoggable("PlayCore", 6) ? Log.e("PlayCore", zzf(this.zza, paramString, paramVarArgs), paramThrowable) : 0;
  }
  
  public final int zzd(String paramString, @Nullable Object... paramVarArgs) {
    return Log.isLoggable("PlayCore", 4) ? Log.i("PlayCore", zzf(this.zza, paramString, paramVarArgs)) : 0;
  }
  
  public final int zze(String paramString, @Nullable Object... paramVarArgs) {
    return Log.isLoggable("PlayCore", 5) ? Log.w("PlayCore", zzf(this.zza, "Phonesky package is not signed -- possibly self-built package. Could not verify.", paramVarArgs)) : 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */