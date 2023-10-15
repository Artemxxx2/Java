package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderApi16 {
  AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {
    super(paramAccessibilityNodeProviderCompat);
  }
  
  public AccessibilityNodeInfo findFocus(int paramInt) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.findFocus(paramInt);
    return (accessibilityNodeInfoCompat == null) ? null : accessibilityNodeInfoCompat.unwrap();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */