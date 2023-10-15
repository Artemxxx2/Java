package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class UserRecoverableException extends Exception {
  private final Intent zza;
  
  public UserRecoverableException(@NonNull String paramString, @NonNull Intent paramIntent) {
    super(paramString);
    this.zza = paramIntent;
  }
  
  @NonNull
  public Intent getIntent() {
    return new Intent(this.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\UserRecoverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */