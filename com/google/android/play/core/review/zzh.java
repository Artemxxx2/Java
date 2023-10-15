package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzi;

final class zzh extends zzg {
  final String zzd;
  
  zzh(zzi paramzzi, TaskCompletionSource paramTaskCompletionSource, String paramString) {
    super(paramzzi, new zzi("OnRequestInstallCallback"), paramTaskCompletionSource);
    this.zzd = paramString;
  }
  
  public final void zzb(Bundle paramBundle) throws RemoteException {
    super.zzb(paramBundle);
    PendingIntent pendingIntent = (PendingIntent)paramBundle.get("confirmation_intent");
    boolean bool = paramBundle.getBoolean("is_review_no_op");
    this.zzb.trySetResult(new zza(pendingIntent, bool));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */