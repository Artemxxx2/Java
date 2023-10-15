package androidx.lifecycle;

import androidx.annotation.NonNull;

class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {
  @NonNull
  final LifecycleOwner mOwner;
  
  LifecycleBoundObserver(LifecycleOwner paramLifecycleOwner, Observer<? super T> paramObserver) {
    super(paramObserver);
    this.mOwner = paramLifecycleOwner;
  }
  
  void detachObserver() {
    this.mOwner.getLifecycle().removeObserver(this);
  }
  
  boolean isAttachedTo(LifecycleOwner paramLifecycleOwner) {
    boolean bool;
    if (this.mOwner == paramLifecycleOwner) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {
    if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
      LiveData.this.removeObserver(this.mObserver);
      return;
    } 
    activeStateChanged(shouldBeActive());
  }
  
  boolean shouldBeActive() {
    return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LiveData$LifecycleBoundObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */