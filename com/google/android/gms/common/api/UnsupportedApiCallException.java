package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
  private final Feature zza;
  
  @KeepForSdk
  public UnsupportedApiCallException(@NonNull Feature paramFeature) {
    this.zza = paramFeature;
  }
  
  @NonNull
  public String getMessage() {
    return "Missing ".concat(String.valueOf(String.valueOf(this.zza)));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\UnsupportedApiCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */