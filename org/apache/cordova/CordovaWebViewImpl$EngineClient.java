package org.apache.cordova;

import android.app.Activity;
import android.view.KeyEvent;
import org.json.JSONException;
import org.json.JSONObject;

public class EngineClient implements CordovaWebViewEngine.Client {
  public void clearLoadTimeoutTimer() {
    CordovaWebViewImpl.access$108(CordovaWebViewImpl.this);
  }
  
  public Boolean onDispatchKeyEvent(KeyEvent paramKeyEvent) {
    boolean bool;
    int i = paramKeyEvent.getKeyCode();
    if (i == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramKeyEvent.getAction() == 0) {
      if (bool && CordovaWebViewImpl.access$400(CordovaWebViewImpl.this) != null)
        return Boolean.valueOf(true); 
      if (CordovaWebViewImpl.access$300(CordovaWebViewImpl.this).contains(Integer.valueOf(i)))
        return Boolean.valueOf(true); 
      if (bool)
        return Boolean.valueOf(CordovaWebViewImpl.this.engine.canGoBack()); 
    } else if (paramKeyEvent.getAction() == 1) {
      if (bool && CordovaWebViewImpl.access$400(CordovaWebViewImpl.this) != null) {
        CordovaWebViewImpl.this.hideCustomView();
        return Boolean.valueOf(true);
      } 
      if (CordovaWebViewImpl.access$300(CordovaWebViewImpl.this).contains(Integer.valueOf(i))) {
        String str;
        if (i != 4) {
          if (i != 82) {
            if (i != 84) {
              switch (i) {
                default:
                  paramKeyEvent = null;
                  break;
                case 25:
                  str = "volumedownbutton";
                  break;
                case 24:
                  str = "volumeupbutton";
                  break;
              } 
            } else {
              str = "searchbutton";
            } 
          } else {
            str = "menubutton";
          } 
        } else {
          str = "backbutton";
        } 
        if (str != null) {
          CordovaWebViewImpl.access$500(CordovaWebViewImpl.this, str);
          return Boolean.valueOf(true);
        } 
      } else if (bool) {
        return Boolean.valueOf(CordovaWebViewImpl.this.engine.goBack());
      } 
    } 
    return null;
  }
  
  public boolean onNavigationAttempt(String paramString) {
    if (CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).onOverrideUrlLoading(paramString))
      return true; 
    if (CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).shouldAllowNavigation(paramString))
      return false; 
    if (CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).shouldOpenExternalUrl(paramString).booleanValue()) {
      CordovaWebViewImpl.this.showWebPage(paramString, true, false, null);
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blocked (possibly sub-frame) navigation to non-allowed URL: ");
    stringBuilder.append(paramString);
    LOG.w("CordovaWebViewImpl", stringBuilder.toString());
    return true;
  }
  
  public void onPageFinishedLoading(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPageFinished(");
    stringBuilder.append(paramString);
    stringBuilder.append(")");
    LOG.d("CordovaWebViewImpl", stringBuilder.toString());
    clearLoadTimeoutTimer();
    CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("onPageFinished", paramString);
    if (CordovaWebViewImpl.this.engine.getView().getVisibility() != 0)
      (new Thread(new Runnable() {
            public void run() {
              try {
                Thread.sleep(2000L);
                Activity activity = CordovaWebViewImpl.access$200(CordovaWebViewImpl.this).getActivity();
                Runnable runnable = new Runnable() {
                    public void run() {
                      CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("spinner", "stop");
                    }
                  };
                super(this);
                activity.runOnUiThread(runnable);
              } catch (InterruptedException interruptedException) {}
            }
          })).start(); 
    if (paramString.equals("about:blank"))
      CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("exit", null); 
  }
  
  public void onPageStarted(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPageDidNavigate(");
    stringBuilder.append(paramString);
    stringBuilder.append(")");
    LOG.d("CordovaWebViewImpl", stringBuilder.toString());
    CordovaWebViewImpl.access$300(CordovaWebViewImpl.this).clear();
    CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).onReset();
    CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("onPageStarted", paramString);
  }
  
  public void onReceivedError(int paramInt, String paramString1, String paramString2) {
    clearLoadTimeoutTimer();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("errorCode", paramInt);
      jSONObject.put("description", paramString1);
      jSONObject.put("url", paramString2);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    CordovaWebViewImpl.access$000(CordovaWebViewImpl.this).postMessage("onReceivedError", jSONObject);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaWebViewImpl$EngineClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */