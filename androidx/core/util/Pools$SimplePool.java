package androidx.core.util;

import androidx.annotation.NonNull;

public class SimplePool<T> implements Pools.Pool<T> {
  private final Object[] mPool;
  
  private int mPoolSize;
  
  public SimplePool(int paramInt) {
    if (paramInt > 0) {
      this.mPool = new Object[paramInt];
      return;
    } 
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean isInPool(@NonNull T paramT) {
    for (byte b = 0; b < this.mPoolSize; b++) {
      if (this.mPool[b] == paramT)
        return true; 
    } 
    return false;
  }
  
  public T acquire() {
    int i = this.mPoolSize;
    if (i > 0) {
      int j = i - 1;
      Object[] arrayOfObject = this.mPool;
      Object object = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.mPoolSize = i - 1;
      return (T)object;
    } 
    return null;
  }
  
  public boolean release(@NonNull T paramT) {
    if (!isInPool(paramT)) {
      int i = this.mPoolSize;
      Object[] arrayOfObject = this.mPool;
      if (i < arrayOfObject.length) {
        arrayOfObject[i] = paramT;
        this.mPoolSize = i + 1;
        return true;
      } 
      return false;
    } 
    throw new IllegalStateException("Already in the pool!");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cor\\util\Pools$SimplePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */