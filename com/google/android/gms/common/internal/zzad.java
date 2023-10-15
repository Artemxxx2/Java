package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzad extends zza implements zzaf {
  zzad(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
  }
  
  public final zzq zze(zzo paramzzo) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzd(parcel2, (Parcelable)paramzzo);
    Parcel parcel1 = zzB(6, parcel2);
    zzq zzq = (zzq)zzc.zza(parcel1, zzq.CREATOR);
    parcel1.recycle();
    return zzq;
  }
  
  public final zzq zzf(zzo paramzzo) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzd(parcel2, (Parcelable)paramzzo);
    Parcel parcel1 = zzB(8, parcel2);
    zzq zzq = (zzq)zzc.zza(parcel1, zzq.CREATOR);
    parcel1.recycle();
    return zzq;
  }
  
  public final boolean zzg() throws RemoteException {
    Parcel parcel = zzB(9, zza());
    boolean bool = zzc.zzg(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean zzh(zzs paramzzs, IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zzd(parcel2, (Parcelable)paramzzs);
    zzc.zzf(parcel2, (IInterface)paramIObjectWrapper);
    Parcel parcel1 = zzB(5, parcel2);
    boolean bool = zzc.zzg(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final boolean zzi() throws RemoteException {
    Parcel parcel = zzB(7, zza());
    boolean bool = zzc.zzg(parcel);
    parcel.recycle();
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */