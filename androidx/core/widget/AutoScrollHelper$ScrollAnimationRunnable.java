package androidx.core.widget;

import androidx.core.view.ViewCompat;

class ScrollAnimationRunnable implements Runnable {
  public void run() {
    if (!AutoScrollHelper.this.mAnimating)
      return; 
    if (AutoScrollHelper.this.mNeedsReset) {
      AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
      autoScrollHelper.mNeedsReset = false;
      autoScrollHelper.mScroller.start();
    } 
    AutoScrollHelper.ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
    if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
      AutoScrollHelper.this.mAnimating = false;
      return;
    } 
    if (AutoScrollHelper.this.mNeedsCancel) {
      AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
      autoScrollHelper.mNeedsCancel = false;
      autoScrollHelper.cancelTargetTouch();
    } 
    clampedScroller.computeScrollDelta();
    int i = clampedScroller.getDeltaX();
    int j = clampedScroller.getDeltaY();
    AutoScrollHelper.this.scrollTargetBy(i, j);
    ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\AutoScrollHelper$ScrollAnimationRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */