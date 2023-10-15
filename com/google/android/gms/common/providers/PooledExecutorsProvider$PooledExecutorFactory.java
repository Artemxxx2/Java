package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

public interface PooledExecutorFactory {
  @Deprecated
  @NonNull
  @KeepForSdk
  ScheduledExecutorService newSingleThreadScheduledExecutor();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\providers\PooledExecutorsProvider$PooledExecutorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */