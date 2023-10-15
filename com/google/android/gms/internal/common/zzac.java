package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@DoNotMock("Use ImmutableList.of or another implementation")
@NullMarked
public abstract class zzac extends AbstractCollection implements Serializable {
  private static final Object[] zza = new Object[0];
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final boolean add(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final boolean addAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @DoNotCall("Always throws UnsupportedOperationException")
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final boolean remove(@CheckForNull Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final boolean removeAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final boolean retainAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray() {
    return toArray(zza);
  }
  
  @CanIgnoreReturnValue
  public final Object[] toArray(Object[] paramArrayOfObject) {
    if (paramArrayOfObject != null) {
      Object[] arrayOfObject;
      int i = size();
      int j = paramArrayOfObject.length;
      if (j < i) {
        arrayOfObject = zzg();
        if (arrayOfObject == null) {
          arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
        } else {
          return Arrays.copyOfRange(arrayOfObject, zzc(), zzb(), (Class)paramArrayOfObject.getClass());
        } 
      } else {
        arrayOfObject = paramArrayOfObject;
        if (j > i) {
          paramArrayOfObject[i] = null;
          arrayOfObject = paramArrayOfObject;
        } 
      } 
      zza(arrayOfObject, 0);
      return arrayOfObject;
    } 
    throw null;
  }
  
  @CanIgnoreReturnValue
  int zza(Object[] paramArrayOfObject, int paramInt) {
    throw null;
  }
  
  int zzb() {
    throw null;
  }
  
  int zzc() {
    throw null;
  }
  
  public zzag zzd() {
    throw null;
  }
  
  public abstract zzaj zze();
  
  abstract boolean zzf();
  
  @CheckForNull
  Object[] zzg() {
    throw null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */