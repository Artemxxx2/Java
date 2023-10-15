package com.google.android.gms.dynamite;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

public final class zzb {
  @GuardedBy("DynamiteLoaderV2ClassLoader.class")
  @Nullable
  private static volatile ClassLoader zza;
  
  @GuardedBy("DynamiteLoaderV2ClassLoader.class")
  @Nullable
  private static volatile Thread zzb;
  
  @Nullable
  public static ClassLoader zza() {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/zzb
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/zzb.zza : Ljava/lang/ClassLoader;
    //   6: ifnonnull -> 15
    //   9: invokestatic zzb : ()Ljava/lang/ClassLoader;
    //   12: putstatic com/google/android/gms/dynamite/zzb.zza : Ljava/lang/ClassLoader;
    //   15: getstatic com/google/android/gms/dynamite/zzb.zza : Ljava/lang/ClassLoader;
    //   18: astore_0
    //   19: ldc com/google/android/gms/dynamite/zzb
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: ldc com/google/android/gms/dynamite/zzb
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	24	finally
    //   15	19	24	finally
  }
  
  @Nullable
  private static ClassLoader zzb() {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/zzb
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/zzb.zzb : Ljava/lang/Thread;
    //   6: astore_0
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: ifnonnull -> 35
    //   13: invokestatic zzc : ()Ljava/lang/Thread;
    //   16: putstatic com/google/android/gms/dynamite/zzb.zzb : Ljava/lang/Thread;
    //   19: getstatic com/google/android/gms/dynamite/zzb.zzb : Ljava/lang/Thread;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull -> 30
    //   27: goto -> 35
    //   30: ldc com/google/android/gms/dynamite/zzb
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: getstatic com/google/android/gms/dynamite/zzb.zzb : Ljava/lang/Thread;
    //   38: astore_2
    //   39: aload_2
    //   40: monitorenter
    //   41: getstatic com/google/android/gms/dynamite/zzb.zzb : Ljava/lang/Thread;
    //   44: invokevirtual getContextClassLoader : ()Ljava/lang/ClassLoader;
    //   47: astore_0
    //   48: aload_0
    //   49: astore_1
    //   50: goto -> 94
    //   53: astore_1
    //   54: goto -> 101
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual getMessage : ()Ljava/lang/String;
    //   62: astore_0
    //   63: new java/lang/StringBuilder
    //   66: astore_3
    //   67: aload_3
    //   68: invokespecial <init> : ()V
    //   71: aload_3
    //   72: ldc 'Failed to get thread context classloader '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: aload_0
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 'DynamiteLoaderV2CL'
    //   86: aload_3
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aload_2
    //   95: monitorexit
    //   96: ldc com/google/android/gms/dynamite/zzb
    //   98: monitorexit
    //   99: aload_1
    //   100: areturn
    //   101: aload_2
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: ldc com/google/android/gms/dynamite/zzb
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	105	finally
    //   13	23	105	finally
    //   35	41	105	finally
    //   41	48	57	java/lang/SecurityException
    //   41	48	53	finally
    //   58	94	53	finally
    //   94	96	53	finally
    //   101	103	53	finally
    //   103	105	105	finally
  }
  
  @Nullable
  private static Thread zzc() {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/zzb
    //   2: monitorenter
    //   3: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   6: invokevirtual getThread : ()Ljava/lang/Thread;
    //   9: invokevirtual getThreadGroup : ()Ljava/lang/ThreadGroup;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull -> 22
    //   17: ldc com/google/android/gms/dynamite/zzb
    //   19: monitorexit
    //   20: aconst_null
    //   21: areturn
    //   22: ldc java/lang/Void
    //   24: monitorenter
    //   25: aload_0
    //   26: invokevirtual activeGroupCount : ()I
    //   29: anewarray java/lang/ThreadGroup
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual enumerate : ([Ljava/lang/ThreadGroup;)I
    //   38: pop
    //   39: aload_1
    //   40: arraylength
    //   41: istore_2
    //   42: iconst_0
    //   43: istore_3
    //   44: iconst_0
    //   45: istore #4
    //   47: iload #4
    //   49: iload_2
    //   50: if_icmpge -> 81
    //   53: aload_1
    //   54: iload #4
    //   56: aaload
    //   57: astore #5
    //   59: ldc 'dynamiteLoader'
    //   61: aload #5
    //   63: invokevirtual getName : ()Ljava/lang/String;
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 75
    //   72: goto -> 84
    //   75: iinc #4, 1
    //   78: goto -> 47
    //   81: aconst_null
    //   82: astore #5
    //   84: aload #5
    //   86: astore_1
    //   87: aload #5
    //   89: ifnonnull -> 103
    //   92: new java/lang/ThreadGroup
    //   95: astore_1
    //   96: aload_1
    //   97: aload_0
    //   98: ldc 'dynamiteLoader'
    //   100: invokespecial <init> : (Ljava/lang/ThreadGroup;Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual activeCount : ()I
    //   107: anewarray java/lang/Thread
    //   110: astore_0
    //   111: aload_1
    //   112: aload_0
    //   113: invokevirtual enumerate : ([Ljava/lang/Thread;)I
    //   116: pop
    //   117: aload_0
    //   118: arraylength
    //   119: istore_2
    //   120: iload_3
    //   121: istore #4
    //   123: iload #4
    //   125: iload_2
    //   126: if_icmpge -> 161
    //   129: aload_0
    //   130: iload #4
    //   132: aaload
    //   133: astore #5
    //   135: ldc 'GmsDynamite'
    //   137: aload #5
    //   139: invokevirtual getName : ()Ljava/lang/String;
    //   142: invokevirtual equals : (Ljava/lang/Object;)Z
    //   145: istore #6
    //   147: iload #6
    //   149: ifeq -> 155
    //   152: goto -> 164
    //   155: iinc #4, 1
    //   158: goto -> 123
    //   161: aconst_null
    //   162: astore #5
    //   164: aload #5
    //   166: astore_0
    //   167: aload #5
    //   169: ifnonnull -> 256
    //   172: new com/google/android/gms/dynamite/zza
    //   175: astore_0
    //   176: aload_0
    //   177: aload_1
    //   178: ldc 'GmsDynamite'
    //   180: invokespecial <init> : (Ljava/lang/ThreadGroup;Ljava/lang/String;)V
    //   183: aload_0
    //   184: aconst_null
    //   185: invokevirtual setContextClassLoader : (Ljava/lang/ClassLoader;)V
    //   188: aload_0
    //   189: invokevirtual start : ()V
    //   192: goto -> 256
    //   195: astore_1
    //   196: aload_0
    //   197: astore #5
    //   199: aload_1
    //   200: astore_0
    //   201: goto -> 217
    //   204: astore_0
    //   205: goto -> 217
    //   208: astore #5
    //   210: goto -> 264
    //   213: astore_0
    //   214: aconst_null
    //   215: astore #5
    //   217: aload_0
    //   218: invokevirtual getMessage : ()Ljava/lang/String;
    //   221: astore_1
    //   222: new java/lang/StringBuilder
    //   225: astore_0
    //   226: aload_0
    //   227: invokespecial <init> : ()V
    //   230: aload_0
    //   231: ldc 'Failed to enumerate thread/threadgroup '
    //   233: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_0
    //   238: aload_1
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: ldc 'DynamiteLoaderV2CL'
    //   245: aload_0
    //   246: invokevirtual toString : ()Ljava/lang/String;
    //   249: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   252: pop
    //   253: aload #5
    //   255: astore_0
    //   256: ldc java/lang/Void
    //   258: monitorexit
    //   259: ldc com/google/android/gms/dynamite/zzb
    //   261: monitorexit
    //   262: aload_0
    //   263: areturn
    //   264: ldc java/lang/Void
    //   266: monitorexit
    //   267: aload #5
    //   269: athrow
    //   270: astore #5
    //   272: ldc com/google/android/gms/dynamite/zzb
    //   274: monitorexit
    //   275: aload #5
    //   277: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	270	finally
    //   22	25	270	finally
    //   25	42	213	java/lang/SecurityException
    //   25	42	208	finally
    //   59	72	213	java/lang/SecurityException
    //   59	72	208	finally
    //   92	103	213	java/lang/SecurityException
    //   92	103	208	finally
    //   103	120	213	java/lang/SecurityException
    //   103	120	208	finally
    //   135	147	213	java/lang/SecurityException
    //   135	147	208	finally
    //   172	183	204	java/lang/SecurityException
    //   172	183	208	finally
    //   183	192	195	java/lang/SecurityException
    //   183	192	208	finally
    //   217	253	208	finally
    //   256	259	208	finally
    //   264	267	208	finally
    //   267	270	270	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */