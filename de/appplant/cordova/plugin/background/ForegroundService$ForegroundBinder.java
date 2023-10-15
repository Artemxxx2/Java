package de.appplant.cordova.plugin.background;

import android.os.Binder;

class ForegroundBinder extends Binder {
  ForegroundService getService() {
    return ForegroundService.this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\de\appplant\cordova\plugin\background\ForegroundService$ForegroundBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */