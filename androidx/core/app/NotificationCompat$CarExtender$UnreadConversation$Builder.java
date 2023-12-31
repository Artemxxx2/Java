package androidx.core.app;

import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;

public class Builder {
  private long mLatestTimestamp;
  
  private final List<String> mMessages = new ArrayList<String>();
  
  private final String mParticipant;
  
  private PendingIntent mReadPendingIntent;
  
  private RemoteInput mRemoteInput;
  
  private PendingIntent mReplyPendingIntent;
  
  public Builder(String paramString) {
    this.mParticipant = paramString;
  }
  
  public Builder addMessage(String paramString) {
    this.mMessages.add(paramString);
    return this;
  }
  
  public NotificationCompat.CarExtender.UnreadConversation build() {
    List<String> list = this.mMessages;
    String[] arrayOfString = list.<String>toArray(new String[list.size()]);
    String str = this.mParticipant;
    RemoteInput remoteInput = this.mRemoteInput;
    PendingIntent pendingIntent1 = this.mReplyPendingIntent;
    PendingIntent pendingIntent2 = this.mReadPendingIntent;
    long l = this.mLatestTimestamp;
    return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
  }
  
  public Builder setLatestTimestamp(long paramLong) {
    this.mLatestTimestamp = paramLong;
    return this;
  }
  
  public Builder setReadPendingIntent(PendingIntent paramPendingIntent) {
    this.mReadPendingIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput) {
    this.mRemoteInput = paramRemoteInput;
    this.mReplyPendingIntent = paramPendingIntent;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$CarExtender$UnreadConversation$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */