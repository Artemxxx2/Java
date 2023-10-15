package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;

class null implements Runnable {
  public void run() {
    CordovaWebViewImpl.this.stopLoading();
    LOG.e("CordovaWebViewImpl", "CordovaWebView: TIMEOUT ERROR!");
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("errorCode", -6);
      jSONObject.put("description", "The connection to the server was unsuccessful.");
      jSONObject.put("url", url);
    } catch (JSONException jSONException) {}
    CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("onReceivedError", jSONObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaWebViewImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */