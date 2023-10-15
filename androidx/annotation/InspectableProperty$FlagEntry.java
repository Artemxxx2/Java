package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface FlagEntry {
  int mask() default 0;
  
  String name();
  
  int target();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\InspectableProperty$FlagEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */