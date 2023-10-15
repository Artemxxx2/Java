package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
  private final int zza;
  
  public GooglePlayServicesRepairableException(int paramInt, @NonNull String paramString, @NonNull Intent paramIntent) {
    super(paramString, paramIntent);
    this.zza = paramInt;
  }
  
  public int getConnectionStatusCode() {
    return this.zza;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\GooglePlayServicesRepairableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */