package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory implements ThreadFactory {
  private final String zza;
  
  private final ThreadFactory zzb = Executors.defaultThreadFactory();
  
  @KeepForSdk
  public NamedThreadFactory(@NonNull String paramString) {
    Preconditions.checkNotNull(paramString, "Name must not be null");
    this.zza = paramString;
  }
  
  @NonNull
  public final Thread newThread(@NonNull Runnable paramRunnable) {
    paramRunnable = this.zzb.newThread(new zza(paramRunnable, 0));
    paramRunnable.setName(this.zza);
    return (Thread)paramRunnable;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\concurrent\NamedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */