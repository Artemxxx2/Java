package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
abstract class zzj implements Iterator {
  @CheckForNull
  private Object zza;
  
  private int zzb = 2;
  
  public final boolean hasNext() {
    int i = this.zzb;
    if (i != 4) {
      int j = i - 1;
      if (i != 0) {
        if (j != 0) {
          if (j != 2) {
            this.zzb = 4;
            this.zza = zza();
            if (this.zzb != 3) {
              this.zzb = 1;
              return true;
            } 
          } 
          return false;
        } 
        return true;
      } 
      throw null;
    } 
    throw new IllegalStateException();
  }
  
  public final Object next() {
    if (hasNext()) {
      this.zzb = 2;
      Object object = this.zza;
      this.zza = null;
      return object;
    } 
    throw new NoSuchElementException();
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
  
  @CheckForNull
  protected abstract Object zza();
  
  @CheckForNull
  @CanIgnoreReturnValue
  protected final Object zzb() {
    this.zzb = 3;
    return null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */