package uk.co.whiteoctober.cordova;

import android.content.pm.PackageManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class AppVersion extends CordovaPlugin {
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    try {
      PackageManager packageManager;
      if (paramString.equals("getAppName")) {
        packageManager = this.cordova.getActivity().getPackageManager();
        paramCallbackContext.success((String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0)));
        return true;
      } 
      if (packageManager.equals("getPackageName")) {
        paramCallbackContext.success(this.cordova.getActivity().getPackageName());
        return true;
      } 
      if (packageManager.equals("getVersionNumber")) {
        paramCallbackContext.success((this.cordova.getActivity().getPackageManager().getPackageInfo(this.cordova.getActivity().getPackageName(), 0)).versionName);
        return true;
      } 
      if (packageManager.equals("getVersionCode")) {
        paramCallbackContext.success((this.cordova.getActivity().getPackageManager().getPackageInfo(this.cordova.getActivity().getPackageName(), 0)).versionCode);
        return true;
      } 
      return false;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      paramCallbackContext.success("N/A");
      return true;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\\\uk\co\whiteoctober\cordova\AppVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */