package org.apache.cordova.engine;

import android.webkit.JsResult;
import org.apache.cordova.CordovaDialogsHelper;

class null implements CordovaDialogsHelper.Result {
  public void gotResult(boolean paramBoolean, String paramString) {
    if (paramBoolean) {
      result.confirm();
    } else {
      result.cancel();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebChromeClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */