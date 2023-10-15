package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzg extends zzb implements zzh {
  public zzg() {
    super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 2) {
      Bundle bundle = (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR);
      zzc.zzb(paramParcel1);
      zzb(bundle);
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */