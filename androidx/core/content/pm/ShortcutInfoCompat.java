package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortcutInfoCompat {
  private static final String EXTRA_LONG_LIVED = "extraLongLived";
  
  private static final String EXTRA_PERSON_ = "extraPerson_";
  
  private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
  
  ComponentName mActivity;
  
  Set<String> mCategories;
  
  Context mContext;
  
  CharSequence mDisabledMessage;
  
  IconCompat mIcon;
  
  String mId;
  
  Intent[] mIntents;
  
  boolean mIsAlwaysBadged;
  
  boolean mIsLongLived;
  
  CharSequence mLabel;
  
  CharSequence mLongLabel;
  
  Person[] mPersons;
  
  int mRank;
  
  @RequiresApi(22)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  private PersistableBundle buildLegacyExtrasBundle() {
    PersistableBundle persistableBundle = new PersistableBundle();
    Person[] arrayOfPerson = this.mPersons;
    if (arrayOfPerson != null && arrayOfPerson.length > 0) {
      persistableBundle.putInt("extraPersonCount", arrayOfPerson.length);
      for (int i = 0; i < this.mPersons.length; i = j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("extraPerson_");
        int j = i + 1;
        stringBuilder.append(j);
        persistableBundle.putPersistableBundle(stringBuilder.toString(), this.mPersons[i].toPersistableBundle());
      } 
    } 
    persistableBundle.putBoolean("extraLongLived", this.mIsLongLived);
    return persistableBundle;
  }
  
  @RequiresApi(25)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static boolean getLongLivedFromExtra(@NonNull PersistableBundle paramPersistableBundle) {
    return (paramPersistableBundle == null || !paramPersistableBundle.containsKey("extraLongLived")) ? false : paramPersistableBundle.getBoolean("extraLongLived");
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static Person[] getPersonsFromExtra(@NonNull PersistableBundle paramPersistableBundle) {
    if (paramPersistableBundle == null || !paramPersistableBundle.containsKey("extraPersonCount"))
      return null; 
    int i = paramPersistableBundle.getInt("extraPersonCount");
    Person[] arrayOfPerson = new Person[i];
    for (int j = 0; j < i; j = k) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("extraPerson_");
      int k = j + 1;
      stringBuilder.append(k);
      arrayOfPerson[j] = Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle(stringBuilder.toString()));
    } 
    return arrayOfPerson;
  }
  
  Intent addToIntent(Intent paramIntent) {
    Intent[] arrayOfIntent = this.mIntents;
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)arrayOfIntent[arrayOfIntent.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    if (this.mIcon != null) {
      Drawable drawable;
      ComponentName componentName = null;
      Intent[] arrayOfIntent1 = null;
      if (this.mIsAlwaysBadged) {
        Intent[] arrayOfIntent2;
        PackageManager packageManager = this.mContext.getPackageManager();
        componentName = this.mActivity;
        arrayOfIntent = arrayOfIntent1;
        if (componentName != null)
          try {
            Drawable drawable1 = packageManager.getActivityIcon(componentName);
          } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            arrayOfIntent2 = arrayOfIntent1;
          }  
        Intent[] arrayOfIntent3 = arrayOfIntent2;
        if (arrayOfIntent2 == null)
          drawable = this.mContext.getApplicationInfo().loadIcon(packageManager); 
      } 
      this.mIcon.addToShortcutIntent(paramIntent, drawable, this.mContext);
    } 
    return paramIntent;
  }
  
  @Nullable
  public ComponentName getActivity() {
    return this.mActivity;
  }
  
  @Nullable
  public Set<String> getCategories() {
    return this.mCategories;
  }
  
  @Nullable
  public CharSequence getDisabledMessage() {
    return this.mDisabledMessage;
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public IconCompat getIcon() {
    return this.mIcon;
  }
  
  @NonNull
  public String getId() {
    return this.mId;
  }
  
  @NonNull
  public Intent getIntent() {
    Intent[] arrayOfIntent = this.mIntents;
    return arrayOfIntent[arrayOfIntent.length - 1];
  }
  
  @NonNull
  public Intent[] getIntents() {
    Intent[] arrayOfIntent = this.mIntents;
    return Arrays.<Intent>copyOf(arrayOfIntent, arrayOfIntent.length);
  }
  
  @Nullable
  public CharSequence getLongLabel() {
    return this.mLongLabel;
  }
  
  public int getRank() {
    return this.mRank;
  }
  
  @NonNull
  public CharSequence getShortLabel() {
    return this.mLabel;
  }
  
  @RequiresApi(25)
  public ShortcutInfo toShortcutInfo() {
    ShortcutInfo.Builder builder = (new ShortcutInfo.Builder(this.mContext, this.mId)).setShortLabel(this.mLabel).setIntents(this.mIntents);
    IconCompat iconCompat = this.mIcon;
    if (iconCompat != null)
      builder.setIcon(iconCompat.toIcon()); 
    if (!TextUtils.isEmpty(this.mLongLabel))
      builder.setLongLabel(this.mLongLabel); 
    if (!TextUtils.isEmpty(this.mDisabledMessage))
      builder.setDisabledMessage(this.mDisabledMessage); 
    ComponentName componentName = this.mActivity;
    if (componentName != null)
      builder.setActivity(componentName); 
    Set<String> set = this.mCategories;
    if (set != null)
      builder.setCategories(set); 
    builder.setRank(this.mRank);
    if (Build.VERSION.SDK_INT >= 29) {
      Person[] arrayOfPerson = this.mPersons;
      if (arrayOfPerson != null && arrayOfPerson.length > 0) {
        Person[] arrayOfPerson1 = new Person[arrayOfPerson.length];
        for (byte b = 0; b < arrayOfPerson1.length; b++)
          arrayOfPerson1[b] = this.mPersons[b].toAndroidPerson(); 
        builder.setPersons(arrayOfPerson1);
      } 
      builder.setLongLived(this.mIsLongLived);
    } else {
      builder.setExtras(buildLegacyExtrasBundle());
    } 
    return builder.build();
  }
  
  public static class Builder {
    private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
    
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull Context param1Context, @NonNull ShortcutInfo param1ShortcutInfo) {
      ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
      shortcutInfoCompat.mContext = param1Context;
      shortcutInfoCompat.mId = param1ShortcutInfo.getId();
      Intent[] arrayOfIntent = param1ShortcutInfo.getIntents();
      this.mInfo.mIntents = Arrays.<Intent>copyOf(arrayOfIntent, arrayOfIntent.length);
      this.mInfo.mActivity = param1ShortcutInfo.getActivity();
      this.mInfo.mLabel = param1ShortcutInfo.getShortLabel();
      this.mInfo.mLongLabel = param1ShortcutInfo.getLongLabel();
      this.mInfo.mDisabledMessage = param1ShortcutInfo.getDisabledMessage();
      this.mInfo.mCategories = param1ShortcutInfo.getCategories();
      this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(param1ShortcutInfo.getExtras());
      this.mInfo.mRank = param1ShortcutInfo.getRank();
    }
    
    public Builder(@NonNull Context param1Context, @NonNull String param1String) {
      ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
      shortcutInfoCompat.mContext = param1Context;
      shortcutInfoCompat.mId = param1String;
    }
    
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull ShortcutInfoCompat param1ShortcutInfoCompat) {
      this.mInfo.mContext = param1ShortcutInfoCompat.mContext;
      this.mInfo.mId = param1ShortcutInfoCompat.mId;
      this.mInfo.mIntents = Arrays.<Intent>copyOf(param1ShortcutInfoCompat.mIntents, param1ShortcutInfoCompat.mIntents.length);
      this.mInfo.mActivity = param1ShortcutInfoCompat.mActivity;
      this.mInfo.mLabel = param1ShortcutInfoCompat.mLabel;
      this.mInfo.mLongLabel = param1ShortcutInfoCompat.mLongLabel;
      this.mInfo.mDisabledMessage = param1ShortcutInfoCompat.mDisabledMessage;
      this.mInfo.mIcon = param1ShortcutInfoCompat.mIcon;
      this.mInfo.mIsAlwaysBadged = param1ShortcutInfoCompat.mIsAlwaysBadged;
      this.mInfo.mIsLongLived = param1ShortcutInfoCompat.mIsLongLived;
      this.mInfo.mRank = param1ShortcutInfoCompat.mRank;
      if (param1ShortcutInfoCompat.mPersons != null)
        this.mInfo.mPersons = Arrays.<Person>copyOf(param1ShortcutInfoCompat.mPersons, param1ShortcutInfoCompat.mPersons.length); 
      if (param1ShortcutInfoCompat.mCategories != null)
        this.mInfo.mCategories = new HashSet<String>(param1ShortcutInfoCompat.mCategories); 
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
    public Builder setActivity(@NonNull ComponentName param1ComponentName) {
      this.mInfo.mActivity = param1ComponentName;
      return this;
    }
    
    @NonNull
    public Builder setAlwaysBadged() {
      this.mInfo.mIsAlwaysBadged = true;
      return this;
    }
    
    @NonNull
    public Builder setCategories(@NonNull Set<String> param1Set) {
      this.mInfo.mCategories = param1Set;
      return this;
    }
    
    @NonNull
    public Builder setDisabledMessage(@NonNull CharSequence param1CharSequence) {
      this.mInfo.mDisabledMessage = param1CharSequence;
      return this;
    }
    
    @NonNull
    public Builder setIcon(IconCompat param1IconCompat) {
      this.mInfo.mIcon = param1IconCompat;
      return this;
    }
    
    @NonNull
    public Builder setIntent(@NonNull Intent param1Intent) {
      return setIntents(new Intent[] { param1Intent });
    }
    
    @NonNull
    public Builder setIntents(@NonNull Intent[] param1ArrayOfIntent) {
      this.mInfo.mIntents = param1ArrayOfIntent;
      return this;
    }
    
    @NonNull
    public Builder setLongLabel(@NonNull CharSequence param1CharSequence) {
      this.mInfo.mLongLabel = param1CharSequence;
      return this;
    }
    
    @Deprecated
    @NonNull
    public Builder setLongLived() {
      this.mInfo.mIsLongLived = true;
      return this;
    }
    
    @NonNull
    public Builder setLongLived(boolean param1Boolean) {
      this.mInfo.mIsLongLived = param1Boolean;
      return this;
    }
    
    @NonNull
    public Builder setPerson(@NonNull Person param1Person) {
      return setPersons(new Person[] { param1Person });
    }
    
    @NonNull
    public Builder setPersons(@NonNull Person[] param1ArrayOfPerson) {
      this.mInfo.mPersons = param1ArrayOfPerson;
      return this;
    }
    
    @NonNull
    public Builder setRank(int param1Int) {
      this.mInfo.mRank = param1Int;
      return this;
    }
    
    @NonNull
    public Builder setShortLabel(@NonNull CharSequence param1CharSequence) {
      this.mInfo.mLabel = param1CharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */