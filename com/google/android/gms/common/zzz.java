package com.google.android.gms.common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

final class zzz {
  @Nullable
  private String zza = null;
  
  private long zzb = -1L;
  
  private zzag zzc = zzag.zzl();
  
  private zzag zzd = zzag.zzl();
  
  @CanIgnoreReturnValue
  final zzz zza(long paramLong) {
    this.zzb = paramLong;
    return this;
  }
  
  @CanIgnoreReturnValue
  final zzz zzb(List paramList) {
    Preconditions.checkNotNull(paramList);
    this.zzd = zzag.zzk(paramList);
    return this;
  }
  
  @CanIgnoreReturnValue
  final zzz zzc(List paramList) {
    Preconditions.checkNotNull(paramList);
    this.zzc = zzag.zzk(paramList);
    return this;
  }
  
  @CanIgnoreReturnValue
  final zzz zzd(String paramString) {
    this.zza = paramString;
    return this;
  }
  
  final zzab zze() {
    if (this.zza != null) {
      if (this.zzb >= 0L) {
        if (!this.zzc.isEmpty() || !this.zzd.isEmpty())
          return new zzab(this.zza, this.zzb, this.zzc, this.zzd, null); 
        throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
      } 
      throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
    } 
    throw new IllegalStateException("packageName must be defined");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */