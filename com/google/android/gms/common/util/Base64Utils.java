package com.google.android.gms.common.util;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Base64Utils {
  @NonNull
  @KeepForSdk
  public static byte[] decode(@NonNull String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 0);
  }
  
  @NonNull
  @KeepForSdk
  public static byte[] decodeUrlSafe(@NonNull String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 10);
  }
  
  @NonNull
  @KeepForSdk
  public static byte[] decodeUrlSafeNoPadding(@NonNull String paramString) {
    return (paramString == null) ? null : Base64.decode(paramString, 11);
  }
  
  @NonNull
  @KeepForSdk
  public static String encode(@NonNull byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 0);
  }
  
  @NonNull
  @KeepForSdk
  public static String encodeUrlSafe(@NonNull byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 10);
  }
  
  @NonNull
  @KeepForSdk
  public static String encodeUrlSafeNoPadding(@NonNull byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeToString(paramArrayOfbyte, 11);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\Base64Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */