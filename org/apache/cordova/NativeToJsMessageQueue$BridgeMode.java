package org.apache.cordova;

public abstract class BridgeMode {
  public void notifyOfFlush(NativeToJsMessageQueue paramNativeToJsMessageQueue, boolean paramBoolean) {}
  
  public abstract void onNativeToJsMessageAvailable(NativeToJsMessageQueue paramNativeToJsMessageQueue);
  
  public void reset() {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue$BridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */