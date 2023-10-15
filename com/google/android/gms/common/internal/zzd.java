package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzd extends zzab {
  @Nullable
  private BaseGmsClient zza;
  
  private final int zzb;
  
  public zzd(@NonNull BaseGmsClient paramBaseGmsClient, int paramInt) {
    this.zza = paramBaseGmsClient;
    this.zzb = paramInt;
  }
  
  @BinderThread
  public final void onPostInitComplete(int paramInt, @NonNull IBinder paramIBinder, @Nullable Bundle paramBundle) {
    Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
    this.zza.onPostInitHandler(paramInt, paramIBinder, paramBundle, this.zzb);
    this.zza = null;
  }
  
  @BinderThread
  public final void zzb(int paramInt, @Nullable Bundle paramBundle) {
    Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
  }
  
  @BinderThread
  public final void zzc(int paramInt, @NonNull IBinder paramIBinder, @NonNull zzj paramzzj) {
    BaseGmsClient baseGmsClient = this.zza;
    Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
    Preconditions.checkNotNull(paramzzj);
    BaseGmsClient.zzj(baseGmsClient, paramzzj);
    onPostInitComplete(paramInt, paramIBinder, paramzzj.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */