package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class ReceiverRecord {
  boolean broadcasting;
  
  boolean dead;
  
  final IntentFilter filter;
  
  final BroadcastReceiver receiver;
  
  ReceiverRecord(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver) {
    this.filter = paramIntentFilter;
    this.receiver = paramBroadcastReceiver;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("Receiver{");
    stringBuilder.append(this.receiver);
    stringBuilder.append(" filter=");
    stringBuilder.append(this.filter);
    if (this.dead)
      stringBuilder.append(" DEAD"); 
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\localbroadcastmanager\content\LocalBroadcastManager$ReceiverRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */