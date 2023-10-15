package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface GuardedBy {
  String value();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\GuardedBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */