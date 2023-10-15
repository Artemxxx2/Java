package org.apache.cordova.file;

import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws IOException, JSONException {
    String str = paramJSONArray.getString(0);
    JSONObject jSONObject = FileUtils.access$000(FileUtils.this, str);
    callbackContext.success(jSONObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */