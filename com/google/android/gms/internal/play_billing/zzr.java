package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

public abstract class zzr extends AbstractCollection implements Serializable {
  private static final Object[] zza = new Object[0];
  
  @Deprecated
  public final boolean add(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@CheckForNull Object paramObject);
  
  @Deprecated
  public final boolean remove(@CheckForNull Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray() {
    return toArray(zza);
  }
  
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
  
  int zza(Object[] paramArrayOfObject, int paramInt) {
    throw null;
  }
  
  int zzb() {
    throw new UnsupportedOperationException();
  }
  
  int zzc() {
    throw new UnsupportedOperationException();
  }
  
  public zzu zzd() {
    throw null;
  }
  
  public abstract zzah zze();
  
  abstract boolean zzf();
  
  @CheckForNull
  Object[] zzg() {
    return null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */