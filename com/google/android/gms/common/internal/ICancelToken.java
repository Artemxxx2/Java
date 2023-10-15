package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public interface ICancelToken extends IInterface {
  void cancel() throws RemoteException;
  
  public static abstract class Stub extends zzb implements ICancelToken {
    public Stub() {
      super("com.google.android.gms.common.internal.ICancelToken");
    }
    
    @NonNull
    public static ICancelToken asInterface(@NonNull IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
      return (iInterface instanceof ICancelToken) ? (ICancelToken)iInterface : new zzw(param1IBinder);
    }
    
    protected final boolean zza(int param1Int1, @NonNull Parcel param1Parcel1, @NonNull Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 == 2) {
        cancel();
        return true;
      } 
      return false;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\ICancelToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */