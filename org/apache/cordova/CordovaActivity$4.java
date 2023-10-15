package org.apache.cordova;

import android.app.AlertDialog;
import android.content.DialogInterface;

class null implements Runnable {
  public void run() {
    try {
      AlertDialog.Builder builder = new AlertDialog.Builder();
      this();
      builder.setMessage(message);
      builder.setTitle(title);
      builder.setCancelable(false);
      String str = button;
      DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param2DialogInterface, int param2Int) {
            param2DialogInterface.dismiss();
            if (exit)
              CordovaActivity.this.finish(); 
          }
        };
      super(this);
      builder.setPositiveButton(str, onClickListener);
      builder.create();
      builder.show();
    } catch (Exception exception) {
      CordovaActivity.this.finish();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */