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

public interface IAccountAccessor extends IInterface {
  @NonNull
  Account zzb() throws RemoteException;
  
  public static abstract class Stub extends zzb implements IAccountAccessor {
    public Stub() {
      super("com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    @NonNull
    public static IAccountAccessor asInterface(@NonNull IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
      return (iInterface instanceof IAccountAccessor) ? (IAccountAccessor)iInterface : new zzv(param1IBinder);
    }
    
    protected final boolean zza(int param1Int1, @NonNull Parcel param1Parcel1, @NonNull Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 == 2) {
        Account account = zzb();
        param1Parcel2.writeNoException();
        zzc.zze(param1Parcel2, (Parcelable)account);
        return true;
      } 
      return false;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\IAccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */