package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface LongDef {
  boolean flag() default false;
  
  boolean open() default false;
  
  long[] value() default {};
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\LongDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */