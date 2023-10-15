package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;

class null implements ValueAnimator.AnimatorUpdateListener {
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CircularProgressDrawable.this.updateRingColor(f, ring);
    CircularProgressDrawable.this.applyTransformation(f, ring, false);
    CircularProgressDrawable.this.invalidateSelf();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\CircularProgressDrawable$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */