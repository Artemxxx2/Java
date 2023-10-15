package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Pool<T> {
  @Nullable
  T acquire();
  
  boolean release(@NonNull T paramT);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cor\\util\Pools$Pool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */