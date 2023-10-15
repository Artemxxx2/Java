package org.apache.cordova.file;

import java.net.MalformedURLException;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

class null implements FileUtils.FileOp {
  public void run(JSONArray paramJSONArray) throws JSONException, NoModificationAllowedException, InvalidModificationException, MalformedURLException {
    String str = paramJSONArray.getString(0);
    if (FileUtils.access$1100(FileUtils.this, str)) {
      callbackContext.success();
    } else {
      callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */