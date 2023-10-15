package androidx.lifecycle;

class null implements Runnable {
  public void run() {
    synchronized (LiveData.this.mDataLock) {
      Object object = LiveData.this.mPendingData;
      LiveData.this.mPendingData = LiveData.NOT_SET;
      LiveData.this.setValue(object);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LiveData$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */