package androidx.core.app;

import android.content.ComponentName;
import android.os.IBinder;

class ServiceConnectedEvent {
  final ComponentName componentName;
  
  final IBinder iBinder;
  
  ServiceConnectedEvent(ComponentName paramComponentName, IBinder paramIBinder) {
    this.componentName = paramComponentName;
    this.iBinder = paramIBinder;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationManagerCompat$ServiceConnectedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */