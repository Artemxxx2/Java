package androidx.viewpager.widget;

import android.database.DataSetObserver;

class PagerObserver extends DataSetObserver {
  public void onChanged() {
    ViewPager.this.dataSetChanged();
  }
  
  public void onInvalidated() {
    ViewPager.this.dataSetChanged();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$PagerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */