package androidx.viewpager.widget;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
  private Locale mLocale;
  
  SingleLineAllCapsTransform(Context paramContext) {
    this.mLocale = (paramContext.getResources().getConfiguration()).locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView) {
    paramCharSequence = super.getTransformation(paramCharSequence, paramView);
    if (paramCharSequence != null) {
      paramCharSequence = paramCharSequence.toString().toUpperCase(this.mLocale);
    } else {
      paramCharSequence = null;
    } 
    return paramCharSequence;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\PagerTitleStrip$SingleLineAllCapsTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */