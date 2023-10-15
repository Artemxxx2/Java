package org.apache.cordova.labs.keyboard;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Keyboard extends CordovaPlugin {
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    View view;
    InputMethodManager inputMethodManager = (InputMethodManager)this.cordova.getActivity().getSystemService("input_method");
    try {
      view = (View)this.webView.getClass().getMethod("getView", new Class[0]).invoke(this.webView, new Object[0]);
    } catch (Exception exception) {
      view = (View)this.webView;
    } 
    if ("show".equals(paramString)) {
      inputMethodManager.showSoftInput(view, 0);
      paramCallbackContext.success();
      return true;
    } 
    if ("hide".equals(paramString)) {
      inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
      paramCallbackContext.success();
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" is not a supported action");
    paramCallbackContext.error(stringBuilder.toString());
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\labs\keyboard\Keyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */