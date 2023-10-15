package com.google.android.gms.internal.play_billing;

final class zzae extends zzu {
  private final transient Object[] zza;
  
  private final transient int zzb;
  
  private final transient int zzc;
  
  zzae(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
    this.zza = paramArrayOfObject;
    this.zzb = paramInt1;
    this.zzc = paramInt2;
  }
  
  public final Object get(int paramInt) {
    zzm.zza(paramInt, this.zzc, "index");
    Object object = this.zza[paramInt + paramInt + this.zzb];
    object.getClass();
    return object;
  }
  
  public final int size() {
    return this.zzc;
  }
  
  final boolean zzf() {
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */