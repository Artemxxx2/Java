package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class null extends Animation {
  public void applyTransformation(float paramFloat, Transformation paramTransformation) {
    float f1 = SwipeRefreshLayout.this.mStartingScale;
    float f2 = -SwipeRefreshLayout.this.mStartingScale;
    SwipeRefreshLayout.this.setAnimationProgress(f1 + f2 * paramFloat);
    SwipeRefreshLayout.this.moveToStart(paramFloat);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\SwipeRefreshLayout$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */