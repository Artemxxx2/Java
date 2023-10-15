package org.apache.cordova.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
    String str = paramJSONArray.getString(0);
    int i = paramJSONArray.getInt(1);
    long l = FileUtils.access$300(FileUtils.this, str, i);
    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */