package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class null extends Animation {
  public void applyTransformation(float paramFloat, Transformation paramTransformation) {
    SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramFloat);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\SwipeRefreshLayout$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */