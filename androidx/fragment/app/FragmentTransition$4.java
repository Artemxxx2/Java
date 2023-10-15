package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

final class null implements Runnable {
  public void run() {
    ArrayMap<String, View> arrayMap = FragmentTransition.captureInSharedElements(impl, nameOverrides, finalSharedElementTransition, fragments);
    if (arrayMap != null) {
      sharedElementsIn.addAll(arrayMap.values());
      sharedElementsIn.add(nonExistentView);
    } 
    FragmentTransition.callSharedElementStartEnd(inFragment, outFragment, inIsPop, arrayMap, false);
    Object object = finalSharedElementTransition;
    if (object != null) {
      impl.swapSharedElementTargets(object, sharedElementsOut, sharedElementsIn);
      object = FragmentTransition.getInEpicenterView(arrayMap, fragments, enterTransition, inIsPop);
      if (object != null)
        impl.getBoundsOnScreen((View)object, inEpicenter); 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransition$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */