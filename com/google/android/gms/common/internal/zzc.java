package com.google.android.gms.common.internal;

import androidx.annotation.Nullable;

public abstract class zzc {
  @Nullable
  private Object zza;
  
  private boolean zzb;
  
  public zzc(BaseGmsClient paramBaseGmsClient, Object paramObject) {
    this.zza = paramObject;
    this.zzb = false;
  }
  
  protected abstract void zza(Object paramObject);
  
  protected abstract void zzc();
  
  public final void zze() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zza : Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield zzb : Z
    //   11: ifeq -> 57
    //   14: aload_0
    //   15: invokevirtual toString : ()Ljava/lang/String;
    //   18: astore_2
    //   19: new java/lang/StringBuilder
    //   22: astore_3
    //   23: aload_3
    //   24: invokespecial <init> : ()V
    //   27: aload_3
    //   28: ldc 'Callback proxy '
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: aload_2
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc ' being reused. This is not safe.'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 'GmsClient'
    //   49: aload_3
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: ifnull -> 74
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual zza : (Ljava/lang/Object;)V
    //   68: goto -> 74
    //   71: astore_1
    //   72: aload_1
    //   73: athrow
    //   74: aload_0
    //   75: monitorenter
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield zzb : Z
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_0
    //   84: invokevirtual zzg : ()V
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	57	93	finally
    //   57	59	93	finally
    //   63	68	71	java/lang/RuntimeException
    //   76	83	88	finally
    //   89	91	88	finally
    //   94	96	93	finally
  }
  
  public final void zzf() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield zza : Ljava/lang/Object;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	10	finally
    //   11	13	10	finally
  }
  
  public final void zzg() {
    zzf();
    synchronized (BaseGmsClient.zzf(this.zzd)) {
      BaseGmsClient.zzf(this.zzd).remove(this);
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */