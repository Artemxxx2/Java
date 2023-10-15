package org.apache.cordova;

public class ResumeCallback extends CallbackContext {
  private final String TAG = "CordovaResumeCallback";
  
  private PluginManager pluginManager;
  
  private String serviceName;
  
  public ResumeCallback(String paramString, PluginManager paramPluginManager) {
    super("resumecallback", null);
    this.serviceName = paramString;
    this.pluginManager = paramPluginManager;
  }
  
  public void sendPluginResult(PluginResult paramPluginResult) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield finished : Z
    //   6: ifeq -> 54
    //   9: new java/lang/StringBuilder
    //   12: astore_2
    //   13: aload_2
    //   14: invokespecial <init> : ()V
    //   17: aload_2
    //   18: aload_0
    //   19: getfield serviceName : Ljava/lang/String;
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: ldc ' attempted to send a second callback to ResumeCallback\\nResult was: '
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual getMessage : ()Ljava/lang/String;
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 'CordovaResumeCallback'
    //   44: aload_2
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield finished : Z
    //   59: aload_0
    //   60: monitorexit
    //   61: new org/json/JSONObject
    //   64: dup
    //   65: invokespecial <init> : ()V
    //   68: astore_2
    //   69: new org/json/JSONObject
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc 'pluginServiceName'
    //   80: aload_0
    //   81: getfield serviceName : Ljava/lang/String;
    //   84: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload_3
    //   89: ldc 'pluginStatus'
    //   91: getstatic org/apache/cordova/PluginResult.StatusMessages : [Ljava/lang/String;
    //   94: aload_1
    //   95: invokevirtual getStatus : ()I
    //   98: aaload
    //   99: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   102: pop
    //   103: aload_2
    //   104: ldc 'action'
    //   106: ldc 'resume'
    //   108: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload_2
    //   113: ldc 'pendingResult'
    //   115: aload_3
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: goto -> 131
    //   123: astore_3
    //   124: ldc 'CordovaResumeCallback'
    //   126: ldc 'Unable to create resume object for Activity Result'
    //   128: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: new org/apache/cordova/PluginResult
    //   134: dup
    //   135: getstatic org/apache/cordova/PluginResult$Status.OK : Lorg/apache/cordova/PluginResult$Status;
    //   138: aload_2
    //   139: invokespecial <init> : (Lorg/apache/cordova/PluginResult$Status;Lorg/json/JSONObject;)V
    //   142: astore_2
    //   143: new java/util/ArrayList
    //   146: dup
    //   147: invokespecial <init> : ()V
    //   150: astore_3
    //   151: aload_3
    //   152: aload_2
    //   153: invokeinterface add : (Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload_3
    //   160: aload_1
    //   161: invokeinterface add : (Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_0
    //   168: getfield pluginManager : Lorg/apache/cordova/PluginManager;
    //   171: ldc 'CoreAndroid'
    //   173: invokevirtual getPlugin : (Ljava/lang/String;)Lorg/apache/cordova/CordovaPlugin;
    //   176: checkcast org/apache/cordova/CoreAndroid
    //   179: new org/apache/cordova/PluginResult
    //   182: dup
    //   183: getstatic org/apache/cordova/PluginResult$Status.OK : Lorg/apache/cordova/PluginResult$Status;
    //   186: aload_3
    //   187: invokespecial <init> : (Lorg/apache/cordova/PluginResult$Status;Ljava/util/List;)V
    //   190: invokevirtual sendResumeEvent : (Lorg/apache/cordova/PluginResult;)V
    //   193: return
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Exception table:
    //   from	to	target	type
    //   2	53	194	finally
    //   54	61	194	finally
    //   77	120	123	org/json/JSONException
    //   195	197	194	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\ResumeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */