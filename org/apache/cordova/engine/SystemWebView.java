package org.apache.cordova.engine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;

public class SystemWebView extends WebView implements CordovaWebViewEngine.EngineView {
  SystemWebChromeClient chromeClient;
  
  private CordovaInterface cordova;
  
  private SystemWebViewEngine parentEngine;
  
  private SystemWebViewClient viewClient;
  
  public SystemWebView(Context paramContext) {
    this(paramContext, null);
  }
  
  public SystemWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    Boolean bool = this.parentEngine.client.onDispatchKeyEvent(paramKeyEvent);
    return (bool != null) ? bool.booleanValue() : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public CordovaWebView getCordovaWebView() {
    SystemWebViewEngine systemWebViewEngine = this.parentEngine;
    if (systemWebViewEngine != null) {
      CordovaWebView cordovaWebView = systemWebViewEngine.getCordovaWebView();
    } else {
      systemWebViewEngine = null;
    } 
    return (CordovaWebView)systemWebViewEngine;
  }
  
  void init(SystemWebViewEngine paramSystemWebViewEngine, CordovaInterface paramCordovaInterface) {
    this.cordova = paramCordovaInterface;
    this.parentEngine = paramSystemWebViewEngine;
    if (this.viewClient == null)
      setWebViewClient(new SystemWebViewClient(paramSystemWebViewEngine)); 
    if (this.chromeClient == null)
      setWebChromeClient(new SystemWebChromeClient(paramSystemWebViewEngine)); 
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient) {
    this.chromeClient = (SystemWebChromeClient)paramWebChromeClient;
    super.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient) {
    this.viewClient = (SystemWebViewClient)paramWebViewClient;
    super.setWebViewClient(paramWebViewClient);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */