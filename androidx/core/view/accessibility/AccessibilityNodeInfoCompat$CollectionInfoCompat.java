package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class CollectionInfoCompat {
  public static final int SELECTION_MODE_MULTIPLE = 2;
  
  public static final int SELECTION_MODE_NONE = 0;
  
  public static final int SELECTION_MODE_SINGLE = 1;
  
  final Object mInfo;
  
  CollectionInfoCompat(Object paramObject) {
    this.mInfo = paramObject;
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean) {
    return (Build.VERSION.SDK_INT >= 19) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean)) : new CollectionInfoCompat(null);
  }
  
  public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    return (Build.VERSION.SDK_INT >= 21) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3)) : ((Build.VERSION.SDK_INT >= 19) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean)) : new CollectionInfoCompat(null));
  }
  
  public int getColumnCount() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getColumnCount() : 0;
  }
  
  public int getRowCount() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getRowCount() : 0;
  }
  
  public int getSelectionMode() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getSelectionMode() : 0;
  }
  
  public boolean isHierarchical() {
    return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).isHierarchical() : false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeInfoCompat$CollectionInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */