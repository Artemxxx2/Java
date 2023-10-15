package org.apache.cordova.statusbar;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.LOG;

class null implements Runnable {
  public void run() {
    cordova.getActivity().getWindow().clearFlags(2048);
    StatusBar statusBar = StatusBar.this;
    StatusBar.access$100(statusBar, StatusBar.access$000(statusBar).getBoolean("StatusBarOverlaysWebView", true));
    statusBar = StatusBar.this;
    StatusBar.access$300(statusBar, StatusBar.access$200(statusBar).getString("StatusBarBackgroundColor", "#000000"));
    String str = StatusBar.access$400(StatusBar.this).getString("StatusBarStyle", "lightcontent");
    if (str.equalsIgnoreCase("blacktranslucent") || str.equalsIgnoreCase("blackopaque")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" is deprecated and will be removed in next major release, use lightcontent");
      LOG.w("StatusBar", stringBuilder.toString());
    } 
    StatusBar.access$500(StatusBar.this, str);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\statusbar\StatusBar$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */