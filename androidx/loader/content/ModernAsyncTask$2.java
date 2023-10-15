package androidx.loader.content;

import android.os.Binder;
import android.os.Process;

class null extends ModernAsyncTask.WorkerRunnable<Params, Result> {
  public Result call() throws Exception {
    ModernAsyncTask.this.mTaskInvoked.set(true);
    Object object = null;
    Object object1 = null;
    Object object2 = object1;
    Object object3 = object;
    try {
      Process.setThreadPriority(10);
      object2 = object1;
      object3 = object;
      object1 = ModernAsyncTask.this.doInBackground((Object[])this.mParams);
      object2 = object1;
      object3 = object1;
      Binder.flushPendingCommands();
      ModernAsyncTask.this.postResult(object1);
      return (Result)object1;
    } catch (Throwable throwable) {
      object2 = object3;
      ModernAsyncTask.this.mCancelled.set(true);
      object2 = object3;
      throw throwable;
    } finally {}
    ModernAsyncTask.this.postResult(object2);
    throw object3;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */