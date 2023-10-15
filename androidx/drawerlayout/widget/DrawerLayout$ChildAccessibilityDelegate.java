package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!DrawerLayout.includeChildForAccessibility(paramView))
      paramAccessibilityNodeInfoCompat.setParent(null); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$ChildAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */