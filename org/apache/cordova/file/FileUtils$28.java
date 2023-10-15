package org.apache.cordova.file;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
    String str1 = paramJSONArray.getString(0);
    String str2 = paramJSONArray.getString(1);
    JSONObject jSONObject = FileUtils.access$1000(FileUtils.this, str1, str2, paramJSONArray.optJSONObject(2), true);
    req.getCallbackContext().success(jSONObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$28.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */