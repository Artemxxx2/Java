package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;

class null extends FragmentManagerImpl.AnimationListenerWrapper {
  null(Animation.AnimationListener paramAnimationListener) {
    super(paramAnimationListener);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {
    super.onAnimationEnd(paramAnimation);
    container.post(new Runnable() {
          public void run() {
            if (fragment.getAnimatingAway() != null) {
              fragment.setAnimatingAway(null);
              FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
            } 
          }
        });
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */