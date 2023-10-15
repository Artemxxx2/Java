package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;

class null extends FragmentContainer {
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle) {
    return Fragment.this.mHost.instantiate(paramContext, paramString, paramBundle);
  }
  
  @Nullable
  public View onFindViewById(int paramInt) {
    if (Fragment.this.mView != null)
      return Fragment.this.mView.findViewById(paramInt); 
    throw new IllegalStateException("Fragment does not have a view");
  }
  
  public boolean onHasView() {
    boolean bool;
    if (Fragment.this.mView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\Fragment$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */