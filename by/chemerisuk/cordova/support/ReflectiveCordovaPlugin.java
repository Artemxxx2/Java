package by.chemerisuk.cordova.support;

import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReflectiveCordovaPlugin extends CordovaPlugin {
  private static String TAG = "ReflectiveCordovaPlugin";
  
  private Map<String, Pair<Method, ExecutionThread>> pairs;
  
  private Runnable createCommand(final Method method, final Object[] methodArgs, final CallbackContext callbackContext) {
    return new Runnable() {
        public void run() {
          try {
            method.invoke(ReflectiveCordovaPlugin.this, methodArgs);
          } catch (Throwable throwable1) {
            Throwable throwable2 = throwable1;
            if (throwable1 instanceof InvocationTargetException)
              throwable2 = ((InvocationTargetException)throwable1).getTargetException(); 
            String str = ReflectiveCordovaPlugin.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Uncaught exception at ");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("#");
            stringBuilder.append(method.getName());
            LOG.e(str, stringBuilder.toString(), throwable2);
            callbackContext.error(throwable2.getMessage());
          } 
        }
      };
  }
  
  private Map<String, Pair<Method, ExecutionThread>> createCommandFactories() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Method method : getClass().getDeclaredMethods()) {
      CordovaMethod cordovaMethod = method.<CordovaMethod>getAnnotation(CordovaMethod.class);
      if (cordovaMethod != null) {
        String str1 = cordovaMethod.action();
        String str2 = str1;
        if (str1.isEmpty())
          str2 = method.getName(); 
        hashMap.put(str2, new Pair(method, cordovaMethod.value()));
        method.setAccessible(true);
      } 
    } 
    return (Map)hashMap;
  }
  
  private static Object[] getMethodArgs(JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    int i = paramJSONArray.length();
    Object[] arrayOfObject = new Object[i + 1];
    for (byte b = 0; b < i; b++) {
      Object object1 = paramJSONArray.opt(b);
      Object object2 = object1;
      if (JSONObject.NULL.equals(object1))
        object2 = null; 
      arrayOfObject[b] = object2;
    } 
    arrayOfObject[i] = paramCallbackContext;
    return arrayOfObject;
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    if (this.pairs == null)
      this.pairs = createCommandFactories(); 
    Pair pair = this.pairs.get(paramString);
    if (pair != null) {
      Object[] arrayOfObject = getMethodArgs(paramJSONArray, paramCallbackContext);
      Runnable runnable = createCommand((Method)pair.first, arrayOfObject, paramCallbackContext);
      ExecutionThread executionThread = (ExecutionThread)pair.second;
      if (executionThread == ExecutionThread.WORKER) {
        this.cordova.getThreadPool().execute(runnable);
      } else if (executionThread == ExecutionThread.UI) {
        this.cordova.getActivity().runOnUiThread(runnable);
      } else {
        runnable.run();
      } 
      return true;
    } 
    return false;
  }
  
  public enum ExecutionThread {
    MAIN, UI, WORKER;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\by\chemerisuk\cordova\support\ReflectiveCordovaPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */