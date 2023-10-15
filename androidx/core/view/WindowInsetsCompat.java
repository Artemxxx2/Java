package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.Objects;

public class WindowInsetsCompat {
  private final Object mInsets;
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat) {
    int i = Build.VERSION.SDK_INT;
    WindowInsetsCompat windowInsetsCompat = null;
    if (i >= 20) {
      WindowInsets windowInsets;
      if (paramWindowInsetsCompat == null) {
        paramWindowInsetsCompat = windowInsetsCompat;
      } else {
        windowInsets = new WindowInsets((WindowInsets)paramWindowInsetsCompat.mInsets);
      } 
      this.mInsets = windowInsets;
    } else {
      this.mInsets = null;
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  WindowInsetsCompat(@Nullable Object paramObject) {
    this.mInsets = paramObject;
  }
  
  @NonNull
  @RequiresApi(20)
  public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets paramWindowInsets) {
    return new WindowInsetsCompat(Objects.requireNonNull(paramWindowInsets));
  }
  
  public WindowInsetsCompat consumeDisplayCutout() {
    return (Build.VERSION.SDK_INT >= 28) ? new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeDisplayCutout()) : this;
  }
  
  public WindowInsetsCompat consumeStableInsets() {
    return (Build.VERSION.SDK_INT >= 21) ? new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeStableInsets()) : null;
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? new WindowInsetsCompat(((WindowInsets)this.mInsets).consumeSystemWindowInsets()) : null;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof WindowInsetsCompat))
      return false; 
    paramObject = paramObject;
    return ObjectsCompat.equals(this.mInsets, ((WindowInsetsCompat)paramObject).mInsets);
  }
  
  @Nullable
  public DisplayCutoutCompat getDisplayCutout() {
    return (Build.VERSION.SDK_INT >= 28) ? DisplayCutoutCompat.wrap(((WindowInsets)this.mInsets).getDisplayCutout()) : null;
  }
  
  @NonNull
  public Insets getMandatorySystemGestureInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.mInsets).getMandatorySystemGestureInsets()) : getSystemWindowInsets();
  }
  
  public int getStableInsetBottom() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).getStableInsetBottom() : 0;
  }
  
  public int getStableInsetLeft() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).getStableInsetLeft() : 0;
  }
  
  public int getStableInsetRight() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).getStableInsetRight() : 0;
  }
  
  public int getStableInsetTop() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).getStableInsetTop() : 0;
  }
  
  @NonNull
  public Insets getStableInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.mInsets).getStableInsets()) : Insets.of(getStableInsetLeft(), getStableInsetTop(), getStableInsetRight(), getStableInsetBottom());
  }
  
  @NonNull
  public Insets getSystemGestureInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.mInsets).getSystemGestureInsets()) : getSystemWindowInsets();
  }
  
  public int getSystemWindowInsetBottom() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).getSystemWindowInsetBottom() : 0;
  }
  
  public int getSystemWindowInsetLeft() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).getSystemWindowInsetLeft() : 0;
  }
  
  public int getSystemWindowInsetRight() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).getSystemWindowInsetRight() : 0;
  }
  
  public int getSystemWindowInsetTop() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).getSystemWindowInsetTop() : 0;
  }
  
  @NonNull
  public Insets getSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.mInsets).getSystemWindowInsets()) : Insets.of(getSystemWindowInsetLeft(), getSystemWindowInsetTop(), getSystemWindowInsetRight(), getSystemWindowInsetBottom());
  }
  
  @NonNull
  public Insets getTappableElementInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.mInsets).getTappableElementInsets()) : getSystemWindowInsets();
  }
  
  public boolean hasInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).hasInsets() : false;
  }
  
  public boolean hasStableInsets() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).hasStableInsets() : false;
  }
  
  public boolean hasSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).hasSystemWindowInsets() : false;
  }
  
  public int hashCode() {
    int i;
    Object object = this.mInsets;
    if (object == null) {
      i = 0;
    } else {
      i = object.hashCode();
    } 
    return i;
  }
  
  public boolean isConsumed() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.mInsets).isConsumed() : false;
  }
  
  public boolean isRound() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.mInsets).isRound() : false;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 20) ? new WindowInsetsCompat(((WindowInsets)this.mInsets).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4)) : null;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect) {
    return (Build.VERSION.SDK_INT >= 21) ? new WindowInsetsCompat(((WindowInsets)this.mInsets).replaceSystemWindowInsets(paramRect)) : null;
  }
  
  @Nullable
  @RequiresApi(20)
  public WindowInsets toWindowInsets() {
    return (WindowInsets)this.mInsets;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\WindowInsetsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */