package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zzg extends zza {
  @BinderThread
  public zzg(BaseGmsClient paramBaseGmsClient, @Nullable int paramInt, Bundle paramBundle) {
    super(paramBaseGmsClient, paramInt, null);
  }
  
  protected final void zzb(ConnectionResult paramConnectionResult) {
    if (this.zze.enableLocalFallback() && BaseGmsClient.zzo(this.zze)) {
      BaseGmsClient.zzk(this.zze, 16);
      return;
    } 
    this.zze.zzc.onReportServiceBinding(paramConnectionResult);
    this.zze.onConnectionFailed(paramConnectionResult);
  }
  
  protected final boolean zzd() {
    this.zze.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */