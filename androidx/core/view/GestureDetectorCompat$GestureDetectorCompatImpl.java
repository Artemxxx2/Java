package androidx.core.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

interface GestureDetectorCompatImpl {
  boolean isLongpressEnabled();
  
  boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  void setIsLongpressEnabled(boolean paramBoolean);
  
  void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\GestureDetectorCompat$GestureDetectorCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */