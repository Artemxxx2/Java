package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
public @interface FloatRange {
  double from() default -InfinityD;
  
  boolean fromInclusive() default true;
  
  double to() default InfinityD;
  
  boolean toInclusive() default true;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\FloatRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */