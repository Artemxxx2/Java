package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class null extends AnimatorListenerAdapter {
  public void onAnimationCancel(Animator paramAnimator) {
    listener.onAnimationCancel(view);
  }
  
  public void onAnimationEnd(Animator paramAnimator) {
    listener.onAnimationEnd(view);
  }
  
  public void onAnimationStart(Animator paramAnimator) {
    listener.onAnimationStart(view);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewPropertyAnimatorCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */