package com.xmartlabs.cordova.market;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class Market extends CordovaPlugin {
  private void openGooglePlay(String paramString) throws ActivityNotFoundException {
    Context context = this.cordova.getActivity().getApplicationContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://details?id=");
    stringBuilder.append(paramString);
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
    intent.addFlags(268435456);
    context.startActivity(intent);
  }
  
  private void searchGooglePlay(String paramString) throws ActivityNotFoundException {
    Context context = this.cordova.getActivity().getApplicationContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://search?q=");
    stringBuilder.append(paramString);
    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
    intent.addFlags(268435456);
    context.startActivity(intent);
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    try {
      if (paramString.equals("open")) {
        if (paramJSONArray.length() == 1) {
          openGooglePlay(paramJSONArray.getString(0));
          paramCallbackContext.success();
          return true;
        } 
      } else if (paramString.equals("search") && paramJSONArray.length() == 1) {
        searchGooglePlay(paramJSONArray.getString(0));
        paramCallbackContext.success();
        return true;
      } 
    } catch (JSONException jSONException) {
      Log.d("CordovaLog", "Plugin Market: cannot parse args.");
      jSONException.printStackTrace();
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.d("CordovaLog", "Plugin Market: cannot open Google Play activity.");
      activityNotFoundException.printStackTrace();
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\xmartlabs\cordova\market\Market.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */