package androidx.lifecycle;

abstract class ObserverWrapper {
  boolean mActive;
  
  int mLastVersion = -1;
  
  final Observer<? super T> mObserver;
  
  ObserverWrapper(Observer<? super T> paramObserver) {
    this.mObserver = paramObserver;
  }
  
  void activeStateChanged(boolean paramBoolean) {
    if (paramBoolean == this.mActive)
      return; 
    this.mActive = paramBoolean;
    int i = LiveData.this.mActiveCount;
    byte b = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    LiveData liveData = LiveData.this;
    int j = liveData.mActiveCount;
    if (!this.mActive)
      b = -1; 
    liveData.mActiveCount = j + b;
    if (i != 0 && this.mActive)
      LiveData.this.onActive(); 
    if (LiveData.this.mActiveCount == 0 && !this.mActive)
      LiveData.this.onInactive(); 
    if (this.mActive)
      LiveData.this.dispatchingValue(this); 
  }
  
  void detachObserver() {}
  
  boolean isAttachedTo(LifecycleOwner paramLifecycleOwner) {
    return false;
  }
  
  abstract boolean shouldBeActive();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LiveData$ObserverWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */