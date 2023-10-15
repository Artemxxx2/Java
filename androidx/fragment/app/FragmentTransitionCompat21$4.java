package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

class null extends Transition.EpicenterCallback {
  public Rect onGetEpicenter(Transition paramTransition) {
    Rect rect = epicenter;
    return (rect == null || rect.isEmpty()) ? null : epicenter;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransitionCompat21$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */