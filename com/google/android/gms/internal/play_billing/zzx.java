package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzx implements Map, Serializable {
  @CheckForNull
  private transient zzy zza;
  
  @CheckForNull
  private transient zzy zzb;
  
  @CheckForNull
  private transient zzr zzc;
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public final boolean containsKey(@CheckForNull Object paramObject) {
    return (get(paramObject) != null);
  }
  
  public final boolean containsValue(@CheckForNull Object paramObject) {
    return zzb().contains(paramObject);
  }
  
  public final boolean equals(@CheckForNull Object paramObject) {
    if (this == paramObject) {
      boolean bool = true;
    } else {
      if (!(paramObject instanceof Map))
        return false; 
      paramObject = paramObject;
      return super.entrySet().equals(paramObject.entrySet());
    } 
    return SYNTHETIC_LOCAL_VARIABLE_2;
  }
  
  @CheckForNull
  public abstract Object get(@CheckForNull Object paramObject);
  
  @CheckForNull
  public final Object getOrDefault(@CheckForNull Object paramObject1, @CheckForNull Object paramObject2) {
    paramObject1 = get(paramObject1);
    return (paramObject1 != null) ? paramObject1 : paramObject2;
  }
  
  public final int hashCode() {
    return zzag.zza(zze());
  }
  
  public final boolean isEmpty() {
    return (size() == 0);
  }
  
  @Deprecated
  @CheckForNull
  public final Object put(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map paramMap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CheckForNull
  public final Object remove(@CheckForNull Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public final String toString() {
    int i = size();
    if (i >= 0) {
      StringBuilder stringBuilder1 = new StringBuilder((int)Math.min(i * 8L, 1073741824L));
      stringBuilder1.append('{');
      Iterator<Map.Entry> iterator = super.entrySet().iterator();
      for (i = 1; iterator.hasNext(); i = 0) {
        Map.Entry entry = iterator.next();
        if (i == 0)
          stringBuilder1.append(", "); 
        stringBuilder1.append(entry.getKey());
        stringBuilder1.append('=');
        stringBuilder1.append(entry.getValue());
      } 
      stringBuilder1.append('}');
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("size cannot be negative but was: ");
    stringBuilder.append(i);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  abstract zzr zza();
  
  public final zzr zzb() {
    zzr zzr1 = this.zzc;
    zzr zzr2 = zzr1;
    if (zzr1 == null) {
      zzr2 = zza();
      this.zzc = zzr2;
    } 
    return zzr2;
  }
  
  abstract zzy zzc();
  
  abstract zzy zzd();
  
  public final zzy zze() {
    zzy zzy1 = this.zza;
    zzy zzy2 = zzy1;
    if (zzy1 == null) {
      zzy2 = zzc();
      this.zza = zzy2;
    } 
    return zzy2;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */