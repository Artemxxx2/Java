package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

public final class zzl extends zzk {
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */