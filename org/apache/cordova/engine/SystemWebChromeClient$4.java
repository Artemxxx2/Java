package org.apache.cordova.engine;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

class null extends CordovaPlugin {
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    Uri uri;
    if (paramIntent == null || paramInt2 != -1) {
      paramIntent = null;
    } else {
      uri = paramIntent.getData();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Receive file chooser URL: ");
    stringBuilder.append(uri);
    LOG.d("SystemWebChromeClient", stringBuilder.toString());
    uploadMsg.onReceiveValue(uri);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebChromeClient$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */