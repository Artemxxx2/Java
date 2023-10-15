package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;

class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
  AccessibilityManagerCompat.AccessibilityStateChangeListener mListener;
  
  AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.AccessibilityStateChangeListener paramAccessibilityStateChangeListener) {
    this.mListener = paramAccessibilityStateChangeListener;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof AccessibilityStateChangeListenerWrapper))
      return false; 
    paramObject = paramObject;
    return this.mListener.equals(((AccessibilityStateChangeListenerWrapper)paramObject).mListener);
  }
  
  public int hashCode() {
    return this.mListener.hashCode();
  }
  
  public void onAccessibilityStateChanged(boolean paramBoolean) {
    this.mListener.onAccessibilityStateChanged(paramBoolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */