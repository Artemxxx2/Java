package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup;

class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
  public void onChildViewAdded(View paramView1, View paramView2) {
    if (CoordinatorLayout.this.mOnHierarchyChangeListener != null)
      CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2); 
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2) {
    CoordinatorLayout.this.onChildViewsChanged(2);
    if (CoordinatorLayout.this.mOnHierarchyChangeListener != null)
      CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$HierarchyChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */