package org.apache.cordova;

import android.view.KeyEvent;

public interface Client {
  void clearLoadTimeoutTimer();
  
  Boolean onDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  boolean onNavigationAttempt(String paramString);
  
  void onPageFinishedLoading(String paramString);
  
  void onPageStarted(String paramString);
  
  void onReceivedError(int paramInt, String paramString1, String paramString2);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaWebViewEngine$Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */