package com.wordsbaking.cordova.tts;

import android.speech.tts.UtteranceProgressListener;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

class null extends UtteranceProgressListener {
  public void onDone(String paramString) {
    if (!paramString.equals(""))
      (new CallbackContext(paramString, webView)).success(); 
  }
  
  public void onError(String paramString) {
    if (!paramString.equals(""))
      (new CallbackContext(paramString, webView)).error("ERR_UNKNOWN"); 
  }
  
  public void onStart(String paramString) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\wordsbaking\cordova\tts\TTS$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */