package de.appplant.cordova.plugin.background;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONObject;

public class BackgroundMode extends CordovaPlugin {
  private static final String JS_NAMESPACE = "cordova.plugins.backgroundMode";
  
  private static JSONObject defaultSettings = new JSONObject();
  
  private final ServiceConnection connection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        ForegroundService.ForegroundBinder foregroundBinder = (ForegroundService.ForegroundBinder)param1IBinder;
        BackgroundMode.access$002(BackgroundMode.this, foregroundBinder.getService());
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        BackgroundMode.this.fireEvent(BackgroundMode.Event.FAILURE, "'service disconnected'");
      }
    };
  
  private boolean inBackground = false;
  
  private boolean isBind = false;
  
  private boolean isDisabled = true;
  
  private ForegroundService service;
  
  private void configure(JSONObject paramJSONObject, boolean paramBoolean) {
    if (paramBoolean) {
      updateNotification(paramJSONObject);
    } else {
      setDefaultSettings(paramJSONObject);
    } 
  }
  
  private void disableMode() {
    stopService();
    this.isDisabled = true;
  }
  
  private void enableMode() {
    this.isDisabled = false;
    if (this.inBackground)
      startService(); 
  }
  
  private void fireEvent(Event paramEvent, String paramString) {
    boolean bool;
    String str2 = paramEvent.name().toLowerCase();
    if (paramEvent == Event.ACTIVATE) {
      bool = true;
    } else {
      bool = false;
    } 
    String str1 = String.format("%s;%s.fireEvent('%s',%s);", new Object[] { String.format("%s;%s.on('%s', %s)", new Object[] { String.format("%s._setActive(%b)", new Object[] { "cordova.plugins.backgroundMode", Boolean.valueOf(bool) }), "cordova.plugins.backgroundMode", str2, paramString }), "cordova.plugins.backgroundMode", str2, paramString });
    this.cordova.getActivity().runOnUiThread(new _$$Lambda$BackgroundMode$K6y_lRKzoGM6t_6fzblSCZ0X_uQ(this, str1));
  }
  
  static JSONObject getSettings() {
    return defaultSettings;
  }
  
  private void setDefaultSettings(JSONObject paramJSONObject) {
    defaultSettings = paramJSONObject;
  }
  
  private void startService() {
    Activity activity = this.cordova.getActivity();
    if (this.isDisabled || this.isBind)
      return; 
    Intent intent = new Intent((Context)activity, ForegroundService.class);
    try {
      activity.bindService(intent, this.connection, 1);
      fireEvent(Event.ACTIVATE, (String)null);
      activity.startService(intent);
    } catch (Exception exception) {
      fireEvent(Event.FAILURE, String.format("'%s'", new Object[] { exception.getMessage() }));
    } 
    this.isBind = true;
  }
  
  private void stopService() {
    Activity activity = this.cordova.getActivity();
    Intent intent = new Intent((Context)activity, ForegroundService.class);
    if (!this.isBind)
      return; 
    fireEvent(Event.DEACTIVATE, (String)null);
    activity.unbindService(this.connection);
    activity.stopService(intent);
    this.isBind = false;
  }
  
  private void updateNotification(JSONObject paramJSONObject) {
    if (this.isBind)
      this.service.updateNotification(paramJSONObject); 
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual hashCode : ()I
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iload #4
    //   11: ldc -1298848381
    //   13: if_icmpeq -> 63
    //   16: iload #4
    //   18: ldc -804429082
    //   20: if_icmpeq -> 48
    //   23: iload #4
    //   25: ldc 1671308008
    //   27: if_icmpeq -> 33
    //   30: goto -> 78
    //   33: aload_1
    //   34: ldc 'disable'
    //   36: invokevirtual equals : (Ljava/lang/Object;)Z
    //   39: ifeq -> 78
    //   42: iconst_2
    //   43: istore #4
    //   45: goto -> 81
    //   48: aload_1
    //   49: ldc 'configure'
    //   51: invokevirtual equals : (Ljava/lang/Object;)Z
    //   54: ifeq -> 78
    //   57: iconst_0
    //   58: istore #4
    //   60: goto -> 81
    //   63: aload_1
    //   64: ldc 'enable'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 78
    //   72: iconst_1
    //   73: istore #4
    //   75: goto -> 81
    //   78: iconst_m1
    //   79: istore #4
    //   81: iload #4
    //   83: tableswitch default -> 108, 0 -> 125, 1 -> 118, 2 -> 111
    //   108: goto -> 142
    //   111: aload_0
    //   112: invokespecial disableMode : ()V
    //   115: goto -> 139
    //   118: aload_0
    //   119: invokespecial enableMode : ()V
    //   122: goto -> 139
    //   125: aload_0
    //   126: aload_2
    //   127: iconst_0
    //   128: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   131: aload_2
    //   132: iconst_1
    //   133: invokevirtual optBoolean : (I)Z
    //   136: invokespecial configure : (Lorg/json/JSONObject;Z)V
    //   139: iconst_1
    //   140: istore #5
    //   142: iload #5
    //   144: ifeq -> 154
    //   147: aload_3
    //   148: invokevirtual success : ()V
    //   151: goto -> 183
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore_2
    //   162: aload_2
    //   163: ldc 'Invalid action: '
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: aload_1
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: aload_2
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokevirtual error : (Ljava/lang/String;)V
    //   183: iload #5
    //   185: ireturn
  }
  
  public void onDestroy() {
    stopService();
    Process.killProcess(Process.myPid());
  }
  
  public void onPause(boolean paramBoolean) {
    try {
      this.inBackground = true;
      startService();
      return;
    } finally {
      BackgroundModeExt.clearKeyguardFlags(this.cordova.getActivity());
    } 
  }
  
  public void onResume(boolean paramBoolean) {
    this.inBackground = false;
    stopService();
  }
  
  public void onStop() {
    BackgroundModeExt.clearKeyguardFlags(this.cordova.getActivity());
  }
  
  private enum Event {
    ACTIVATE, DEACTIVATE, FAILURE;
    
    static {
    
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\appplant\cordova\plugin\background\BackgroundMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */