package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public interface IGmsServiceBroker extends IInterface {
  @KeepForSdk
  void getService(@NonNull IGmsCallbacks paramIGmsCallbacks, @Nullable GetServiceRequest paramGetServiceRequest) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IGmsServiceBroker {
    public Stub() {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }
    
    @NonNull
    @KeepForSdk
    @CanIgnoreReturnValue
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public final boolean onTransact(int param1Int1, @NonNull Parcel param1Parcel1, @Nullable Parcel param1Parcel2, int param1Int2) throws RemoteException {
      zzaj zzaj;
      IGmsCallbacks iGmsCallbacks;
      if (param1Int1 > 16777215)
        return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
      param1Parcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      IBinder iBinder = param1Parcel1.readStrongBinder();
      GetServiceRequest getServiceRequest = null;
      if (iBinder == null) {
        iBinder = null;
      } else {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if (iInterface instanceof IGmsCallbacks) {
          iGmsCallbacks = (IGmsCallbacks)iInterface;
        } else {
          iGmsCallbacks = new zzaa((IBinder)iGmsCallbacks);
        } 
      } 
      if (param1Int1 == 46) {
        if (param1Parcel1.readInt() != 0)
          getServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(param1Parcel1); 
        getService(iGmsCallbacks, getServiceRequest);
        Preconditions.checkNotNull(param1Parcel2);
        param1Parcel2.writeNoException();
        return true;
      } 
      if (param1Int1 == 47) {
        if (param1Parcel1.readInt() != 0)
          zzaj = (zzaj)zzaj.CREATOR.createFromParcel(param1Parcel1); 
        throw new UnsupportedOperationException();
      } 
      zzaj.readInt();
      if (param1Int1 != 4) {
        Bundle bundle;
        zzaj.readString();
        if (param1Int1 != 23 && param1Int1 != 25 && param1Int1 != 27)
          if (param1Int1 != 30) {
            if (param1Int1 != 34) {
              if (param1Int1 != 41 && param1Int1 != 43)
                switch (param1Int1) {
                  default:
                    switch (param1Int1) {
                      default:
                        switch (param1Int1) {
                          default:
                            throw new UnsupportedOperationException();
                          case 37:
                          case 38:
                            break;
                        } 
                        break;
                      case 19:
                        zzaj.readStrongBinder();
                        if (zzaj.readInt() != 0)
                          bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)zzaj); 
                      case 10:
                        bundle.readString();
                        bundle.createStringArray();
                      case 9:
                        bundle.readString();
                        bundle.createStringArray();
                        bundle.readString();
                        bundle.readStrongBinder();
                        bundle.readString();
                        if (bundle.readInt() != 0)
                          bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
                      case 20:
                        bundle.createStringArray();
                        bundle.readString();
                        if (bundle.readInt() != 0)
                          bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
                      case 5:
                      case 6:
                      case 7:
                      case 8:
                      case 11:
                      case 12:
                      case 13:
                      case 14:
                      case 15:
                      case 16:
                      case 17:
                      case 18:
                        break;
                    } 
                    break;
                  case 1:
                    bundle.readString();
                    bundle.createStringArray();
                    bundle.readString();
                    if (bundle.readInt() != 0)
                      bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
                  case 2:
                    break;
                }  
            } else {
              bundle.readString();
            } 
          } else {
          
          }  
        if (bundle.readInt() != 0)
          bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
      } 
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\IGmsServiceBroker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */