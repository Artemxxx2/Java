package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;

final class null implements View.OnApplyWindowInsetsListener {
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets) {
    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(paramWindowInsets);
    return listener.onApplyWindowInsets(paramView, windowInsetsCompat).toWindowInsets();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */