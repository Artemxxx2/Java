package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
  private final CountDownLatch mDone = new CountDownLatch(1);
  
  boolean waiting;
  
  protected D doInBackground(Void... paramVarArgs) {
    try {
      return (D)AsyncTaskLoader.this.onLoadInBackground();
    } catch (OperationCanceledException operationCanceledException) {
      if (isCancelled())
        return null; 
      throw operationCanceledException;
    } 
  }
  
  protected void onCancelled(D paramD) {
    try {
      AsyncTaskLoader.this.dispatchOnCancelled(this, paramD);
      return;
    } finally {
      this.mDone.countDown();
    } 
  }
  
  protected void onPostExecute(D paramD) {
    try {
      AsyncTaskLoader.this.dispatchOnLoadComplete(this, paramD);
      return;
    } finally {
      this.mDone.countDown();
    } 
  }
  
  public void run() {
    this.waiting = false;
    AsyncTaskLoader.this.executePendingTask();
  }
  
  public void waitForLoader() {
    try {
      this.mDone.await();
    } catch (InterruptedException interruptedException) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\AsyncTaskLoader$LoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */