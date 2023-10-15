package androidx.legacy.app;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

@Deprecated
public interface Delegate {
  @Nullable
  Drawable getThemeUpIndicator();
  
  void setActionBarDescription(@StringRes int paramInt);
  
  void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\legacy\app\ActionBarDrawerToggle$Delegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */