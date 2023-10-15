package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class Stub extends Binder implements INotificationSideChannel {
  private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
  
  static final int TRANSACTION_cancel = 2;
  
  static final int TRANSACTION_cancelAll = 3;
  
  static final int TRANSACTION_notify = 1;
  
  public Stub() {
    attachInterface(this, "android.support.v4.app.INotificationSideChannel");
  }
  
  public static INotificationSideChannel asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
    return (iInterface != null && iInterface instanceof INotificationSideChannel) ? (INotificationSideChannel)iInterface : new Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    String str;
    if (paramInt1 != 1598968902) {
      switch (paramInt1) {
        default:
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 3:
          paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
          cancelAll(paramParcel1.readString());
          return true;
        case 2:
          paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
          cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
          return true;
        case 1:
          break;
      } 
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      String str1 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        Notification notification = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = null;
      } 
      notify(str1, paramInt1, str, (Notification)paramParcel1);
      return true;
    } 
    str.writeString("android.support.v4.app.INotificationSideChannel");
    return true;
  }
  
  private static class Proxy implements INotificationSideChannel {
    private IBinder mRemote;
    
    Proxy(IBinder param2IBinder) {
      this.mRemote = param2IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void cancel(String param2String1, int param2Int, String param2String2) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        parcel.writeString(param2String1);
        parcel.writeInt(param2Int);
        parcel.writeString(param2String2);
        this.mRemote.transact(2, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void cancelAll(String param2String) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        parcel.writeString(param2String);
        this.mRemote.transact(3, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.v4.app.INotificationSideChannel";
    }
    
    public void notify(String param2String1, int param2Int, String param2String2, Notification param2Notification) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        parcel.writeString(param2String1);
        parcel.writeInt(param2Int);
        parcel.writeString(param2String2);
        if (param2Notification != null) {
          parcel.writeInt(1);
          param2Notification.writeToParcel(parcel, 0);
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\app\INotificationSideChannel$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */