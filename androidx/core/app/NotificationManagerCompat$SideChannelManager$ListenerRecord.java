package androidx.core.app;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import java.util.ArrayDeque;

class ListenerRecord {
  boolean bound = false;
  
  final ComponentName componentName;
  
  int retryCount = 0;
  
  INotificationSideChannel service;
  
  ArrayDeque<NotificationManagerCompat.Task> taskQueue = new ArrayDeque<NotificationManagerCompat.Task>();
  
  ListenerRecord(ComponentName paramComponentName) {
    this.componentName = paramComponentName;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$SideChannelManager$ListenerRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */