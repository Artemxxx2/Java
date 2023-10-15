package androidx.customview.widget;

import android.graphics.Rect;
import java.util.Comparator;

class SequentialComparator<T> implements Comparator<T> {
  private final FocusStrategy.BoundsAdapter<T> mAdapter;
  
  private final boolean mIsLayoutRtl;
  
  private final Rect mTemp1 = new Rect();
  
  private final Rect mTemp2 = new Rect();
  
  SequentialComparator(boolean paramBoolean, FocusStrategy.BoundsAdapter<T> paramBoundsAdapter) {
    this.mIsLayoutRtl = paramBoolean;
    this.mAdapter = paramBoundsAdapter;
  }
  
  public int compare(T paramT1, T paramT2) {
    Rect rect1 = this.mTemp1;
    Rect rect2 = this.mTemp2;
    this.mAdapter.obtainBounds(paramT1, rect1);
    this.mAdapter.obtainBounds(paramT2, rect2);
    int i = rect1.top;
    int j = rect2.top;
    byte b = -1;
    if (i < j)
      return -1; 
    if (rect1.top > rect2.top)
      return 1; 
    if (rect1.left < rect2.left) {
      if (this.mIsLayoutRtl)
        b = 1; 
      return b;
    } 
    if (rect1.left > rect2.left) {
      if (!this.mIsLayoutRtl)
        b = 1; 
      return b;
    } 
    if (rect1.bottom < rect2.bottom)
      return -1; 
    if (rect1.bottom > rect2.bottom)
      return 1; 
    if (rect1.right < rect2.right) {
      if (this.mIsLayoutRtl)
        b = 1; 
      return b;
    } 
    if (rect1.right > rect2.right) {
      if (!this.mIsLayoutRtl)
        b = 1; 
      return b;
    } 
    return 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\customview\widget\FocusStrategy$SequentialComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */