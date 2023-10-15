package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzy extends zzr implements Set {
  @CheckForNull
  private transient zzu zza;
  
  public final boolean equals(@CheckForNull Object paramObject) {
    if (paramObject != this) {
      boolean bool2;
      boolean bool1 = false;
      if (paramObject == this) {
        bool2 = true;
      } else {
        bool2 = bool1;
        if (paramObject instanceof Set) {
          paramObject = paramObject;
          bool2 = bool1;
          try {
            if (size() == paramObject.size()) {
              bool2 = containsAll((Collection<?>)paramObject);
              if (!bool2) {
                bool2 = bool1;
              } else {
                return true;
              } 
            } 
          } catch (NullPointerException|ClassCastException nullPointerException) {
            bool2 = bool1;
          } 
        } 
      } 
      return bool2;
    } 
    return true;
  }
  
  public final int hashCode() {
    return zzag.zza(this);
  }
  
  public zzu zzd() {
    zzu zzu1 = this.zza;
    zzu zzu2 = zzu1;
    if (zzu1 == null) {
      zzu2 = zzh();
      this.zza = zzu2;
    } 
    return zzu2;
  }
  
  public abstract zzah zze();
  
  zzu zzh() {
    return zzu.zzi(toArray());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */