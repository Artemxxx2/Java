package androidx.lifecycle;

import androidx.annotation.NonNull;

public enum State {
  CREATED, DESTROYED, INITIALIZED, RESUMED, STARTED;
  
  static {
    CREATED = new State("CREATED", 2);
    STARTED = new State("STARTED", 3);
    RESUMED = new State("RESUMED", 4);
    $VALUES = new State[] { DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED };
  }
  
  public boolean isAtLeast(@NonNull State paramState) {
    boolean bool;
    if (compareTo(paramState) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\Lifecycle$State.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */