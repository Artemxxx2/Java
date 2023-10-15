package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;

final class null extends ViewCompat.AccessibilityViewProperty<CharSequence> {
  null(int paramInt1, Class<CharSequence> paramClass, int paramInt2, int paramInt3) {
    super(paramInt1, paramClass, paramInt2, paramInt3);
  }
  
  @RequiresApi(28)
  CharSequence frameworkGet(View paramView) {
    return paramView.getAccessibilityPaneTitle();
  }
  
  @RequiresApi(28)
  void frameworkSet(View paramView, CharSequence paramCharSequence) {
    paramView.setAccessibilityPaneTitle(paramCharSequence);
  }
  
  boolean shouldUpdate(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
    return TextUtils.equals(paramCharSequence1, paramCharSequence2) ^ true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */