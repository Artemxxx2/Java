package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
final class zzai extends zzag {
  static final zzag zza = new zzai(new Object[0], 0);
  
  final transient Object[] zzb;
  
  private final transient int zzc;
  
  zzai(Object[] paramArrayOfObject, int paramInt) {
    this.zzb = paramArrayOfObject;
    this.zzc = paramInt;
  }
  
  public final Object get(int paramInt) {
    zzs.zza(paramInt, this.zzc, "index");
    Object object = this.zzb[paramInt];
    object.getClass();
    return object;
  }
  
  public final int size() {
    return this.zzc;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt) {
    System.arraycopy(this.zzb, 0, paramArrayOfObject, 0, this.zzc);
    return this.zzc;
  }
  
  final int zzb() {
    return this.zzc;
  }
  
  final int zzc() {
    return 0;
  }
  
  final boolean zzf() {
    return false;
  }
  
  final Object[] zzg() {
    return this.zzb;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */