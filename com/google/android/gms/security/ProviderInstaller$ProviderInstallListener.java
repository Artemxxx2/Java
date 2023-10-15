package com.google.android.gms.security;

import android.content.Intent;
import androidx.annotation.Nullable;

public interface ProviderInstallListener {
  void onProviderInstallFailed(int paramInt, @Nullable Intent paramIntent);
  
  void onProviderInstalled();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\security\ProviderInstaller$ProviderInstallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */