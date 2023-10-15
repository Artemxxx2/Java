package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;
import org.json.JSONException;

class null implements Runnable {
  public void run() {
    try {
      callbackContext.success(FileUtils.access$500(FileUtils.this));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */