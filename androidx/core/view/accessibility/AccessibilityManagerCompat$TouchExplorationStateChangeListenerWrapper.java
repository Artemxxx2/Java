package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
  final AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;
  
  TouchExplorationStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener) {
    this.mListener = paramTouchExplorationStateChangeListener;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof TouchExplorationStateChangeListenerWrapper))
      return false; 
    paramObject = paramObject;
    return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)paramObject).mListener);
  }
  
  public int hashCode() {
    return this.mListener.hashCode();
  }
  
  public void onTouchExplorationStateChanged(boolean paramBoolean) {
    this.mListener.onTouchExplorationStateChanged(paramBoolean);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */