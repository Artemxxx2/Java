package org.apache.cordova;

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

class URLPattern {
  public Pattern host;
  
  public Pattern path;
  
  public Integer port;
  
  public Pattern scheme;
  
  public URLPattern(String paramString1, String paramString2, String paramString3, String paramString4) throws MalformedURLException {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_1
    //   5: ifnull -> 37
    //   8: ldc '*'
    //   10: aload_1
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: ifeq -> 20
    //   17: goto -> 37
    //   20: aload_0
    //   21: aload_0
    //   22: aload_1
    //   23: iconst_0
    //   24: invokespecial regexFromPattern : (Ljava/lang/String;Z)Ljava/lang/String;
    //   27: iconst_2
    //   28: invokestatic compile : (Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   31: putfield scheme : Ljava/util/regex/Pattern;
    //   34: goto -> 42
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield scheme : Ljava/util/regex/Pattern;
    //   42: ldc '*'
    //   44: aload_2
    //   45: invokevirtual equals : (Ljava/lang/Object;)Z
    //   48: ifeq -> 59
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield host : Ljava/util/regex/Pattern;
    //   56: goto -> 127
    //   59: aload_2
    //   60: ldc '*.'
    //   62: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   65: ifeq -> 113
    //   68: new java/lang/StringBuilder
    //   71: astore_1
    //   72: aload_1
    //   73: invokespecial <init> : ()V
    //   76: aload_1
    //   77: ldc '([a-z0-9.-]*\.)?'
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: aload_0
    //   85: aload_2
    //   86: iconst_2
    //   87: invokevirtual substring : (I)Ljava/lang/String;
    //   90: iconst_0
    //   91: invokespecial regexFromPattern : (Ljava/lang/String;Z)Ljava/lang/String;
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: iconst_2
    //   104: invokestatic compile : (Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   107: putfield host : Ljava/util/regex/Pattern;
    //   110: goto -> 127
    //   113: aload_0
    //   114: aload_0
    //   115: aload_2
    //   116: iconst_0
    //   117: invokespecial regexFromPattern : (Ljava/lang/String;Z)Ljava/lang/String;
    //   120: iconst_2
    //   121: invokestatic compile : (Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   124: putfield host : Ljava/util/regex/Pattern;
    //   127: aload_3
    //   128: ifnull -> 159
    //   131: ldc '*'
    //   133: aload_3
    //   134: invokevirtual equals : (Ljava/lang/Object;)Z
    //   137: ifeq -> 143
    //   140: goto -> 159
    //   143: aload_0
    //   144: aload_3
    //   145: bipush #10
    //   147: invokestatic parseInt : (Ljava/lang/String;I)I
    //   150: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   153: putfield port : Ljava/lang/Integer;
    //   156: goto -> 164
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield port : Ljava/lang/Integer;
    //   164: aload #4
    //   166: ifnull -> 199
    //   169: ldc '/*'
    //   171: aload #4
    //   173: invokevirtual equals : (Ljava/lang/Object;)Z
    //   176: ifeq -> 182
    //   179: goto -> 199
    //   182: aload_0
    //   183: aload_0
    //   184: aload #4
    //   186: iconst_1
    //   187: invokespecial regexFromPattern : (Ljava/lang/String;Z)Ljava/lang/String;
    //   190: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   193: putfield path : Ljava/util/regex/Pattern;
    //   196: goto -> 204
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield path : Ljava/util/regex/Pattern;
    //   204: return
    //   205: astore_1
    //   206: new java/net/MalformedURLException
    //   209: dup
    //   210: ldc 'Port must be a number'
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: athrow
    // Exception table:
    //   from	to	target	type
    //   8	17	205	java/lang/NumberFormatException
    //   20	34	205	java/lang/NumberFormatException
    //   37	42	205	java/lang/NumberFormatException
    //   42	56	205	java/lang/NumberFormatException
    //   59	110	205	java/lang/NumberFormatException
    //   113	127	205	java/lang/NumberFormatException
    //   131	140	205	java/lang/NumberFormatException
    //   143	156	205	java/lang/NumberFormatException
    //   159	164	205	java/lang/NumberFormatException
    //   169	179	205	java/lang/NumberFormatException
    //   182	196	205	java/lang/NumberFormatException
    //   199	204	205	java/lang/NumberFormatException
  }
  
  private String regexFromPattern(String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c == '*' && paramBoolean) {
        stringBuilder.append(".");
      } else if ("\\.[]{}()^$?+|".indexOf(c) > -1) {
        stringBuilder.append('\\');
      } 
      stringBuilder.append(c);
    } 
    return stringBuilder.toString();
  }
  
  public boolean matches(Uri paramUri) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield scheme : Ljava/util/regex/Pattern;
    //   6: ifnull -> 28
    //   9: iload_2
    //   10: istore_3
    //   11: aload_0
    //   12: getfield scheme : Ljava/util/regex/Pattern;
    //   15: aload_1
    //   16: invokevirtual getScheme : ()Ljava/lang/String;
    //   19: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   22: invokevirtual matches : ()Z
    //   25: ifeq -> 112
    //   28: aload_0
    //   29: getfield host : Ljava/util/regex/Pattern;
    //   32: ifnull -> 54
    //   35: iload_2
    //   36: istore_3
    //   37: aload_0
    //   38: getfield host : Ljava/util/regex/Pattern;
    //   41: aload_1
    //   42: invokevirtual getHost : ()Ljava/lang/String;
    //   45: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   48: invokevirtual matches : ()Z
    //   51: ifeq -> 112
    //   54: aload_0
    //   55: getfield port : Ljava/lang/Integer;
    //   58: ifnull -> 80
    //   61: iload_2
    //   62: istore_3
    //   63: aload_0
    //   64: getfield port : Ljava/lang/Integer;
    //   67: aload_1
    //   68: invokevirtual getPort : ()I
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: invokevirtual equals : (Ljava/lang/Object;)Z
    //   77: ifeq -> 112
    //   80: aload_0
    //   81: getfield path : Ljava/util/regex/Pattern;
    //   84: ifnull -> 110
    //   87: aload_0
    //   88: getfield path : Ljava/util/regex/Pattern;
    //   91: aload_1
    //   92: invokevirtual getPath : ()Ljava/lang/String;
    //   95: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   98: invokevirtual matches : ()Z
    //   101: istore #4
    //   103: iload_2
    //   104: istore_3
    //   105: iload #4
    //   107: ifeq -> 112
    //   110: iconst_1
    //   111: istore_3
    //   112: iload_3
    //   113: ireturn
    //   114: astore_1
    //   115: ldc 'Whitelist'
    //   117: aload_1
    //   118: invokevirtual toString : ()Ljava/lang/String;
    //   121: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   124: iconst_0
    //   125: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	9	114	java/lang/Exception
    //   11	28	114	java/lang/Exception
    //   28	35	114	java/lang/Exception
    //   37	54	114	java/lang/Exception
    //   54	61	114	java/lang/Exception
    //   63	80	114	java/lang/Exception
    //   80	103	114	java/lang/Exception
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\Whitelist$URLPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */