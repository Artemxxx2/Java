package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import java.util.Map;
import java.util.WeakHashMap;

class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
  private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<View, Boolean>();
  
  @RequiresApi(19)
  private void checkPaneVisibility(View paramView, boolean paramBoolean) {
    boolean bool;
    if (paramView.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean != bool) {
      if (bool)
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 16); 
      this.mPanesToVisible.put(paramView, Boolean.valueOf(bool));
    } 
  }
  
  @RequiresApi(19)
  private void registerForLayoutCallback(View paramView) {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  @RequiresApi(19)
  private void unregisterForLayoutCallback(View paramView) {
    paramView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  @RequiresApi(19)
  void addAccessibilityPane(View paramView) {
    boolean bool;
    WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
    if (paramView.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    weakHashMap.put(paramView, Boolean.valueOf(bool));
    paramView.addOnAttachStateChangeListener(this);
    if (paramView.isAttachedToWindow())
      registerForLayoutCallback(paramView); 
  }
  
  @RequiresApi(19)
  public void onGlobalLayout() {
    for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet())
      checkPaneVisibility((View)entry.getKey(), ((Boolean)entry.getValue()).booleanValue()); 
  }
  
  @RequiresApi(19)
  public void onViewAttachedToWindow(View paramView) {
    registerForLayoutCallback(paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
  
  @RequiresApi(19)
  void removeAccessibilityPane(View paramView) {
    this.mPanesToVisible.remove(paramView);
    paramView.removeOnAttachStateChangeListener(this);
    unregisterForLayoutCallback(paramView);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$AccessibilityPaneVisibilityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */