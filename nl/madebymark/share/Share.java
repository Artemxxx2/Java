package nl.madebymark.share;

import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Share extends CordovaPlugin {
  private void share(String paramString1, String paramString2, String paramString3, CallbackContext paramCallbackContext) {
    try {
      Intent intent = new Intent();
      this();
      intent.setAction("android.intent.action.SEND");
      intent.putExtra("android.intent.extra.TEXT", paramString1);
      intent.setType(paramString3);
      this.cordova.getActivity().startActivity(Intent.createChooser(intent, paramString2));
      paramCallbackContext.success();
    } catch (Error error) {
      paramCallbackContext.error(error.getMessage());
    } 
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    if (paramString.equals("share")) {
      share(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2), paramCallbackContext);
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\nl\madebymark\share\Share.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */