package androidx.core.content;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

class MainHandlerExecutor implements Executor {
  private final Handler mHandler;
  
  MainHandlerExecutor(@NonNull Handler paramHandler) {
    this.mHandler = paramHandler;
  }
  
  public void execute(Runnable paramRunnable) {
    if (this.mHandler.post(paramRunnable))
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mHandler);
    stringBuilder.append(" is shutting down");
    throw new RejectedExecutionException(stringBuilder.toString());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\ContextCompat$MainHandlerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */