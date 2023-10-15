package androidx.annotation;

public enum Scope {
  GROUP_ID, LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, SUBCLASSES, TESTS;
  
  static {
    GROUP_ID = new Scope("GROUP_ID", 3);
    TESTS = new Scope("TESTS", 4);
    SUBCLASSES = new Scope("SUBCLASSES", 5);
    $VALUES = new Scope[] { LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, SUBCLASSES };
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\RestrictTo$Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */