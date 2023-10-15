package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {
  private final int zza;
  
  public GooglePlayServicesManifestException(int paramInt, @NonNull String paramString) {
    super(paramString);
    this.zza = paramInt;
  }
  
  public int getActualVersion() {
    return this.zza;
  }
  
  public int getExpectedVersion() {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GooglePlayServicesManifestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */