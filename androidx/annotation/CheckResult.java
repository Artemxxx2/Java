package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface CheckResult {
  String suggest() default "";
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\CheckResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */