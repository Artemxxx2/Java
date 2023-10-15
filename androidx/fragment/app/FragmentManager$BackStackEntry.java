package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public interface BackStackEntry {
  @Nullable
  CharSequence getBreadCrumbShortTitle();
  
  @StringRes
  int getBreadCrumbShortTitleRes();
  
  @Nullable
  CharSequence getBreadCrumbTitle();
  
  @StringRes
  int getBreadCrumbTitleRes();
  
  int getId();
  
  @Nullable
  String getName();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManager$BackStackEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */