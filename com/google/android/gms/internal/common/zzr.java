package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzr extends zzp {
  public static boolean zza(@CheckForNull Object paramObject1, @CheckForNull Object paramObject2) {
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramObject1 != paramObject2)
      if (paramObject1 != null) {
        if (paramObject1.equals(paramObject2)) {
          bool2 = bool1;
        } else {
          return false;
        } 
      } else {
        bool2 = false;
      }  
    return bool2;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */