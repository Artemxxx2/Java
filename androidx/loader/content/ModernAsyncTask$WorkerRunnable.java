package androidx.loader.content;

import java.util.concurrent.Callable;

abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
  Params[] mParams;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$WorkerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */