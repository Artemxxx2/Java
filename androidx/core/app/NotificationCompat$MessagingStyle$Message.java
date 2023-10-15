package androidx.core.app;

import android.app.Person;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class Message {
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
  
  public Message(CharSequence paramCharSequence, long paramLong, @Nullable Person paramPerson) {
    this.mText = paramCharSequence;
    this.mTimestamp = paramLong;
    this.mPerson = paramPerson;
  }
  
  @Deprecated
  public Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2) {
    this(paramCharSequence1, paramLong, (new Person.Builder()).setName(paramCharSequence2).build());
  }
  
  @NonNull
  static Bundle[] getBundleArrayForMessages(List<Message> paramList) {
    Bundle[] arrayOfBundle = new Bundle[paramList.size()];
    int i = paramList.size();
    for (byte b = 0; b < i; b++)
      arrayOfBundle[b] = ((Message)paramList.get(b)).toBundle(); 
    return arrayOfBundle;
  }
  
  @Nullable
  static Message getMessageFromBundle(Bundle paramBundle) {
    try {
      Person person;
      if (!paramBundle.containsKey("text") || !paramBundle.containsKey("time"))
        return null; 
      if (paramBundle.containsKey("person")) {
        person = Person.fromBundle(paramBundle.getBundle("person"));
      } else if (paramBundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
        person = Person.fromAndroidPerson((Person)paramBundle.getParcelable("sender_person"));
      } else if (paramBundle.containsKey("sender")) {
        Person.Builder builder = new Person.Builder();
        this();
        person = builder.setName(paramBundle.getCharSequence("sender")).build();
      } else {
        person = null;
      } 
      Message message = new Message();
      this(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), person);
      if (paramBundle.containsKey("type") && paramBundle.containsKey("uri"))
        message.setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri")); 
      if (paramBundle.containsKey("extras"))
        message.getExtras().putAll(paramBundle.getBundle("extras")); 
      return message;
    } catch (ClassCastException classCastException) {
      return null;
    } 
  }
  
  @NonNull
  static List<Message> getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable) {
    ArrayList<Message> arrayList = new ArrayList(paramArrayOfParcelable.length);
    for (byte b = 0; b < paramArrayOfParcelable.length; b++) {
      if (paramArrayOfParcelable[b] instanceof Bundle) {
        Message message = getMessageFromBundle((Bundle)paramArrayOfParcelable[b]);
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
  
  public Message setData(String paramString, Uri paramUri) {
    this.mDataMimeType = paramString;
    this.mDataUri = paramUri;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\NotificationCompat$MessagingStyle$Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */