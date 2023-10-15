package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException {
    int i = paramJSONArray.getInt(0);
    long l = paramJSONArray.optLong(1);
    FileUtils.access$600(FileUtils.this, i, l, callbackContext);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */