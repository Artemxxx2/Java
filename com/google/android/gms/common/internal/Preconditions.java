package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Preconditions {
  private Preconditions() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException();
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, @NonNull Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkArgument(boolean paramBoolean, @NonNull String paramString, @NonNull Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  @KeepForSdk
  public static void checkHandlerThread(@NonNull Handler paramHandler) {
    Looper looper = Looper.myLooper();
    if (looper != paramHandler.getLooper()) {
      String str2;
      if (looper != null) {
        str2 = looper.getThread().getName();
      } else {
        str2 = "null current looper";
      } 
      String str1 = paramHandler.getLooper().getThread().getName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Must be called on ");
      stringBuilder.append(str1);
      stringBuilder.append(" thread, but got ");
      stringBuilder.append(str2);
      stringBuilder.append(".");
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  @KeepForSdk
  public static void checkHandlerThread(@NonNull Handler paramHandler, @NonNull String paramString) {
    if (Looper.myLooper() == paramHandler.getLooper())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static void checkMainThread() {
    checkMainThread("Must be called on the main application thread");
  }
  
  @KeepForSdk
  public static void checkMainThread(@NonNull String paramString) {
    if (zzb.zza())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @EnsuresNonNull({"#1"})
  @NonNull
  @KeepForSdk
  public static String checkNotEmpty(@Nullable String paramString) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  @EnsuresNonNull({"#1"})
  @NonNull
  @KeepForSdk
  public static String checkNotEmpty(@Nullable String paramString, @NonNull Object paramObject) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkNotMainThread() {
    checkNotMainThread("Must not be called on the main application thread");
  }
  
  @KeepForSdk
  public static void checkNotMainThread(@NonNull String paramString) {
    if (!zzb.zza())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @EnsuresNonNull({"#1"})
  @NonNull
  @KeepForSdk
  public static <T> T checkNotNull(@Nullable T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException("null reference");
  }
  
  @EnsuresNonNull({"#1"})
  @NonNull
  @KeepForSdk
  public static <T> T checkNotNull(@NonNull T paramT, @NonNull Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static int checkNotZero(int paramInt) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException("Given Integer is zero");
  }
  
  @KeepForSdk
  public static int checkNotZero(int paramInt, @NonNull Object paramObject) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static long checkNotZero(long paramLong) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException("Given Long is zero");
  }
  
  @KeepForSdk
  public static long checkNotZero(long paramLong, @NonNull Object paramObject) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean, @NonNull Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  @KeepForSdk
  public static void checkState(boolean paramBoolean, @NonNull String paramString, @NonNull Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */