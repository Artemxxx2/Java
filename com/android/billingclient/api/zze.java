package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;

public final class zze {
  private final String zza;
  
  private final String zzb;
  
  public final boolean equals(@Nullable Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zze))
      return false; 
    paramObject = paramObject;
    return (this.zza.equals(((zze)paramObject).zza) && this.zzb.equals(((zze)paramObject).zzb));
  }
  
  public final int hashCode() {
    return Arrays.hashCode(new Object[] { this.zza, this.zzb });
  }
  
  public final String toString() {
    return String.format("{id: %s, type: %s}", new Object[] { this.zza, this.zzb });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\android\billingclient\api\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */