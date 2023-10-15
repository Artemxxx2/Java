package org.apache.cordova;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreAndroid extends CordovaPlugin {
  public static final String PLUGIN_NAME = "CoreAndroid";
  
  protected static final String TAG = "CordovaApp";
  
  private CallbackContext messageChannel;
  
  private final Object messageChannelLock = new Object();
  
  private PluginResult pendingPause;
  
  private PluginResult pendingResume;
  
  private BroadcastReceiver telephonyReceiver;
  
  public static Object getBuildConfigValue(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(".BuildConfig");
      return Class.forName(stringBuilder.toString()).getField(paramString).get(null);
    } catch (ClassNotFoundException classNotFoundException) {
      LOG.d("CordovaApp", "Unable to get the BuildConfig, is this built with ANT?");
      classNotFoundException.printStackTrace();
    } catch (NoSuchFieldException noSuchFieldException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" is not a valid field. Check your build.gradle");
      LOG.d("CordovaApp", stringBuilder.toString());
    } catch (IllegalAccessException illegalAccessException) {
      LOG.d("CordovaApp", "Illegal Access Exception: Let's print a stack trace.");
      illegalAccessException.printStackTrace();
    } 
    return null;
  }
  
  private void initTelephonyReceiver() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.PHONE_STATE");
    this.telephonyReceiver = new BroadcastReceiver() {
        public void onReceive(Context param1Context, Intent param1Intent) {
          if (param1Intent != null && param1Intent.getAction().equals("android.intent.action.PHONE_STATE") && param1Intent.hasExtra("state")) {
            String str = param1Intent.getStringExtra("state");
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
      };
    this.webView.getContext().registerReceiver(this.telephonyReceiver, intentFilter);
  }
  
  private void sendEventMessage(String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("action", paramString);
    } catch (JSONException jSONException) {
      LOG.e("CordovaApp", "Failed to create event message", (Throwable)jSONException);
    } 
    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, jSONObject);
    if (this.messageChannel == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Request to send event before messageChannel initialised: ");
      stringBuilder.append(paramString);
      LOG.i("CordovaApp", stringBuilder.toString());
      if ("pause".equals(paramString)) {
        this.pendingPause = pluginResult;
      } else if ("resume".equals(paramString)) {
        this.pendingPause = null;
      } 
    } else {
      sendEventMessage(pluginResult);
    } 
  }
  
  private void sendEventMessage(PluginResult paramPluginResult) {
    paramPluginResult.setKeepCallback(true);
    CallbackContext callbackContext = this.messageChannel;
    if (callbackContext != null)
      callbackContext.sendPluginResult(paramPluginResult); 
  }
  
  public void backHistory() {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            CoreAndroid.this.webView.backHistory();
          }
        });
  }
  
  public void clearCache() {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            CoreAndroid.this.webView.clearCache();
          }
        });
  }
  
  public void clearHistory() {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
          public void run() {
            CoreAndroid.this.webView.clearHistory();
          }
        });
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext) throws JSONException {
    PluginResult.Status status = PluginResult.Status.OK;
    try {
      if (paramString.equals("clearCache")) {
        clearCache();
      } else {
        Activity activity;
        Runnable runnable;
        if (paramString.equals("show")) {
          activity = this.cordova.getActivity();
          runnable = new Runnable() {
              public void run() {
                CoreAndroid.this.webView.getPluginManager().postMessage("spinner", "stop");
              }
            };
          super(this);
          activity.runOnUiThread(runnable);
        } else if (activity.equals("loadUrl")) {
          loadUrl(runnable.getString(0), runnable.optJSONObject(1));
        } else if (!activity.equals("cancelLoadUrl")) {
          if (activity.equals("clearHistory")) {
            clearHistory();
          } else if (activity.equals("backHistory")) {
            backHistory();
          } else if (activity.equals("overrideButton")) {
            overrideButton(runnable.getString(0), runnable.getBoolean(1));
          } else if (activity.equals("overrideBackbutton")) {
            overrideBackbutton(runnable.getBoolean(0));
          } else if (activity.equals("exitApp")) {
            exitApp();
          } else if (activity.equals("messageChannel")) {
            synchronized (this.messageChannelLock) {
              this.messageChannel = paramCallbackContext;
              if (this.pendingPause != null) {
                sendEventMessage(this.pendingPause);
                this.pendingPause = null;
              } 
              if (this.pendingResume != null) {
                sendEventMessage(this.pendingResume);
                this.pendingResume = null;
              } 
              return true;
            } 
          } 
        } 
      } 
      PluginResult pluginResult = new PluginResult();
      this(status, "");
      paramCallbackContext.sendPluginResult(pluginResult);
      return true;
    } catch (JSONException jSONException) {
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
      return false;
    } 
  }
  
  public void exitApp() {
    this.webView.getPluginManager().postMessage("exit", null);
  }
  
  public void fireJavascriptEvent(String paramString) {
    sendEventMessage(paramString);
  }
  
  public boolean isBackbuttonOverridden() {
    return this.webView.isButtonPlumbedToJs(4);
  }
  
  public void loadUrl(String paramString, JSONObject paramJSONObject) throws JSONException {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc_w 'App.loadUrl('
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_3
    //   17: aload_1
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc_w ','
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: ldc_w ')'
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc_w 'App'
    //   47: aload_3
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: new java/util/HashMap
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore_3
    //   62: iconst_0
    //   63: istore #4
    //   65: iconst_0
    //   66: istore #5
    //   68: aload_2
    //   69: ifnull -> 376
    //   72: aload_2
    //   73: invokevirtual names : ()Lorg/json/JSONArray;
    //   76: astore #6
    //   78: iconst_0
    //   79: istore #4
    //   81: iconst_0
    //   82: istore #7
    //   84: iconst_0
    //   85: istore #8
    //   87: iload #5
    //   89: aload #6
    //   91: invokevirtual length : ()I
    //   94: if_icmpge -> 373
    //   97: aload #6
    //   99: iload #5
    //   101: invokevirtual getString : (I)Ljava/lang/String;
    //   104: astore #9
    //   106: aload #9
    //   108: ldc_w 'wait'
    //   111: invokevirtual equals : (Ljava/lang/Object;)Z
    //   114: ifeq -> 136
    //   117: aload_2
    //   118: aload #9
    //   120: invokevirtual getInt : (Ljava/lang/String;)I
    //   123: istore #10
    //   125: iload #7
    //   127: istore #11
    //   129: iload #8
    //   131: istore #12
    //   133: goto -> 355
    //   136: aload #9
    //   138: ldc_w 'openexternal'
    //   141: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   144: ifeq -> 166
    //   147: aload_2
    //   148: aload #9
    //   150: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   153: istore #11
    //   155: iload #4
    //   157: istore #10
    //   159: iload #8
    //   161: istore #12
    //   163: goto -> 355
    //   166: aload #9
    //   168: ldc_w 'clearhistory'
    //   171: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   174: ifeq -> 196
    //   177: aload_2
    //   178: aload #9
    //   180: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   183: istore #12
    //   185: iload #4
    //   187: istore #10
    //   189: iload #7
    //   191: istore #11
    //   193: goto -> 355
    //   196: aload_2
    //   197: aload #9
    //   199: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   202: astore #13
    //   204: aload #13
    //   206: ifnonnull -> 224
    //   209: iload #4
    //   211: istore #10
    //   213: iload #7
    //   215: istore #11
    //   217: iload #8
    //   219: istore #12
    //   221: goto -> 355
    //   224: aload #13
    //   226: invokevirtual getClass : ()Ljava/lang/Class;
    //   229: ldc java/lang/String
    //   231: invokevirtual equals : (Ljava/lang/Object;)Z
    //   234: ifeq -> 264
    //   237: aload_3
    //   238: aload #9
    //   240: aload #13
    //   242: checkcast java/lang/String
    //   245: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   248: pop
    //   249: iload #4
    //   251: istore #10
    //   253: iload #7
    //   255: istore #11
    //   257: iload #8
    //   259: istore #12
    //   261: goto -> 355
    //   264: aload #13
    //   266: invokevirtual getClass : ()Ljava/lang/Class;
    //   269: ldc_w java/lang/Boolean
    //   272: invokevirtual equals : (Ljava/lang/Object;)Z
    //   275: ifeq -> 305
    //   278: aload_3
    //   279: aload #9
    //   281: aload #13
    //   283: checkcast java/lang/Boolean
    //   286: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: iload #4
    //   292: istore #10
    //   294: iload #7
    //   296: istore #11
    //   298: iload #8
    //   300: istore #12
    //   302: goto -> 355
    //   305: iload #4
    //   307: istore #10
    //   309: iload #7
    //   311: istore #11
    //   313: iload #8
    //   315: istore #12
    //   317: aload #13
    //   319: invokevirtual getClass : ()Ljava/lang/Class;
    //   322: ldc_w java/lang/Integer
    //   325: invokevirtual equals : (Ljava/lang/Object;)Z
    //   328: ifeq -> 355
    //   331: aload_3
    //   332: aload #9
    //   334: aload #13
    //   336: checkcast java/lang/Integer
    //   339: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: iload #8
    //   345: istore #12
    //   347: iload #7
    //   349: istore #11
    //   351: iload #4
    //   353: istore #10
    //   355: iinc #5, 1
    //   358: iload #10
    //   360: istore #4
    //   362: iload #11
    //   364: istore #7
    //   366: iload #12
    //   368: istore #8
    //   370: goto -> 87
    //   373: goto -> 382
    //   376: iconst_0
    //   377: istore #7
    //   379: iconst_0
    //   380: istore #8
    //   382: iload #4
    //   384: ifle -> 415
    //   387: aload_0
    //   388: monitorenter
    //   389: iload #4
    //   391: i2l
    //   392: lstore #14
    //   394: aload_0
    //   395: lload #14
    //   397: invokevirtual wait : (J)V
    //   400: aload_0
    //   401: monitorexit
    //   402: goto -> 415
    //   405: astore_2
    //   406: aload_0
    //   407: monitorexit
    //   408: aload_2
    //   409: athrow
    //   410: astore_2
    //   411: aload_2
    //   412: invokevirtual printStackTrace : ()V
    //   415: aload_0
    //   416: getfield webView : Lorg/apache/cordova/CordovaWebView;
    //   419: aload_1
    //   420: iload #7
    //   422: iload #8
    //   424: aload_3
    //   425: invokeinterface showWebPage : (Ljava/lang/String;ZZLjava/util/Map;)V
    //   430: return
    // Exception table:
    //   from	to	target	type
    //   387	389	410	java/lang/InterruptedException
    //   394	402	405	finally
    //   406	408	405	finally
    //   408	410	410	java/lang/InterruptedException
  }
  
  public void onDestroy() {
    this.webView.getContext().unregisterReceiver(this.telephonyReceiver);
  }
  
  public void overrideBackbutton(boolean paramBoolean) {
    LOG.i("App", "WARNING: Back Button Default Behavior will be overridden.  The backbutton event will be fired!");
    this.webView.setButtonPlumbedToJs(4, paramBoolean);
  }
  
  public void overrideButton(String paramString, boolean paramBoolean) {
    LOG.i("App", "WARNING: Volume Button Default Behavior will be overridden.  The volume event will be fired!");
    if (paramString.equals("volumeup")) {
      this.webView.setButtonPlumbedToJs(24, paramBoolean);
    } else if (paramString.equals("volumedown")) {
      this.webView.setButtonPlumbedToJs(25, paramBoolean);
    } else if (paramString.equals("menubutton")) {
      this.webView.setButtonPlumbedToJs(82, paramBoolean);
    } 
  }
  
  public void pluginInitialize() {
    initTelephonyReceiver();
  }
  
  public void sendResumeEvent(PluginResult paramPluginResult) {
    synchronized (this.messageChannelLock) {
      if (this.messageChannel != null) {
        sendEventMessage(paramPluginResult);
      } else {
        this.pendingResume = paramPluginResult;
      } 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\CoreAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */