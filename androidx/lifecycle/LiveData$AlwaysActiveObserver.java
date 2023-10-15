package androidx.lifecycle;

class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
  AlwaysActiveObserver(Observer<? super T> paramObserver) {
    super(paramObserver);
  }
  
  boolean shouldBeActive() {
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LiveData$AlwaysActiveObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */