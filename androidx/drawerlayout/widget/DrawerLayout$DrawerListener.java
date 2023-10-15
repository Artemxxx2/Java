package androidx.drawerlayout.widget;

import android.view.View;
import androidx.annotation.NonNull;

public interface DrawerListener {
  void onDrawerClosed(@NonNull View paramView);
  
  void onDrawerOpened(@NonNull View paramView);
  
  void onDrawerSlide(@NonNull View paramView, float paramFloat);
  
  void onDrawerStateChanged(int paramInt);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$DrawerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */