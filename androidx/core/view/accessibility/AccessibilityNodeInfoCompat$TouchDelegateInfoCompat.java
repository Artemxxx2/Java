package androidx.core.view.accessibility;

import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public final class TouchDelegateInfoCompat {
  final AccessibilityNodeInfo.TouchDelegateInfo mInfo;
  
  TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo paramTouchDelegateInfo) {
    this.mInfo = paramTouchDelegateInfo;
  }
  
  public TouchDelegateInfoCompat(@NonNull Map<Region, View> paramMap) {
    if (Build.VERSION.SDK_INT >= 29) {
      this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(paramMap);
    } else {
      this.mInfo = null;
    } 
  }
  
  @Nullable
  public Region getRegionAt(@IntRange(from = 0L) int paramInt) {
    return (Build.VERSION.SDK_INT >= 29) ? this.mInfo.getRegionAt(paramInt) : null;
  }
  
  @IntRange(from = 0L)
  public int getRegionCount() {
    return (Build.VERSION.SDK_INT >= 29) ? this.mInfo.getRegionCount() : 0;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region paramRegion) {
    if (Build.VERSION.SDK_INT >= 29) {
      AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo.getTargetForRegion(paramRegion);
      if (accessibilityNodeInfo != null)
        return AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo); 
    } 
    return null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeInfoCompat$TouchDelegateInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */