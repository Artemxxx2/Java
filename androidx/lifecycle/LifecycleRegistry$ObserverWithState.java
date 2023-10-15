package androidx.lifecycle;

class ObserverWithState {
  GenericLifecycleObserver mLifecycleObserver;
  
  Lifecycle.State mState;
  
  ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState) {
    this.mLifecycleObserver = Lifecycling.getCallback(paramLifecycleObserver);
    this.mState = paramState;
  }
  
  void dispatchEvent(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {
    Lifecycle.State state = LifecycleRegistry.getStateAfter(paramEvent);
    this.mState = LifecycleRegistry.min(this.mState, state);
    this.mLifecycleObserver.onStateChanged(paramLifecycleOwner, paramEvent);
    this.mState = state;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LifecycleRegistry$ObserverWithState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */