package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) {
    long l = DirectoryManager.getFreeExternalStorageSpace();
    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */