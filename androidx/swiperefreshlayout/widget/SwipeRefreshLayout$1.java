package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

class null implements Animation.AnimationListener {
  public void onAnimationEnd(Animation paramAnimation) {
    if (SwipeRefreshLayout.this.mRefreshing) {
      SwipeRefreshLayout.this.mProgress.setAlpha(255);
      SwipeRefreshLayout.this.mProgress.start();
      if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null)
        SwipeRefreshLayout.this.mListener.onRefresh(); 
      SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
      swipeRefreshLayout.mCurrentTargetOffsetTop = swipeRefreshLayout.mCircleView.getTop();
    } else {
      SwipeRefreshLayout.this.reset();
    } 
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\SwipeRefreshLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */