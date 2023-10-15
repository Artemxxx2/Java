package org.apache.cordova.engine;

import android.content.Intent;
import android.webkit.ValueCallback;
import org.apache.cordova.CordovaPlugin;

class null extends CordovaPlugin {
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: iload_2
    //   1: iconst_m1
    //   2: if_icmpne -> 147
    //   5: aload_3
    //   6: ifnull -> 147
    //   9: aload_3
    //   10: invokevirtual getClipData : ()Landroid/content/ClipData;
    //   13: ifnull -> 99
    //   16: aload_3
    //   17: invokevirtual getClipData : ()Landroid/content/ClipData;
    //   20: invokevirtual getItemCount : ()I
    //   23: istore_2
    //   24: iload_2
    //   25: anewarray android/net/Uri
    //   28: astore #4
    //   30: iconst_0
    //   31: istore_1
    //   32: aload #4
    //   34: astore #5
    //   36: iload_1
    //   37: iload_2
    //   38: if_icmpge -> 150
    //   41: aload #4
    //   43: iload_1
    //   44: aload_3
    //   45: invokevirtual getClipData : ()Landroid/content/ClipData;
    //   48: iload_1
    //   49: invokevirtual getItemAt : (I)Landroid/content/ClipData$Item;
    //   52: invokevirtual getUri : ()Landroid/net/Uri;
    //   55: aastore
    //   56: new java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #5
    //   65: aload #5
    //   67: ldc 'Receive file chooser URL: '
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #5
    //   75: aload #4
    //   77: iload_1
    //   78: aaload
    //   79: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 'SystemWebChromeClient'
    //   85: aload #5
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   93: iinc #1, 1
    //   96: goto -> 32
    //   99: aload_3
    //   100: invokevirtual getData : ()Landroid/net/Uri;
    //   103: ifnull -> 147
    //   106: iload_2
    //   107: aload_3
    //   108: invokestatic parseResult : (ILandroid/content/Intent;)[Landroid/net/Uri;
    //   111: astore #5
    //   113: new java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial <init> : ()V
    //   120: astore_3
    //   121: aload_3
    //   122: ldc 'Receive file chooser URL: '
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: aload #5
    //   131: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 'SystemWebChromeClient'
    //   137: aload_3
    //   138: invokevirtual toString : ()Ljava/lang/String;
    //   141: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   144: goto -> 150
    //   147: aconst_null
    //   148: astore #5
    //   150: aload_0
    //   151: getfield val$filePathsCallback : Landroid/webkit/ValueCallback;
    //   154: aload #5
    //   156: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
    //   161: return
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\engine\SystemWebChromeClient$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */