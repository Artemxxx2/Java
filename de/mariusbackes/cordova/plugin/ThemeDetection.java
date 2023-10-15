package de.mariusbackes.cordova.plugin;

import android.os.Build;
import java.io.PrintStream;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDetection extends CordovaPlugin {
  private static final int MINIMUM_VERSION = 28;
  
  private CallbackContext callback = null;
  
  private JSONObject createReturnObject(boolean paramBoolean, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("value", paramBoolean);
      jSONObject.put("message", paramString);
      return jSONObject;
    } catch (Exception exception) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("JSONObject error: ");
      stringBuilder.append(exception.getMessage());
      printStream.println(stringBuilder.toString());
      return null;
    } 
  }
  
  private boolean isAvailable(CallbackContext paramCallbackContext) {
    this.callback = paramCallbackContext;
    try {
      boolean bool;
      int i = Build.VERSION.SDK_INT;
      if (i >= 28) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Dark mode detection is not available. You need at least Android 9 (API 28), but you have installed API ");
      stringBuilder.append(i);
      String str = stringBuilder.toString();
      if (bool)
        str = "Dark mode detection is available"; 
      JSONObject jSONObject = createReturnObject(bool, str);
      returnCordovaPluginResult(PluginResult.Status.OK, jSONObject, false);
      return true;
    } catch (Exception exception) {
      JSONObject jSONObject = createReturnObject(false, exception.getMessage());
      returnCordovaPluginResult(PluginResult.Status.ERROR, jSONObject, true);
      return false;
    } 
  }
  
  private boolean isDarkModeEnabled(CallbackContext paramCallbackContext) {
    this.callback = paramCallbackContext;
    try {
      boolean bool;
      if (((this.cordova.getActivity().getResources().getConfiguration()).uiMode & 0x30) == 32) {
        bool = true;
      } else {
        bool = false;
      } 
      String str = "Dark mode is not enabled";
      if (bool)
        str = "Dark mode is enabled"; 
      JSONObject jSONObject = createReturnObject(bool, str);
      returnCordovaPluginResult(PluginResult.Status.OK, jSONObject, false);
      return true;
    } catch (Exception exception) {
      JSONObject jSONObject = createReturnObject(false, exception.getMessage());
      returnCordovaPluginResult(PluginResult.Status.ERROR, jSONObject, true);
      return false;
    } 
  }
  
  private void returnCordovaPluginResult(PluginResult.Status paramStatus, JSONObject paramJSONObject, boolean paramBoolean) {
    PluginResult pluginResult = new PluginResult(paramStatus, paramJSONObject);
    if (!paramBoolean)
      pluginResult.setKeepCallback(false); 
    this.callback.sendPluginResult(pluginResult);
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    switch (Action.valueOf(paramString)) {
      default:
        return false;
      case isDarkModeEnabled:
        return isDarkModeEnabled(paramCallbackContext);
      case isAvailable:
        break;
    } 
    return isAvailable(paramCallbackContext);
  }
  
  public enum Action {
    isAvailable, isDarkModeEnabled;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\mariusbackes\cordova\plugin\ThemeDetection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */