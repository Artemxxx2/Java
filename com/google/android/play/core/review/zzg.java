package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzg;
import com.google.android.play.core.review.internal.zzi;
import com.google.android.play.core.review.internal.zzt;

class zzg extends zzg {
  final zzi zza;
  
  final TaskCompletionSource zzb;
  
  zzg(zzi paramzzi, zzi paramzzi1, TaskCompletionSource paramTaskCompletionSource) {
    this.zza = paramzzi1;
    this.zzb = paramTaskCompletionSource;
  }
  
  public void zzb(Bundle paramBundle) throws RemoteException {
    zzt zzt = this.zzc.zza;
    if (zzt != null)
      zzt.zzr(this.zzb); 
    this.zza.zzd("onGetLaunchReviewFlowInfo", new Object[0]);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */