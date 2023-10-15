package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.Nullable;

public interface TintableCompoundDrawablesView {
  @Nullable
  ColorStateList getSupportCompoundDrawablesTintList();
  
  @Nullable
  PorterDuff.Mode getSupportCompoundDrawablesTintMode();
  
  void setSupportCompoundDrawablesTintList(@Nullable ColorStateList paramColorStateList);
  
  void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\TintableCompoundDrawablesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */