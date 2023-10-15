package androidx.viewpager.widget;

import android.database.DataSetObserver;

class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
  private int mScrollState;
  
  public void onAdapterChanged(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2) {
    PagerTitleStrip.this.updateAdapter(paramPagerAdapter1, paramPagerAdapter2);
  }
  
  public void onChanged() {
    PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
    pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
    float f1 = PagerTitleStrip.this.mLastKnownPositionOffset;
    float f2 = 0.0F;
    if (f1 >= 0.0F)
      f2 = PagerTitleStrip.this.mLastKnownPositionOffset; 
    pagerTitleStrip = PagerTitleStrip.this;
    pagerTitleStrip.updateTextPositions(pagerTitleStrip.mPager.getCurrentItem(), f2, true);
  }
  
  public void onPageScrollStateChanged(int paramInt) {
    this.mScrollState = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    paramInt2 = paramInt1;
    if (paramFloat > 0.5F)
      paramInt2 = paramInt1 + 1; 
    PagerTitleStrip.this.updateTextPositions(paramInt2, paramFloat, false);
  }
  
  public void onPageSelected(int paramInt) {
    if (this.mScrollState == 0) {
      PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
      pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
      float f1 = PagerTitleStrip.this.mLastKnownPositionOffset;
      float f2 = 0.0F;
      if (f1 >= 0.0F)
        f2 = PagerTitleStrip.this.mLastKnownPositionOffset; 
      pagerTitleStrip = PagerTitleStrip.this;
      pagerTitleStrip.updateTextPositions(pagerTitleStrip.mPager.getCurrentItem(), f2, true);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\PagerTitleStrip$PageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */