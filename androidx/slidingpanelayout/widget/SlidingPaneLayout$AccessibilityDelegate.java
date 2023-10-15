package androidx.slidingpanelayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class AccessibilityDelegate extends AccessibilityDelegateCompat {
  private final Rect mTmpRect = new Rect();
  
  private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2) {
    Rect rect = this.mTmpRect;
    paramAccessibilityNodeInfoCompat2.getBoundsInParent(rect);
    paramAccessibilityNodeInfoCompat1.setBoundsInParent(rect);
    paramAccessibilityNodeInfoCompat2.getBoundsInScreen(rect);
    paramAccessibilityNodeInfoCompat1.setBoundsInScreen(rect);
    paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
    paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
    paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
    paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
    paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
    paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
    paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
    paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
    paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
    paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
    paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
    paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
  }
  
  public boolean filter(View paramView) {
    return SlidingPaneLayout.this.isDimmed(paramView);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
    super.onInitializeAccessibilityNodeInfo(paramView, accessibilityNodeInfoCompat);
    copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
    accessibilityNodeInfoCompat.recycle();
    paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
    paramAccessibilityNodeInfoCompat.setSource(paramView);
    ViewParent viewParent = ViewCompat.getParentForAccessibility(paramView);
    if (viewParent instanceof View)
      paramAccessibilityNodeInfoCompat.setParent((View)viewParent); 
    int i = SlidingPaneLayout.this.getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = SlidingPaneLayout.this.getChildAt(b);
      if (!filter(view) && view.getVisibility() == 0) {
        ViewCompat.setImportantForAccessibility(view, 1);
        paramAccessibilityNodeInfoCompat.addChild(view);
      } 
    } 
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return !filter(paramView) ? super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent) : false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$AccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */