package org.apache.cordova;

import android.content.Intent;

class ActivityResultHolder {
  private Intent intent;
  
  private int requestCode;
  
  private int resultCode;
  
  public ActivityResultHolder(int paramInt1, int paramInt2, Intent paramIntent) {
    this.requestCode = paramInt1;
    this.resultCode = paramInt2;
    this.intent = paramIntent;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaInterfaceImpl$ActivityResultHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */