package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(16)
class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
  final AccessibilityNodeProviderCompat mCompat;
  
  AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {
    this.mCompat = paramAccessibilityNodeProviderCompat;
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.createAccessibilityNodeInfo(paramInt);
    return (accessibilityNodeInfoCompat == null) ? null : accessibilityNodeInfoCompat.unwrap();
  }
  
  public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt) {
    List<AccessibilityNodeInfoCompat> list = this.mCompat.findAccessibilityNodeInfosByText(paramString, paramInt);
    if (list == null)
      return null; 
    ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList();
    int i = list.size();
    for (paramInt = 0; paramInt < i; paramInt++)
      arrayList.add(((AccessibilityNodeInfoCompat)list.get(paramInt)).unwrap()); 
    return arrayList;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
    return this.mCompat.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */