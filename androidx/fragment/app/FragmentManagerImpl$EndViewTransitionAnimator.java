package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;

class EndViewTransitionAnimator extends AnimationSet implements Runnable {
  private boolean mAnimating = true;
  
  private final View mChild;
  
  private boolean mEnded;
  
  private final ViewGroup mParent;
  
  private boolean mTransitionEnded;
  
  EndViewTransitionAnimator(@NonNull Animation paramAnimation, @NonNull ViewGroup paramViewGroup, @NonNull View paramView) {
    super(false);
    this.mParent = paramViewGroup;
    this.mChild = paramView;
    addAnimation(paramAnimation);
    this.mParent.post(this);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation) {
    this.mAnimating = true;
    if (this.mEnded)
      return this.mTransitionEnded ^ true; 
    if (!super.getTransformation(paramLong, paramTransformation)) {
      this.mEnded = true;
      OneShotPreDrawListener.add((View)this.mParent, this);
    } 
    return true;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat) {
    this.mAnimating = true;
    if (this.mEnded)
      return this.mTransitionEnded ^ true; 
    if (!super.getTransformation(paramLong, paramTransformation, paramFloat)) {
      this.mEnded = true;
      OneShotPreDrawListener.add((View)this.mParent, this);
    } 
    return true;
  }
  
  public void run() {
    if (!this.mEnded && this.mAnimating) {
      this.mAnimating = false;
      this.mParent.post(this);
    } else {
      this.mParent.endViewTransition(this.mChild);
      this.mTransitionEnded = true;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$EndViewTransitionAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */