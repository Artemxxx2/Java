package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Map;

public abstract class LiveData<T> {
  static final Object NOT_SET = new Object();
  
  static final int START_VERSION = -1;
  
  int mActiveCount = 0;
  
  private volatile Object mData;
  
  final Object mDataLock = new Object();
  
  private boolean mDispatchInvalidated;
  
  private boolean mDispatchingValue;
  
  private SafeIterableMap<Observer<? super T>, ObserverWrapper> mObservers = new SafeIterableMap();
  
  volatile Object mPendingData;
  
  private final Runnable mPostValueRunnable;
  
  private int mVersion;
  
  public LiveData() {
    Object object = NOT_SET;
    this.mData = object;
    this.mPendingData = object;
    this.mVersion = -1;
    this.mPostValueRunnable = new Runnable() {
        public void run() {
          synchronized (LiveData.this.mDataLock) {
            Object object = LiveData.this.mPendingData;
            LiveData.this.mPendingData = LiveData.NOT_SET;
            LiveData.this.setValue(object);
            return;
          } 
        }
      };
  }
  
  private static void assertMainThread(String paramString) {
    if (ArchTaskExecutor.getInstance().isMainThread())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot invoke ");
    stringBuilder.append(paramString);
    stringBuilder.append(" on a background");
    stringBuilder.append(" thread");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void considerNotify(ObserverWrapper paramObserverWrapper) {
    if (!paramObserverWrapper.mActive)
      return; 
    if (!paramObserverWrapper.shouldBeActive()) {
      paramObserverWrapper.activeStateChanged(false);
      return;
    } 
    int i = paramObserverWrapper.mLastVersion;
    int j = this.mVersion;
    if (i >= j)
      return; 
    paramObserverWrapper.mLastVersion = j;
    paramObserverWrapper.mObserver.onChanged((T)this.mData);
  }
  
  void dispatchingValue(@Nullable ObserverWrapper paramObserverWrapper) {
    if (this.mDispatchingValue) {
      this.mDispatchInvalidated = true;
      return;
    } 
    this.mDispatchingValue = true;
    ObserverWrapper observerWrapper = paramObserverWrapper;
    while (true) {
      this.mDispatchInvalidated = false;
      if (observerWrapper != null) {
        considerNotify(observerWrapper);
        paramObserverWrapper = null;
      } else {
        SafeIterableMap.IteratorWithAdditions<Map.Entry> iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
        while (true) {
          paramObserverWrapper = observerWrapper;
          if (iteratorWithAdditions.hasNext()) {
            considerNotify((ObserverWrapper)((Map.Entry)iteratorWithAdditions.next()).getValue());
            if (this.mDispatchInvalidated) {
              paramObserverWrapper = observerWrapper;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
      observerWrapper = paramObserverWrapper;
      if (!this.mDispatchInvalidated) {
        this.mDispatchingValue = false;
        return;
      } 
    } 
  }
  
  @Nullable
  public T getValue() {
    Object object = this.mData;
    return (T)((object != NOT_SET) ? object : null);
  }
  
  int getVersion() {
    return this.mVersion;
  }
  
  public boolean hasActiveObservers() {
    boolean bool;
    if (this.mActiveCount > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean hasObservers() {
    boolean bool;
    if (this.mObservers.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @MainThread
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Observer<? super T> paramObserver) {
    assertMainThread("observe");
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      return; 
    LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
    ObserverWrapper observerWrapper = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, lifecycleBoundObserver);
    if (observerWrapper == null || observerWrapper.isAttachedTo(paramLifecycleOwner)) {
      if (observerWrapper != null)
        return; 
      paramLifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
      return;
    } 
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  @MainThread
  public void observeForever(@NonNull Observer<? super T> paramObserver) {
    assertMainThread("observeForever");
    AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    ObserverWrapper observerWrapper = (ObserverWrapper)this.mObservers.putIfAbsent(paramObserver, alwaysActiveObserver);
    if (observerWrapper == null || !(observerWrapper instanceof LifecycleBoundObserver)) {
      if (observerWrapper != null)
        return; 
      alwaysActiveObserver.activeStateChanged(true);
      return;
    } 
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT) {
    synchronized (this.mDataLock) {
      boolean bool;
      if (this.mPendingData == NOT_SET) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mPendingData = paramT;
      if (!bool)
        return; 
      ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
      return;
    } 
  }
  
  @MainThread
  public void removeObserver(@NonNull Observer<? super T> paramObserver) {
    assertMainThread("removeObserver");
    ObserverWrapper observerWrapper = (ObserverWrapper)this.mObservers.remove(paramObserver);
    if (observerWrapper == null)
      return; 
    observerWrapper.detachObserver();
    observerWrapper.activeStateChanged(false);
  }
  
  @MainThread
  public void removeObservers(@NonNull LifecycleOwner paramLifecycleOwner) {
    assertMainThread("removeObservers");
    for (Map.Entry entry : this.mObservers) {
      if (((ObserverWrapper)entry.getValue()).isAttachedTo(paramLifecycleOwner))
        removeObserver((Observer<? super T>)entry.getKey()); 
    } 
  }
  
  @MainThread
  protected void setValue(T paramT) {
    assertMainThread("setValue");
    this.mVersion++;
    this.mData = paramT;
    dispatchingValue(null);
  }
  
  private class AlwaysActiveObserver extends ObserverWrapper {
    AlwaysActiveObserver(Observer<? super T> param1Observer) {
      super(param1Observer);
    }
    
    boolean shouldBeActive() {
      return true;
    }
  }
  
  class LifecycleBoundObserver extends ObserverWrapper implements GenericLifecycleObserver {
    @NonNull
    final LifecycleOwner mOwner;
    
    LifecycleBoundObserver(LifecycleOwner param1LifecycleOwner, Observer<? super T> param1Observer) {
      super(param1Observer);
      this.mOwner = param1LifecycleOwner;
    }
    
    void detachObserver() {
      this.mOwner.getLifecycle().removeObserver(this);
    }
    
    boolean isAttachedTo(LifecycleOwner param1LifecycleOwner) {
      boolean bool;
      if (this.mOwner == param1LifecycleOwner) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
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
  
  private abstract class ObserverWrapper {
    boolean mActive;
    
    int mLastVersion = -1;
    
    final Observer<? super T> mObserver;
    
    ObserverWrapper(Observer<? super T> param1Observer) {
      this.mObserver = param1Observer;
    }
    
    void activeStateChanged(boolean param1Boolean) {
      if (param1Boolean == this.mActive)
        return; 
      this.mActive = param1Boolean;
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
    
    boolean isAttachedTo(LifecycleOwner param1LifecycleOwner) {
      return false;
    }
    
    abstract boolean shouldBeActive();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\LiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */