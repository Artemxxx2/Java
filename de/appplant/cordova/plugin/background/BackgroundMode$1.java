package de.appplant.cordova.plugin.background;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class null implements ServiceConnection {
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    ForegroundService.ForegroundBinder foregroundBinder = (ForegroundService.ForegroundBinder)paramIBinder;
    BackgroundMode.access$002(BackgroundMode.this, foregroundBinder.getService());
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    BackgroundMode.access$100(BackgroundMode.this, BackgroundMode.Event.FAILURE, "'service disconnected'");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\appplant\cordova\plugin\background\BackgroundMode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */