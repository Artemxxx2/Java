package com.google.android.gms.internal.common;

import java.util.List;
import javax.annotation.CheckForNull;

final class zzaf extends zzag {
  final transient int zza;
  
  final transient int zzb;
  
  zzaf(zzag paramzzag, int paramInt1, int paramInt2) {
    this.zza = paramInt1;
    this.zzb = paramInt2;
  }
  
  public final Object get(int paramInt) {
    zzs.zza(paramInt, this.zzb, "index");
    return this.zzc.get(paramInt + this.zza);
  }
  
  public final int size() {
    return this.zzb;
  }
  
  final int zzb() {
    return this.zzc.zzc() + this.zza + this.zzb;
  }
  
  final int zzc() {
    return this.zzc.zzc() + this.zza;
  }
  
  final boolean zzf() {
    return true;
  }
  
  @CheckForNull
  final Object[] zzg() {
    return this.zzc.zzg();
  }
  
  public final zzag zzh(int paramInt1, int paramInt2) {
    zzs.zzc(paramInt1, paramInt2, this.zzb);
    zzag zzag1 = this.zzc;
    int i = this.zza;
    return zzag1.zzh(paramInt1 + i, paramInt2 + i);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */