package org.apache.cordova.statusbar;

import org.apache.cordova.CordovaArgs;
import org.apache.cordova.LOG;
import org.json.JSONException;

class null implements Runnable {
  public void run() {
    try {
      StatusBar.access$300(StatusBar.this, args.getString(0));
    } catch (JSONException jSONException) {
      LOG.e("StatusBar", "Invalid hexString argument, use f.i. '#777777'");
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\statusbar\StatusBar$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */