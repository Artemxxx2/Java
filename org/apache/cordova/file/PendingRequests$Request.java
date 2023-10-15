package org.apache.cordova.file;

import org.apache.cordova.CallbackContext;

public class Request {
  private int action;
  
  private CallbackContext callbackContext;
  
  private String rawArgs;
  
  private int requestCode;
  
  private Request(String paramString, int paramInt, CallbackContext paramCallbackContext) {
    this.rawArgs = paramString;
    this.action = paramInt;
    this.callbackContext = paramCallbackContext;
    this.requestCode = PendingRequests.access$208(paramPendingRequests);
  }
  
  public int getAction() {
    return this.action;
  }
  
  public CallbackContext getCallbackContext() {
    return this.callbackContext;
  }
  
  public String getRawArgs() {
    return this.rawArgs;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\file\PendingRequests$Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */