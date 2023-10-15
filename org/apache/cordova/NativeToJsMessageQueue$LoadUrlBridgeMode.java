package org.apache.cordova;

public class LoadUrlBridgeMode extends NativeToJsMessageQueue.BridgeMode {
  private final CordovaInterface cordova;
  
  private final CordovaWebViewEngine engine;
  
  public LoadUrlBridgeMode(CordovaWebViewEngine paramCordovaWebViewEngine, CordovaInterface paramCordovaInterface) {
    this.engine = paramCordovaWebViewEngine;
    this.cordova = paramCordovaInterface;
  }
  
  public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            String str = queue.popAndEncodeAsJs();
            if (str != null) {
              CordovaWebViewEngine cordovaWebViewEngine = NativeToJsMessageQueue.LoadUrlBridgeMode.this.engine;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("javascript:");
              stringBuilder.append(str);
              cordovaWebViewEngine.loadUrl(stringBuilder.toString(), false);
            } 
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$LoadUrlBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */