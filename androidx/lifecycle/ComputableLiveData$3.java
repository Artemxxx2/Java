package androidx.lifecycle;

import androidx.annotation.MainThread;

class null implements Runnable {
  @MainThread
  public void run() {
    boolean bool = ComputableLiveData.this.mLiveData.hasActiveObservers();
    if (ComputableLiveData.this.mInvalid.compareAndSet(false, true) && bool)
      ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ComputableLiveData$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */