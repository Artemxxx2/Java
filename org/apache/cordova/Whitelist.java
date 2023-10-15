package org.apache.cordova;

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Whitelist {
  public static final String TAG = "Whitelist";
  
  private ArrayList<URLPattern> whiteList = new ArrayList<URLPattern>();
  
  public void addWhiteListEntry(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield whiteList : Ljava/util/ArrayList;
    //   4: ifnull -> 235
    //   7: aload_1
    //   8: ldc '*'
    //   10: invokevirtual compareTo : (Ljava/lang/String;)I
    //   13: ifne -> 31
    //   16: ldc 'Whitelist'
    //   18: ldc 'Unlimited access to network resources'
    //   20: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield whiteList : Ljava/util/ArrayList;
    //   28: goto -> 235
    //   31: ldc '^((\*|[A-Za-z-]+):(//)?)?(\*|((\*\.)?[^*/:]+))?(:(\d+))?(/.*)?'
    //   33: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   36: aload_1
    //   37: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual matches : ()Z
    //   45: ifeq -> 235
    //   48: aload_3
    //   49: iconst_2
    //   50: invokevirtual group : (I)Ljava/lang/String;
    //   53: astore #4
    //   55: aload_3
    //   56: iconst_4
    //   57: invokevirtual group : (I)Ljava/lang/String;
    //   60: astore #5
    //   62: ldc 'file'
    //   64: aload #4
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifne -> 86
    //   72: aload #5
    //   74: astore #6
    //   76: ldc 'content'
    //   78: aload #4
    //   80: invokevirtual equals : (Ljava/lang/Object;)Z
    //   83: ifeq -> 99
    //   86: aload #5
    //   88: astore #6
    //   90: aload #5
    //   92: ifnonnull -> 99
    //   95: ldc '*'
    //   97: astore #6
    //   99: aload_3
    //   100: bipush #8
    //   102: invokevirtual group : (I)Ljava/lang/String;
    //   105: astore #5
    //   107: aload_3
    //   108: bipush #9
    //   110: invokevirtual group : (I)Ljava/lang/String;
    //   113: astore_3
    //   114: aload #4
    //   116: ifnonnull -> 184
    //   119: aload_0
    //   120: getfield whiteList : Ljava/util/ArrayList;
    //   123: astore #7
    //   125: new org/apache/cordova/Whitelist$URLPattern
    //   128: astore #4
    //   130: aload #4
    //   132: ldc 'http'
    //   134: aload #6
    //   136: aload #5
    //   138: aload_3
    //   139: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload #7
    //   144: aload #4
    //   146: invokevirtual add : (Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload_0
    //   151: getfield whiteList : Ljava/util/ArrayList;
    //   154: astore #7
    //   156: new org/apache/cordova/Whitelist$URLPattern
    //   159: astore #4
    //   161: aload #4
    //   163: ldc 'https'
    //   165: aload #6
    //   167: aload #5
    //   169: aload_3
    //   170: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload #7
    //   175: aload #4
    //   177: invokevirtual add : (Ljava/lang/Object;)Z
    //   180: pop
    //   181: goto -> 235
    //   184: aload_0
    //   185: getfield whiteList : Ljava/util/ArrayList;
    //   188: astore #7
    //   190: new org/apache/cordova/Whitelist$URLPattern
    //   193: astore #8
    //   195: aload #8
    //   197: aload #4
    //   199: aload #6
    //   201: aload #5
    //   203: aload_3
    //   204: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload #7
    //   209: aload #8
    //   211: invokevirtual add : (Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -> 235
    //   218: astore #6
    //   220: ldc 'Whitelist'
    //   222: ldc 'Failed to add origin %s'
    //   224: iconst_1
    //   225: anewarray java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_1
    //   231: aastore
    //   232: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: return
    // Exception table:
    //   from	to	target	type
    //   7	28	218	java/lang/Exception
    //   31	72	218	java/lang/Exception
    //   76	86	218	java/lang/Exception
    //   99	114	218	java/lang/Exception
    //   119	181	218	java/lang/Exception
    //   184	215	218	java/lang/Exception
  }
  
  public boolean isUrlWhiteListed(String paramString) {
    if (this.whiteList == null)
      return true; 
    Uri uri = Uri.parse(paramString);
    Iterator<URLPattern> iterator = this.whiteList.iterator();
    while (iterator.hasNext()) {
      if (((URLPattern)iterator.next()).matches(uri))
        return true; 
    } 
    return false;
  }
  
  private static class URLPattern {
    public Pattern host;
    
    public Pattern path;
    
    public Integer port;
    
    public Pattern scheme;
    
    public URLPattern(String param1String1, String param1String2, String param1String3, String param1String4) throws MalformedURLException {
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
    
    private String regexFromPattern(String param1String, boolean param1Boolean) {
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b = 0; b < param1String.length(); b++) {
        char c = param1String.charAt(b);
        if (c == '*' && param1Boolean) {
          stringBuilder.append(".");
        } else if ("\\.[]{}()^$?+|".indexOf(c) > -1) {
          stringBuilder.append('\\');
        } 
        stringBuilder.append(c);
      } 
      return stringBuilder.toString();
    }
    
    public boolean matches(Uri param1Uri) {
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
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\org\apache\cordova\Whitelist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */