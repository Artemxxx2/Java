package org.apache.cordova.file;

import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws IOException, JSONException {
    callbackContext.success(FileUtils.access$400(FileUtils.this));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */