package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaInterfaceImpl implements CordovaInterface {
  private static final String TAG = "CordovaInterfaceImpl";
  
  protected Activity activity;
  
  protected CordovaPlugin activityResultCallback;
  
  protected int activityResultRequestCode;
  
  protected boolean activityWasDestroyed = false;
  
  protected String initCallbackService;
  
  protected CallbackMap permissionResultCallbacks;
  
  protected PluginManager pluginManager;
  
  protected Bundle savedPluginState;
  
  protected ActivityResultHolder savedResult;
  
  protected ExecutorService threadPool;
  
  public CordovaInterfaceImpl(Activity paramActivity) {
    this(paramActivity, Executors.newCachedThreadPool());
  }
  
  public CordovaInterfaceImpl(Activity paramActivity, ExecutorService paramExecutorService) {
    this.activity = paramActivity;
    this.threadPool = paramExecutorService;
    this.permissionResultCallbacks = new CallbackMap();
  }
  
  public Activity getActivity() {
    return this.activity;
  }
  
  public Context getContext() {
    return (Context)this.activity;
  }
  
  public ExecutorService getThreadPool() {
    return this.threadPool;
  }
  
  public boolean hasPermission(String paramString) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 23) {
      if (this.activity.checkSelfPermission(paramString) != 0)
        bool = false; 
      return bool;
    } 
    return true;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    String str;
    CordovaPlugin cordovaPlugin1 = this.activityResultCallback;
    CordovaPlugin cordovaPlugin2 = cordovaPlugin1;
    if (cordovaPlugin1 == null) {
      cordovaPlugin2 = cordovaPlugin1;
      if (this.initCallbackService != null) {
        this.savedResult = new ActivityResultHolder(paramInt1, paramInt2, paramIntent);
        PluginManager pluginManager = this.pluginManager;
        cordovaPlugin2 = cordovaPlugin1;
        if (pluginManager != null) {
          cordovaPlugin1 = pluginManager.getPlugin(this.initCallbackService);
          cordovaPlugin2 = cordovaPlugin1;
          if (cordovaPlugin1 != null) {
            cordovaPlugin1.onRestoreStateForActivityResult(this.savedPluginState.getBundle(cordovaPlugin1.getServiceName()), new ResumeCallback(cordovaPlugin1.getServiceName(), this.pluginManager));
            cordovaPlugin2 = cordovaPlugin1;
          } 
        } 
      } 
    } 
    this.activityResultCallback = null;
    if (cordovaPlugin2 != null) {
      LOG.d("CordovaInterfaceImpl", "Sending activity result to plugin");
      this.initCallbackService = null;
      this.savedResult = null;
      cordovaPlugin2.onActivityResult(paramInt1, paramInt2, paramIntent);
      return true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Got an activity result, but no plugin was registered to receive it");
    if (this.savedResult != null) {
      str = " yet!";
    } else {
      str = ".";
    } 
    stringBuilder.append(str);
    LOG.w("CordovaInterfaceImpl", stringBuilder.toString());
    return false;
  }
  
  public void onCordovaInit(PluginManager paramPluginManager) {
    this.pluginManager = paramPluginManager;
    ActivityResultHolder activityResultHolder = this.savedResult;
    if (activityResultHolder != null) {
      onActivityResult(activityResultHolder.requestCode, this.savedResult.resultCode, this.savedResult.intent);
    } else if (this.activityWasDestroyed) {
      this.activityWasDestroyed = false;
      if (paramPluginManager != null) {
        CoreAndroid coreAndroid = (CoreAndroid)paramPluginManager.getPlugin("CoreAndroid");
        if (coreAndroid != null) {
          JSONObject jSONObject = new JSONObject();
          try {
            jSONObject.put("action", "resume");
          } catch (JSONException jSONException) {
            LOG.e("CordovaInterfaceImpl", "Failed to create event message", (Throwable)jSONException);
          } 
          coreAndroid.sendResumeEvent(new PluginResult(PluginResult.Status.OK, jSONObject));
        } 
      } 
    } 
  }
  
  public Object onMessage(String paramString, Object paramObject) {
    if ("exit".equals(paramString))
      this.activity.finish(); 
    return null;
  }
  
  public void onRequestPermissionResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) throws JSONException {
    Pair<CordovaPlugin, Integer> pair = this.permissionResultCallbacks.getAndRemoveCallback(paramInt);
    if (pair != null)
      ((CordovaPlugin)pair.first).onRequestPermissionResult(((Integer)pair.second).intValue(), paramArrayOfString, paramArrayOfint); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    CordovaPlugin cordovaPlugin = this.activityResultCallback;
    if (cordovaPlugin != null)
      paramBundle.putString("callbackService", cordovaPlugin.getServiceName()); 
    PluginManager pluginManager = this.pluginManager;
    if (pluginManager != null)
      paramBundle.putBundle("plugin", pluginManager.onSaveInstanceState()); 
  }
  
  public void requestPermission(CordovaPlugin paramCordovaPlugin, int paramInt, String paramString) {
    requestPermissions(paramCordovaPlugin, paramInt, new String[] { paramString });
  }
  
  @SuppressLint({"NewApi"})
  public void requestPermissions(CordovaPlugin paramCordovaPlugin, int paramInt, String[] paramArrayOfString) {
    paramInt = this.permissionResultCallbacks.registerCallback(paramCordovaPlugin, paramInt);
    getActivity().requestPermissions(paramArrayOfString, paramInt);
  }
  
  public void restoreInstanceState(Bundle paramBundle) {
    this.initCallbackService = paramBundle.getString("callbackService");
    this.savedPluginState = paramBundle.getBundle("plugin");
    this.activityWasDestroyed = true;
  }
  
  public void setActivityResultCallback(CordovaPlugin paramCordovaPlugin) {
    CordovaPlugin cordovaPlugin = this.activityResultCallback;
    if (cordovaPlugin != null)
      cordovaPlugin.onActivityResult(this.activityResultRequestCode, 0, null); 
    this.activityResultCallback = paramCordovaPlugin;
  }
  
  public void setActivityResultRequestCode(int paramInt) {
    this.activityResultRequestCode = paramInt;
  }
  
  public void startActivityForResult(CordovaPlugin paramCordovaPlugin, Intent paramIntent, int paramInt) {
    setActivityResultCallback(paramCordovaPlugin);
    try {
      this.activity.startActivityForResult(paramIntent, paramInt);
      return;
    } catch (RuntimeException runtimeException) {
      this.activityResultCallback = null;
      throw runtimeException;
    } 
  }
  
  private static class ActivityResultHolder {
    private Intent intent;
    
    private int requestCode;
    
    private int resultCode;
    
    public ActivityResultHolder(int param1Int1, int param1Int2, Intent param1Intent) {
      this.requestCode = param1Int1;
      this.resultCode = param1Int2;
      this.intent = param1Intent;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CordovaInterfaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */