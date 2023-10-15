package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor implements Executor {
  private final Handler zza;
  
  @KeepForSdk
  public HandlerExecutor(@NonNull Looper paramLooper) {
    this.zza = (Handler)new zzi(paramLooper);
  }
  
  public final void execute(@NonNull Runnable paramRunnable) {
    this.zza.post(paramRunnable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\commo\\util\concurrent\HandlerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */