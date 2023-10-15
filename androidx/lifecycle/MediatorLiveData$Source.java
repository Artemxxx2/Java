package androidx.lifecycle;

import androidx.annotation.Nullable;

class Source<V> implements Observer<V> {
  final LiveData<V> mLiveData;
  
  final Observer<? super V> mObserver;
  
  int mVersion = -1;
  
  Source(LiveData<V> paramLiveData, Observer<? super V> paramObserver) {
    this.mLiveData = paramLiveData;
    this.mObserver = paramObserver;
  }
  
  public void onChanged(@Nullable V paramV) {
    if (this.mVersion != this.mLiveData.getVersion()) {
      this.mVersion = this.mLiveData.getVersion();
      this.mObserver.onChanged(paramV);
    } 
  }
  
  void plug() {
    this.mLiveData.observeForever(this);
  }
  
  void unplug() {
    this.mLiveData.removeObserver(this);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\MediatorLiveData$Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */