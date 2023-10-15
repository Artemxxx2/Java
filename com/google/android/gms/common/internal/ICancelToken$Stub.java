package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public abstract class Stub extends zzb implements ICancelToken {
  public Stub() {
    super("com.google.android.gms.common.internal.ICancelToken");
  }
  
  @NonNull
  public static ICancelToken asInterface(@NonNull IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
    return (iInterface instanceof ICancelToken) ? (ICancelToken)iInterface : new zzw(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, @NonNull Parcel paramParcel1, @NonNull Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 == 2) {
      cancel();
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\ICancelToken$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */