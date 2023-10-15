package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class Proxy implements IResultReceiver {
  private IBinder mRemote;
  
  Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder() {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor() {
    return "android.support.v4.os.IResultReceiver";
  }
  
  public void send(int paramInt, Bundle paramBundle) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
      parcel.writeInt(paramInt);
      if (paramBundle != null) {
        parcel.writeInt(1);
        paramBundle.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\os\IResultReceiver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */