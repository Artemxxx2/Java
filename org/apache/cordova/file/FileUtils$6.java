package org.apache.cordova.file;

import java.net.MalformedURLException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, MalformedURLException {
    int i = paramJSONArray.getInt(1);
    int j = paramJSONArray.getInt(2);
    String str = paramJSONArray.getString(0);
    FileUtils.this.readFileAs(str, i, j, callbackContext, null, -1);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */