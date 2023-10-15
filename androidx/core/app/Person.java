package androidx.core.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

public class Person {
  private static final String ICON_KEY = "icon";
  
  private static final String IS_BOT_KEY = "isBot";
  
  private static final String IS_IMPORTANT_KEY = "isImportant";
  
  private static final String KEY_KEY = "key";
  
  private static final String NAME_KEY = "name";
  
  private static final String URI_KEY = "uri";
  
  @Nullable
  IconCompat mIcon;
  
  boolean mIsBot;
  
  boolean mIsImportant;
  
  @Nullable
  String mKey;
  
  @Nullable
  CharSequence mName;
  
  @Nullable
  String mUri;
  
  Person(Builder paramBuilder) {
    this.mName = paramBuilder.mName;
    this.mIcon = paramBuilder.mIcon;
    this.mUri = paramBuilder.mUri;
    this.mKey = paramBuilder.mKey;
    this.mIsBot = paramBuilder.mIsBot;
    this.mIsImportant = paramBuilder.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Person fromAndroidPerson(@NonNull android.app.Person paramPerson) {
    IconCompat iconCompat;
    Builder builder = (new Builder()).setName(paramPerson.getName());
    if (paramPerson.getIcon() != null) {
      iconCompat = IconCompat.createFromIcon(paramPerson.getIcon());
    } else {
      iconCompat = null;
    } 
    return builder.setIcon(iconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
  }
  
  @NonNull
  public static Person fromBundle(@NonNull Bundle paramBundle) {
    Bundle bundle = paramBundle.getBundle("icon");
    Builder builder = (new Builder()).setName(paramBundle.getCharSequence("name"));
    if (bundle != null) {
      IconCompat iconCompat = IconCompat.createFromBundle(bundle);
    } else {
      bundle = null;
    } 
    return builder.setIcon((IconCompat)bundle).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
  }
  
  @NonNull
  @RequiresApi(22)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Person fromPersistableBundle(@NonNull PersistableBundle paramPersistableBundle) {
    return (new Builder()).setName(paramPersistableBundle.getString("name")).setUri(paramPersistableBundle.getString("uri")).setKey(paramPersistableBundle.getString("key")).setBot(paramPersistableBundle.getBoolean("isBot")).setImportant(paramPersistableBundle.getBoolean("isImportant")).build();
  }
  
  @Nullable
  public IconCompat getIcon() {
    return this.mIcon;
  }
  
  @Nullable
  public String getKey() {
    return this.mKey;
  }
  
  @Nullable
  public CharSequence getName() {
    return this.mName;
  }
  
  @Nullable
  public String getUri() {
    return this.mUri;
  }
  
  public boolean isBot() {
    return this.mIsBot;
  }
  
  public boolean isImportant() {
    return this.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public android.app.Person toAndroidPerson() {
    Icon icon;
    android.app.Person.Builder builder = (new android.app.Person.Builder()).setName(getName());
    if (getIcon() != null) {
      icon = getIcon().toIcon();
    } else {
      icon = null;
    } 
    return builder.setIcon(icon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
  }
  
  @NonNull
  public Builder toBuilder() {
    return new Builder(this);
  }
  
  @NonNull
  public Bundle toBundle() {
    Bundle bundle = new Bundle();
    bundle.putCharSequence("name", this.mName);
    IconCompat iconCompat = this.mIcon;
    if (iconCompat != null) {
      Bundle bundle1 = iconCompat.toBundle();
    } else {
      iconCompat = null;
    } 
    bundle.putBundle("icon", (Bundle)iconCompat);
    bundle.putString("uri", this.mUri);
    bundle.putString("key", this.mKey);
    bundle.putBoolean("isBot", this.mIsBot);
    bundle.putBoolean("isImportant", this.mIsImportant);
    return bundle;
  }
  
  @NonNull
  @RequiresApi(22)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PersistableBundle toPersistableBundle() {
    PersistableBundle persistableBundle = new PersistableBundle();
    CharSequence charSequence = this.mName;
    if (charSequence != null) {
      charSequence = charSequence.toString();
    } else {
      charSequence = null;
    } 
    persistableBundle.putString("name", (String)charSequence);
    persistableBundle.putString("uri", this.mUri);
    persistableBundle.putString("key", this.mKey);
    persistableBundle.putBoolean("isBot", this.mIsBot);
    persistableBundle.putBoolean("isImportant", this.mIsImportant);
    return persistableBundle;
  }
  
  public static class Builder {
    @Nullable
    IconCompat mIcon;
    
    boolean mIsBot;
    
    boolean mIsImportant;
    
    @Nullable
    String mKey;
    
    @Nullable
    CharSequence mName;
    
    @Nullable
    String mUri;
    
    public Builder() {}
    
    Builder(Person param1Person) {
      this.mName = param1Person.mName;
      this.mIcon = param1Person.mIcon;
      this.mUri = param1Person.mUri;
      this.mKey = param1Person.mKey;
      this.mIsBot = param1Person.mIsBot;
      this.mIsImportant = param1Person.mIsImportant;
    }
    
    @NonNull
    public Person build() {
      return new Person(this);
    }
    
    @NonNull
    public Builder setBot(boolean param1Boolean) {
      this.mIsBot = param1Boolean;
      return this;
    }
    
    @NonNull
    public Builder setIcon(@Nullable IconCompat param1IconCompat) {
      this.mIcon = param1IconCompat;
      return this;
    }
    
    @NonNull
    public Builder setImportant(boolean param1Boolean) {
      this.mIsImportant = param1Boolean;
      return this;
    }
    
    @NonNull
    public Builder setKey(@Nullable String param1String) {
      this.mKey = param1String;
      return this;
    }
    
    @NonNull
    public Builder setName(@Nullable CharSequence param1CharSequence) {
      this.mName = param1CharSequence;
      return this;
    }
    
    @NonNull
    public Builder setUri(@Nullable String param1String) {
      this.mUri = param1String;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\Person.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */