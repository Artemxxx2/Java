package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {
  private final IBinder zza;
  
  private final String zzb;
  
  protected zza(IBinder paramIBinder, String paramString) {
    this.zza = paramIBinder;
    this.zzb = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";
  }
  
  public final IBinder asBinder() {
    return this.zza;
  }
  
  protected final Parcel zza() {
    Parcel parcel = Parcel.obtain();
    parcel.writeInterfaceToken(this.zzb);
    return parcel;
  }
  
  protected final void zzb(int paramInt, Parcel paramParcel) throws RemoteException {
    try {
      this.zza.transact(2, paramParcel, null, 1);
      return;
    } finally {
      paramParcel.recycle();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */