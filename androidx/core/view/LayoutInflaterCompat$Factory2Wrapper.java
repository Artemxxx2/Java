package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;

class Factory2Wrapper implements LayoutInflater.Factory2 {
  final LayoutInflaterFactory mDelegateFactory;
  
  Factory2Wrapper(LayoutInflaterFactory paramLayoutInflaterFactory) {
    this.mDelegateFactory = paramLayoutInflaterFactory;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.mDelegateFactory.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.mDelegateFactory.onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  @NonNull
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append("{");
    stringBuilder.append(this.mDelegateFactory);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\LayoutInflaterCompat$Factory2Wrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */