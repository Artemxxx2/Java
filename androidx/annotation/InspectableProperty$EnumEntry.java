package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface EnumEntry {
  String name();
  
  int value();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\InspectableProperty$EnumEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */