package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

class null implements Animation.AnimationListener {
  public void onAnimationEnd(Animation paramAnimation) {
    if (!SwipeRefreshLayout.this.mScale)
      SwipeRefreshLayout.this.startScaleDownAnimation(null); 
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\SwipeRefreshLayout$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */