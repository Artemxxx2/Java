package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzad<T> implements zzae<T> {
  private final CountDownLatch zza = new CountDownLatch(1);
  
  private zzad() {}
  
  public final void onCanceled() {
    this.zza.countDown();
  }
  
  public final void onFailure(@NonNull Exception paramException) {
    this.zza.countDown();
  }
  
  public final void onSuccess(T paramT) {
    this.zza.countDown();
  }
  
  public final void zza() throws InterruptedException {
    this.zza.await();
  }
  
  public final boolean zzb(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.zza.await(paramLong, paramTimeUnit);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\tasks\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */