package androidx.arch.core.executor;

import java.util.concurrent.Executor;

final class null implements Executor {
  public void execute(Runnable paramRunnable) {
    ArchTaskExecutor.getInstance().postToMainThread(paramRunnable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\arch\core\executor\ArchTaskExecutor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */