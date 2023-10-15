package androidx.lifecycle;

public enum Event {
  ON_ANY, ON_CREATE, ON_DESTROY, ON_PAUSE, ON_RESUME, ON_START, ON_STOP;
  
  static {
    ON_RESUME = new Event("ON_RESUME", 2);
    ON_PAUSE = new Event("ON_PAUSE", 3);
    ON_STOP = new Event("ON_STOP", 4);
    ON_DESTROY = new Event("ON_DESTROY", 5);
    ON_ANY = new Event("ON_ANY", 6);
    $VALUES = new Event[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY };
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\lifecycle\Lifecycle$Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */