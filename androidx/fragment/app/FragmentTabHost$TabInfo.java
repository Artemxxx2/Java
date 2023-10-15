package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class TabInfo {
  @Nullable
  final Bundle args;
  
  @NonNull
  final Class<?> clss;
  
  Fragment fragment;
  
  @NonNull
  final String tag;
  
  TabInfo(@NonNull String paramString, @NonNull Class<?> paramClass, @Nullable Bundle paramBundle) {
    this.tag = paramString;
    this.clss = paramClass;
    this.args = paramBundle;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTabHost$TabInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */