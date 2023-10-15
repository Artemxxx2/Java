package androidx.core.util;

import androidx.annotation.NonNull;

public class SynchronizedPool<T> extends Pools.SimplePool<T> {
  private final Object mLock = new Object();
  
  public SynchronizedPool(int paramInt) {
    super(paramInt);
  }
  
  public T acquire() {
    synchronized (this.mLock) {
      return super.acquire();
    } 
  }
  
  public boolean release(@NonNull T paramT) {
    synchronized (this.mLock) {
      return super.release(paramT);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cor\\util\Pools$SynchronizedPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */