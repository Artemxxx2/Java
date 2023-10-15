package androidx.core.view;

import android.os.Build;
import android.view.View;

abstract class AccessibilityViewProperty<T> {
  private final int mFrameworkMinimumSdk;
  
  private final int mTagKey;
  
  private final Class<T> mType;
  
  AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2) {
    this(paramInt1, paramClass, 0, paramInt2);
  }
  
  AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3) {
    this.mTagKey = paramInt1;
    this.mType = paramClass;
    this.mFrameworkMinimumSdk = paramInt3;
  }
  
  private boolean extrasAvailable() {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean frameworkAvailable() {
    boolean bool;
    if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean booleanNullToFalseEquals(Boolean paramBoolean1, Boolean paramBoolean2) {
    boolean bool1;
    boolean bool2;
    boolean bool = false;
    if (paramBoolean1 == null) {
      bool1 = false;
    } else {
      bool1 = paramBoolean1.booleanValue();
    } 
    if (paramBoolean2 == null) {
      bool2 = false;
    } else {
      bool2 = paramBoolean2.booleanValue();
    } 
    if (bool1 == bool2)
      bool = true; 
    return bool;
  }
  
  abstract T frameworkGet(View paramView);
  
  abstract void frameworkSet(View paramView, T paramT);
  
  T get(View paramView) {
    if (frameworkAvailable())
      return frameworkGet(paramView); 
    if (extrasAvailable()) {
      Object object = paramView.getTag(this.mTagKey);
      if (this.mType.isInstance(object))
        return (T)object; 
    } 
    return null;
  }
  
  void set(View paramView, T paramT) {
    if (frameworkAvailable()) {
      frameworkSet(paramView, paramT);
    } else if (extrasAvailable() && shouldUpdate(get(paramView), paramT)) {
      ViewCompat.getOrCreateAccessibilityDelegateCompat(paramView);
      paramView.setTag(this.mTagKey, paramT);
      ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 0);
    } 
  }
  
  boolean shouldUpdate(T paramT1, T paramT2) {
    return paramT2.equals(paramT1) ^ true;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\ViewCompat$AccessibilityViewProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */