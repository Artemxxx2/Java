package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

class null implements Transition.TransitionListener {
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {
    paramTransition.removeListener(this);
    fragmentView.setVisibility(8);
    int i = exitingViews.size();
    for (byte b = 0; b < i; b++)
      ((View)exitingViews.get(b)).setVisibility(0); 
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransitionCompat21$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */