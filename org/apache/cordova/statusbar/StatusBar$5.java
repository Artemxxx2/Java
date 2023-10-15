package org.apache.cordova.statusbar;

import org.apache.cordova.CordovaArgs;
import org.apache.cordova.LOG;
import org.json.JSONException;

class null implements Runnable {
  public void run() {
    try {
      StatusBar.access$100(StatusBar.this, args.getBoolean(0));
    } catch (JSONException jSONException) {
      LOG.e("StatusBar", "Invalid boolean argument");
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\statusbar\StatusBar$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */