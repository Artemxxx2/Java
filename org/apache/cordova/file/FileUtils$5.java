package org.apache.cordova.file;

import java.net.MalformedURLException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, MalformedURLException {
    String str2 = paramJSONArray.getString(1);
    int i = paramJSONArray.getInt(2);
    int j = paramJSONArray.getInt(3);
    String str1 = paramJSONArray.getString(0);
    FileUtils.this.readFileAs(str1, i, j, callbackContext, str2, 1);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */