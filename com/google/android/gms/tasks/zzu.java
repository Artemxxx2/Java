package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.tasks.zza;
import java.util.concurrent.Executor;

final class zzu implements Executor {
  private final Handler zza = (Handler)new zza(Looper.getMainLooper());
  
  public final void execute(@NonNull Runnable paramRunnable) {
    this.zza.post(paramRunnable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */