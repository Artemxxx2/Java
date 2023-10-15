package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@KeepForSdk
public class LibraryVersion {
  private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
  
  private static LibraryVersion zzb = new LibraryVersion();
  
  private ConcurrentHashMap zzc = new ConcurrentHashMap<Object, Object>();
  
  @NonNull
  @KeepForSdk
  public static LibraryVersion getInstance() {
    return zzb;
  }
  
  @Deprecated
  @NonNull
  @KeepForSdk
  public String getVersion(@NonNull String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'Please provide a valid libraryName'
    //   3: invokestatic checkNotEmpty : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   6: pop
    //   7: aload_0
    //   8: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   11: aload_1
    //   12: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   15: ifeq -> 30
    //   18: aload_0
    //   19: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast java/lang/String
    //   29: areturn
    //   30: new java/util/Properties
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore #4
    //   43: aconst_null
    //   44: astore #5
    //   46: aconst_null
    //   47: astore #6
    //   49: ldc com/google/android/gms/common/internal/LibraryVersion
    //   51: ldc '/%s.properties'
    //   53: iconst_1
    //   54: anewarray java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore #7
    //   69: aload #7
    //   71: ifnull -> 178
    //   74: aload_3
    //   75: astore #4
    //   77: aload_2
    //   78: aload #7
    //   80: invokevirtual load : (Ljava/io/InputStream;)V
    //   83: aload_3
    //   84: astore #4
    //   86: aload_2
    //   87: ldc 'version'
    //   89: aconst_null
    //   90: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore #6
    //   95: aload #6
    //   97: astore #4
    //   99: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   102: astore_3
    //   103: aload #6
    //   105: astore #4
    //   107: new java/lang/StringBuilder
    //   110: astore #5
    //   112: aload #6
    //   114: astore #4
    //   116: aload #5
    //   118: invokespecial <init> : ()V
    //   121: aload #6
    //   123: astore #4
    //   125: aload #5
    //   127: aload_1
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload #6
    //   134: astore #4
    //   136: aload #5
    //   138: ldc ' version is '
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #6
    //   146: astore #4
    //   148: aload #5
    //   150: aload #6
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #6
    //   158: astore #4
    //   160: aload_3
    //   161: ldc 'LibraryVersion'
    //   163: aload #5
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokevirtual v : (Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload #6
    //   173: astore #4
    //   175: goto -> 237
    //   178: aload_3
    //   179: astore #4
    //   181: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   184: astore #5
    //   186: aload_3
    //   187: astore #4
    //   189: new java/lang/StringBuilder
    //   192: astore_2
    //   193: aload_3
    //   194: astore #4
    //   196: aload_2
    //   197: invokespecial <init> : ()V
    //   200: aload_3
    //   201: astore #4
    //   203: aload_2
    //   204: ldc 'Failed to get app version for libraryName: '
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_3
    //   211: astore #4
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: astore #4
    //   222: aload #5
    //   224: ldc 'LibraryVersion'
    //   226: aload_2
    //   227: invokevirtual toString : ()Ljava/lang/String;
    //   230: invokevirtual w : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload #6
    //   235: astore #4
    //   237: aload #7
    //   239: ifnull -> 247
    //   242: aload #7
    //   244: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   247: aload #4
    //   249: astore #6
    //   251: goto -> 347
    //   254: astore_1
    //   255: aload #7
    //   257: astore #4
    //   259: goto -> 385
    //   262: astore #6
    //   264: aload #7
    //   266: astore_3
    //   267: aload #4
    //   269: astore #7
    //   271: aload_3
    //   272: astore #4
    //   274: goto -> 290
    //   277: astore_1
    //   278: aload #5
    //   280: astore #4
    //   282: goto -> 385
    //   285: astore #6
    //   287: aconst_null
    //   288: astore #7
    //   290: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   293: astore #5
    //   295: new java/lang/StringBuilder
    //   298: astore_3
    //   299: aload_3
    //   300: invokespecial <init> : ()V
    //   303: aload_3
    //   304: ldc 'Failed to get app version for libraryName: '
    //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_3
    //   311: aload_1
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload #5
    //   318: ldc 'LibraryVersion'
    //   320: aload_3
    //   321: invokevirtual toString : ()Ljava/lang/String;
    //   324: aload #6
    //   326: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: aload #7
    //   331: astore #6
    //   333: aload #4
    //   335: ifnull -> 347
    //   338: aload #4
    //   340: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   343: aload #7
    //   345: astore #6
    //   347: aload #6
    //   349: astore #4
    //   351: aload #6
    //   353: ifnonnull -> 370
    //   356: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   359: ldc 'LibraryVersion'
    //   361: ldc '.properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used'
    //   363: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   366: ldc 'UNKNOWN'
    //   368: astore #4
    //   370: aload_0
    //   371: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   374: aload_1
    //   375: aload #4
    //   377: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   380: pop
    //   381: aload #4
    //   383: areturn
    //   384: astore_1
    //   385: aload #4
    //   387: ifnull -> 395
    //   390: aload #4
    //   392: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   395: aload_1
    //   396: athrow
    // Exception table:
    //   from	to	target	type
    //   49	69	285	java/io/IOException
    //   49	69	277	finally
    //   77	83	262	java/io/IOException
    //   77	83	254	finally
    //   86	95	262	java/io/IOException
    //   86	95	254	finally
    //   99	103	262	java/io/IOException
    //   99	103	254	finally
    //   107	112	262	java/io/IOException
    //   107	112	254	finally
    //   116	121	262	java/io/IOException
    //   116	121	254	finally
    //   125	132	262	java/io/IOException
    //   125	132	254	finally
    //   136	144	262	java/io/IOException
    //   136	144	254	finally
    //   148	156	262	java/io/IOException
    //   148	156	254	finally
    //   160	171	262	java/io/IOException
    //   160	171	254	finally
    //   181	186	262	java/io/IOException
    //   181	186	254	finally
    //   189	193	262	java/io/IOException
    //   189	193	254	finally
    //   196	200	262	java/io/IOException
    //   196	200	254	finally
    //   203	210	262	java/io/IOException
    //   203	210	254	finally
    //   213	219	262	java/io/IOException
    //   213	219	254	finally
    //   222	233	262	java/io/IOException
    //   222	233	254	finally
    //   290	329	384	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */