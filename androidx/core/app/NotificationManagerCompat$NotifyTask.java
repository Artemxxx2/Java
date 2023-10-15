package androidx.core.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.annotation.NonNull;

class NotifyTask implements NotificationManagerCompat.Task {
  final int id;
  
  final Notification notif;
  
  final String packageName;
  
  final String tag;
  
  NotifyTask(String paramString1, int paramInt, String paramString2, Notification paramNotification) {
    this.packageName = paramString1;
    this.id = paramInt;
    this.tag = paramString2;
    this.notif = paramNotification;
  }
  
  public void send(INotificationSideChannel paramINotificationSideChannel) throws RemoteException {
    paramINotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
  }
  
  @NonNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
    stringBuilder.append("packageName:");
    stringBuilder.append(this.packageName);
    stringBuilder.append(", id:");
    stringBuilder.append(this.id);
    stringBuilder.append(", tag:");
    stringBuilder.append(this.tag);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$NotifyTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */