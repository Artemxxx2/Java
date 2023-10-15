package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public final class RootTelemetryConfigManager {
  @Nullable
  private static RootTelemetryConfigManager zza;
  
  private static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);
  
  @Nullable
  private RootTelemetryConfiguration zzc;
  
  @NonNull
  @KeepForSdk
  public static RootTelemetryConfigManager getInstance() {
    // Byte code:
    //   0: ldc com/google/android/gms/common/internal/RootTelemetryConfigManager
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/common/internal/RootTelemetryConfigManager.zza : Lcom/google/android/gms/common/internal/RootTelemetryConfigManager;
    //   6: ifnonnull -> 21
    //   9: new com/google/android/gms/common/internal/RootTelemetryConfigManager
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/google/android/gms/common/internal/RootTelemetryConfigManager.zza : Lcom/google/android/gms/common/internal/RootTelemetryConfigManager;
    //   21: getstatic com/google/android/gms/common/internal/RootTelemetryConfigManager.zza : Lcom/google/android/gms/common/internal/RootTelemetryConfigManager;
    //   24: astore_0
    //   25: ldc com/google/android/gms/common/internal/RootTelemetryConfigManager
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/google/android/gms/common/internal/RootTelemetryConfigManager
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  @Nullable
  @KeepForSdk
  public RootTelemetryConfiguration getConfig() {
    return this.zzc;
  }
  
  @VisibleForTesting
  public final void zza(@Nullable RootTelemetryConfiguration paramRootTelemetryConfiguration) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 16
    //   6: aload_0
    //   7: getstatic com/google/android/gms/common/internal/RootTelemetryConfigManager.zzb : Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;
    //   10: putfield zzc : Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield zzc : Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull -> 48
    //   25: aload_2
    //   26: invokevirtual getVersion : ()I
    //   29: istore_3
    //   30: aload_1
    //   31: invokevirtual getVersion : ()I
    //   34: istore #4
    //   36: iload_3
    //   37: iload #4
    //   39: if_icmpge -> 45
    //   42: goto -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_1
    //   50: putfield zzc : Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   6	13	56	finally
    //   16	21	56	finally
    //   25	36	56	finally
    //   48	53	56	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\RootTelemetryConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */