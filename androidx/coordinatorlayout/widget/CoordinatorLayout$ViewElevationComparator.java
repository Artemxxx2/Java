package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Comparator;

class ViewElevationComparator implements Comparator<View> {
  public int compare(View paramView1, View paramView2) {
    float f1 = ViewCompat.getZ(paramView1);
    float f2 = ViewCompat.getZ(paramView2);
    return (f1 > f2) ? -1 : ((f1 < f2) ? 1 : 0);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$ViewElevationComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */