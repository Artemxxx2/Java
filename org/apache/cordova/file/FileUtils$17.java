package org.apache.cordova.file;

import java.io.IOException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException {
    boolean bool = false;
    String str1 = paramJSONArray.getString(0);
    String str2 = paramJSONArray.getString(1);
    String str3 = FileUtils.access$000(FileUtils.this, str1).getString("nativeURL");
    if (!paramJSONArray.isNull(2))
      bool = paramJSONArray.getJSONObject(2).optBoolean("create", false); 
    if (bool && FileUtils.access$100(FileUtils.this, str3, 3)) {
      FileUtils.access$200(FileUtils.this, rawArgs, 2, callbackContext);
    } else if (!bool && FileUtils.access$100(FileUtils.this, str3, 4)) {
      FileUtils.access$900(FileUtils.this, rawArgs, 2, callbackContext);
    } else {
      JSONObject jSONObject = FileUtils.access$1000(FileUtils.this, str1, str2, paramJSONArray.optJSONObject(2), true);
      callbackContext.success(jSONObject);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */