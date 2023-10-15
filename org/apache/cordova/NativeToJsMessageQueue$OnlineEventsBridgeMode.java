package org.apache.cordova;

public class OnlineEventsBridgeMode extends NativeToJsMessageQueue.BridgeMode {
  private final OnlineEventsBridgeModeDelegate delegate;
  
  private boolean ignoreNextFlush;
  
  private boolean online;
  
  public OnlineEventsBridgeMode(OnlineEventsBridgeModeDelegate paramOnlineEventsBridgeModeDelegate) {
    this.delegate = paramOnlineEventsBridgeModeDelegate;
  }
  
  public void notifyOfFlush(NativeToJsMessageQueue paramNativeToJsMessageQueue, boolean paramBoolean) {
    if (paramBoolean && !this.ignoreNextFlush)
      this.online ^= 0x1; 
  }
  
  public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
    this.delegate.runOnUiThread(new Runnable() {
          public void run() {
            if (!queue.isEmpty()) {
              NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
              NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online);
            } 
          }
        });
  }
  
  public void reset() {
    this.delegate.runOnUiThread(new Runnable() {
          public void run() {
            NativeToJsMessageQueue.OnlineEventsBridgeMode.access$102(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
            NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, true);
            NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(true);
          }
        });
  }
  
  public static interface OnlineEventsBridgeModeDelegate {
    void runOnUiThread(Runnable param2Runnable);
    
    void setNetworkAvailable(boolean param2Boolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$OnlineEventsBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */