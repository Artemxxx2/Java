package nl.xservices.plugins;

import android.app.Activity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class Insomnia extends CordovaPlugin {
  private static final String ACTION_ALLOW_SLEEP_AGAIN = "allowSleepAgain";
  
  private static final String ACTION_KEEP_AWAKE = "keepAwake";
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    try {
      Activity activity;
      if ("keepAwake".equals(paramString)) {
        activity = this.cordova.getActivity();
        Runnable runnable = new Runnable() {
            public void run() {
              Insomnia.this.cordova.getActivity().getWindow().addFlags(128);
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          };
        super(this, paramCallbackContext);
        activity.runOnUiThread(runnable);
        return true;
      } 
      if ("allowSleepAgain".equals(activity)) {
        activity = this.cordova.getActivity();
        Runnable runnable = new Runnable() {
            public void run() {
              Insomnia.this.cordova.getActivity().getWindow().clearFlags(128);
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          };
        super(this, paramCallbackContext);
        activity.runOnUiThread(runnable);
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("insomnia.");
      stringBuilder.append((String)activity);
      stringBuilder.append(" is not a supported function. Did you mean '");
      stringBuilder.append("keepAwake");
      stringBuilder.append("'?");
      paramCallbackContext.error(stringBuilder.toString());
      return false;
    } catch (Exception exception) {
      paramCallbackContext.error(exception.getMessage());
      return false;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\nl\xservices\plugins\Insomnia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */