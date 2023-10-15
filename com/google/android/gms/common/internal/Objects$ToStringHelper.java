package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public final class ToStringHelper {
  private final List zza;
  
  private final Object zzb;
  
  @NonNull
  @KeepForSdk
  @CanIgnoreReturnValue
  public ToStringHelper add(@NonNull String paramString, @Nullable Object paramObject) {
    List<String> list = this.zza;
    Preconditions.checkNotNull(paramString);
    paramObject = String.valueOf(paramObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=");
    stringBuilder.append((String)paramObject);
    list.add(stringBuilder.toString());
    return this;
  }
  
  @NonNull
  @KeepForSdk
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(100);
    stringBuilder.append(this.zzb.getClass().getSimpleName());
    stringBuilder.append('{');
    int i = this.zza.size();
    for (byte b = 0; b < i; b++) {
      stringBuilder.append(this.zza.get(b));
      if (b < i - 1)
        stringBuilder.append(", "); 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\Objects$ToStringHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */