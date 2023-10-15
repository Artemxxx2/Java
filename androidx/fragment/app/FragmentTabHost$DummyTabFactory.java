package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

class DummyTabFactory implements TabHost.TabContentFactory {
  private final Context mContext;
  
  public DummyTabFactory(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public View createTabContent(String paramString) {
    View view = new View(this.mContext);
    view.setMinimumWidth(0);
    view.setMinimumHeight(0);
    return view;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTabHost$DummyTabFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */