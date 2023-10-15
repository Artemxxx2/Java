package org.apache.cordova;

class null implements Runnable {
  public void run() {
    String str = queue.popAndEncodeAsJs();
    if (str != null)
      NativeToJsMessageQueue.EvalBridgeMode.access$400(NativeToJsMessageQueue.EvalBridgeMode.this).evaluateJavascript(str, null); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$EvalBridgeMode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */