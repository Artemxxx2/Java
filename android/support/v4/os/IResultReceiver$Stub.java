package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class Stub extends Binder implements IResultReceiver {
  private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
  
  static final int TRANSACTION_send = 1;
  
  public Stub() {
    attachInterface(this, "android.support.v4.os.IResultReceiver");
  }
  
  public static IResultReceiver asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
    return (iInterface != null && iInterface instanceof IResultReceiver) ? (IResultReceiver)iInterface : new Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    if (paramInt1 != 1) {
      if (paramInt1 != 1598968902)
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); 
      paramParcel2.writeString("android.support.v4.os.IResultReceiver");
      return true;
    } 
    paramParcel1.enforceInterface("android.support.v4.os.IResultReceiver");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {
      Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    } 
    send(paramInt1, (Bundle)paramParcel1);
    return true;
  }
  
  private static class Proxy implements IResultReceiver {
    private IBinder mRemote;
    
    Proxy(IBinder param2IBinder) {
      this.mRemote = param2IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.v4.os.IResultReceiver";
    }
    
    public void send(int param2Int, Bundle param2Bundle) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
        parcel.writeInt(param2Int);
        if (param2Bundle != null) {
          parcel.writeInt(1);
          param2Bundle.writeToParcel(parcel, 0);
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
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\os\IResultReceiver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */