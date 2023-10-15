package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;

final class null implements Runnable {
  public void run() {
    int[] arrayOfInt = new int[permissions.length];
    PackageManager packageManager = activity.getPackageManager();
    String str = activity.getPackageName();
    int i = permissions.length;
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = packageManager.checkPermission(permissions[b], str); 
    ((ActivityCompat.OnRequestPermissionsResultCallback)activity).onRequestPermissionsResult(requestCode, permissions, arrayOfInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */