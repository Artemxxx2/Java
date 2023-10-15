package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

public final class zzad extends zzaa {
  public zzad() {
    super(4);
  }
  
  zzad(int paramInt) {
    super(4);
  }
  
  @CanIgnoreReturnValue
  public final zzad zzb(Object paramObject) {
    zza(paramObject);
    return this;
  }
  
  @CanIgnoreReturnValue
  public final zzad zzc(Iterator paramIterator) {
    while (paramIterator.hasNext())
      zza(paramIterator.next()); 
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */