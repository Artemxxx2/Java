package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
public @interface UiThread {}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\UiThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */