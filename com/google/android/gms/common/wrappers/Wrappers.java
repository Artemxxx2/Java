package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class Wrappers {
  private static Wrappers zza = new Wrappers();
  
  @Nullable
  private PackageManagerWrapper zzb = null;
  
  @NonNull
  @KeepForSdk
  public static PackageManagerWrapper packageManager(@NonNull Context paramContext) {
    return zza.zza(paramContext);
  }
  
  @NonNull
  @VisibleForTesting
  public final PackageManagerWrapper zza(@NonNull Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzb : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   6: ifnonnull -> 37
    //   9: aload_1
    //   10: astore_2
    //   11: aload_1
    //   12: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   15: ifnull -> 23
    //   18: aload_1
    //   19: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   22: astore_2
    //   23: new com/google/android/gms/common/wrappers/PackageManagerWrapper
    //   26: astore_1
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial <init> : (Landroid/content/Context;)V
    //   32: aload_0
    //   33: aload_1
    //   34: putfield zzb : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   37: aload_0
    //   38: getfield zzb : Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	46	finally
    //   11	23	46	finally
    //   23	37	46	finally
    //   37	42	46	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\wrappers\Wrappers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */