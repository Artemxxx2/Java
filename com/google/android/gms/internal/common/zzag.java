package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
public abstract class zzag extends zzac implements List, RandomAccess {
  private static final zzak zza = new zzae(zzai.zza, 0);
  
  static zzag zzi(Object[] paramArrayOfObject, int paramInt) {
    return (paramInt == 0) ? zzai.zza : new zzai(paramArrayOfObject, paramInt);
  }
  
  public static zzag zzj(Iterable paramIterable) {
    if (paramIterable != null) {
      if (paramIterable instanceof Collection) {
        paramIterable = zzk((Collection)paramIterable);
      } else {
        Iterator<Iterable> iterator = paramIterable.iterator();
        if (!iterator.hasNext()) {
          paramIterable = zzai.zza;
        } else {
          paramIterable = iterator.next();
          if (!iterator.hasNext()) {
            paramIterable = zzm(paramIterable);
          } else {
            zzad zzad = new zzad(4);
            zzad.zzb(paramIterable);
            zzad.zzc(iterator);
            zzad.zzc = true;
            paramIterable = zzi(zzad.zza, zzad.zzb);
          } 
        } 
      } 
      return (zzag)paramIterable;
    } 
    throw null;
  }
  
  public static zzag zzk(Collection paramCollection) {
    zzag zzag1;
    if (paramCollection instanceof zzac) {
      zzag zzag2 = ((zzac)paramCollection).zzd();
      paramCollection = zzag2;
      if (zzag2.zzf()) {
        Object[] arrayOfObject1 = zzag2.toArray();
        zzag1 = zzi(arrayOfObject1, arrayOfObject1.length);
      } 
      return zzag1;
    } 
    Object[] arrayOfObject = zzag1.toArray();
    int i = arrayOfObject.length;
    zzah.zza(arrayOfObject, i);
    return zzi(arrayOfObject, i);
  }
  
  public static zzag zzl() {
    return zzai.zza;
  }
  
  public static zzag zzm(Object paramObject) {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramObject;
    zzah.zza(arrayOfObject, 1);
    return zzi(arrayOfObject, 1);
  }
  
  public static zzag zzn(Object paramObject1, Object paramObject2) {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramObject1;
    arrayOfObject[1] = paramObject2;
    zzah.zza(arrayOfObject, 2);
    return zzi(arrayOfObject, 2);
  }
  
  @Deprecated
  @DoNotCall("Always throws UnsupportedOperationException")
  public final void add(int paramInt, Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
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
              if (!zzr.zza(get(b), list.get(b)))
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
            if (!zzr.zza(paramObject.next(), iterator.next()))
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
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
  public final Object remove(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  @DoNotCall("Always throws UnsupportedOperationException")
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
  @InlineMe(replacement = "this")
  public final zzag zzd() {
    return this;
  }
  
  public final zzaj zze() {
    return zzo(0);
  }
  
  public zzag zzh(int paramInt1, int paramInt2) {
    zzs.zzc(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    return (paramInt2 == size()) ? this : ((paramInt2 == 0) ? zzai.zza : new zzaf(this, paramInt1, paramInt2));
  }
  
  public final zzak zzo(int paramInt) {
    zzs.zzb(paramInt, size(), "index");
    return isEmpty() ? zza : new zzae(this, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */