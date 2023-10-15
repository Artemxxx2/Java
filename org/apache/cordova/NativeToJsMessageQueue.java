package org.apache.cordova;

import java.util.ArrayList;
import java.util.LinkedList;

public class NativeToJsMessageQueue {
  static final boolean DISABLE_EXEC_CHAINING = false;
  
  private static final boolean FORCE_ENCODE_USING_EVAL = false;
  
  private static final String LOG_TAG = "JsMessageQueue";
  
  private static int MAX_PAYLOAD_SIZE = 524288000;
  
  private BridgeMode activeBridgeMode;
  
  private ArrayList<BridgeMode> bridgeModes = new ArrayList<BridgeMode>();
  
  private boolean paused;
  
  private final LinkedList<JsMessage> queue = new LinkedList<JsMessage>();
  
  private int calculatePackedMessageLength(JsMessage paramJsMessage) {
    int i = paramJsMessage.calculateEncodedLength();
    return String.valueOf(i).length() + i + 1;
  }
  
  private void enqueueMessage(JsMessage paramJsMessage) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   6: ifnonnull -> 19
    //   9: ldc 'JsMessageQueue'
    //   11: ldc 'Dropping Native->JS message due to disabled bridge'
    //   13: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield queue : Ljava/util/LinkedList;
    //   23: aload_1
    //   24: invokevirtual add : (Ljava/lang/Object;)Z
    //   27: pop
    //   28: aload_0
    //   29: getfield paused : Z
    //   32: ifne -> 43
    //   35: aload_0
    //   36: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   39: aload_0
    //   40: invokevirtual onNativeToJsMessageAvailable : (Lorg/apache/cordova/NativeToJsMessageQueue;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	46	finally
    //   19	43	46	finally
    //   43	45	46	finally
    //   47	49	46	finally
  }
  
  private void packMessage(JsMessage paramJsMessage, StringBuilder paramStringBuilder) {
    paramStringBuilder.append(paramJsMessage.calculateEncodedLength());
    paramStringBuilder.append(' ');
    paramJsMessage.encodeAsMessage(paramStringBuilder);
  }
  
  public void addBridgeMode(BridgeMode paramBridgeMode) {
    this.bridgeModes.add(paramBridgeMode);
  }
  
  public void addJavaScript(String paramString) {
    enqueueMessage(new JsMessage(paramString));
  }
  
  public void addPluginResult(PluginResult paramPluginResult, String paramString) {
    boolean bool;
    if (paramString == null) {
      LOG.e("JsMessageQueue", "Got plugin result with no callbackId", new Throwable());
      return;
    } 
    if (paramPluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal()) {
      bool = true;
    } else {
      bool = false;
    } 
    boolean bool1 = paramPluginResult.getKeepCallback();
    if (bool && bool1)
      return; 
    enqueueMessage(new JsMessage(paramPluginResult, paramString));
  }
  
  public boolean isBridgeEnabled() {
    boolean bool;
    if (this.activeBridgeMode != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isEmpty() {
    return this.queue.isEmpty();
  }
  
  public String popAndEncode(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   6: ifnonnull -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   17: aload_0
    //   18: iload_1
    //   19: invokevirtual notifyOfFlush : (Lorg/apache/cordova/NativeToJsMessageQueue;Z)V
    //   22: aload_0
    //   23: getfield queue : Ljava/util/LinkedList;
    //   26: invokevirtual isEmpty : ()Z
    //   29: ifeq -> 36
    //   32: aload_0
    //   33: monitorexit
    //   34: aconst_null
    //   35: areturn
    //   36: aload_0
    //   37: getfield queue : Ljava/util/LinkedList;
    //   40: invokevirtual iterator : ()Ljava/util/Iterator;
    //   43: astore_2
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore #4
    //   49: iconst_0
    //   50: istore #5
    //   52: aload_2
    //   53: invokeinterface hasNext : ()Z
    //   58: ifeq -> 114
    //   61: aload_0
    //   62: aload_2
    //   63: invokeinterface next : ()Ljava/lang/Object;
    //   68: checkcast org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   71: invokespecial calculatePackedMessageLength : (Lorg/apache/cordova/NativeToJsMessageQueue$JsMessage;)I
    //   74: istore #6
    //   76: iload #4
    //   78: ifle -> 101
    //   81: iload #5
    //   83: iload #6
    //   85: iadd
    //   86: getstatic org/apache/cordova/NativeToJsMessageQueue.MAX_PAYLOAD_SIZE : I
    //   89: if_icmple -> 101
    //   92: getstatic org/apache/cordova/NativeToJsMessageQueue.MAX_PAYLOAD_SIZE : I
    //   95: ifle -> 101
    //   98: goto -> 114
    //   101: iload #5
    //   103: iload #6
    //   105: iadd
    //   106: istore #5
    //   108: iinc #4, 1
    //   111: goto -> 52
    //   114: new java/lang/StringBuilder
    //   117: astore_2
    //   118: aload_2
    //   119: iload #5
    //   121: invokespecial <init> : (I)V
    //   124: iload_3
    //   125: istore #5
    //   127: iload #5
    //   129: iload #4
    //   131: if_icmpge -> 155
    //   134: aload_0
    //   135: aload_0
    //   136: getfield queue : Ljava/util/LinkedList;
    //   139: invokevirtual removeFirst : ()Ljava/lang/Object;
    //   142: checkcast org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   145: aload_2
    //   146: invokespecial packMessage : (Lorg/apache/cordova/NativeToJsMessageQueue$JsMessage;Ljava/lang/StringBuilder;)V
    //   149: iinc #5, 1
    //   152: goto -> 127
    //   155: aload_0
    //   156: getfield queue : Ljava/util/LinkedList;
    //   159: invokevirtual isEmpty : ()Z
    //   162: ifne -> 172
    //   165: aload_2
    //   166: bipush #42
    //   168: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: astore_2
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_2
    //   180: areturn
    //   181: astore_2
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_2
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	181	finally
    //   13	34	181	finally
    //   36	44	181	finally
    //   52	76	181	finally
    //   81	98	181	finally
    //   114	124	181	finally
    //   134	149	181	finally
    //   155	172	181	finally
    //   172	179	181	finally
    //   182	184	181	finally
  }
  
  public String popAndEncodeAsJs() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield queue : Ljava/util/LinkedList;
    //   6: invokevirtual size : ()I
    //   9: ifne -> 16
    //   12: aload_0
    //   13: monitorexit
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield queue : Ljava/util/LinkedList;
    //   20: invokevirtual iterator : ()Ljava/util/Iterator;
    //   23: astore_1
    //   24: iconst_0
    //   25: istore_2
    //   26: iconst_0
    //   27: istore_3
    //   28: iconst_0
    //   29: istore #4
    //   31: aload_1
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 94
    //   40: aload_1
    //   41: invokeinterface next : ()Ljava/lang/Object;
    //   46: checkcast org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   49: invokevirtual calculateEncodedLength : ()I
    //   52: bipush #50
    //   54: iadd
    //   55: istore #5
    //   57: iload_3
    //   58: ifle -> 81
    //   61: iload #4
    //   63: iload #5
    //   65: iadd
    //   66: getstatic org/apache/cordova/NativeToJsMessageQueue.MAX_PAYLOAD_SIZE : I
    //   69: if_icmple -> 81
    //   72: getstatic org/apache/cordova/NativeToJsMessageQueue.MAX_PAYLOAD_SIZE : I
    //   75: ifle -> 81
    //   78: goto -> 94
    //   81: iload #4
    //   83: iload #5
    //   85: iadd
    //   86: istore #4
    //   88: iinc #3, 1
    //   91: goto -> 31
    //   94: iload_3
    //   95: aload_0
    //   96: getfield queue : Ljava/util/LinkedList;
    //   99: invokevirtual size : ()I
    //   102: if_icmpne -> 111
    //   105: iconst_1
    //   106: istore #5
    //   108: goto -> 114
    //   111: iconst_0
    //   112: istore #5
    //   114: new java/lang/StringBuilder
    //   117: astore_1
    //   118: iload #5
    //   120: ifeq -> 129
    //   123: iconst_0
    //   124: istore #6
    //   126: goto -> 133
    //   129: bipush #100
    //   131: istore #6
    //   133: aload_1
    //   134: iload #4
    //   136: iload #6
    //   138: iadd
    //   139: invokespecial <init> : (I)V
    //   142: iload_2
    //   143: istore #4
    //   145: iload #4
    //   147: iload_3
    //   148: if_icmpge -> 211
    //   151: aload_0
    //   152: getfield queue : Ljava/util/LinkedList;
    //   155: invokevirtual removeFirst : ()Ljava/lang/Object;
    //   158: checkcast org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   161: astore #7
    //   163: iload #5
    //   165: ifeq -> 185
    //   168: iload #4
    //   170: iconst_1
    //   171: iadd
    //   172: iload_3
    //   173: if_icmpne -> 185
    //   176: aload #7
    //   178: aload_1
    //   179: invokevirtual encodeAsJsMessage : (Ljava/lang/StringBuilder;)V
    //   182: goto -> 205
    //   185: aload_1
    //   186: ldc 'try{'
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #7
    //   194: aload_1
    //   195: invokevirtual encodeAsJsMessage : (Ljava/lang/StringBuilder;)V
    //   198: aload_1
    //   199: ldc '}finally{'
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: iinc #4, 1
    //   208: goto -> 145
    //   211: iload #5
    //   213: istore #4
    //   215: iload #5
    //   217: ifne -> 231
    //   220: aload_1
    //   221: ldc 'window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);'
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: iload #5
    //   229: istore #4
    //   231: iload #4
    //   233: iload_3
    //   234: if_icmpge -> 250
    //   237: aload_1
    //   238: bipush #125
    //   240: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: iinc #4, 1
    //   247: goto -> 231
    //   250: aload_1
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: astore_1
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_1
    //   258: areturn
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	259	finally
    //   16	24	259	finally
    //   31	57	259	finally
    //   61	78	259	finally
    //   94	105	259	finally
    //   114	118	259	finally
    //   133	142	259	finally
    //   151	163	259	finally
    //   176	182	259	finally
    //   185	205	259	finally
    //   220	227	259	finally
    //   237	244	259	finally
    //   250	257	259	finally
    //   260	262	259	finally
  }
  
  public void reset() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield queue : Ljava/util/LinkedList;
    //   6: invokevirtual clear : ()V
    //   9: aload_0
    //   10: iconst_m1
    //   11: invokevirtual setBridgeMode : (I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	17	finally
    //   18	20	17	finally
  }
  
  public void setBridgeMode(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmplt -> 146
    //   5: iload_1
    //   6: aload_0
    //   7: getfield bridgeModes : Ljava/util/ArrayList;
    //   10: invokevirtual size : ()I
    //   13: if_icmplt -> 19
    //   16: goto -> 146
    //   19: iload_1
    //   20: ifge -> 28
    //   23: aconst_null
    //   24: astore_2
    //   25: goto -> 40
    //   28: aload_0
    //   29: getfield bridgeModes : Ljava/util/ArrayList;
    //   32: iload_1
    //   33: invokevirtual get : (I)Ljava/lang/Object;
    //   36: checkcast org/apache/cordova/NativeToJsMessageQueue$BridgeMode
    //   39: astore_2
    //   40: aload_2
    //   41: aload_0
    //   42: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   45: if_acmpeq -> 176
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore_3
    //   56: aload_3
    //   57: ldc 'Set native->JS mode to '
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: ifnonnull -> 74
    //   67: ldc 'null'
    //   69: astore #4
    //   71: goto -> 83
    //   74: aload_2
    //   75: invokevirtual getClass : ()Ljava/lang/Class;
    //   78: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   81: astore #4
    //   83: aload_3
    //   84: aload #4
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 'JsMessageQueue'
    //   92: aload_3
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: aload_2
    //   103: putfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   106: aload_2
    //   107: ifnull -> 136
    //   110: aload_2
    //   111: invokevirtual reset : ()V
    //   114: aload_0
    //   115: getfield paused : Z
    //   118: ifne -> 136
    //   121: aload_0
    //   122: getfield queue : Ljava/util/LinkedList;
    //   125: invokevirtual isEmpty : ()Z
    //   128: ifne -> 136
    //   131: aload_2
    //   132: aload_0
    //   133: invokevirtual onNativeToJsMessageAvailable : (Lorg/apache/cordova/NativeToJsMessageQueue;)V
    //   136: aload_0
    //   137: monitorexit
    //   138: goto -> 176
    //   141: astore_2
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: new java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc 'Invalid NativeToJsBridgeMode: '
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: iload_1
    //   163: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 'JsMessageQueue'
    //   169: aload_2
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: return
    // Exception table:
    //   from	to	target	type
    //   101	106	141	finally
    //   110	136	141	finally
    //   136	138	141	finally
    //   142	144	141	finally
  }
  
  public void setPaused(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield paused : Z
    //   4: ifeq -> 25
    //   7: iload_1
    //   8: ifeq -> 25
    //   11: ldc 'JsMessageQueue'
    //   13: ldc 'nested call to setPaused detected.'
    //   15: new java/lang/Throwable
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   25: aload_0
    //   26: iload_1
    //   27: putfield paused : Z
    //   30: iload_1
    //   31: ifne -> 71
    //   34: aload_0
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield queue : Ljava/util/LinkedList;
    //   40: invokevirtual isEmpty : ()Z
    //   43: ifne -> 61
    //   46: aload_0
    //   47: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   50: ifnull -> 61
    //   53: aload_0
    //   54: getfield activeBridgeMode : Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   57: aload_0
    //   58: invokevirtual onNativeToJsMessageAvailable : (Lorg/apache/cordova/NativeToJsMessageQueue;)V
    //   61: aload_0
    //   62: monitorexit
    //   63: goto -> 71
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: return
    // Exception table:
    //   from	to	target	type
    //   36	61	66	finally
    //   61	63	66	finally
    //   67	69	66	finally
  }
  
  public static abstract class BridgeMode {
    public void notifyOfFlush(NativeToJsMessageQueue param1NativeToJsMessageQueue, boolean param1Boolean) {}
    
    public abstract void onNativeToJsMessageAvailable(NativeToJsMessageQueue param1NativeToJsMessageQueue);
    
    public void reset() {}
  }
  
  public static class EvalBridgeMode extends BridgeMode {
    private final CordovaInterface cordova;
    
    private final CordovaWebViewEngine engine;
    
    public EvalBridgeMode(CordovaWebViewEngine param1CordovaWebViewEngine, CordovaInterface param1CordovaInterface) {
      this.engine = param1CordovaWebViewEngine;
      this.cordova = param1CordovaInterface;
    }
    
    public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              String str = queue.popAndEncodeAsJs();
              if (str != null)
                NativeToJsMessageQueue.EvalBridgeMode.this.engine.evaluateJavascript(str, null); 
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      String str = queue.popAndEncodeAsJs();
      if (str != null)
        this.this$0.engine.evaluateJavascript(str, null); 
    }
  }
  
  private static class JsMessage {
    final String jsPayloadOrCallbackId;
    
    final PluginResult pluginResult;
    
    JsMessage(String param1String) {
      if (param1String != null) {
        this.jsPayloadOrCallbackId = param1String;
        this.pluginResult = null;
        return;
      } 
      throw new NullPointerException();
    }
    
    JsMessage(PluginResult param1PluginResult, String param1String) {
      if (param1String != null && param1PluginResult != null) {
        this.jsPayloadOrCallbackId = param1String;
        this.pluginResult = param1PluginResult;
        return;
      } 
      throw new NullPointerException();
    }
    
    static int calculateEncodedLengthHelper(PluginResult param1PluginResult) {
      int i = param1PluginResult.getMessageType();
      if (i != 1) {
        byte b;
        switch (i) {
          default:
            return param1PluginResult.getMessage().length();
          case 8:
            b = 0;
            i = 1;
            while (b < param1PluginResult.getMultipartMessagesSize()) {
              int j = calculateEncodedLengthHelper(param1PluginResult.getMultipartMessage(b));
              i += String.valueOf(j).length() + 1 + j;
              b++;
            } 
            return i;
          case 7:
            return param1PluginResult.getMessage().length() + 1;
          case 6:
            return param1PluginResult.getMessage().length() + 1;
          case 4:
          case 5:
            return 1;
          case 3:
            break;
        } 
        return param1PluginResult.getMessage().length() + 1;
      } 
      return param1PluginResult.getStrMessage().length() + 1;
    }
    
    static void encodeAsMessageHelper(StringBuilder param1StringBuilder, PluginResult param1PluginResult) {
      int i = param1PluginResult.getMessageType();
      if (i != 1) {
        byte b = 0;
        switch (i) {
          default:
            param1StringBuilder.append(param1PluginResult.getMessage());
            return;
          case 8:
            param1StringBuilder.append('M');
            while (b < param1PluginResult.getMultipartMessagesSize()) {
              PluginResult pluginResult = param1PluginResult.getMultipartMessage(b);
              param1StringBuilder.append(String.valueOf(calculateEncodedLengthHelper(pluginResult)));
              param1StringBuilder.append(' ');
              encodeAsMessageHelper(param1StringBuilder, pluginResult);
              b++;
            } 
            return;
          case 7:
            param1StringBuilder.append('S');
            param1StringBuilder.append(param1PluginResult.getMessage());
            return;
          case 6:
            param1StringBuilder.append('A');
            param1StringBuilder.append(param1PluginResult.getMessage());
            return;
          case 5:
            param1StringBuilder.append('N');
            return;
          case 4:
            param1StringBuilder.append(param1PluginResult.getMessage().charAt(0));
            return;
          case 3:
            break;
        } 
        param1StringBuilder.append('n');
        param1StringBuilder.append(param1PluginResult.getMessage());
      } else {
        param1StringBuilder.append('s');
        param1StringBuilder.append(param1PluginResult.getStrMessage());
      } 
    }
    
    void buildJsMessage(StringBuilder param1StringBuilder) {
      int i;
      byte b;
      switch (this.pluginResult.getMessageType()) {
        default:
          param1StringBuilder.append(this.pluginResult.getMessage());
          return;
        case 8:
          i = this.pluginResult.getMultipartMessagesSize();
          for (b = 0; b < i; b++) {
            (new JsMessage(this.pluginResult.getMultipartMessage(b), this.jsPayloadOrCallbackId)).buildJsMessage(param1StringBuilder);
            if (b < i - 1)
              param1StringBuilder.append(","); 
          } 
          return;
        case 7:
          param1StringBuilder.append("atob('");
          param1StringBuilder.append(this.pluginResult.getMessage());
          param1StringBuilder.append("')");
          return;
        case 6:
          param1StringBuilder.append("cordova.require('cordova/base64').toArrayBuffer('");
          param1StringBuilder.append(this.pluginResult.getMessage());
          param1StringBuilder.append("')");
          return;
        case 5:
          break;
      } 
      param1StringBuilder.append("null");
    }
    
    int calculateEncodedLength() {
      PluginResult pluginResult = this.pluginResult;
      return (pluginResult == null) ? (this.jsPayloadOrCallbackId.length() + 1) : (String.valueOf(pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1 + calculateEncodedLengthHelper(this.pluginResult));
    }
    
    void encodeAsJsMessage(StringBuilder param1StringBuilder) {
      PluginResult pluginResult = this.pluginResult;
      if (pluginResult == null) {
        param1StringBuilder.append(this.jsPayloadOrCallbackId);
      } else {
        boolean bool;
        int i = pluginResult.getStatus();
        if (i == PluginResult.Status.OK.ordinal() || i == PluginResult.Status.NO_RESULT.ordinal()) {
          bool = true;
        } else {
          bool = false;
        } 
        param1StringBuilder.append("cordova.callbackFromNative('");
        param1StringBuilder.append(this.jsPayloadOrCallbackId);
        param1StringBuilder.append("',");
        param1StringBuilder.append(bool);
        param1StringBuilder.append(",");
        param1StringBuilder.append(i);
        param1StringBuilder.append(",[");
        buildJsMessage(param1StringBuilder);
        param1StringBuilder.append("],");
        param1StringBuilder.append(this.pluginResult.getKeepCallback());
        param1StringBuilder.append(");");
      } 
    }
    
    void encodeAsMessage(StringBuilder param1StringBuilder) {
      int k;
      PluginResult pluginResult = this.pluginResult;
      if (pluginResult == null) {
        param1StringBuilder.append('J');
        param1StringBuilder.append(this.jsPayloadOrCallbackId);
        return;
      } 
      int i = pluginResult.getStatus();
      int j = PluginResult.Status.NO_RESULT.ordinal();
      boolean bool = true;
      if (i == j) {
        j = 1;
      } else {
        j = 0;
      } 
      if (i != PluginResult.Status.OK.ordinal())
        bool = false; 
      boolean bool1 = this.pluginResult.getKeepCallback();
      if (j != 0 || bool) {
        j = 83;
        k = j;
      } else {
        j = 70;
        k = j;
      } 
      param1StringBuilder.append(k);
      if (bool1) {
        j = 49;
        k = j;
      } else {
        j = 48;
        k = j;
      } 
      param1StringBuilder.append(k);
      param1StringBuilder.append(i);
      param1StringBuilder.append(' ');
      param1StringBuilder.append(this.jsPayloadOrCallbackId);
      param1StringBuilder.append(' ');
      encodeAsMessageHelper(param1StringBuilder, this.pluginResult);
    }
  }
  
  public static class LoadUrlBridgeMode extends BridgeMode {
    private final CordovaInterface cordova;
    
    private final CordovaWebViewEngine engine;
    
    public LoadUrlBridgeMode(CordovaWebViewEngine param1CordovaWebViewEngine, CordovaInterface param1CordovaInterface) {
      this.engine = param1CordovaWebViewEngine;
      this.cordova = param1CordovaInterface;
    }
    
    public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
      this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              String str = queue.popAndEncodeAsJs();
              if (str != null) {
                CordovaWebViewEngine cordovaWebViewEngine = NativeToJsMessageQueue.LoadUrlBridgeMode.this.engine;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("javascript:");
                stringBuilder.append(str);
                cordovaWebViewEngine.loadUrl(stringBuilder.toString(), false);
              } 
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      String str = queue.popAndEncodeAsJs();
      if (str != null) {
        CordovaWebViewEngine cordovaWebViewEngine = this.this$0.engine;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(str);
        cordovaWebViewEngine.loadUrl(stringBuilder.toString(), false);
      } 
    }
  }
  
  public static class NoOpBridgeMode extends BridgeMode {
    public void onNativeToJsMessageAvailable(NativeToJsMessageQueue param1NativeToJsMessageQueue) {}
  }
  
  public static class OnlineEventsBridgeMode extends BridgeMode {
    private final OnlineEventsBridgeModeDelegate delegate;
    
    private boolean ignoreNextFlush;
    
    private boolean online;
    
    public OnlineEventsBridgeMode(OnlineEventsBridgeModeDelegate param1OnlineEventsBridgeModeDelegate) {
      this.delegate = param1OnlineEventsBridgeModeDelegate;
    }
    
    public void notifyOfFlush(NativeToJsMessageQueue param1NativeToJsMessageQueue, boolean param1Boolean) {
      if (param1Boolean && !this.ignoreNextFlush)
        this.online ^= 0x1; 
    }
    
    public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue queue) {
      this.delegate.runOnUiThread(new Runnable() {
            public void run() {
              if (!queue.isEmpty()) {
                NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
                NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online);
              } 
            }
          });
    }
    
    public void reset() {
      this.delegate.runOnUiThread(new Runnable() {
            public void run() {
              NativeToJsMessageQueue.OnlineEventsBridgeMode.access$102(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
              NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, true);
              NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(true);
            }
          });
    }
    
    public static interface OnlineEventsBridgeModeDelegate {
      void runOnUiThread(Runnable param2Runnable);
      
      void setNetworkAvailable(boolean param2Boolean);
    }
  }
  
  class null implements Runnable {
    public void run() {
      NativeToJsMessageQueue.OnlineEventsBridgeMode.access$102(this.this$0, false);
      NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(this.this$0, true);
      this.this$0.delegate.setNetworkAvailable(true);
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (!queue.isEmpty()) {
        NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(this.this$0, false);
        this.this$0.delegate.setNetworkAvailable(this.this$0.online);
      } 
    }
  }
  
  public static interface OnlineEventsBridgeModeDelegate {
    void runOnUiThread(Runnable param1Runnable);
    
    void setNetworkAvailable(boolean param1Boolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\NativeToJsMessageQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */