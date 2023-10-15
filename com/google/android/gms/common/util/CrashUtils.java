package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class CrashUtils {
  private static final String[] zza = new String[] { "android.", "com.android.", "dalvik.", "java.", "javax." };
  
  @KeepForSdk
  public static boolean addDynamiteErrorToDropBox(@NonNull Context paramContext, @NonNull Throwable paramThrowable) {
    try {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramThrowable);
    } catch (Exception exception) {
      Log.e("CrashUtils", "Error adding exception to DropBox!", exception);
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\CrashUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */