package androidx.loader.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class null extends FutureTask<Result> {
  null(Callable<Result> paramCallable) {
    super(paramCallable);
  }
  
  protected void done() {
    try {
      Result result = get();
      ModernAsyncTask.this.postResultIfNotInvoked(result);
    } catch (InterruptedException interruptedException) {
      Log.w("AsyncTask", interruptedException);
    } catch (ExecutionException executionException) {
      throw new RuntimeException("An error occurred while executing doInBackground()", executionException.getCause());
    } catch (CancellationException cancellationException) {
      ModernAsyncTask.this.postResultIfNotInvoked(null);
    } catch (Throwable throwable) {
      throw new RuntimeException("An error occurred while executing doInBackground()", throwable);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */