package tomloprod;

import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class AppMinimize extends CordovaPlugin {
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    if (paramString.equals("minimize")) {
      Intent intent = new Intent("android.intent.action.MAIN");
      intent.addCategory("android.intent.category.HOME");
      intent.setFlags(268435456);
      this.cordova.getActivity().startActivity(intent);
      paramCallbackContext.success(1);
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\tomloprod\AppMinimize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */