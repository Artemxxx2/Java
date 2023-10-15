package androidx.fragment.app;

import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class null implements Runnable {
  public void run() {
    for (byte b = 0; b < numSharedElements; b++) {
      ViewCompat.setTransitionName(sharedElementsIn.get(b), inNames.get(b));
      ViewCompat.setTransitionName(sharedElementsOut.get(b), outNames.get(b));
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransitionImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */