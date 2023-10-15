package androidx.core.app;

import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import androidx.annotation.NonNull;

class CancelTask implements NotificationManagerCompat.Task {
  final boolean all;
  
  final int id;
  
  final String packageName;
  
  final String tag;
  
  CancelTask(String paramString) {
    this.packageName = paramString;
    this.id = 0;
    this.tag = null;
    this.all = true;
  }
  
  CancelTask(String paramString1, int paramInt, String paramString2) {
    this.packageName = paramString1;
    this.id = paramInt;
    this.tag = paramString2;
    this.all = false;
  }
  
  public void send(INotificationSideChannel paramINotificationSideChannel) throws RemoteException {
    if (this.all) {
      paramINotificationSideChannel.cancelAll(this.packageName);
    } else {
      paramINotificationSideChannel.cancel(this.packageName, this.id, this.tag);
    } 
  }
  
  @NonNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("CancelTask[");
    stringBuilder.append("packageName:");
    stringBuilder.append(this.packageName);
    stringBuilder.append(", id:");
    stringBuilder.append(this.id);
    stringBuilder.append(", tag:");
    stringBuilder.append(this.tag);
    stringBuilder.append(", all:");
    stringBuilder.append(this.all);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$CancelTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */