package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

class AnimationOrAnimator {
  public final Animation animation = null;
  
  public final Animator animator;
  
  AnimationOrAnimator(Animator paramAnimator) {
    this.animator = paramAnimator;
    if (paramAnimator != null)
      return; 
    throw new IllegalStateException("Animator cannot be null");
  }
  
  AnimationOrAnimator(Animation paramAnimation) {
    this.animator = null;
    if (paramAnimation != null)
      return; 
    throw new IllegalStateException("Animation cannot be null");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$AnimationOrAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */