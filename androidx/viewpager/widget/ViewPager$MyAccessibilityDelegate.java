package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
  private boolean canScroll() {
    PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
    boolean bool = true;
    if (pagerAdapter == null || ViewPager.this.mAdapter.getCount() <= 1)
      bool = false; 
    return bool;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(canScroll());
    if (paramAccessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
      paramAccessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
      paramAccessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
      paramAccessibilityEvent.setToIndex(ViewPager.this.mCurItem);
    } 
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
    if (ViewPager.this.canScrollHorizontally(1))
      paramAccessibilityNodeInfoCompat.addAction(4096); 
    if (ViewPager.this.canScrollHorizontally(-1))
      paramAccessibilityNodeInfoCompat.addAction(8192); 
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      return true; 
    if (paramInt != 4096) {
      if (paramInt != 8192)
        return false; 
      if (ViewPager.this.canScrollHorizontally(-1)) {
        ViewPager viewPager = ViewPager.this;
        viewPager.setCurrentItem(viewPager.mCurItem - 1);
        return true;
      } 
      return false;
    } 
    if (ViewPager.this.canScrollHorizontally(1)) {
      ViewPager viewPager = ViewPager.this;
      viewPager.setCurrentItem(viewPager.mCurItem + 1);
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$MyAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */