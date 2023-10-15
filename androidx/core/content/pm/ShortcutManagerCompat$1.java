package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;

final class null extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    try {
      callback.sendIntent(paramContext, 0, null, null, null);
    } catch (android.content.IntentSender.SendIntentException sendIntentException) {}
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutManagerCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */