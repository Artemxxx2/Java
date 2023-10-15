package androidx.annotation;

public enum ValueType {
  COLOR, GRAVITY, INFERRED, INT_ENUM, INT_FLAG, NONE, RESOURCE_ID;
  
  static {
    INFERRED = new ValueType("INFERRED", 1);
    INT_ENUM = new ValueType("INT_ENUM", 2);
    INT_FLAG = new ValueType("INT_FLAG", 3);
    COLOR = new ValueType("COLOR", 4);
    GRAVITY = new ValueType("GRAVITY", 5);
    RESOURCE_ID = new ValueType("RESOURCE_ID", 6);
    $VALUES = new ValueType[] { NONE, INFERRED, INT_ENUM, INT_FLAG, COLOR, GRAVITY, RESOURCE_ID };
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\InspectableProperty$ValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */