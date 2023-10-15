package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

public interface IGmsCallbacks extends IInterface {
  void onPostInitComplete(int paramInt, @NonNull IBinder paramIBinder, @NonNull Bundle paramBundle) throws RemoteException;
  
  void zzb(int paramInt, @NonNull Bundle paramBundle) throws RemoteException;
  
  void zzc(int paramInt, IBinder paramIBinder, zzj paramzzj) throws RemoteException;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\IGmsCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */