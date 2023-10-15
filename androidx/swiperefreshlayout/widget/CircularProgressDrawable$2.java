package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

class null implements Animator.AnimatorListener {
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {
    CircularProgressDrawable.this.applyTransformation(1.0F, ring, true);
    ring.storeOriginals();
    ring.goToNextColor();
    if (CircularProgressDrawable.this.mFinishing) {
      CircularProgressDrawable.this.mFinishing = false;
      paramAnimator.cancel();
      paramAnimator.setDuration(1332L);
      paramAnimator.start();
      ring.setShowArrow(false);
    } else {
      CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
      circularProgressDrawable.mRotationCount++;
    } 
  }
  
  public void onAnimationStart(Animator paramAnimator) {
    CircularProgressDrawable.this.mRotationCount = 0.0F;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\CircularProgressDrawable$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */