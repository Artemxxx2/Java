package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;

final class null implements Runnable {
  public void run() {
    Object<View> object = (Object<View>)enterTransition;
    if (object != null) {
      impl.removeTarget(object, nonExistentView);
      object = (Object<View>)FragmentTransition.configureEnteringExitingViews(impl, enterTransition, inFragment, sharedElementsIn, nonExistentView);
      enteringViews.addAll((Collection<? extends View>)object);
    } 
    if (exitingViews != null) {
      if (exitTransition != null) {
        object = (Object<View>)new ArrayList();
        object.add(nonExistentView);
        impl.replaceTargets(exitTransition, exitingViews, (ArrayList<View>)object);
      } 
      exitingViews.clear();
      exitingViews.add(nonExistentView);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTransition$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */