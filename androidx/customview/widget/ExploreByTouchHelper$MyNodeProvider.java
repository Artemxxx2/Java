package androidx.customview.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;

class MyNodeProvider extends AccessibilityNodeProviderCompat {
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt) {
    return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(paramInt));
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt) {
    if (paramInt == 2) {
      paramInt = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
    } else {
      paramInt = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
    } 
    return (paramInt == Integer.MIN_VALUE) ? null : createAccessibilityNodeInfo(paramInt);
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
    return ExploreByTouchHelper.this.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\customview\widget\ExploreByTouchHelper$MyNodeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */