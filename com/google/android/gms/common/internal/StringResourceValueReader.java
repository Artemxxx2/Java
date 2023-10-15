package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader {
  private final Resources zza;
  
  private final String zzb;
  
  public StringResourceValueReader(@NonNull Context paramContext) {
    Preconditions.checkNotNull(paramContext);
    this.zza = paramContext.getResources();
    this.zzb = this.zza.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  @Nullable
  @KeepForSdk
  public String getString(@NonNull String paramString) {
    int i = this.zza.getIdentifier(paramString, "string", this.zzb);
    return (i == 0) ? null : this.zza.getString(i);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\StringResourceValueReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */