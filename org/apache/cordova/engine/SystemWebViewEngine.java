package org.apache.cordova.engine;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import org.apache.cordova.CordovaBridge;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.ICordovaCookieManager;
import org.apache.cordova.LOG;
import org.apache.cordova.NativeToJsMessageQueue;
import org.apache.cordova.PluginManager;

public class SystemWebViewEngine implements CordovaWebViewEngine {
  public static final String TAG = "SystemWebViewEngine";
  
  protected CordovaBridge bridge;
  
  protected CordovaWebViewEngine.Client client;
  
  protected final SystemCookieManager cookieManager;
  
  protected CordovaInterface cordova;
  
  protected NativeToJsMessageQueue nativeToJsMessageQueue;
  
  protected CordovaWebView parentWebView;
  
  protected PluginManager pluginManager;
  
  protected CordovaPreferences preferences;
  
  private BroadcastReceiver receiver;
  
  protected CordovaResourceApi resourceApi;
  
  protected final SystemWebView webView;
  
  public SystemWebViewEngine(Context paramContext, CordovaPreferences paramCordovaPreferences) {
    this(new SystemWebView(paramContext), paramCordovaPreferences);
  }
  
  public SystemWebViewEngine(SystemWebView paramSystemWebView) {
    this(paramSystemWebView, (CordovaPreferences)null);
  }
  
  public SystemWebViewEngine(SystemWebView paramSystemWebView, CordovaPreferences paramCordovaPreferences) {
    this.preferences = paramCordovaPreferences;
    this.webView = paramSystemWebView;
    this.cookieManager = new SystemCookieManager(paramSystemWebView);
  }
  
  private void enableRemoteDebugging() {
    try {
      WebView.setWebContentsDebuggingEnabled(true);
    } catch (IllegalArgumentException illegalArgumentException) {
      LOG.d("SystemWebViewEngine", "You have one job! To turn on Remote Web Debugging! YOU HAVE FAILED! ");
      illegalArgumentException.printStackTrace();
    } 
  }
  
  @SuppressLint({"AddJavascriptInterface"})
  private static void exposeJsInterface(WebView paramWebView, CordovaBridge paramCordovaBridge) {
    paramWebView.addJavascriptInterface(new SystemExposedJsApi(paramCordovaBridge), "_cordovaNative");
  }
  
  @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
  private void initWebViewSettings() {
    this.webView.setInitialScale(0);
    this.webView.setVerticalScrollBarEnabled(false);
    final WebSettings settings = this.webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    String str1 = Build.MANUFACTURER;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CordovaWebView is running on device made by: ");
    stringBuilder.append(str1);
    LOG.d("SystemWebViewEngine", stringBuilder.toString());
    webSettings.setSaveFormData(false);
    webSettings.setSavePassword(false);
    webSettings.setAllowUniversalAccessFromFileURLs(true);
    webSettings.setMediaPlaybackRequiresUserGesture(false);
    str1 = this.webView.getContext().getApplicationContext().getDir("database", 0).getPath();
    webSettings.setDatabaseEnabled(true);
    webSettings.setDatabasePath(str1);
    if (((this.webView.getContext().getApplicationContext().getApplicationInfo()).flags & 0x2) != 0)
      enableRemoteDebugging(); 
    webSettings.setGeolocationDatabasePath(str1);
    webSettings.setDomStorageEnabled(true);
    webSettings.setGeolocationEnabled(true);
    webSettings.setAppCacheMaxSize(5242880L);
    webSettings.setAppCachePath(str1);
    webSettings.setAppCacheEnabled(true);
    str1 = webSettings.getUserAgentString();
    String str2 = this.preferences.getString("OverrideUserAgent", null);
    if (str2 != null) {
      webSettings.setUserAgentString(str2);
    } else {
      String str = this.preferences.getString("AppendUserAgent", null);
      if (str != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" ");
        stringBuilder1.append(str);
        webSettings.setUserAgentString(stringBuilder1.toString());
      } 
    } 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
    if (this.receiver == null) {
      this.receiver = new BroadcastReceiver() {
          public void onReceive(Context param1Context, Intent param1Intent) {
            settings.getUserAgentString();
          }
        };
      this.webView.getContext().registerReceiver(this.receiver, intentFilter);
    } 
  }
  
  public boolean canGoBack() {
    return this.webView.canGoBack();
  }
  
  public void clearCache() {
    this.webView.clearCache(true);
  }
  
  public void clearHistory() {
    this.webView.clearHistory();
  }
  
  public void destroy() {
    this.webView.chromeClient.destroyLastDialog();
    this.webView.destroy();
    if (this.receiver != null)
      try {
        this.webView.getContext().unregisterReceiver(this.receiver);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error unregistering configuration receiver: ");
        stringBuilder.append(exception.getMessage());
        LOG.e("SystemWebViewEngine", stringBuilder.toString(), exception);
      }  
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback) {
    this.webView.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public ICordovaCookieManager getCookieManager() {
    return this.cookieManager;
  }
  
  public CordovaWebView getCordovaWebView() {
    return this.parentWebView;
  }
  
  public String getUrl() {
    return this.webView.getUrl();
  }
  
  public View getView() {
    return (View)this.webView;
  }
  
  public boolean goBack() {
    if (this.webView.canGoBack()) {
      this.webView.goBack();
      return true;
    } 
    return false;
  }
  
  public void init(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface, CordovaWebViewEngine.Client paramClient, CordovaResourceApi paramCordovaResourceApi, PluginManager paramPluginManager, NativeToJsMessageQueue paramNativeToJsMessageQueue) {
    if (this.cordova == null) {
      if (this.preferences == null)
        this.preferences = paramCordovaWebView.getPreferences(); 
      this.parentWebView = paramCordovaWebView;
      this.cordova = paramCordovaInterface;
      this.client = paramClient;
      this.resourceApi = paramCordovaResourceApi;
      this.pluginManager = paramPluginManager;
      this.nativeToJsMessageQueue = paramNativeToJsMessageQueue;
      this.webView.init(this, paramCordovaInterface);
      initWebViewSettings();
      paramNativeToJsMessageQueue.addBridgeMode((NativeToJsMessageQueue.BridgeMode)new NativeToJsMessageQueue.OnlineEventsBridgeMode(new NativeToJsMessageQueue.OnlineEventsBridgeMode.OnlineEventsBridgeModeDelegate() {
              public void runOnUiThread(Runnable param1Runnable) {
                SystemWebViewEngine.this.cordova.getActivity().runOnUiThread(param1Runnable);
              }
              
              public void setNetworkAvailable(boolean param1Boolean) {
                if (SystemWebViewEngine.this.webView != null)
                  SystemWebViewEngine.this.webView.setNetworkAvailable(param1Boolean); 
              }
            }));
      paramNativeToJsMessageQueue.addBridgeMode((NativeToJsMessageQueue.BridgeMode)new NativeToJsMessageQueue.EvalBridgeMode(this, paramCordovaInterface));
      this.bridge = new CordovaBridge(paramPluginManager, paramNativeToJsMessageQueue);
      exposeJsInterface(this.webView, this.bridge);
      return;
    } 
    throw new IllegalStateException();
  }
  
  public void loadUrl(String paramString, boolean paramBoolean) {
    this.webView.loadUrl(paramString);
  }
  
  public void setPaused(boolean paramBoolean) {
    if (paramBoolean) {
      this.webView.onPause();
      this.webView.pauseTimers();
    } else {
      this.webView.onResume();
      this.webView.resumeTimers();
    } 
  }
  
  public void stopLoading() {
    this.webView.stopLoading();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebViewEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */