package org.apache.cordova;

class null implements Runnable {
  public void run() {
    CoreAndroid.this.webView.getPluginManager().postMessage("spinner", "stop");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CoreAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */