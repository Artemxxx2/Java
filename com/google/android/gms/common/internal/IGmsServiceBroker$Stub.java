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

public abstract class Stub extends Binder implements IGmsServiceBroker {
  public Stub() {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
  }
  
  @NonNull
  @KeepForSdk
  @CanIgnoreReturnValue
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public final boolean onTransact(int paramInt1, @NonNull Parcel paramParcel1, @Nullable Parcel paramParcel2, int paramInt2) throws RemoteException {
    zzaj zzaj;
    IGmsCallbacks iGmsCallbacks;
    if (paramInt1 > 16777215)
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    IBinder iBinder = paramParcel1.readStrongBinder();
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
    if (paramInt1 == 46) {
      if (paramParcel1.readInt() != 0)
        getServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(paramParcel1); 
      getService(iGmsCallbacks, getServiceRequest);
      Preconditions.checkNotNull(paramParcel2);
      paramParcel2.writeNoException();
      return true;
    } 
    if (paramInt1 == 47) {
      if (paramParcel1.readInt() != 0)
        zzaj = (zzaj)zzaj.CREATOR.createFromParcel(paramParcel1); 
      throw new UnsupportedOperationException();
    } 
    zzaj.readInt();
    if (paramInt1 != 4) {
      Bundle bundle;
      zzaj.readString();
      if (paramInt1 != 23 && paramInt1 != 25 && paramInt1 != 27)
        if (paramInt1 != 30) {
          if (paramInt1 != 34) {
            if (paramInt1 != 41 && paramInt1 != 43)
              switch (paramInt1) {
                default:
                  switch (paramInt1) {
                    default:
                      switch (paramInt1) {
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\IGmsServiceBroker$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */