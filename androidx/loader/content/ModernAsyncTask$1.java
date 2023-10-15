package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class null implements ThreadFactory {
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ModernAsyncTask #");
    stringBuilder.append(this.mCount.getAndIncrement());
    return new Thread(paramRunnable, stringBuilder.toString());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */