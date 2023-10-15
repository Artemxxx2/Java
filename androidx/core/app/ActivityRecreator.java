package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class ActivityRecreator {
  private static final String LOG_TAG = "ActivityRecreator";
  
  protected static final Class<?> activityThreadClass;
  
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());
  
  protected static final Field mainThreadField;
  
  protected static final Method performStopActivity2ParamsMethod;
  
  protected static final Method performStopActivity3ParamsMethod;
  
  protected static final Method requestRelaunchActivityMethod;
  
  protected static final Field tokenField;
  
  static {
    activityThreadClass = getActivityThreadClass();
    mainThreadField = getMainThreadField();
    tokenField = getTokenField();
    performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass);
    performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass);
    requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass);
  }
  
  private static Class<?> getActivityThreadClass() {
    try {
      return Class.forName("android.app.ActivityThread");
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Field getMainThreadField() {
    try {
      Field field = Activity.class.getDeclaredField("mMainThread");
      field.setAccessible(true);
      return field;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Method getPerformStopActivity2Params(Class<?> paramClass) {
    if (paramClass == null)
      return null; 
    try {
      Method method = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, boolean.class });
      method.setAccessible(true);
      return method;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Method getPerformStopActivity3Params(Class<?> paramClass) {
    if (paramClass == null)
      return null; 
    try {
      Method method = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, boolean.class, String.class });
      method.setAccessible(true);
      return method;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Method getRequestRelaunchActivityMethod(Class<?> paramClass) {
    if (!needsRelaunchCall() || paramClass == null)
      return null; 
    try {
      Method method = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, int.class, boolean.class, Configuration.class, Configuration.class, boolean.class, boolean.class });
      method.setAccessible(true);
      return method;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Field getTokenField() {
    try {
      Field field = Activity.class.getDeclaredField("mToken");
      field.setAccessible(true);
      return field;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static boolean needsRelaunchCall() {
    return (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27);
  }
  
  protected static boolean queueOnStopIfNecessary(Object paramObject, Activity paramActivity) {
    try {
      Object object = tokenField.get(paramActivity);
      if (object != paramObject)
        return false; 
      paramObject = mainThreadField.get(paramActivity);
      Handler handler = mainHandler;
      Runnable runnable = new Runnable() {
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
        };
      super(paramObject, object);
      handler.postAtFrontOfQueue(runnable);
      return true;
    } catch (Throwable throwable) {
      Log.e("ActivityRecreator", "Exception while fetching field values", throwable);
      return false;
    } 
  }
  
  static boolean recreate(@NonNull Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 28) {
      paramActivity.recreate();
      return true;
    } 
    if (needsRelaunchCall() && requestRelaunchActivityMethod == null)
      return false; 
    if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null)
      return false; 
    try {
      Object object1 = tokenField.get(paramActivity);
      if (object1 == null)
        return false; 
      Object object2 = mainThreadField.get(paramActivity);
      if (object2 == null)
        return false; 
      Application application = paramActivity.getApplication();
      LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks();
      this(paramActivity);
      application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
      Handler handler = mainHandler;
      Runnable runnable = new Runnable() {
          public void run() {
            callbacks.currentlyRecreatingToken = token;
          }
        };
      super(lifecycleCheckCallbacks, object1);
      handler.post(runnable);
      try {
        Runnable runnable1;
        if (needsRelaunchCall()) {
          requestRelaunchActivityMethod.invoke(object2, new Object[] { object1, null, null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), Boolean.valueOf(false) });
        } else {
          paramActivity.recreate();
        } 
        return true;
      } finally {
        handler = mainHandler;
        object2 = new Runnable() {
            public void run() {
              application.unregisterActivityLifecycleCallbacks(callbacks);
            }
          };
        super(application, lifecycleCheckCallbacks);
        handler.post((Runnable)object2);
      } 
    } catch (Throwable throwable) {
      return false;
    } 
  }
  
  private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
    Object currentlyRecreatingToken;
    
    private Activity mActivity;
    
    private boolean mDestroyed = false;
    
    private boolean mStarted = false;
    
    private boolean mStopQueued = false;
    
    LifecycleCheckCallbacks(@NonNull Activity param1Activity) {
      this.mActivity = param1Activity;
    }
    
    public void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityDestroyed(Activity param1Activity) {
      if (this.mActivity == param1Activity) {
        this.mActivity = null;
        this.mDestroyed = true;
      } 
    }
    
    public void onActivityPaused(Activity param1Activity) {
      if (this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, param1Activity)) {
        this.mStopQueued = true;
        this.currentlyRecreatingToken = null;
      } 
    }
    
    public void onActivityResumed(Activity param1Activity) {}
    
    public void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public void onActivityStarted(Activity param1Activity) {
      if (this.mActivity == param1Activity)
        this.mStarted = true; 
    }
    
    public void onActivityStopped(Activity param1Activity) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityRecreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */