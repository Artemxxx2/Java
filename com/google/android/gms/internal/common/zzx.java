package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzx {
  private final zzo zza;
  
  private final boolean zzb;
  
  private final zzu zzc;
  
  private zzx(zzu paramzzu, boolean paramBoolean, zzo paramzzo, int paramInt, byte[] paramArrayOfbyte) {
    this.zzc = paramzzu;
    this.zzb = paramBoolean;
    this.zza = paramzzo;
  }
  
  public static zzx zzc(zzo paramzzo) {
    return new zzx(new zzu(paramzzo), false, zzn.zza, 2147483647, null);
  }
  
  private final Iterator zzh(CharSequence paramCharSequence) {
    return new zzt(this.zzc, this, paramCharSequence);
  }
  
  public final zzx zzb() {
    return new zzx(this.zzc, true, this.zza, 2147483647, null);
  }
  
  public final Iterable zzd(CharSequence paramCharSequence) {
    return new zzv(this, paramCharSequence);
  }
  
  public final List zzf(CharSequence paramCharSequence) {
    if (paramCharSequence != null) {
      Iterator<String> iterator = zzh(paramCharSequence);
      ArrayList<String> arrayList = new ArrayList();
      while (iterator.hasNext())
        arrayList.add(iterator.next()); 
      return Collections.unmodifiableList(arrayList);
    } 
    throw null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */