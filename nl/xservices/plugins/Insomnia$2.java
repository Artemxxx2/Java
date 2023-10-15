package nl.xservices.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

class null implements Runnable {
  public void run() {
    Insomnia.this.cordova.getActivity().getWindow().clearFlags(128);
    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\nl\xservices\plugins\Insomnia$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */