package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

interface LocaleListInterface {
  Locale get(int paramInt);
  
  @Nullable
  Locale getFirstMatch(@NonNull String[] paramArrayOfString);
  
  Object getLocaleList();
  
  @IntRange(from = -1L)
  int indexOf(Locale paramLocale);
  
  boolean isEmpty();
  
  @IntRange(from = 0L)
  int size();
  
  String toLanguageTags();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\os\LocaleListInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */