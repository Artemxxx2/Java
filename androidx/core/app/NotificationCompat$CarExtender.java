package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

public final class CarExtender implements NotificationCompat.Extender {
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
  
  private static final String EXTRA_COLOR = "app_color";
  
  private static final String EXTRA_CONVERSATION = "car_conversation";
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
  
  private static final String EXTRA_LARGE_ICON = "large_icon";
  
  private static final String KEY_AUTHOR = "author";
  
  private static final String KEY_MESSAGES = "messages";
  
  private static final String KEY_ON_READ = "on_read";
  
  private static final String KEY_ON_REPLY = "on_reply";
  
  private static final String KEY_PARTICIPANTS = "participants";
  
  private static final String KEY_REMOTE_INPUT = "remote_input";
  
  private static final String KEY_TEXT = "text";
  
  private static final String KEY_TIMESTAMP = "timestamp";
  
  private int mColor;
  
  private Bitmap mLargeIcon;
  
  private UnreadConversation mUnreadConversation;
  
  public CarExtender() {
    this.mColor = 0;
  }
  
  public CarExtender(Notification paramNotification) {
    Bundle bundle;
    this.mColor = 0;
    if (Build.VERSION.SDK_INT < 21)
      return; 
    if (NotificationCompat.getExtras(paramNotification) == null) {
      paramNotification = null;
    } else {
      bundle = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS");
    } 
    if (bundle != null) {
      this.mLargeIcon = (Bitmap)bundle.getParcelable("large_icon");
      this.mColor = bundle.getInt("app_color", 0);
      this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle("car_conversation"));
    } 
  }
  
  @RequiresApi(21)
  private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation paramUnreadConversation) {
    Bundle bundle = new Bundle();
    String[] arrayOfString = paramUnreadConversation.getParticipants();
    byte b = 0;
    if (arrayOfString != null && (paramUnreadConversation.getParticipants()).length > 1) {
      String str = paramUnreadConversation.getParticipants()[0];
    } else {
      arrayOfString = null;
    } 
    Parcelable[] arrayOfParcelable = new Parcelable[(paramUnreadConversation.getMessages()).length];
    while (b < arrayOfParcelable.length) {
      Bundle bundle1 = new Bundle();
      bundle1.putString("text", paramUnreadConversation.getMessages()[b]);
      bundle1.putString("author", (String)arrayOfString);
      arrayOfParcelable[b] = (Parcelable)bundle1;
      b++;
    } 
    bundle.putParcelableArray("messages", arrayOfParcelable);
    RemoteInput remoteInput = paramUnreadConversation.getRemoteInput();
    if (remoteInput != null)
      bundle.putParcelable("remote_input", (Parcelable)(new RemoteInput.Builder(remoteInput.getResultKey())).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build()); 
    bundle.putParcelable("on_reply", (Parcelable)paramUnreadConversation.getReplyPendingIntent());
    bundle.putParcelable("on_read", (Parcelable)paramUnreadConversation.getReadPendingIntent());
    bundle.putStringArray("participants", paramUnreadConversation.getParticipants());
    bundle.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
    return bundle;
  }
  
  @RequiresApi(21)
  private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle paramBundle) {
    RemoteInput remoteInput;
    String[] arrayOfString1;
    CharSequence charSequence = null;
    if (paramBundle == null)
      return null; 
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("messages");
    if (arrayOfParcelable != null) {
      arrayOfString1 = new String[arrayOfParcelable.length];
      byte b = 0;
      while (true) {
        if (b < arrayOfString1.length) {
          if (!(arrayOfParcelable[b] instanceof Bundle)) {
            b = 0;
            break;
          } 
          arrayOfString1[b] = ((Bundle)arrayOfParcelable[b]).getString("text");
          if (arrayOfString1[b] == null) {
            b = 0;
            break;
          } 
          b++;
          continue;
        } 
        b = 1;
        break;
      } 
      if (b == 0)
        return null; 
    } else {
      arrayOfString1 = null;
    } 
    PendingIntent pendingIntent1 = (PendingIntent)paramBundle.getParcelable("on_read");
    PendingIntent pendingIntent2 = (PendingIntent)paramBundle.getParcelable("on_reply");
    RemoteInput remoteInput1 = (RemoteInput)paramBundle.getParcelable("remote_input");
    String[] arrayOfString2 = paramBundle.getStringArray("participants");
    if (arrayOfString2 == null || arrayOfString2.length != 1)
      return null; 
    if (remoteInput1 != null) {
      boolean bool;
      String str = remoteInput1.getResultKey();
      charSequence = remoteInput1.getLabel();
      CharSequence[] arrayOfCharSequence = remoteInput1.getChoices();
      boolean bool1 = remoteInput1.getAllowFreeFormInput();
      if (Build.VERSION.SDK_INT >= 29) {
        bool = remoteInput1.getEditChoicesBeforeSending();
      } else {
        bool = false;
      } 
      remoteInput = new RemoteInput(str, charSequence, arrayOfCharSequence, bool1, bool, remoteInput1.getExtras(), null);
    } 
    return new UnreadConversation(arrayOfString1, remoteInput, pendingIntent2, pendingIntent1, arrayOfString2, paramBundle.getLong("timestamp"));
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder) {
    if (Build.VERSION.SDK_INT < 21)
      return paramBuilder; 
    Bundle bundle = new Bundle();
    Bitmap bitmap = this.mLargeIcon;
    if (bitmap != null)
      bundle.putParcelable("large_icon", (Parcelable)bitmap); 
    int i = this.mColor;
    if (i != 0)
      bundle.putInt("app_color", i); 
    UnreadConversation unreadConversation = this.mUnreadConversation;
    if (unreadConversation != null)
      bundle.putBundle("car_conversation", getBundleForUnreadConversation(unreadConversation)); 
    paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
    return paramBuilder;
  }
  
  @ColorInt
  public int getColor() {
    return this.mColor;
  }
  
  public Bitmap getLargeIcon() {
    return this.mLargeIcon;
  }
  
  public UnreadConversation getUnreadConversation() {
    return this.mUnreadConversation;
  }
  
  public CarExtender setColor(@ColorInt int paramInt) {
    this.mColor = paramInt;
    return this;
  }
  
  public CarExtender setLargeIcon(Bitmap paramBitmap) {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public CarExtender setUnreadConversation(UnreadConversation paramUnreadConversation) {
    this.mUnreadConversation = paramUnreadConversation;
    return this;
  }
  
  public static class UnreadConversation {
    private final long mLatestTimestamp;
    
    private final String[] mMessages;
    
    private final String[] mParticipants;
    
    private final PendingIntent mReadPendingIntent;
    
    private final RemoteInput mRemoteInput;
    
    private final PendingIntent mReplyPendingIntent;
    
    UnreadConversation(String[] param2ArrayOfString1, RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long) {
      this.mMessages = param2ArrayOfString1;
      this.mRemoteInput = param2RemoteInput;
      this.mReadPendingIntent = param2PendingIntent2;
      this.mReplyPendingIntent = param2PendingIntent1;
      this.mParticipants = param2ArrayOfString2;
      this.mLatestTimestamp = param2Long;
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
  
  public static class Builder {
    private long mLatestTimestamp;
    
    private final List<String> mMessages = new ArrayList<String>();
    
    private final String mParticipant;
    
    private PendingIntent mReadPendingIntent;
    
    private RemoteInput mRemoteInput;
    
    private PendingIntent mReplyPendingIntent;
    
    public Builder(String param2String) {
      this.mParticipant = param2String;
    }
    
    public Builder addMessage(String param2String) {
      this.mMessages.add(param2String);
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
    
    public Builder setLatestTimestamp(long param2Long) {
      this.mLatestTimestamp = param2Long;
      return this;
    }
    
    public Builder setReadPendingIntent(PendingIntent param2PendingIntent) {
      this.mReadPendingIntent = param2PendingIntent;
      return this;
    }
    
    public Builder setReplyAction(PendingIntent param2PendingIntent, RemoteInput param2RemoteInput) {
      this.mRemoteInput = param2RemoteInput;
      this.mReplyPendingIntent = param2PendingIntent;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$CarExtender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */