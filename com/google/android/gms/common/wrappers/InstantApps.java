package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class InstantApps {
  private static Context zza;
  
  @Nullable
  private static Boolean zzb;
  
  @KeepForSdk
  public static boolean isInstantApp(@NonNull Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/common/wrappers/InstantApps
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   7: astore_1
    //   8: getstatic com/google/android/gms/common/wrappers/InstantApps.zza : Landroid/content/Context;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull -> 44
    //   16: getstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnull -> 44
    //   24: aload_2
    //   25: aload_1
    //   26: if_acmpeq -> 32
    //   29: goto -> 44
    //   32: aload_3
    //   33: invokevirtual booleanValue : ()Z
    //   36: istore #4
    //   38: ldc com/google/android/gms/common/wrappers/InstantApps
    //   40: monitorexit
    //   41: iload #4
    //   43: ireturn
    //   44: aconst_null
    //   45: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   48: invokestatic isAtLeastO : ()Z
    //   51: ifeq -> 70
    //   54: aload_1
    //   55: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   58: invokevirtual isInstantApp : ()Z
    //   61: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   64: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   67: goto -> 98
    //   70: aload_0
    //   71: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   74: ldc 'com.google.android.instantapps.supervisor.InstantAppsRuntime'
    //   76: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   79: pop
    //   80: iconst_1
    //   81: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   84: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   87: goto -> 98
    //   90: astore_0
    //   91: iconst_0
    //   92: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   95: putstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   98: aload_1
    //   99: putstatic com/google/android/gms/common/wrappers/InstantApps.zza : Landroid/content/Context;
    //   102: getstatic com/google/android/gms/common/wrappers/InstantApps.zzb : Ljava/lang/Boolean;
    //   105: invokevirtual booleanValue : ()Z
    //   108: istore #4
    //   110: ldc com/google/android/gms/common/wrappers/InstantApps
    //   112: monitorexit
    //   113: iload #4
    //   115: ireturn
    //   116: astore_0
    //   117: ldc com/google/android/gms/common/wrappers/InstantApps
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	116	finally
    //   16	20	116	finally
    //   32	38	116	finally
    //   44	67	116	finally
    //   70	87	90	java/lang/ClassNotFoundException
    //   70	87	116	finally
    //   91	98	116	finally
    //   98	110	116	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\wrappers\InstantApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */