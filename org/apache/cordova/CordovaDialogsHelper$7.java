package org.apache.cordova;

import android.content.DialogInterface;
import android.view.KeyEvent;

class null implements DialogInterface.OnKeyListener {
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      result.gotResult(false, null);
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaDialogsHelper$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */