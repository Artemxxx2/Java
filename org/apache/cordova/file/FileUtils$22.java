package org.apache.cordova.file;

import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException {
    String str2 = paramJSONArray.getString(0);
    String str3 = paramJSONArray.getString(1);
    String str1 = paramJSONArray.getString(2);
    JSONObject jSONObject = FileUtils.access$1300(FileUtils.this, str2, str3, str1, false);
    callbackContext.success(jSONObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$22.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */