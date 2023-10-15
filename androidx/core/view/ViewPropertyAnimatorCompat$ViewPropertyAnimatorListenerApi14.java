package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
  boolean mAnimEndCalled;
  
  ViewPropertyAnimatorCompat mVpa;
  
  ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat) {
    this.mVpa = paramViewPropertyAnimatorCompat;
  }
  
  public void onAnimationCancel(View paramView) {
    Object object = paramView.getTag(2113929216);
    if (object instanceof ViewPropertyAnimatorListener) {
      object = object;
    } else {
      object = null;
    } 
    if (object != null)
      object.onAnimationCancel(paramView); 
  }
  
  @SuppressLint({"WrongConstant"})
  public void onAnimationEnd(View paramView) {
    int i = this.mVpa.mOldLayerType;
    ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
    if (i > -1) {
      paramView.setLayerType(this.mVpa.mOldLayerType, null);
      this.mVpa.mOldLayerType = -1;
    } 
    if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
      if (this.mVpa.mEndAction != null) {
        Runnable runnable = this.mVpa.mEndAction;
        this.mVpa.mEndAction = null;
        runnable.run();
      } 
      Object object = paramView.getTag(2113929216);
      if (object instanceof ViewPropertyAnimatorListener)
        viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
      if (viewPropertyAnimatorListener != null)
        viewPropertyAnimatorListener.onAnimationEnd(paramView); 
      this.mAnimEndCalled = true;
    } 
  }
  
  public void onAnimationStart(View paramView) {
    this.mAnimEndCalled = false;
    int i = this.mVpa.mOldLayerType;
    ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
    if (i > -1)
      paramView.setLayerType(2, null); 
    if (this.mVpa.mStartAction != null) {
      Runnable runnable = this.mVpa.mStartAction;
      this.mVpa.mStartAction = null;
      runnable.run();
    } 
    Object object = paramView.getTag(2113929216);
    if (object instanceof ViewPropertyAnimatorListener)
      viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
    if (viewPropertyAnimatorListener != null)
      viewPropertyAnimatorListener.onAnimationStart(paramView); 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */