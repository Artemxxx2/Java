package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;

class AnimateOnHWLayerIfNeededListener extends FragmentManagerImpl.AnimationListenerWrapper {
  View mView;
  
  AnimateOnHWLayerIfNeededListener(View paramView, Animation.AnimationListener paramAnimationListener) {
    super(paramAnimationListener);
    this.mView = paramView;
  }
  
  @CallSuper
  public void onAnimationEnd(Animation paramAnimation) {
    if (ViewCompat.isAttachedToWindow(this.mView) || Build.VERSION.SDK_INT >= 24) {
      this.mView.post(new Runnable() {
            public void run() {
              FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.this.mView.setLayerType(0, null);
            }
          });
    } else {
      this.mView.setLayerType(0, null);
    } 
    super.onAnimationEnd(paramAnimation);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerImpl$AnimateOnHWLayerIfNeededListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */