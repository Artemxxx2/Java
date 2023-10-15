package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver;

class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
  public boolean onPreDraw() {
    CoordinatorLayout.this.onChildViewsChanged(0);
    return true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$OnPreDrawListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */