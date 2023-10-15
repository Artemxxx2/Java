package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzaa extends zza implements IGmsCallbacks {
  zzaa(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    parcel.writeStrongBinder(paramIBinder);
    zzc.zzd(parcel, (Parcelable)paramBundle);
    zzC(1, parcel);
  }
  
  public final void zzb(int paramInt, Bundle paramBundle) throws RemoteException {
    throw null;
  }
  
  public final void zzc(int paramInt, IBinder paramIBinder, zzj paramzzj) throws RemoteException {
    throw null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */