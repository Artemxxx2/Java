package androidx.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.List;

final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
  final AccessibilityDelegateCompat mCompat;
  
  AccessibilityDelegateAdapter(AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {
    this.mCompat = paramAccessibilityDelegateCompat;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return this.mCompat.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  @RequiresApi(16)
  public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView) {
    AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.mCompat.getAccessibilityNodeProvider(paramView);
    if (accessibilityNodeProviderCompat != null) {
      AccessibilityNodeProvider accessibilityNodeProvider = (AccessibilityNodeProvider)accessibilityNodeProviderCompat.getProvider();
    } else {
      accessibilityNodeProviderCompat = null;
    } 
    return (AccessibilityNodeProvider)accessibilityNodeProviderCompat;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.mCompat.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    accessibilityNodeInfoCompat.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(paramView));
    accessibilityNodeInfoCompat.setHeading(ViewCompat.isAccessibilityHeading(paramView));
    accessibilityNodeInfoCompat.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(paramView));
    this.mCompat.onInitializeAccessibilityNodeInfo(paramView, accessibilityNodeInfoCompat);
    accessibilityNodeInfoCompat.addSpansToExtras(paramAccessibilityNodeInfo.getText(), paramView);
    List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = AccessibilityDelegateCompat.getActionList(paramView);
    for (byte b = 0; b < list.size(); b++)
      accessibilityNodeInfoCompat.addAction(list.get(b)); 
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.mCompat.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return this.mCompat.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    return this.mCompat.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt) {
    this.mCompat.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.mCompat.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\AccessibilityDelegateCompat$AccessibilityDelegateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */