package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.DoNotCall;
import java.util.ListIterator;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzak extends zzaj implements ListIterator {
  @Deprecated
  @DoNotCall("Always throws UnsupportedOperationException")
  public final void add(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @DoNotCall("Always throws UnsupportedOperationException")
  public final void set(Object paramObject) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */