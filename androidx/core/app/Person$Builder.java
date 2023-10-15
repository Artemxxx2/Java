package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

public class Builder {
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
  
  Builder(Person paramPerson) {
    this.mName = paramPerson.mName;
    this.mIcon = paramPerson.mIcon;
    this.mUri = paramPerson.mUri;
    this.mKey = paramPerson.mKey;
    this.mIsBot = paramPerson.mIsBot;
    this.mIsImportant = paramPerson.mIsImportant;
  }
  
  @NonNull
  public Person build() {
    return new Person(this);
  }
  
  @NonNull
  public Builder setBot(boolean paramBoolean) {
    this.mIsBot = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setIcon(@Nullable IconCompat paramIconCompat) {
    this.mIcon = paramIconCompat;
    return this;
  }
  
  @NonNull
  public Builder setImportant(boolean paramBoolean) {
    this.mIsImportant = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setKey(@Nullable String paramString) {
    this.mKey = paramString;
    return this;
  }
  
  @NonNull
  public Builder setName(@Nullable CharSequence paramCharSequence) {
    this.mName = paramCharSequence;
    return this;
  }
  
  @NonNull
  public Builder setUri(@Nullable String paramString) {
    this.mUri = paramString;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\Person$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */