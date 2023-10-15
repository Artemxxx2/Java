package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Read {
  RequiresPermission value() default @RequiresPermission;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\RequiresPermission$Read.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */