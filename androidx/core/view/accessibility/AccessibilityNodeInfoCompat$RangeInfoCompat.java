package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class RangeInfoCompat {
  public static final int RANGE_TYPE_FLOAT = 1;
  
  public static final int RANGE_TYPE_INT = 0;
  
  public static final int RANGE_TYPE_PERCENT = 2;
  
  final Object mInfo;
  
  RangeInfoCompat(Object paramObject) {
    this.mInfo = paramObject;
  }
  
  public static RangeInfoCompat obtain(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    return (Build.VERSION.SDK_INT >= 19) ? new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(paramInt, paramFloat1, paramFloat2, paramFloat3)) : new RangeInfoCompat(null);
  }
  
  public float getCurrent() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getCurrent() : 0.0F;
  }
  
  public float getMax() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMax() : 0.0F;
  }
  
  public float getMin() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMin() : 0.0F;
  }
  
  public int getType() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getType() : 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeInfoCompat$RangeInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */