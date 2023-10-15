package com.google.android.gms.dynamite;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

public interface VersionPolicy {
  @NonNull
  @KeepForSdk
  SelectionResult selectModule(@NonNull Context paramContext, @NonNull String paramString, @NonNull IVersions paramIVersions) throws DynamiteModule.LoadingException;
  
  @KeepForSdk
  public static interface IVersions {
    int zza(@NonNull Context param2Context, @NonNull String param2String);
    
    int zzb(@NonNull Context param2Context, @NonNull String param2String, boolean param2Boolean) throws DynamiteModule.LoadingException;
  }
  
  @KeepForSdk
  public static class SelectionResult {
    @KeepForSdk
    public int localVersion = 0;
    
    @KeepForSdk
    public int remoteVersion = 0;
    
    @KeepForSdk
    public int selection = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\DynamiteModule$VersionPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */