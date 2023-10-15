package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

public final class zzw extends zza implements ICancelToken {
  zzw(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.common.internal.ICancelToken");
  }
  
  public final void cancel() throws RemoteException {
    zzD(2, zza());
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */