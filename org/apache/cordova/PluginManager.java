package org.apache.cordova;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;

public class PluginManager {
  private static final int SLOW_EXEC_WARNING_THRESHOLD;
  
  private static String TAG = "PluginManager";
  
  private final CordovaWebView app;
  
  private final CordovaInterface ctx;
  
  private final LinkedHashMap<String, PluginEntry> entryMap = new LinkedHashMap<String, PluginEntry>();
  
  private boolean isInitialized;
  
  private CordovaPlugin permissionRequester;
  
  private final LinkedHashMap<String, CordovaPlugin> pluginMap = new LinkedHashMap<String, CordovaPlugin>();
  
  static {
    byte b;
    if (Debug.isDebuggerConnected()) {
      b = 60;
    } else {
      b = 16;
    } 
    SLOW_EXEC_WARNING_THRESHOLD = b;
  }
  
  public PluginManager(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface, Collection<PluginEntry> paramCollection) {
    this.ctx = paramCordovaInterface;
    this.app = paramCordovaWebView;
    setPluginEntries(paramCollection);
  }
  
  private CordovaPlugin instantiatePlugin(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 28
    //   6: ldc ''
    //   8: aload_1
    //   9: invokevirtual equals : (Ljava/lang/Object;)Z
    //   12: ifne -> 28
    //   15: aload_1
    //   16: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   19: astore_3
    //   20: goto -> 30
    //   23: astore #4
    //   25: goto -> 70
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull -> 40
    //   34: iconst_1
    //   35: istore #5
    //   37: goto -> 43
    //   40: iconst_0
    //   41: istore #5
    //   43: aload_2
    //   44: astore #4
    //   46: iload #5
    //   48: ldc org/apache/cordova/CordovaPlugin
    //   50: aload_3
    //   51: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   54: iand
    //   55: ifeq -> 123
    //   58: aload_3
    //   59: invokevirtual newInstance : ()Ljava/lang/Object;
    //   62: checkcast org/apache/cordova/CordovaPlugin
    //   65: astore #4
    //   67: goto -> 123
    //   70: aload #4
    //   72: invokevirtual printStackTrace : ()V
    //   75: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   78: astore_3
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore #4
    //   88: aload #4
    //   90: ldc 'Error adding plugin '
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #4
    //   98: aload_1
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #4
    //   105: ldc '.'
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_3
    //   112: aload #4
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokevirtual println : (Ljava/lang/String;)V
    //   120: aload_2
    //   121: astore #4
    //   123: aload #4
    //   125: areturn
    // Exception table:
    //   from	to	target	type
    //   6	20	23	java/lang/Exception
    //   46	67	23	java/lang/Exception
  }
  
  private void startupPlugins() {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      if (pluginEntry.onload) {
        getPlugin(pluginEntry.service);
        continue;
      } 
      this.pluginMap.put(pluginEntry.service, null);
    } 
  }
  
  public void addService(String paramString1, String paramString2) {
    addService(new PluginEntry(paramString1, paramString2, false));
  }
  
  public void addService(PluginEntry paramPluginEntry) {
    this.entryMap.put(paramPluginEntry.service, paramPluginEntry);
    if (paramPluginEntry.plugin != null) {
      CordovaPlugin cordovaPlugin = paramPluginEntry.plugin;
      String str = paramPluginEntry.service;
      CordovaInterface cordovaInterface = this.ctx;
      CordovaWebView cordovaWebView = this.app;
      cordovaPlugin.privateInitialize(str, cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
      this.pluginMap.put(paramPluginEntry.service, paramPluginEntry.plugin);
    } 
  }
  
  public void exec(String paramString1, String paramString2, String paramString3, String paramString4) {
    PluginResult pluginResult;
    StringBuilder stringBuilder;
    CordovaPlugin cordovaPlugin = getPlugin(paramString1);
    if (cordovaPlugin == null) {
      paramString2 = TAG;
      stringBuilder = new StringBuilder();
      stringBuilder.append("exec() call to unknown plugin: ");
      stringBuilder.append(paramString1);
      LOG.d(paramString2, stringBuilder.toString());
      pluginResult = new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION);
      this.app.sendPluginResult(pluginResult, paramString3);
      return;
    } 
    CallbackContext callbackContext = new CallbackContext(paramString3, this.app);
    try {
      long l = System.currentTimeMillis();
      boolean bool = cordovaPlugin.execute(paramString2, (String)stringBuilder, callbackContext);
      l = System.currentTimeMillis() - l;
      if (l > SLOW_EXEC_WARNING_THRESHOLD) {
        String str = TAG;
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append("THREAD WARNING: exec() call to ");
        stringBuilder1.append((String)pluginResult);
        stringBuilder1.append(".");
        stringBuilder1.append(paramString2);
        stringBuilder1.append(" blocked the main thread for ");
        stringBuilder1.append(l);
        stringBuilder1.append("ms. Plugin should use CordovaInterface.getThreadPool().");
        LOG.w(str, stringBuilder1.toString());
      } 
      if (!bool) {
        pluginResult = new PluginResult();
        this(PluginResult.Status.INVALID_ACTION);
        callbackContext.sendPluginResult(pluginResult);
      } 
    } catch (JSONException jSONException) {
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
    } catch (Exception exception) {
      LOG.e(TAG, "Uncaught exception from plugin", exception);
      callbackContext.error(exception.getMessage());
    } 
  }
  
  public CordovaPlugin getPlugin(String paramString) {
    CordovaPlugin cordovaPlugin1 = this.pluginMap.get(paramString);
    CordovaPlugin cordovaPlugin2 = cordovaPlugin1;
    if (cordovaPlugin1 == null) {
      PluginEntry pluginEntry = this.entryMap.get(paramString);
      if (pluginEntry == null)
        return null; 
      if (pluginEntry.plugin != null) {
        cordovaPlugin2 = pluginEntry.plugin;
      } else {
        cordovaPlugin2 = instantiatePlugin(((PluginEntry)cordovaPlugin2).pluginClass);
      } 
      CordovaInterface cordovaInterface = this.ctx;
      CordovaWebView cordovaWebView = this.app;
      cordovaPlugin2.privateInitialize(paramString, cordovaInterface, cordovaWebView, cordovaWebView.getPreferences());
      this.pluginMap.put(paramString, cordovaPlugin2);
    } 
    return cordovaPlugin2;
  }
  
  public Collection<PluginEntry> getPluginEntries() {
    return this.entryMap.values();
  }
  
  public void init() {
    LOG.d(TAG, "init()");
    this.isInitialized = true;
    onPause(false);
    onDestroy();
    this.pluginMap.clear();
    startupPlugins();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onConfigurationChanged(paramConfiguration); 
    } 
  }
  
  public void onDestroy() {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onDestroy(); 
    } 
  }
  
  public void onNewIntent(Intent paramIntent) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onNewIntent(paramIntent); 
    } 
  }
  
  public boolean onOverrideUrlLoading(String paramString) {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
      if (cordovaPlugin != null && cordovaPlugin.onOverrideUrlLoading(paramString))
        return true; 
    } 
    return false;
  }
  
  public void onPause(boolean paramBoolean) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onPause(paramBoolean); 
    } 
  }
  
  public boolean onReceivedClientCertRequest(CordovaWebView paramCordovaWebView, ICordovaClientCertRequest paramICordovaClientCertRequest) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null && cordovaPlugin.onReceivedClientCertRequest(this.app, paramICordovaClientCertRequest))
        return true; 
    } 
    return false;
  }
  
  public boolean onReceivedHttpAuthRequest(CordovaWebView paramCordovaWebView, ICordovaHttpAuthHandler paramICordovaHttpAuthHandler, String paramString1, String paramString2) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null && cordovaPlugin.onReceivedHttpAuthRequest(this.app, paramICordovaHttpAuthHandler, paramString1, paramString2))
        return true; 
    } 
    return false;
  }
  
  public void onReset() {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onReset(); 
    } 
  }
  
  public void onResume(boolean paramBoolean) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onResume(paramBoolean); 
    } 
  }
  
  public Bundle onSaveInstanceState() {
    Bundle bundle = new Bundle();
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null) {
        Bundle bundle1 = cordovaPlugin.onSaveInstanceState();
        if (bundle1 != null)
          bundle.putBundle(cordovaPlugin.getServiceName(), bundle1); 
      } 
    } 
    return bundle;
  }
  
  public void onStart() {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onStart(); 
    } 
  }
  
  public void onStop() {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null)
        cordovaPlugin.onStop(); 
    } 
  }
  
  public Object postMessage(String paramString, Object paramObject) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null) {
        Object object = cordovaPlugin.onMessage(paramString, paramObject);
        if (object != null)
          return object; 
      } 
    } 
    return this.ctx.onMessage(paramString, paramObject);
  }
  
  Uri remapUri(Uri paramUri) {
    for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
      if (cordovaPlugin != null) {
        Uri uri = cordovaPlugin.remapUri(paramUri);
        if (uri != null)
          return uri; 
      } 
    } 
    return null;
  }
  
  public void setPluginEntries(Collection<PluginEntry> paramCollection) {
    if (this.isInitialized) {
      onPause(false);
      onDestroy();
      this.pluginMap.clear();
      this.entryMap.clear();
    } 
    Iterator<PluginEntry> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      addService(iterator.next()); 
    if (this.isInitialized)
      startupPlugins(); 
  }
  
  public boolean shouldAllowBridgeAccess(String paramString) {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
      if (cordovaPlugin != null) {
        Boolean bool = cordovaPlugin.shouldAllowBridgeAccess(paramString);
        if (bool != null)
          return bool.booleanValue(); 
      } 
    } 
    return paramString.startsWith("file://");
  }
  
  public boolean shouldAllowNavigation(String paramString) {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
      if (cordovaPlugin != null) {
        Boolean bool = cordovaPlugin.shouldAllowNavigation(paramString);
        if (bool != null)
          return bool.booleanValue(); 
      } 
    } 
    return (paramString.startsWith("file://") || paramString.startsWith("about:blank"));
  }
  
  public boolean shouldAllowRequest(String paramString) {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
      if (cordovaPlugin != null) {
        Boolean bool = cordovaPlugin.shouldAllowRequest(paramString);
        if (bool != null)
          return bool.booleanValue(); 
      } 
    } 
    return (paramString.startsWith("blob:") || paramString.startsWith("data:") || paramString.startsWith("about:blank")) ? true : (paramString.startsWith("https://ssl.gstatic.com/accessibility/javascript/android/") ? true : (paramString.startsWith("file://") ? (paramString.contains("/app_webview/") ^ true) : false));
  }
  
  public Boolean shouldOpenExternalUrl(String paramString) {
    for (PluginEntry pluginEntry : this.entryMap.values()) {
      CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
      if (cordovaPlugin != null) {
        Boolean bool = cordovaPlugin.shouldOpenExternalUrl(paramString);
        if (bool != null)
          return bool; 
      } 
    } 
    return Boolean.valueOf(false);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\PluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */