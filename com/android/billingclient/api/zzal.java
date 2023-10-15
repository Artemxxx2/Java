package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzal implements ThreadFactory {
  private final ThreadFactory zza = Executors.defaultThreadFactory();
  
  private final AtomicInteger zzb = new AtomicInteger(1);
  
  zzal(BillingClientImpl paramBillingClientImpl) {}
  
  public final Thread newThread(Runnable paramRunnable) {
    paramRunnable = this.zza.newThread(paramRunnable);
    int i = this.zzb.getAndIncrement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PlayBillingLibrary-");
    stringBuilder.append(i);
    paramRunnable.setName(stringBuilder.toString());
    return (Thread)paramRunnable;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */