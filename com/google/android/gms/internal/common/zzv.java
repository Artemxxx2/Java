package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

final class zzv implements Iterable {
  zzv(zzx paramzzx, CharSequence paramCharSequence) {}
  
  public final Iterator iterator() {
    return zzx.zze(this.zzb, this.zza);
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    Iterator<?> iterator = super.iterator();
    try {
      if (iterator.hasNext()) {
        stringBuilder.append(zzq.zza(iterator.next(), ", "));
        while (iterator.hasNext()) {
          stringBuilder.append(", ");
          stringBuilder.append(zzq.zza(iterator.next(), ", "));
        } 
      } 
      stringBuilder.append(']');
      return stringBuilder.toString();
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */