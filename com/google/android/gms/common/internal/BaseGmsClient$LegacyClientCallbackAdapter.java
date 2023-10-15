package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;

public class LegacyClientCallbackAdapter implements BaseGmsClient.ConnectionProgressReportCallbacks {
  @KeepForSdk
  public LegacyClientCallbackAdapter(BaseGmsClient paramBaseGmsClient) {}
  
  public final void onReportServiceBinding(@NonNull ConnectionResult paramConnectionResult) {
    BaseGmsClient baseGmsClient;
    if (paramConnectionResult.isSuccess()) {
      baseGmsClient = this.zza;
      baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
      return;
    } 
    if (BaseGmsClient.zzc(this.zza) != null)
      BaseGmsClient.zzc(this.zza).onConnectionFailed((ConnectionResult)baseGmsClient); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\BaseGmsClient$LegacyClientCallbackAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */