package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BundleCompatBaseImpl {
  private static final String TAG = "BundleCompatBaseImpl";
  
  private static Method sGetIBinderMethod;
  
  private static boolean sGetIBinderMethodFetched;
  
  private static Method sPutIBinderMethod;
  
  private static boolean sPutIBinderMethodFetched;
  
  public static IBinder getBinder(Bundle paramBundle, String paramString) {
    if (!sGetIBinderMethodFetched) {
      try {
        sGetIBinderMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        sGetIBinderMethod.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", noSuchMethodException);
      } 
      sGetIBinderMethodFetched = true;
    } 
    Method method = sGetIBinderMethod;
    if (method != null)
      try {
        return (IBinder)method.invoke(paramBundle, new Object[] { paramString });
      } catch (InvocationTargetException|IllegalAccessException|IllegalArgumentException invocationTargetException) {
        Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", invocationTargetException);
        sGetIBinderMethod = null;
      }  
    return null;
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder) {
    if (!sPutIBinderMethodFetched) {
      try {
        sPutIBinderMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        sPutIBinderMethod.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", noSuchMethodException);
      } 
      sPutIBinderMethodFetched = true;
    } 
    Method method = sPutIBinderMethod;
    if (method != null)
      try {
        method.invoke(paramBundle, new Object[] { paramString, paramIBinder });
      } catch (InvocationTargetException|IllegalAccessException|IllegalArgumentException invocationTargetException) {
        Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", invocationTargetException);
        sPutIBinderMethod = null;
      }  
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\BundleCompat$BundleCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */