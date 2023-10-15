package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

public final class zzw {
  Object[] zza = new Object[8];
  
  int zzb = 0;
  
  zzv zzc;
  
  public final zzw zza(Object paramObject1, Object paramObject2) {
    int i = this.zzb + 1;
    int j = i + i;
    Object[] arrayOfObject = this.zza;
    i = arrayOfObject.length;
    if (j > i) {
      int m = i + (i >> 1) + 1;
      i = m;
      if (m < j) {
        i = Integer.highestOneBit(j - 1);
        i += i;
      } 
      m = i;
      if (i < 0)
        m = Integer.MAX_VALUE; 
      this.zza = Arrays.copyOf(arrayOfObject, m);
    } 
    zzp.zza(paramObject1, paramObject2);
    arrayOfObject = this.zza;
    i = this.zzb;
    int k = i + i;
    arrayOfObject[k] = paramObject1;
    arrayOfObject[k + 1] = paramObject2;
    this.zzb = i + 1;
    return this;
  }
  
  public final zzx zzb() {
    zzaf zzaf;
    zzv zzv1 = this.zzc;
    if (zzv1 == null) {
      zzaf = zzaf.zzf(this.zzb, this.zza, this);
      zzv zzv2 = this.zzc;
      if (zzv2 == null)
        return zzaf; 
      throw zzv2.zza();
    } 
    throw zzaf.zza();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */