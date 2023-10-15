package androidx.drawerlayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;

class AccessibilityDelegate extends AccessibilityDelegateCompat {
  private final Rect mTmpRect = new Rect();
  
  private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup) {
    int i = paramViewGroup.getChildCount();
    for (byte b = 0; b < i; b++) {
      View view = paramViewGroup.getChildAt(b);
      if (DrawerLayout.includeChildForAccessibility(view))
        paramAccessibilityNodeInfoCompat.addChild(view); 
    } 
  }
  
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
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    List<CharSequence> list;
    CharSequence charSequence;
    if (paramAccessibilityEvent.getEventType() == 32) {
      list = paramAccessibilityEvent.getText();
      View view = DrawerLayout.this.findVisibleDrawer();
      if (view != null) {
        int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(view);
        charSequence = DrawerLayout.this.getDrawerTitle(i);
        if (charSequence != null)
          list.add(charSequence); 
      } 
      return true;
    } 
    return super.dispatchPopulateAccessibilityEvent((View)list, (AccessibilityEvent)charSequence);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    } else {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, accessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      ViewParent viewParent = ViewCompat.getParentForAccessibility(paramView);
      if (viewParent instanceof View)
        paramAccessibilityNodeInfoCompat.setParent((View)viewParent); 
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
      accessibilityNodeInfoCompat.recycle();
      addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
    } 
    paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
    paramAccessibilityNodeInfoCompat.setFocusable(false);
    paramAccessibilityNodeInfoCompat.setFocused(false);
    paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
    paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(paramView)) ? super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent) : false;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$AccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */