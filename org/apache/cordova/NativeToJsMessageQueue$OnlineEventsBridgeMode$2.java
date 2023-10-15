package org.apache.cordova;

class null implements Runnable {
  public void run() {
    if (!queue.isEmpty()) {
      NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
      NativeToJsMessageQueue.OnlineEventsBridgeMode.access$300(NativeToJsMessageQueue.OnlineEventsBridgeMode.this).setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.access$100(NativeToJsMessageQueue.OnlineEventsBridgeMode.this));
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$OnlineEventsBridgeMode$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */