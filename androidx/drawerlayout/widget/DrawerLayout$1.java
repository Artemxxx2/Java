package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;

class null implements View.OnApplyWindowInsetsListener {
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets) {
    boolean bool;
    DrawerLayout drawerLayout = (DrawerLayout)paramView;
    if (paramWindowInsets.getSystemWindowInsetTop() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    drawerLayout.setChildInsets(paramWindowInsets, bool);
    return paramWindowInsets.consumeSystemWindowInsets();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */