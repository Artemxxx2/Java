package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

class ViewPositionComparator implements Comparator<View> {
  public int compare(View paramView1, View paramView2) {
    ViewPager.LayoutParams layoutParams1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
    if (layoutParams1.isDecor != layoutParams2.isDecor) {
      byte b;
      if (layoutParams1.isDecor) {
        b = 1;
      } else {
        b = -1;
      } 
      return b;
    } 
    return layoutParams1.position - layoutParams2.position;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$ViewPositionComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */