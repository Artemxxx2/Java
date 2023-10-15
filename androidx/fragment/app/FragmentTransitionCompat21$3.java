package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

class null implements Transition.TransitionListener {
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {}
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {
    Object object = enterTransition;
    if (object != null)
      FragmentTransitionCompat21.this.replaceTargets(object, enteringViews, null); 
    object = exitTransition;
    if (object != null)
      FragmentTransitionCompat21.this.replaceTargets(object, exitingViews, null); 
    object = sharedElementTransition;
    if (object != null)
      FragmentTransitionCompat21.this.replaceTargets(object, sharedElementsIn, null); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransitionCompat21$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */