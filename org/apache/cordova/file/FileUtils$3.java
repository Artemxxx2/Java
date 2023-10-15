package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException {
    boolean bool = DirectoryManager.testFileExists(paramJSONArray.getString(0));
    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */