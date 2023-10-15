package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
  View mView;
  
  AnimatorOnHWLayerIfNeededListener(View paramView) {
    this.mView = paramView;
  }
  
  public void onAnimationEnd(Animator paramAnimator) {
    this.mView.setLayerType(0, null);
    paramAnimator.removeListener((Animator.AnimatorListener)this);
  }
  
  public void onAnimationStart(Animator paramAnimator) {
    this.mView.setLayerType(2, null);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$AnimatorOnHWLayerIfNeededListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */