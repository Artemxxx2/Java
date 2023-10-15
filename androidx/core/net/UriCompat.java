package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;

public final class UriCompat {
  @NonNull
  public static String toSafeString(@NonNull Uri paramUri) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getScheme : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual getSchemeSpecificPart : ()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_3
    //   12: aload_1
    //   13: ifnull -> 313
    //   16: aload_1
    //   17: ldc 'tel'
    //   19: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   22: ifne -> 214
    //   25: aload_1
    //   26: ldc 'sip'
    //   28: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   31: ifne -> 214
    //   34: aload_1
    //   35: ldc 'sms'
    //   37: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   40: ifne -> 214
    //   43: aload_1
    //   44: ldc 'smsto'
    //   46: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   49: ifne -> 214
    //   52: aload_1
    //   53: ldc 'mailto'
    //   55: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   58: ifne -> 214
    //   61: aload_1
    //   62: ldc 'nfc'
    //   64: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   67: ifeq -> 73
    //   70: goto -> 214
    //   73: aload_1
    //   74: ldc 'http'
    //   76: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   79: ifne -> 111
    //   82: aload_1
    //   83: ldc 'https'
    //   85: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   88: ifne -> 111
    //   91: aload_1
    //   92: ldc 'ftp'
    //   94: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   97: ifne -> 111
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: ldc 'rtsp'
    //   105: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   108: ifeq -> 313
    //   111: new java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: astore_2
    //   119: aload_2
    //   120: ldc '//'
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_0
    //   127: invokevirtual getHost : ()Ljava/lang/String;
    //   130: ifnull -> 141
    //   133: aload_0
    //   134: invokevirtual getHost : ()Ljava/lang/String;
    //   137: astore_3
    //   138: goto -> 144
    //   141: ldc ''
    //   143: astore_3
    //   144: aload_2
    //   145: aload_3
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: invokevirtual getPort : ()I
    //   154: iconst_m1
    //   155: if_icmpeq -> 190
    //   158: new java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore_3
    //   166: aload_3
    //   167: ldc ':'
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_3
    //   174: aload_0
    //   175: invokevirtual getPort : ()I
    //   178: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: invokevirtual toString : ()Ljava/lang/String;
    //   186: astore_0
    //   187: goto -> 193
    //   190: ldc ''
    //   192: astore_0
    //   193: aload_2
    //   194: aload_0
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: ldc '/...'
    //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: astore_3
    //   211: goto -> 313
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: bipush #64
    //   220: invokespecial <init> : (I)V
    //   223: astore_0
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_0
    //   231: bipush #58
    //   233: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_2
    //   238: ifnull -> 308
    //   241: iconst_0
    //   242: istore #4
    //   244: iload #4
    //   246: aload_2
    //   247: invokevirtual length : ()I
    //   250: if_icmpge -> 308
    //   253: aload_2
    //   254: iload #4
    //   256: invokevirtual charAt : (I)C
    //   259: istore #5
    //   261: iload #5
    //   263: bipush #45
    //   265: if_icmpeq -> 295
    //   268: iload #5
    //   270: bipush #64
    //   272: if_icmpeq -> 295
    //   275: iload #5
    //   277: bipush #46
    //   279: if_icmpne -> 285
    //   282: goto -> 295
    //   285: aload_0
    //   286: bipush #120
    //   288: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: goto -> 302
    //   295: aload_0
    //   296: iload #5
    //   298: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: iinc #4, 1
    //   305: goto -> 244
    //   308: aload_0
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: areturn
    //   313: new java/lang/StringBuilder
    //   316: dup
    //   317: bipush #64
    //   319: invokespecial <init> : (I)V
    //   322: astore_0
    //   323: aload_1
    //   324: ifnull -> 340
    //   327: aload_0
    //   328: aload_1
    //   329: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: bipush #58
    //   336: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: ifnull -> 350
    //   344: aload_0
    //   345: aload_3
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_0
    //   351: invokevirtual toString : ()Ljava/lang/String;
    //   354: areturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\net\UriCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */