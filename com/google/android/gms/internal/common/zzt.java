package com.google.android.gms.internal.common;

final class zzt extends zzw {
  zzt(zzu paramzzu, zzx paramzzx, CharSequence paramCharSequence) {
    super(paramzzx, paramCharSequence);
  }
  
  final int zzc(int paramInt) {
    return paramInt + 1;
  }
  
  final int zzd(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zza : Lcom/google/android/gms/internal/common/zzu;
    //   4: getfield zza : Lcom/google/android/gms/internal/common/zzo;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield zzb : Ljava/lang/CharSequence;
    //   12: astore_3
    //   13: aload_3
    //   14: invokeinterface length : ()I
    //   19: istore #4
    //   21: iload_1
    //   22: iload #4
    //   24: ldc 'index'
    //   26: invokestatic zzb : (IILjava/lang/String;)I
    //   29: pop
    //   30: iload_1
    //   31: iload #4
    //   33: if_icmpge -> 59
    //   36: iload_1
    //   37: istore #5
    //   39: aload_2
    //   40: aload_3
    //   41: iload_1
    //   42: invokeinterface charAt : (I)C
    //   47: invokevirtual zza : (C)Z
    //   50: ifne -> 62
    //   53: iinc #1, 1
    //   56: goto -> 30
    //   59: iconst_m1
    //   60: istore #5
    //   62: iload #5
    //   64: ireturn
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */