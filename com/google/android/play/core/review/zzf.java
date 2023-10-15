package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzh;
import com.google.android.play.core.review.internal.zzj;

final class zzf extends zzj {
  zzf(zzi paramzzi, TaskCompletionSource paramTaskCompletionSource1, TaskCompletionSource paramTaskCompletionSource2) {
    super(paramTaskCompletionSource1);
  }
  
  protected final void zza() {
    try {
      IInterface iInterface = this.zzb.zza.zze();
      String str = zzi.zzc(this.zzb);
      Bundle bundle = zzj.zza();
      zzh zzh = new zzh();
      zzi zzi1 = this.zzb;
      this(zzi1, this.zza, zzi.zzc(zzi1));
      iInterface.zzc(str, bundle, (zzh)zzh);
      return;
    } catch (RemoteException remoteException) {
      zzi.zzb().zzc((Throwable)remoteException, "error requesting in-app review for %s", new Object[] { zzi.zzc(this.zzb) });
      this.zza.trySetException(new RuntimeException((Throwable)remoteException));
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */