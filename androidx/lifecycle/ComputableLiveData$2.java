package androidx.lifecycle;

import androidx.annotation.WorkerThread;

class null implements Runnable {
  @WorkerThread
  public void run() {
    boolean bool;
    do {
      if (ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
        null = null;
        bool = false;
        try {
          while (ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
            null = (Exception)ComputableLiveData.this.compute();
            bool = true;
          } 
          if (bool)
            ComputableLiveData.this.mLiveData.postValue(null); 
        } finally {
          ComputableLiveData.this.mComputing.set(false);
        } 
      } else {
        bool = false;
      } 
    } while (bool && ComputableLiveData.this.mInvalid.get());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\ComputableLiveData$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */