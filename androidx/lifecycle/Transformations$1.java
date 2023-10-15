package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

final class null implements Observer<X> {
  public void onChanged(@Nullable X paramX) {
    result.setValue(mapFunction.apply(paramX));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\Transformations$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */