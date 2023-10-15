package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzq {
  static final CharSequence zza(@CheckForNull Object paramObject, String paramString) {
    paramObject.getClass();
    if (paramObject instanceof CharSequence) {
      paramObject = paramObject;
    } else {
      paramObject = paramObject.toString();
    } 
    return (CharSequence)paramObject;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */