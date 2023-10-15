package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;

public final class LocaleListCompat {
  private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
  
  private LocaleListInterface mImpl;
  
  private LocaleListCompat(LocaleListInterface paramLocaleListInterface) {
    this.mImpl = paramLocaleListInterface;
  }
  
  @NonNull
  public static LocaleListCompat create(@NonNull Locale... paramVarArgs) {
    return (Build.VERSION.SDK_INT >= 24) ? wrap(new LocaleList(paramVarArgs)) : new LocaleListCompat(new LocaleListCompatWrapper(paramVarArgs));
  }
  
  static Locale forLanguageTagCompat(String paramString) {
    if (paramString.contains("-")) {
      String[] arrayOfString = paramString.split("-", -1);
      if (arrayOfString.length > 2)
        return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]); 
      if (arrayOfString.length > 1)
        return new Locale(arrayOfString[0], arrayOfString[1]); 
      if (arrayOfString.length == 1)
        return new Locale(arrayOfString[0]); 
    } else {
      if (paramString.contains("_")) {
        String[] arrayOfString = paramString.split("_", -1);
        if (arrayOfString.length > 2)
          return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]); 
        if (arrayOfString.length > 1)
          return new Locale(arrayOfString[0], arrayOfString[1]); 
        if (arrayOfString.length == 1)
          return new Locale(arrayOfString[0]); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Can not parse language tag: [");
        stringBuilder1.append(paramString);
        stringBuilder1.append("]");
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      return new Locale(paramString);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can not parse language tag: [");
    stringBuilder.append(paramString);
    stringBuilder.append("]");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @NonNull
  public static LocaleListCompat forLanguageTags(@Nullable String paramString) {
    if (paramString == null || paramString.isEmpty())
      return getEmptyLocaleList(); 
    String[] arrayOfString = paramString.split(",", -1);
    Locale[] arrayOfLocale = new Locale[arrayOfString.length];
    for (byte b = 0; b < arrayOfLocale.length; b++) {
      Locale locale;
      if (Build.VERSION.SDK_INT >= 21) {
        locale = Locale.forLanguageTag(arrayOfString[b]);
      } else {
        locale = forLanguageTagCompat(arrayOfString[b]);
      } 
      arrayOfLocale[b] = locale;
    } 
    return create(arrayOfLocale);
  }
  
  @NonNull
  @Size(min = 1L)
  public static LocaleListCompat getAdjustedDefault() {
    return (Build.VERSION.SDK_INT >= 24) ? wrap(LocaleList.getAdjustedDefault()) : create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  @Size(min = 1L)
  public static LocaleListCompat getDefault() {
    return (Build.VERSION.SDK_INT >= 24) ? wrap(LocaleList.getDefault()) : create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  public static LocaleListCompat getEmptyLocaleList() {
    return sEmptyLocaleList;
  }
  
  @NonNull
  @RequiresApi(24)
  public static LocaleListCompat wrap(@NonNull LocaleList paramLocaleList) {
    return new LocaleListCompat(new LocaleListPlatformWrapper(paramLocaleList));
  }
  
  @Deprecated
  @RequiresApi(24)
  public static LocaleListCompat wrap(Object paramObject) {
    return wrap((LocaleList)paramObject);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool;
    if (paramObject instanceof LocaleListCompat && this.mImpl.equals(((LocaleListCompat)paramObject).mImpl)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Locale get(int paramInt) {
    return this.mImpl.get(paramInt);
  }
  
  @Nullable
  public Locale getFirstMatch(@NonNull String[] paramArrayOfString) {
    return this.mImpl.getFirstMatch(paramArrayOfString);
  }
  
  public int hashCode() {
    return this.mImpl.hashCode();
  }
  
  @IntRange(from = -1L)
  public int indexOf(Locale paramLocale) {
    return this.mImpl.indexOf(paramLocale);
  }
  
  public boolean isEmpty() {
    return this.mImpl.isEmpty();
  }
  
  @IntRange(from = 0L)
  public int size() {
    return this.mImpl.size();
  }
  
  @NonNull
  public String toLanguageTags() {
    return this.mImpl.toLanguageTags();
  }
  
  public String toString() {
    return this.mImpl.toString();
  }
  
  @Nullable
  public Object unwrap() {
    return this.mImpl.getLocaleList();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\LocaleListCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */