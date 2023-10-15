package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zze extends zzb implements zzf {
  public static zzf zzb(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    return (iInterface instanceof zzf) ? (zzf)iInterface : new zzd(paramIBinder);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */