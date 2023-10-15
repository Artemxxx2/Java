package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;

final class zzac implements IGmsServiceBroker {
  private final IBinder zza;
  
  zzac(IBinder paramIBinder) {
    this.zza = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.zza;
  }
  
  public final void getService(IGmsCallbacks paramIGmsCallbacks, @Nullable GetServiceRequest paramGetServiceRequest) throws RemoteException {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
      if (paramIGmsCallbacks != null) {
        IBinder iBinder = paramIGmsCallbacks.asBinder();
      } else {
        paramIGmsCallbacks = null;
      } 
      parcel1.writeStrongBinder((IBinder)paramIGmsCallbacks);
      if (paramGetServiceRequest != null) {
        parcel1.writeInt(1);
        zzm.zza(paramGetServiceRequest, parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.zza.transact(46, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */