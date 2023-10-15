package org.apache.cordova;

class null implements Runnable {
  public void run() {
    if (loadUrlTimeoutValue > 0)
      CordovaWebViewImpl.access$200(CordovaWebViewImpl.this).getThreadPool().execute(timeoutCheck); 
    CordovaWebViewImpl.this.engine.loadUrl(url, _recreatePlugins);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaWebViewImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */