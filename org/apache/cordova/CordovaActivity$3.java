package org.apache.cordova;

class null implements Runnable {
  public void run() {
    if (exit) {
      me.appView.getView().setVisibility(8);
      CordovaActivity cordovaActivity = me;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(description);
      stringBuilder.append(" (");
      stringBuilder.append(failingUrl);
      stringBuilder.append(")");
      cordovaActivity.displayError("Application Error", stringBuilder.toString(), "OK", exit);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */