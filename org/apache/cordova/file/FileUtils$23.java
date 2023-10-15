package org.apache.cordova.file;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws FileNotFoundException, JSONException, MalformedURLException {
    String str = paramJSONArray.getString(0);
    JSONArray jSONArray = FileUtils.access$1400(FileUtils.this, str);
    callbackContext.success(jSONArray);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */