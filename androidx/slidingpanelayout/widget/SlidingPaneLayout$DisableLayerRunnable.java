package androidx.slidingpanelayout.widget;

import android.view.View;

class DisableLayerRunnable implements Runnable {
  final View mChildView;
  
  DisableLayerRunnable(View paramView) {
    this.mChildView = paramView;
  }
  
  public void run() {
    if (this.mChildView.getParent() == SlidingPaneLayout.this) {
      this.mChildView.setLayerType(0, null);
      SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
    } 
    SlidingPaneLayout.this.mPostedRunnables.remove(this);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$DisableLayerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */