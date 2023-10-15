package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class Stub extends zzb implements IAccountAccessor {
  public Stub() {
    super("com.google.android.gms.common.internal.IAccountAccessor");
  }
  
  @NonNull
  public static IAccountAccessor asInterface(@NonNull IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    return (iInterface instanceof IAccountAccessor) ? (IAccountAccessor)iInterface : new zzv(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, @NonNull Parcel paramParcel1, @NonNull Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 2) {
      Account account = zzb();
      paramParcel2.writeNoException();
      zzc.zze(paramParcel2, (Parcelable)account);
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\IAccountAccessor$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */