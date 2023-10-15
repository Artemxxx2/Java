package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@KeepForSdk
@VisibleForTesting
public class Strings {
  private static final Pattern zza = Pattern.compile("\\$\\{(.*?)\\}");
  
  @Nullable
  @KeepForSdk
  public static String emptyToNull(@Nullable String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = null; 
    return str;
  }
  
  @EnsuresNonNullIf(expression = {"#1"}, result = false)
  @KeepForSdk
  public static boolean isEmptyOrWhitespace(@Nullable String paramString) {
    return (paramString == null || paramString.trim().isEmpty());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */