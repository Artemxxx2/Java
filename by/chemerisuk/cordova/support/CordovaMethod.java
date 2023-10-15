package by.chemerisuk.cordova.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CordovaMethod {
  String action() default "";
  
  ReflectiveCordovaPlugin.ExecutionThread value() default ReflectiveCordovaPlugin.ExecutionThread.MAIN;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\support\CordovaMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */