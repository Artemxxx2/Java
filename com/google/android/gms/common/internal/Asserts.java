package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Asserts {
  private Asserts() {
    throw new AssertionError("Uninstantiable");
  }
  
  @KeepForSdk
  public static void checkMainThread(@NonNull String paramString) {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
      return; 
    String str1 = String.valueOf(Thread.currentThread());
    String str2 = String.valueOf(Looper.getMainLooper().getThread());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkMainThread: current thread ");
    stringBuilder.append(str1);
    stringBuilder.append(" IS NOT the main thread ");
    stringBuilder.append(str2);
    stringBuilder.append("!");
    Log.e("Asserts", stringBuilder.toString());
    throw new IllegalStateException(paramString);
  }
  
  @KeepForSdk
  public static void checkNotMainThread(@NonNull String paramString) {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
      return; 
    String str1 = String.valueOf(Thread.currentThread());
    String str2 = String.valueOf(Looper.getMainLooper().getThread());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkNotMainThread: current thread ");
    stringBuilder.append(str1);
    stringBuilder.append(" IS the main thread ");
    stringBuilder.append(str2);
    stringBuilder.append("!");
    Log.e("Asserts", stringBuilder.toString());
    throw new IllegalStateException(paramString);
  }
  
  @EnsuresNonNull({"#1"})
  @KeepForSdk
  public static void checkNotNull(@Nullable Object paramObject) {
    if (paramObject != null)
      return; 
    throw new IllegalArgumentException("null reference");
  }
  
  @EnsuresNonNull({"#1"})
  @KeepForSdk
  public static void checkNotNull(@Nullable Object paramObject1, @NonNull Object paramObject2) {
    if (paramObject1 != null)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject2));
  }
  
  @KeepForSdk
  public static void checkNull(@NonNull Object paramObject) {
    if (paramObject == null)
      return; 
    throw new IllegalArgumentException("non-null reference");
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
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\Asserts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */