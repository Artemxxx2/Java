package androidx.localbroadcastmanager.content;

import android.content.Intent;
import java.util.ArrayList;

final class BroadcastRecord {
  final Intent intent;
  
  final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
  
  BroadcastRecord(Intent paramIntent, ArrayList<LocalBroadcastManager.ReceiverRecord> paramArrayList) {
    this.intent = paramIntent;
    this.receivers = paramArrayList;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\localbroadcastmanager\content\LocalBroadcastManager$BroadcastRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */