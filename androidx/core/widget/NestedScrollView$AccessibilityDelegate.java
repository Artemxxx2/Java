package androidx.core.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;

class AccessibilityDelegate extends AccessibilityDelegateCompat {
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    boolean bool;
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    if (nestedScrollView.getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    paramAccessibilityEvent.setScrollable(bool);
    paramAccessibilityEvent.setScrollX(nestedScrollView.getScrollX());
    paramAccessibilityEvent.setScrollY(nestedScrollView.getScrollY());
    AccessibilityRecordCompat.setMaxScrollX((AccessibilityRecord)paramAccessibilityEvent, nestedScrollView.getScrollX());
    AccessibilityRecordCompat.setMaxScrollY((AccessibilityRecord)paramAccessibilityEvent, nestedScrollView.getScrollRange());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    paramAccessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
    if (nestedScrollView.isEnabled()) {
      int i = nestedScrollView.getScrollRange();
      if (i > 0) {
        paramAccessibilityNodeInfoCompat.setScrollable(true);
        if (nestedScrollView.getScrollY() > 0) {
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        } 
        if (nestedScrollView.getScrollY() < i) {
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
          paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
        } 
      } 
    } 
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      return true; 
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    if (!nestedScrollView.isEnabled())
      return false; 
    if (paramInt != 4096)
      if (paramInt != 8192 && paramInt != 16908344) {
        if (paramInt != 16908346)
          return false; 
      } else {
        int k = nestedScrollView.getHeight();
        paramInt = nestedScrollView.getPaddingBottom();
        int m = nestedScrollView.getPaddingTop();
        paramInt = Math.max(nestedScrollView.getScrollY() - k - paramInt - m, 0);
        if (paramInt != nestedScrollView.getScrollY()) {
          nestedScrollView.smoothScrollTo(0, paramInt, true);
          return true;
        } 
        return false;
      }  
    paramInt = nestedScrollView.getHeight();
    int j = nestedScrollView.getPaddingBottom();
    int i = nestedScrollView.getPaddingTop();
    paramInt = Math.min(nestedScrollView.getScrollY() + paramInt - j - i, nestedScrollView.getScrollRange());
    if (paramInt != nestedScrollView.getScrollY()) {
      nestedScrollView.smoothScrollTo(0, paramInt, true);
      return true;
    } 
    return false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\NestedScrollView$AccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */