package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class null extends Handler {
  null(Looper paramLooper) {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1) {
      super.handleMessage(paramMessage);
    } else {
      LocalBroadcastManager.this.executePendingBroadcasts();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\localbroadcastmanager\content\LocalBroadcastManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */