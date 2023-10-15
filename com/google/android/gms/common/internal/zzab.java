package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzab extends zzb implements IGmsCallbacks {
  public zzab() {
    super("com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    IBinder iBinder2;
    Bundle bundle1;
    zzj zzj;
    switch (paramInt1) {
      default:
        return false;
      case 3:
        paramInt1 = paramParcel1.readInt();
        iBinder2 = paramParcel1.readStrongBinder();
        zzj = (zzj)zzc.zza(paramParcel1, zzj.CREATOR);
        zzc.zzb(paramParcel1);
        zzc(paramInt1, iBinder2, zzj);
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramInt1 = paramParcel1.readInt();
        bundle1 = (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR);
        zzc.zzb(paramParcel1);
        zzb(paramInt1, bundle1);
        paramParcel2.writeNoException();
        return true;
      case 1:
        break;
    } 
    paramInt1 = paramParcel1.readInt();
    IBinder iBinder1 = paramParcel1.readStrongBinder();
    Bundle bundle2 = (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR);
    zzc.zzb(paramParcel1);
    onPostInitComplete(paramInt1, iBinder1, bundle2);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */