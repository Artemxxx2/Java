package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

class null extends AnimatorListenerAdapter {
  public void onAnimationEnd(Animator paramAnimator) {
    container.endViewTransition(animatingView);
    paramAnimator.removeListener((Animator.AnimatorListener)this);
    if (fragment.mView != null)
      fragment.mView.setVisibility(8); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */