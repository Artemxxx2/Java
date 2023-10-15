package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {
  private final String zza;
  
  private final AtomicInteger zzb = new AtomicInteger();
  
  private final ThreadFactory zzc = Executors.defaultThreadFactory();
  
  @KeepForSdk
  public NumberedThreadFactory(@NonNull String paramString) {
    Preconditions.checkNotNull(paramString, "Name must not be null");
    this.zza = paramString;
  }
  
  @NonNull
  public final Thread newThread(@NonNull Runnable paramRunnable) {
    paramRunnable = this.zzc.newThread(new zza(paramRunnable, 0));
    String str = this.zza;
    int i = this.zzb.getAndIncrement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("[");
    stringBuilder.append(i);
    stringBuilder.append("]");
    paramRunnable.setName(stringBuilder.toString());
    return (Thread)paramRunnable;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\concurrent\NumberedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */