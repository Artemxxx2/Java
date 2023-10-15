package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

class BasicInflater extends LayoutInflater {
  private static final String[] sClassPrefixList = new String[] { "android.widget.", "android.webkit.", "android.app." };
  
  BasicInflater(Context paramContext) {
    super(paramContext);
  }
  
  public LayoutInflater cloneInContext(Context paramContext) {
    return new BasicInflater(paramContext);
  }
  
  protected View onCreateView(String paramString, AttributeSet paramAttributeSet) throws ClassNotFoundException {
    String[] arrayOfString = sClassPrefixList;
    int i = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < i) {
        String str = arrayOfString[b];
        try {
          View view = createView(paramString, str, paramAttributeSet);
          if (view != null)
            return view; 
        } catch (ClassNotFoundException classNotFoundException) {}
        b++;
        continue;
      } 
      return super.onCreateView(paramString, paramAttributeSet);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\asynclayoutinflater\view\AsyncLayoutInflater$BasicInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */