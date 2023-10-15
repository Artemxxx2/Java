package org.apache.cordova.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, FileNotFoundException, IOException, NoModificationAllowedException {
    String str1 = paramJSONArray.getString(0);
    String str2 = FileUtils.access$000(FileUtils.this, str1).getString("nativeURL");
    String str3 = paramJSONArray.getString(1);
    int i = paramJSONArray.getInt(2);
    boolean bool = paramJSONArray.getBoolean(3);
    if (FileUtils.access$100(FileUtils.this, str2, 3)) {
      FileUtils.access$200(FileUtils.this, rawArgs, 1, callbackContext);
    } else {
      long l = FileUtils.this.write(str1, str3, i, Boolean.valueOf(bool).booleanValue());
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */