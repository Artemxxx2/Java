package org.apache.cordova;

import android.app.Activity;

class null implements Runnable {
  public void run() {
    try {
      Thread.sleep(2000L);
      Activity activity = CordovaWebViewImpl.access$200(this.this$1.this$0).getActivity();
      Runnable runnable = new Runnable() {
          public void run() {
            CordovaWebViewImpl.access$000(this.this$2.this$1.this$0).postMessage("spinner", "stop");
          }
        };
      super(this);
      activity.runOnUiThread(runnable);
    } catch (InterruptedException interruptedException) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaWebViewImpl$EngineClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */