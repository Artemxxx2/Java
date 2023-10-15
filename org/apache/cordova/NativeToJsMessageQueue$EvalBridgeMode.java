package org.apache.cordova;

public class EvalBridgeMode extends NativeToJsMessageQueue.BridgeMode {
  private final CordovaInterface cordova;
  
  private final CordovaWebViewEngine engine;
  
  public EvalBridgeMode(CordovaWebViewEngine paramCordovaWebViewEngine, CordovaInterface paramCordovaInterface) {
    this.engine = paramCordovaWebViewEngine;
    this.cordova = paramCordovaInterface;
  }
  
  public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            String str = queue.popAndEncodeAsJs();
            if (str != null)
              NativeToJsMessageQueue.EvalBridgeMode.this.engine.evaluateJavascript(str, null); 
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$EvalBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */