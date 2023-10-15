package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.review.internal.zzi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzj {
  private static final Set zza = new HashSet(Arrays.asList((Object[])new String[] { "native", "unity" }));
  
  private static final Map zzb = new HashMap<Object, Object>();
  
  private static final zzi zzc = new zzi("PlayCoreVersion");
  
  public static Bundle zza() {
    Bundle bundle = new Bundle();
    Map map = zzb();
    bundle.putInt("playcore_version_code", ((Integer)map.get("java")).intValue());
    if (map.containsKey("native"))
      bundle.putInt("playcore_native_version", ((Integer)map.get("native")).intValue()); 
    if (map.containsKey("unity"))
      bundle.putInt("playcore_unity_version", ((Integer)map.get("unity")).intValue()); 
    return bundle;
  }
  
  public static Map zzb() {
    // Byte code:
    //   0: ldc com/google/android/play/core/review/zzj
    //   2: monitorenter
    //   3: getstatic com/google/android/play/core/review/zzj.zzb : Ljava/util/Map;
    //   6: ldc 'java'
    //   8: sipush #11004
    //   11: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   14: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: pop
    //   20: getstatic com/google/android/play/core/review/zzj.zzb : Ljava/util/Map;
    //   23: astore_0
    //   24: ldc com/google/android/play/core/review/zzj
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/google/android/play/core/review/zzj
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	29	finally
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */