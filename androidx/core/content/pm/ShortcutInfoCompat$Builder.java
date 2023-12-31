package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Builder {
  private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
  
  @RequiresApi(25)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Builder(@NonNull Context paramContext, @NonNull ShortcutInfo paramShortcutInfo) {
    ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
    shortcutInfoCompat.mContext = paramContext;
    shortcutInfoCompat.mId = paramShortcutInfo.getId();
    Intent[] arrayOfIntent = paramShortcutInfo.getIntents();
    this.mInfo.mIntents = Arrays.<Intent>copyOf(arrayOfIntent, arrayOfIntent.length);
    this.mInfo.mActivity = paramShortcutInfo.getActivity();
    this.mInfo.mLabel = paramShortcutInfo.getShortLabel();
    this.mInfo.mLongLabel = paramShortcutInfo.getLongLabel();
    this.mInfo.mDisabledMessage = paramShortcutInfo.getDisabledMessage();
    this.mInfo.mCategories = paramShortcutInfo.getCategories();
    this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(paramShortcutInfo.getExtras());
    this.mInfo.mRank = paramShortcutInfo.getRank();
  }
  
  public Builder(@NonNull Context paramContext, @NonNull String paramString) {
    ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
    shortcutInfoCompat.mContext = paramContext;
    shortcutInfoCompat.mId = paramString;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Builder(@NonNull ShortcutInfoCompat paramShortcutInfoCompat) {
    this.mInfo.mContext = paramShortcutInfoCompat.mContext;
    this.mInfo.mId = paramShortcutInfoCompat.mId;
    this.mInfo.mIntents = Arrays.<Intent>copyOf(paramShortcutInfoCompat.mIntents, paramShortcutInfoCompat.mIntents.length);
    this.mInfo.mActivity = paramShortcutInfoCompat.mActivity;
    this.mInfo.mLabel = paramShortcutInfoCompat.mLabel;
    this.mInfo.mLongLabel = paramShortcutInfoCompat.mLongLabel;
    this.mInfo.mDisabledMessage = paramShortcutInfoCompat.mDisabledMessage;
    this.mInfo.mIcon = paramShortcutInfoCompat.mIcon;
    this.mInfo.mIsAlwaysBadged = paramShortcutInfoCompat.mIsAlwaysBadged;
    this.mInfo.mIsLongLived = paramShortcutInfoCompat.mIsLongLived;
    this.mInfo.mRank = paramShortcutInfoCompat.mRank;
    if (paramShortcutInfoCompat.mPersons != null)
      this.mInfo.mPersons = Arrays.<Person>copyOf(paramShortcutInfoCompat.mPersons, paramShortcutInfoCompat.mPersons.length); 
    if (paramShortcutInfoCompat.mCategories != null)
      this.mInfo.mCategories = new HashSet<String>(paramShortcutInfoCompat.mCategories); 
  }
  
  @NonNull
  public ShortcutInfoCompat build() {
    if (!TextUtils.isEmpty(this.mInfo.mLabel)) {
      if (this.mInfo.mIntents != null && this.mInfo.mIntents.length != 0)
        return this.mInfo; 
      throw new IllegalArgumentException("Shortcut must have an intent");
    } 
    throw new IllegalArgumentException("Shortcut must have a non-empty label");
  }
  
  @NonNull
  public Builder setActivity(@NonNull ComponentName paramComponentName) {
    this.mInfo.mActivity = paramComponentName;
    return this;
  }
  
  @NonNull
  public Builder setAlwaysBadged() {
    this.mInfo.mIsAlwaysBadged = true;
    return this;
  }
  
  @NonNull
  public Builder setCategories(@NonNull Set<String> paramSet) {
    this.mInfo.mCategories = paramSet;
    return this;
  }
  
  @NonNull
  public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence) {
    this.mInfo.mDisabledMessage = paramCharSequence;
    return this;
  }
  
  @NonNull
  public Builder setIcon(IconCompat paramIconCompat) {
    this.mInfo.mIcon = paramIconCompat;
    return this;
  }
  
  @NonNull
  public Builder setIntent(@NonNull Intent paramIntent) {
    return setIntents(new Intent[] { paramIntent });
  }
  
  @NonNull
  public Builder setIntents(@NonNull Intent[] paramArrayOfIntent) {
    this.mInfo.mIntents = paramArrayOfIntent;
    return this;
  }
  
  @NonNull
  public Builder setLongLabel(@NonNull CharSequence paramCharSequence) {
    this.mInfo.mLongLabel = paramCharSequence;
    return this;
  }
  
  @Deprecated
  @NonNull
  public Builder setLongLived() {
    this.mInfo.mIsLongLived = true;
    return this;
  }
  
  @NonNull
  public Builder setLongLived(boolean paramBoolean) {
    this.mInfo.mIsLongLived = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setPerson(@NonNull Person paramPerson) {
    return setPersons(new Person[] { paramPerson });
  }
  
  @NonNull
  public Builder setPersons(@NonNull Person[] paramArrayOfPerson) {
    this.mInfo.mPersons = paramArrayOfPerson;
    return this;
  }
  
  @NonNull
  public Builder setRank(int paramInt) {
    this.mInfo.mRank = paramInt;
    return this;
  }
  
  @NonNull
  public Builder setShortLabel(@NonNull CharSequence paramCharSequence) {
    this.mInfo.mLabel = paramCharSequence;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutInfoCompat$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */