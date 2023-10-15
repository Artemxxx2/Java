package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;

final class null implements Runnable {
  public void run() {
    FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, inSharedElements, false);
    View view = epicenterView;
    if (view != null)
      impl.getBoundsOnScreen(view, epicenter); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransition$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */