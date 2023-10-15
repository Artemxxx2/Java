package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzv extends zza implements IAccountAccessor {
  zzv(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.IAccountAccessor");
  }
  
  public final Account zzb() throws RemoteException {
    Parcel parcel = zzB(2, zza());
    Account account = (Account)zzc.zza(parcel, Account.CREATOR);
    parcel.recycle();
    return account;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */