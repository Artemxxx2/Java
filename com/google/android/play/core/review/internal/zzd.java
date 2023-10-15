package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzd extends zza implements zzf {
  zzd(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
  }
  
  public final void zzc(String paramString, Bundle paramBundle, zzh paramzzh) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeString(paramString);
    zzc.zzc(parcel, (Parcelable)paramBundle);
    zzc.zzd(parcel, paramzzh);
    zzb(2, parcel);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */