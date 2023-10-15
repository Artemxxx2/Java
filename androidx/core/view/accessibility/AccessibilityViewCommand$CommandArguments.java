package androidx.core.view.accessibility;

import android.os.Bundle;
import androidx.annotation.RestrictTo;

public abstract class CommandArguments {
  Bundle mBundle;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setBundle(Bundle paramBundle) {
    this.mBundle = paramBundle;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\accessibility\AccessibilityViewCommand$CommandArguments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */