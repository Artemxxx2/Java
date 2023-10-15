package androidx.fragment.app;

import android.view.animation.Animation;
import androidx.annotation.CallSuper;

class AnimationListenerWrapper implements Animation.AnimationListener {
  private final Animation.AnimationListener mWrapped;
  
  AnimationListenerWrapper(Animation.AnimationListener paramAnimationListener) {
    this.mWrapped = paramAnimationListener;
  }
  
  @CallSuper
  public void onAnimationEnd(Animation paramAnimation) {
    Animation.AnimationListener animationListener = this.mWrapped;
    if (animationListener != null)
      animationListener.onAnimationEnd(paramAnimation); 
  }
  
  @CallSuper
  public void onAnimationRepeat(Animation paramAnimation) {
    Animation.AnimationListener animationListener = this.mWrapped;
    if (animationListener != null)
      animationListener.onAnimationRepeat(paramAnimation); 
  }
  
  @CallSuper
  public void onAnimationStart(Animation paramAnimation) {
    Animation.AnimationListener animationListener = this.mWrapped;
    if (animationListener != null)
      animationListener.onAnimationStart(paramAnimation); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$AnimationListenerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */