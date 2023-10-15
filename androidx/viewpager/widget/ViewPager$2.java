package androidx.viewpager.widget;

import android.view.animation.Interpolator;

final class null implements Interpolator {
  public float getInterpolation(float paramFloat) {
    paramFloat--;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */