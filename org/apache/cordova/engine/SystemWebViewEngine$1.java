package org.apache.cordova.engine;

import org.apache.cordova.NativeToJsMessageQueue;

class null implements NativeToJsMessageQueue.OnlineEventsBridgeMode.OnlineEventsBridgeModeDelegate {
  public void runOnUiThread(Runnable paramRunnable) {
    SystemWebViewEngine.this.cordova.getActivity().runOnUiThread(paramRunnable);
  }
  
  public void setNetworkAvailable(boolean paramBoolean) {
    if (SystemWebViewEngine.this.webView != null)
      SystemWebViewEngine.this.webView.setNetworkAvailable(paramBoolean); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebViewEngine$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */