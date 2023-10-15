package androidx.core.view;

import android.view.View;
import androidx.annotation.RequiresApi;

final class null extends ViewCompat.AccessibilityViewProperty<Boolean> {
  null(int paramInt1, Class<Boolean> paramClass, int paramInt2) {
    super(paramInt1, paramClass, paramInt2);
  }
  
  @RequiresApi(28)
  Boolean frameworkGet(View paramView) {
    return Boolean.valueOf(paramView.isAccessibilityHeading());
  }
  
  @RequiresApi(28)
  void frameworkSet(View paramView, Boolean paramBoolean) {
    paramView.setAccessibilityHeading(paramBoolean.booleanValue());
  }
  
  boolean shouldUpdate(Boolean paramBoolean1, Boolean paramBoolean2) {
    return booleanNullToFalseEquals(paramBoolean1, paramBoolean2) ^ true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */