package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class Proxy implements INotificationSideChannel {
  private IBinder mRemote;
  
  Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder() {
    return this.mRemote;
  }
  
  public void cancel(String paramString1, int paramInt, String paramString2) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      parcel.writeString(paramString1);
      parcel.writeInt(paramInt);
      parcel.writeString(paramString2);
      this.mRemote.transact(2, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public void cancelAll(String paramString) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      parcel.writeString(paramString);
      this.mRemote.transact(3, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public String getInterfaceDescriptor() {
    return "android.support.v4.app.INotificationSideChannel";
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification) throws RemoteException {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      parcel.writeString(paramString1);
      parcel.writeInt(paramInt);
      parcel.writeString(paramString2);
      if (paramNotification != null) {
        parcel.writeInt(1);
        paramNotification.writeToParcel(parcel, 0);
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


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\app\INotificationSideChannel$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */