package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.annotation.NonNull;

public interface PanelSlideListener {
  void onPanelClosed(@NonNull View paramView);
  
  void onPanelOpened(@NonNull View paramView);
  
  void onPanelSlide(@NonNull View paramView, float paramFloat);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$PanelSlideListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */