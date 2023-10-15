package com.google.android.gms.dynamite;

import android.content.Context;

final class zzg implements DynamiteModule.VersionPolicy {
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions) throws DynamiteModule.LoadingException {
    DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    int i = paramIVersions.zza(paramContext, paramString);
    selectionResult.localVersion = i;
    if (i != 0) {
      selectionResult.selection = -1;
    } else {
      i = paramIVersions.zzb(paramContext, paramString, true);
      selectionResult.remoteVersion = i;
      if (i != 0)
        selectionResult.selection = 1; 
    } 
    return selectionResult;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */