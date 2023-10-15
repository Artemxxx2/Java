package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

abstract class zza extends zzc {
  public final int zza;
  
  @Nullable
  public final Bundle zzb;
  
  @BinderThread
  protected zza(BaseGmsClient paramBaseGmsClient, @Nullable int paramInt, Bundle paramBundle) {
    super(paramBaseGmsClient, Boolean.valueOf(true));
    this.zza = paramInt;
    this.zzb = paramBundle;
  }
  
  protected abstract void zzb(ConnectionResult paramConnectionResult);
  
  protected final void zzc() {}
  
  protected abstract boolean zzd();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */