package androidx.arch.core.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class null implements ThreadFactory {
  private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
  
  private final AtomicInteger mThreadId = new AtomicInteger(0);
  
  public Thread newThread(Runnable paramRunnable) {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.mThreadId.getAndIncrement()) }));
    return (Thread)paramRunnable;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\executor\DefaultTaskExecutor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */