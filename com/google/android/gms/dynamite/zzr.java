package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzr extends zza implements IInterface {
  zzr(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
  }
  
  public final IObjectWrapper zze(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper1);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper2);
    Parcel parcel1 = zzB(2, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
  
  public final IObjectWrapper zzf(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper1);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper2);
    Parcel parcel1 = zzB(3, parcel2);
    paramIObjectWrapper1 = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return paramIObjectWrapper1;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */