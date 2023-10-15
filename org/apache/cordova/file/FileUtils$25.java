package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

class null implements Runnable {
  public void run() {
    try {
      JSONArray jSONArray = new JSONArray();
      this(rawArgs);
      f.run(jSONArray);
    } catch (Exception exception) {
      boolean bool = exception instanceof EncodingException;
      if (bool) {
        callbackContext.error(FileUtils.ENCODING_ERR);
      } else if (exception instanceof java.io.FileNotFoundException) {
        callbackContext.error(FileUtils.NOT_FOUND_ERR);
      } else if (exception instanceof FileExistsException) {
        callbackContext.error(FileUtils.PATH_EXISTS_ERR);
      } else if (exception instanceof NoModificationAllowedException) {
        callbackContext.error(FileUtils.NO_MODIFICATION_ALLOWED_ERR);
      } else if (exception instanceof InvalidModificationException) {
        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
      } else if (exception instanceof java.net.MalformedURLException) {
        callbackContext.error(FileUtils.ENCODING_ERR);
      } else if (exception instanceof java.io.IOException) {
        callbackContext.error(FileUtils.INVALID_MODIFICATION_ERR);
      } else if (bool) {
        callbackContext.error(FileUtils.ENCODING_ERR);
      } else if (exception instanceof TypeMismatchException) {
        callbackContext.error(FileUtils.TYPE_MISMATCH_ERR);
      } else if (exception instanceof org.json.JSONException) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
      } else if (exception instanceof SecurityException) {
        callbackContext.error(FileUtils.SECURITY_ERR);
      } else {
        exception.printStackTrace();
        callbackContext.error(FileUtils.UNKNOWN_ERR);
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\FileUtils$25.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */