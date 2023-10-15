package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

class null extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent != null && paramIntent.getAction().equals("android.intent.action.PHONE_STATE") && paramIntent.hasExtra("state")) {
      String str = paramIntent.getStringExtra("state");
      if (str.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
        LOG.i("CordovaApp", "Telephone RINGING");
        CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "ringing");
      } else if (str.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
        LOG.i("CordovaApp", "Telephone OFFHOOK");
        CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "offhook");
      } else if (str.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
        LOG.i("CordovaApp", "Telephone IDLE");
        CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "idle");
      } 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CoreAndroid$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */