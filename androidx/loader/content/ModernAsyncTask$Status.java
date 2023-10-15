package androidx.loader.content;

public enum Status {
  FINISHED, PENDING, RUNNING;
  
  static {
    FINISHED = new Status("FINISHED", 2);
    $VALUES = new Status[] { PENDING, RUNNING, FINISHED };
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\ModernAsyncTask$Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */