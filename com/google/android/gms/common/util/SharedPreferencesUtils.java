package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class SharedPreferencesUtils {
  @Deprecated
  @KeepForSdk
  public static void publishWorldReadableSharedPreferences(@NonNull Context paramContext, @NonNull SharedPreferences.Editor paramEditor, @NonNull String paramString) {
    throw new IllegalStateException("world-readable shared preferences should only be used by apk");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */