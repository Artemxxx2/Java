package by.chemerisuk.cordova.support;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;

class null implements Runnable {
  public void run() {
    try {
      method.invoke(ReflectiveCordovaPlugin.this, methodArgs);
    } catch (Throwable throwable1) {
      Throwable throwable2 = throwable1;
      if (throwable1 instanceof InvocationTargetException)
        throwable2 = ((InvocationTargetException)throwable1).getTargetException(); 
      String str = ReflectiveCordovaPlugin.access$000();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Uncaught exception at ");
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append("#");
      stringBuilder.append(method.getName());
      LOG.e(str, stringBuilder.toString(), throwable2);
      callbackContext.error(throwable2.getMessage());
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\support\ReflectiveCordovaPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */