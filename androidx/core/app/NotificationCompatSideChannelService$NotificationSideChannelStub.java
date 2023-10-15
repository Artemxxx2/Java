package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

class NotificationSideChannelStub extends INotificationSideChannel.Stub {
  public void cancel(String paramString1, int paramInt, String paramString2) throws RemoteException {
    NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try {
      NotificationCompatSideChannelService.this.cancel(paramString1, paramInt, paramString2);
      return;
    } finally {
      restoreCallingIdentity(l);
    } 
  }
  
  public void cancelAll(String paramString) {
    NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), paramString);
    long l = clearCallingIdentity();
    try {
      NotificationCompatSideChannelService.this.cancelAll(paramString);
      return;
    } finally {
      restoreCallingIdentity(l);
    } 
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification) throws RemoteException {
    NotificationCompatSideChannelService.this.checkPermission(getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try {
      NotificationCompatSideChannelService.this.notify(paramString1, paramInt, paramString2, paramNotification);
      return;
    } finally {
      restoreCallingIdentity(l);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompatSideChannelService$NotificationSideChannelStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */