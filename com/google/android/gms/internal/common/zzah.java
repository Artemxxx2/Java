package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzah {
  @CanIgnoreReturnValue
  static Object[] zza(Object[] paramArrayOfObject, int paramInt) {
    StringBuilder stringBuilder;
    byte b = 0;
    while (b < paramInt) {
      if (paramArrayOfObject[b] != null) {
        b++;
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("at index ");
      stringBuilder.append(b);
      throw new NullPointerException(stringBuilder.toString());
    } 
    return (Object[])stringBuilder;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */