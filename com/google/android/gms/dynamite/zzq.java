package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzq extends zza implements IInterface {
  zzq(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
  }
  
  public final int zze() throws RemoteException {
    Parcel parcel = zzB(6, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final int zzf(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    parcel2.writeString(paramString);
    zzc.zzc(parcel2, paramBoolean);
    Parcel parcel1 = zzB(3, parcel2);
    int i = parcel1.readInt();
    parcel1.recycle();
    return i;
  }
  
  public final int zzg(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    parcel2.writeString(paramString);
    zzc.zzc(parcel2, paramBoolean);
    Parcel parcel1 = zzB(5, parcel2);
    int i = parcel1.readInt();
    parcel1.recycle();
    return i;
  }
  
  public final IObjectWrapper zzh(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    Parcel parcel1 = zzB(2, parcel2);
    paramIObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return paramIObjectWrapper;
  }
  
  public final IObjectWrapper zzi(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper1);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper2);
    Parcel parcel1 = zzB(8, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
  
  public final IObjectWrapper zzj(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    parcel2.writeString(paramString);
    parcel2.writeInt(paramInt);
    Parcel parcel1 = zzB(4, parcel2);
    paramIObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return paramIObjectWrapper;
  }
  
  public final IObjectWrapper zzk(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean, long paramLong) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    parcel2.writeString(paramString);
    zzc.zzc(parcel2, paramBoolean);
    parcel2.writeLong(paramLong);
    Parcel parcel1 = zzB(7, parcel2);
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return iObjectWrapper;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\dynamite\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */