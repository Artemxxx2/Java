package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface RequiresFeature {
  String enforcement();
  
  String name();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\annotation\RequiresFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */