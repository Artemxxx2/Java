package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Map;

class null implements Runnable {
  public void run() {
    int i = sharedElementsIn.size();
    for (byte b = 0; b < i; b++) {
      View view = sharedElementsIn.get(b);
      String str = ViewCompat.getTransitionName(view);
      if (str != null)
        ViewCompat.setTransitionName(view, FragmentTransitionImpl.findKeyForValue(nameOverrides, str)); 
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransitionImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */