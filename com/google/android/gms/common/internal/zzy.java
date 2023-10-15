package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzy extends zzb implements zzz {
  public zzy() {
    super("com.google.android.gms.common.internal.ICertData");
  }
  
  public static zzz zzg(IBinder paramIBinder) {
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
    return (iInterface instanceof zzz) ? (zzz)iInterface : new zzx(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    switch (paramInt1) {
      default:
        return false;
      case 2:
        paramInt1 = zzc();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 1:
        break;
    } 
    IObjectWrapper iObjectWrapper = zzd();
    paramParcel2.writeNoException();
    zzc.zzf(paramParcel2, (IInterface)iObjectWrapper);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */