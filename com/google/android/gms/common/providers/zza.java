package com.google.android.gms.common.providers;

import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zza implements PooledExecutorsProvider.PooledExecutorFactory {
  public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
    zzh.zza();
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\providers\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */