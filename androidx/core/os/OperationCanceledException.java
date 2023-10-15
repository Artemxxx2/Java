package androidx.core.os;

import androidx.annotation.Nullable;

public class OperationCanceledException extends RuntimeException {
  public OperationCanceledException() {
    this(null);
  }
  
  public OperationCanceledException(@Nullable String paramString) {
    super(paramString);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\OperationCanceledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */