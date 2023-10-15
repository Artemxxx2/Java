package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

final class null implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
  public void obtainBounds(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, Rect paramRect) {
    paramAccessibilityNodeInfoCompat.getBoundsInParent(paramRect);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\customview\widget\ExploreByTouchHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */