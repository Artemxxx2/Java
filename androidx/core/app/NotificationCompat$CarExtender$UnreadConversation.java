package androidx.core.app;

import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;

public class UnreadConversation {
  private final long mLatestTimestamp;
  
  private final String[] mMessages;
  
  private final String[] mParticipants;
  
  private final PendingIntent mReadPendingIntent;
  
  private final RemoteInput mRemoteInput;
  
  private final PendingIntent mReplyPendingIntent;
  
  UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong) {
    this.mMessages = paramArrayOfString1;
    this.mRemoteInput = paramRemoteInput;
    this.mReadPendingIntent = paramPendingIntent2;
    this.mReplyPendingIntent = paramPendingIntent1;
    this.mParticipants = paramArrayOfString2;
    this.mLatestTimestamp = paramLong;
  }
  
  public long getLatestTimestamp() {
    return this.mLatestTimestamp;
  }
  
  public String[] getMessages() {
    return this.mMessages;
  }
  
  public String getParticipant() {
    String[] arrayOfString = this.mParticipants;
    if (arrayOfString.length > 0) {
      String str = arrayOfString[0];
    } else {
      arrayOfString = null;
    } 
    return (String)arrayOfString;
  }
  
  public String[] getParticipants() {
    return this.mParticipants;
  }
  
  public PendingIntent getReadPendingIntent() {
    return this.mReadPendingIntent;
  }
  
  public RemoteInput getRemoteInput() {
    return this.mRemoteInput;
  }
  
  public PendingIntent getReplyPendingIntent() {
    return this.mReplyPendingIntent;
  }
  
  public static class Builder {
    private long mLatestTimestamp;
    
    private final List<String> mMessages = new ArrayList<String>();
    
    private final String mParticipant;
    
    private PendingIntent mReadPendingIntent;
    
    private RemoteInput mRemoteInput;
    
    private PendingIntent mReplyPendingIntent;
    
    public Builder(String param3String) {
      this.mParticipant = param3String;
    }
    
    public Builder addMessage(String param3String) {
      this.mMessages.add(param3String);
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
    
    public Builder setLatestTimestamp(long param3Long) {
      this.mLatestTimestamp = param3Long;
      return this;
    }
    
    public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
      this.mReadPendingIntent = param3PendingIntent;
      return this;
    }
    
    public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
      this.mRemoteInput = param3RemoteInput;
      this.mReplyPendingIntent = param3PendingIntent;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$CarExtender$UnreadConversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */