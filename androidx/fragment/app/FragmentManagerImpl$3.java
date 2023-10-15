package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

class null extends AnimatorListenerAdapter {
  public void onAnimationEnd(Animator paramAnimator) {
    container.endViewTransition(viewToAnimate);
    paramAnimator = fragment.getAnimator();
    fragment.setAnimator(null);
    if (paramAnimator != null && container.indexOfChild(viewToAnimate) < 0) {
      FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
      Fragment fragment = fragment;
      fragmentManagerImpl.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */