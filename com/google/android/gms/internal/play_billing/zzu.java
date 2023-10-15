package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class zzu extends zzr implements List, RandomAccess {
  private static final zzai zza = new zzs(zzaa.zza, 0);
  
  static zzu zzi(Object[] paramArrayOfObject) {
    return zzj(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static zzu zzj(Object[] paramArrayOfObject, int paramInt) {
    return (paramInt == 0) ? zzaa.zza : new zzaa(paramArrayOfObject, paramInt);
  }
  
  public static zzu zzk(Collection paramCollection) {
    zzu zzu1;
    StringBuilder stringBuilder;
    if (paramCollection instanceof zzr) {
      zzu zzu2 = ((zzr)paramCollection).zzd();
      paramCollection = zzu2;
      if (zzu2.zzf()) {
        Object[] arrayOfObject1 = zzu2.toArray();
        zzu1 = zzj(arrayOfObject1, arrayOfObject1.length);
      } 
      return zzu1;
    } 
    Object[] arrayOfObject = zzu1.toArray();
    int i = arrayOfObject.length;
    byte b = 0;
    while (b < i) {
      if (arrayOfObject[b] != null) {
        b++;
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("at index ");
      stringBuilder.append(b);
      throw new NullPointerException(stringBuilder.toString());
    } 
    return zzj((Object[])stringBuilder, i);
  }
  
  public static zzu zzl() {
    return zzaa.zza;
  }
  
  @Deprecated
  public final void add(int paramInt, Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final boolean contains(@CheckForNull Object paramObject) {
    return (indexOf(paramObject) >= 0);
  }
  
  public final boolean equals(@CheckForNull Object<?> paramObject) {
    boolean bool = false;
    if (paramObject == this) {
      bool = true;
    } else if (paramObject instanceof List) {
      List list = (List)paramObject;
      int i = size();
      if (i == list.size())
        if (list instanceof RandomAccess) {
          byte b = 0;
          while (true) {
            if (b < i) {
              if (!zzl.zza(get(b), list.get(b)))
                break; 
              b++;
              continue;
            } 
            bool = true;
            break;
          } 
        } else {
          paramObject = (Object<?>)super.iterator();
          Iterator iterator = list.iterator();
          while (paramObject.hasNext()) {
            if (!iterator.hasNext())
              // Byte code: goto -> 169 
            if (!zzl.zza(paramObject.next(), iterator.next()))
              // Byte code: goto -> 169 
          } 
          if (!iterator.hasNext())
            bool = true; 
        }  
    } 
    return bool;
  }
  
  public final int hashCode() {
    int i = size();
    int j = 1;
    for (byte b = 0; b < i; b++)
      j = j * 31 + get(b).hashCode(); 
    return j;
  }
  
  public final int indexOf(@CheckForNull Object paramObject) {
    byte b2;
    byte b1 = -1;
    if (paramObject == null)
      return -1; 
    int i = size();
    byte b = 0;
    while (true) {
      b2 = b1;
      if (b < i) {
        if (paramObject.equals(get(b))) {
          b2 = b;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    return b2;
  }
  
  public final int lastIndexOf(@CheckForNull Object paramObject) {
    int j;
    byte b = -1;
    if (paramObject == null)
      return -1; 
    int i = size() - 1;
    while (true) {
      j = b;
      if (i >= 0) {
        if (paramObject.equals(get(i))) {
          j = i;
          break;
        } 
        i--;
        continue;
      } 
      break;
    } 
    return j;
  }
  
  @Deprecated
  public final Object remove(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Object set(int paramInt, Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  int zza(Object[] paramArrayOfObject, int paramInt) {
    int i = size();
    for (paramInt = 0; paramInt < i; paramInt++)
      paramArrayOfObject[paramInt] = get(paramInt); 
    return i;
  }
  
  @Deprecated
  public final zzu zzd() {
    return this;
  }
  
  public final zzah zze() {
    return zzm(0);
  }
  
  public zzu zzh(int paramInt1, int paramInt2) {
    zzm.zzd(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    return (paramInt2 == size()) ? this : ((paramInt2 == 0) ? zzaa.zza : new zzt(this, paramInt1, paramInt2));
  }
  
  public final zzai zzm(int paramInt) {
    zzm.zzb(paramInt, size(), "index");
    return isEmpty() ? zza : new zzs(this, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */