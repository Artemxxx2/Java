package org.apache.cordova;

class null implements Runnable {
  public void run() {
    String str = queue.popAndEncodeAsJs();
    if (str != null) {
      CordovaWebViewEngine cordovaWebViewEngine = NativeToJsMessageQueue.LoadUrlBridgeMode.access$000(NativeToJsMessageQueue.LoadUrlBridgeMode.this);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("javascript:");
      stringBuilder.append(str);
      cordovaWebViewEngine.loadUrl(stringBuilder.toString(), false);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$LoadUrlBridgeMode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */