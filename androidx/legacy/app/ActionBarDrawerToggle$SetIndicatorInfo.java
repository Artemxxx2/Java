package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class SetIndicatorInfo {
  Method mSetHomeActionContentDescription;
  
  Method mSetHomeAsUpIndicator;
  
  ImageView mUpIndicatorView;
  
  SetIndicatorInfo(Activity paramActivity) {
    try {
      this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
      this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { int.class });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      View view1 = paramActivity.findViewById(16908332);
      if (view1 == null)
        return; 
      ViewGroup viewGroup = (ViewGroup)view1.getParent();
      if (viewGroup.getChildCount() != 2)
        return; 
      view1 = viewGroup.getChildAt(0);
      View view2 = viewGroup.getChildAt(1);
      if (view1.getId() == 16908332)
        view1 = view2; 
      if (view1 instanceof ImageView)
        this.mUpIndicatorView = (ImageView)view1; 
      return;
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\legacy\app\ActionBarDrawerToggle$SetIndicatorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */