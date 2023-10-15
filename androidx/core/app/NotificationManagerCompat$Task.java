package androidx.core.app;

import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

interface Task {
  void send(INotificationSideChannel paramINotificationSideChannel) throws RemoteException;
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */