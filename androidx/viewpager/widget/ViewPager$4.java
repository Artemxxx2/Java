package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class null implements OnApplyWindowInsetsListener {
  private final Rect mTempRect = new Rect();
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat) {
    paramWindowInsetsCompat = ViewCompat.onApplyWindowInsets(paramView, paramWindowInsetsCompat);
    if (paramWindowInsetsCompat.isConsumed())
      return paramWindowInsetsCompat; 
    Rect rect = this.mTempRect;
    rect.left = paramWindowInsetsCompat.getSystemWindowInsetLeft();
    rect.top = paramWindowInsetsCompat.getSystemWindowInsetTop();
    rect.right = paramWindowInsetsCompat.getSystemWindowInsetRight();
    rect.bottom = paramWindowInsetsCompat.getSystemWindowInsetBottom();
    byte b = 0;
    int i = ViewPager.this.getChildCount();
    while (b < i) {
      WindowInsetsCompat windowInsetsCompat = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(b), paramWindowInsetsCompat);
      rect.left = Math.min(windowInsetsCompat.getSystemWindowInsetLeft(), rect.left);
      rect.top = Math.min(windowInsetsCompat.getSystemWindowInsetTop(), rect.top);
      rect.right = Math.min(windowInsetsCompat.getSystemWindowInsetRight(), rect.right);
      rect.bottom = Math.min(windowInsetsCompat.getSystemWindowInsetBottom(), rect.bottom);
      b++;
    } 
    return paramWindowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */