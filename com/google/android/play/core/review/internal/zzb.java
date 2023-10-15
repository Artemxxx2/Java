package com.google.android.play.core.review.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzb extends Binder implements IInterface {
  protected zzb(String paramString) {
    attachInterface(this, "com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
  }
  
  public final IBinder asBinder() {
    return (IBinder)this;
  }
  
  public final boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 > 16777215) {
      if (super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2))
        return true; 
    } else {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
    } 
    return zza(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
  
  protected boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    throw null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */