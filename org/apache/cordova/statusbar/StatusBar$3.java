package org.apache.cordova.statusbar;

import android.os.Build;
import android.view.Window;

class null implements Runnable {
  public void run() {
    if (Build.VERSION.SDK_INT >= 19) {
      int i = window.getDecorView().getSystemUiVisibility();
      window.getDecorView().setSystemUiVisibility(i | 0x400 | 0x4);
    } 
    window.addFlags(1024);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\statusbar\StatusBar$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */