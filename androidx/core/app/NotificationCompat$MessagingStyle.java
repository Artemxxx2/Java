package androidx.core.app;

import android.app.Notification;
import android.app.Person;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.text.BidiFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessagingStyle extends NotificationCompat.Style {
  public static final int MAXIMUM_RETAINED_MESSAGES = 25;
  
  @Nullable
  private CharSequence mConversationTitle;
  
  @Nullable
  private Boolean mIsGroupConversation;
  
  private final List<Message> mMessages = new ArrayList<Message>();
  
  private Person mUser;
  
  private MessagingStyle() {}
  
  public MessagingStyle(@NonNull Person paramPerson) {
    if (!TextUtils.isEmpty(paramPerson.getName())) {
      this.mUser = paramPerson;
      return;
    } 
    throw new IllegalArgumentException("User's name must not be empty.");
  }
  
  @Deprecated
  public MessagingStyle(@NonNull CharSequence paramCharSequence) {
    this.mUser = (new Person.Builder()).setName(paramCharSequence).build();
  }
  
  @Nullable
  public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification) {
    Bundle bundle = NotificationCompat.getExtras(paramNotification);
    if (bundle != null && !bundle.containsKey("android.selfDisplayName") && !bundle.containsKey("android.messagingStyleUser"))
      return null; 
    try {
      MessagingStyle messagingStyle = new MessagingStyle();
      this();
      messagingStyle.restoreFromCompatExtras(bundle);
      return messagingStyle;
    } catch (ClassCastException classCastException) {
      return null;
    } 
  }
  
  @Nullable
  private Message findLatestIncomingMessage() {
    for (int i = this.mMessages.size() - 1; i >= 0; i--) {
      Message message = this.mMessages.get(i);
      if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName()))
        return message; 
    } 
    if (!this.mMessages.isEmpty()) {
      List<Message> list = this.mMessages;
      return list.get(list.size() - 1);
    } 
    return null;
  }
  
  private boolean hasMessagesWithoutSender() {
    for (int i = this.mMessages.size() - 1; i >= 0; i--) {
      Message message = this.mMessages.get(i);
      if (message.getPerson() != null && message.getPerson().getName() == null)
        return true; 
    } 
    return false;
  }
  
  @NonNull
  private TextAppearanceSpan makeFontColorSpan(int paramInt) {
    return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
  }
  
  private CharSequence makeMessageLine(Message paramMessage) {
    CharSequence charSequence1;
    boolean bool;
    byte b;
    BidiFormatter bidiFormatter = BidiFormatter.getInstance();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      b = -16777216;
    } else {
      b = -1;
    } 
    if (paramMessage.getPerson() == null) {
      charSequence2 = "";
    } else {
      charSequence2 = paramMessage.getPerson().getName();
    } 
    int i = b;
    CharSequence charSequence3 = charSequence2;
    if (TextUtils.isEmpty(charSequence2)) {
      charSequence2 = this.mUser.getName();
      i = b;
      charSequence3 = charSequence2;
      if (bool) {
        i = b;
        charSequence3 = charSequence2;
        if (this.mBuilder.getColor() != 0) {
          i = this.mBuilder.getColor();
          charSequence3 = charSequence2;
        } 
      } 
    } 
    CharSequence charSequence2 = bidiFormatter.unicodeWrap(charSequence3);
    spannableStringBuilder.append(charSequence2);
    spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - charSequence2.length(), spannableStringBuilder.length(), 33);
    if (paramMessage.getText() == null) {
      charSequence1 = "";
    } else {
      charSequence1 = charSequence1.getText();
    } 
    spannableStringBuilder.append("  ").append(bidiFormatter.unicodeWrap(charSequence1));
    return (CharSequence)spannableStringBuilder;
  }
  
  public void addCompatExtras(Bundle paramBundle) {
    super.addCompatExtras(paramBundle);
    paramBundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
    paramBundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
    paramBundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
    if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue())
      paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle); 
    if (!this.mMessages.isEmpty())
      paramBundle.putParcelableArray("android.messages", (Parcelable[])Message.getBundleArrayForMessages(this.mMessages)); 
    Boolean bool = this.mIsGroupConversation;
    if (bool != null)
      paramBundle.putBoolean("android.isGroupConversation", bool.booleanValue()); 
  }
  
  public MessagingStyle addMessage(Message paramMessage) {
    this.mMessages.add(paramMessage);
    if (this.mMessages.size() > 25)
      this.mMessages.remove(0); 
    return this;
  }
  
  public MessagingStyle addMessage(CharSequence paramCharSequence, long paramLong, Person paramPerson) {
    addMessage(new Message(paramCharSequence, paramLong, paramPerson));
    return this;
  }
  
  @Deprecated
  public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2) {
    this.mMessages.add(new Message(paramCharSequence1, paramLong, (new Person.Builder()).setName(paramCharSequence2).build()));
    if (this.mMessages.size() > 25)
      this.mMessages.remove(0); 
    return this;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    setGroupConversation(isGroupConversation());
    if (Build.VERSION.SDK_INT >= 24) {
      Notification.MessagingStyle messagingStyle;
      if (Build.VERSION.SDK_INT >= 28) {
        messagingStyle = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
      } else {
        messagingStyle = new Notification.MessagingStyle(this.mUser.getName());
      } 
      if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28)
        messagingStyle.setConversationTitle(this.mConversationTitle); 
      if (Build.VERSION.SDK_INT >= 28)
        messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue()); 
      for (Message message : this.mMessages) {
        Notification.MessagingStyle.Message message1;
        if (Build.VERSION.SDK_INT >= 28) {
          Person person;
          Person person1 = message.getPerson();
          CharSequence charSequence = message.getText();
          long l = message.getTimestamp();
          if (person1 == null) {
            person1 = null;
          } else {
            person = person1.toAndroidPerson();
          } 
          message1 = new Notification.MessagingStyle.Message(charSequence, l, person);
        } else {
          if (message.getPerson() != null) {
            message1 = (Notification.MessagingStyle.Message)message.getPerson().getName();
          } else {
            message1 = null;
          } 
          message1 = new Notification.MessagingStyle.Message(message.getText(), message.getTimestamp(), (CharSequence)message1);
        } 
        if (message.getDataMimeType() != null)
          message1.setData(message.getDataMimeType(), message.getDataUri()); 
        messagingStyle.addMessage(message1);
      } 
      messagingStyle.setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
    } else {
      Message message = findLatestIncomingMessage();
      if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
      } else if (message != null) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
        if (message.getPerson() != null)
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(message.getPerson().getName()); 
      } 
      if (message != null) {
        CharSequence charSequence;
        Notification.Builder builder = paramNotificationBuilderWithBuilderAccessor.getBuilder();
        if (this.mConversationTitle != null) {
          charSequence = makeMessageLine(message);
        } else {
          charSequence = charSequence.getText();
        } 
        builder.setContentText(charSequence);
      } 
      if (Build.VERSION.SDK_INT >= 16) {
        boolean bool;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mConversationTitle != null || hasMessagesWithoutSender()) {
          bool = true;
        } else {
          bool = false;
        } 
        for (int i = this.mMessages.size() - 1; i >= 0; i--) {
          CharSequence charSequence;
          message = this.mMessages.get(i);
          if (bool) {
            charSequence = makeMessageLine(message);
          } else {
            charSequence = charSequence.getText();
          } 
          if (i != this.mMessages.size() - 1)
            spannableStringBuilder.insert(0, "\n"); 
          spannableStringBuilder.insert(0, charSequence);
        } 
        (new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(null).bigText((CharSequence)spannableStringBuilder);
      } 
    } 
  }
  
  @Nullable
  public CharSequence getConversationTitle() {
    return this.mConversationTitle;
  }
  
  public List<Message> getMessages() {
    return this.mMessages;
  }
  
  public Person getUser() {
    return this.mUser;
  }
  
  @Deprecated
  public CharSequence getUserDisplayName() {
    return this.mUser.getName();
  }
  
  public boolean isGroupConversation() {
    NotificationCompat.Builder builder = this.mBuilder;
    boolean bool1 = false;
    boolean bool2 = false;
    if (builder != null && (this.mBuilder.mContext.getApplicationInfo()).targetSdkVersion < 28 && this.mIsGroupConversation == null) {
      if (this.mConversationTitle != null)
        bool2 = true; 
      return bool2;
    } 
    Boolean bool = this.mIsGroupConversation;
    bool2 = bool1;
    if (bool != null)
      bool2 = bool.booleanValue(); 
    return bool2;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void restoreFromCompatExtras(Bundle paramBundle) {
    this.mMessages.clear();
    if (paramBundle.containsKey("android.messagingStyleUser")) {
      this.mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser"));
    } else {
      this.mUser = (new Person.Builder()).setName(paramBundle.getString("android.selfDisplayName")).build();
    } 
    this.mConversationTitle = paramBundle.getCharSequence("android.conversationTitle");
    if (this.mConversationTitle == null)
      this.mConversationTitle = paramBundle.getCharSequence("android.hiddenConversationTitle"); 
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("android.messages");
    if (arrayOfParcelable != null)
      this.mMessages.addAll(Message.getMessagesFromBundleArray(arrayOfParcelable)); 
    if (paramBundle.containsKey("android.isGroupConversation"))
      this.mIsGroupConversation = Boolean.valueOf(paramBundle.getBoolean("android.isGroupConversation")); 
  }
  
  public MessagingStyle setConversationTitle(@Nullable CharSequence paramCharSequence) {
    this.mConversationTitle = paramCharSequence;
    return this;
  }
  
  public MessagingStyle setGroupConversation(boolean paramBoolean) {
    this.mIsGroupConversation = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public static final class Message {
    static final String KEY_DATA_MIME_TYPE = "type";
    
    static final String KEY_DATA_URI = "uri";
    
    static final String KEY_EXTRAS_BUNDLE = "extras";
    
    static final String KEY_NOTIFICATION_PERSON = "sender_person";
    
    static final String KEY_PERSON = "person";
    
    static final String KEY_SENDER = "sender";
    
    static final String KEY_TEXT = "text";
    
    static final String KEY_TIMESTAMP = "time";
    
    @Nullable
    private String mDataMimeType;
    
    @Nullable
    private Uri mDataUri;
    
    private Bundle mExtras = new Bundle();
    
    @Nullable
    private final Person mPerson;
    
    private final CharSequence mText;
    
    private final long mTimestamp;
    
    public Message(CharSequence param2CharSequence, long param2Long, @Nullable Person param2Person) {
      this.mText = param2CharSequence;
      this.mTimestamp = param2Long;
      this.mPerson = param2Person;
    }
    
    @Deprecated
    public Message(CharSequence param2CharSequence1, long param2Long, CharSequence param2CharSequence2) {
      this(param2CharSequence1, param2Long, (new Person.Builder()).setName(param2CharSequence2).build());
    }
    
    @NonNull
    static Bundle[] getBundleArrayForMessages(List<Message> param2List) {
      Bundle[] arrayOfBundle = new Bundle[param2List.size()];
      int i = param2List.size();
      for (byte b = 0; b < i; b++)
        arrayOfBundle[b] = ((Message)param2List.get(b)).toBundle(); 
      return arrayOfBundle;
    }
    
    @Nullable
    static Message getMessageFromBundle(Bundle param2Bundle) {
      try {
        Person person;
        if (!param2Bundle.containsKey("text") || !param2Bundle.containsKey("time"))
          return null; 
        if (param2Bundle.containsKey("person")) {
          person = Person.fromBundle(param2Bundle.getBundle("person"));
        } else if (param2Bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
          person = Person.fromAndroidPerson((Person)param2Bundle.getParcelable("sender_person"));
        } else if (param2Bundle.containsKey("sender")) {
          Person.Builder builder = new Person.Builder();
          this();
          person = builder.setName(param2Bundle.getCharSequence("sender")).build();
        } else {
          person = null;
        } 
        Message message = new Message();
        this(param2Bundle.getCharSequence("text"), param2Bundle.getLong("time"), person);
        if (param2Bundle.containsKey("type") && param2Bundle.containsKey("uri"))
          message.setData(param2Bundle.getString("type"), (Uri)param2Bundle.getParcelable("uri")); 
        if (param2Bundle.containsKey("extras"))
          message.getExtras().putAll(param2Bundle.getBundle("extras")); 
        return message;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    @NonNull
    static List<Message> getMessagesFromBundleArray(Parcelable[] param2ArrayOfParcelable) {
      ArrayList<Message> arrayList = new ArrayList(param2ArrayOfParcelable.length);
      for (byte b = 0; b < param2ArrayOfParcelable.length; b++) {
        if (param2ArrayOfParcelable[b] instanceof Bundle) {
          Message message = getMessageFromBundle((Bundle)param2ArrayOfParcelable[b]);
          if (message != null)
            arrayList.add(message); 
        } 
      } 
      return arrayList;
    }
    
    private Bundle toBundle() {
      Bundle bundle1 = new Bundle();
      CharSequence charSequence = this.mText;
      if (charSequence != null)
        bundle1.putCharSequence("text", charSequence); 
      bundle1.putLong("time", this.mTimestamp);
      Person person = this.mPerson;
      if (person != null) {
        bundle1.putCharSequence("sender", person.getName());
        if (Build.VERSION.SDK_INT >= 28) {
          bundle1.putParcelable("sender_person", (Parcelable)this.mPerson.toAndroidPerson());
        } else {
          bundle1.putBundle("person", this.mPerson.toBundle());
        } 
      } 
      String str = this.mDataMimeType;
      if (str != null)
        bundle1.putString("type", str); 
      Uri uri = this.mDataUri;
      if (uri != null)
        bundle1.putParcelable("uri", (Parcelable)uri); 
      Bundle bundle2 = this.mExtras;
      if (bundle2 != null)
        bundle1.putBundle("extras", bundle2); 
      return bundle1;
    }
    
    @Nullable
    public String getDataMimeType() {
      return this.mDataMimeType;
    }
    
    @Nullable
    public Uri getDataUri() {
      return this.mDataUri;
    }
    
    @NonNull
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    @Nullable
    public Person getPerson() {
      return this.mPerson;
    }
    
    @Deprecated
    @Nullable
    public CharSequence getSender() {
      CharSequence charSequence;
      Person person = this.mPerson;
      if (person == null) {
        person = null;
      } else {
        charSequence = person.getName();
      } 
      return charSequence;
    }
    
    @NonNull
    public CharSequence getText() {
      return this.mText;
    }
    
    public long getTimestamp() {
      return this.mTimestamp;
    }
    
    public Message setData(String param2String, Uri param2Uri) {
      this.mDataMimeType = param2String;
      this.mDataUri = param2Uri;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$MessagingStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */