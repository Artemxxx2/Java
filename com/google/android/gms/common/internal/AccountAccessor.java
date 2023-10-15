package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

public class AccountAccessor extends IAccountAccessor.Stub {
  @Nullable
  @KeepForSdk
  public static Account getAccountBinderSafe(@NonNull IAccountAccessor paramIAccountAccessor) {
    RemoteException remoteException1;
    Account account = null;
    RemoteException remoteException2 = null;
    if (paramIAccountAccessor != null) {
      long l = Binder.clearCallingIdentity();
      try {
        Account account1 = paramIAccountAccessor.zzb();
        Binder.restoreCallingIdentity(l);
        account = account1;
      } catch (RemoteException remoteException) {
        Log.w("AccountAccessor", "Remote account accessor probably died");
        remoteException = remoteException2;
        Binder.restoreCallingIdentity(l);
        remoteException1 = remoteException;
      } finally {}
    } 
    return (Account)remoteException1;
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    throw null;
  }
  
  @NonNull
  public final Account zzb() {
    throw null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\AccountAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */