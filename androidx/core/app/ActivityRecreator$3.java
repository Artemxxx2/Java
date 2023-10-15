package androidx.core.app;

import android.util.Log;

final class null implements Runnable {
  public void run() {
    try {
      if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
        ActivityRecreator.performStopActivity3ParamsMethod.invoke(activityThread, new Object[] { this.val$token, Boolean.valueOf(false), "AppCompat recreation" });
      } else {
        ActivityRecreator.performStopActivity2ParamsMethod.invoke(activityThread, new Object[] { this.val$token, Boolean.valueOf(false) });
      } 
    } catch (RuntimeException runtimeException) {
      if (runtimeException.getClass() == RuntimeException.class && runtimeException.getMessage() != null && runtimeException.getMessage().startsWith("Unable to stop"))
        throw runtimeException; 
    } catch (Throwable throwable) {
      Log.e("ActivityRecreator", "Exception while invoking performStopActivity", throwable);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityRecreator$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */