package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  
  private boolean mColorFilterSet;
  
  private int mCurrentColor;
  
  private PorterDuff.Mode mCurrentMode;
  
  Drawable mDrawable;
  
  private boolean mMutated;
  
  WrappedDrawableState mState = mutateConstantState();
  
  WrappedDrawableApi14(@Nullable Drawable paramDrawable) {
    setWrappedDrawable(paramDrawable);
  }
  
  WrappedDrawableApi14(@NonNull WrappedDrawableState paramWrappedDrawableState, @Nullable Resources paramResources) {
    updateLocalState(paramResources);
  }
  
  @NonNull
  private WrappedDrawableState mutateConstantState() {
    return new WrappedDrawableState(this.mState);
  }
  
  private void updateLocalState(@Nullable Resources paramResources) {
    WrappedDrawableState wrappedDrawableState = this.mState;
    if (wrappedDrawableState != null && wrappedDrawableState.mDrawableState != null)
      setWrappedDrawable(this.mState.mDrawableState.newDrawable(paramResources)); 
  }
  
  private boolean updateTint(int[] paramArrayOfint) {
    if (!isCompatTintEnabled())
      return false; 
    ColorStateList colorStateList = this.mState.mTint;
    PorterDuff.Mode mode = this.mState.mTintMode;
    if (colorStateList != null && mode != null) {
      int i = colorStateList.getColorForState(paramArrayOfint, colorStateList.getDefaultColor());
      if (!this.mColorFilterSet || i != this.mCurrentColor || mode != this.mCurrentMode) {
        setColorFilter(i, mode);
        this.mCurrentColor = i;
        this.mCurrentMode = mode;
        this.mColorFilterSet = true;
        return true;
      } 
    } else {
      this.mColorFilterSet = false;
      clearColorFilter();
    } 
    return false;
  }
  
  public void draw(@NonNull Canvas paramCanvas) {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations() {
    byte b;
    int i = super.getChangingConfigurations();
    WrappedDrawableState wrappedDrawableState = this.mState;
    if (wrappedDrawableState != null) {
      b = wrappedDrawableState.getChangingConfigurations();
    } else {
      b = 0;
    } 
    return i | b | this.mDrawable.getChangingConfigurations();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState() {
    WrappedDrawableState wrappedDrawableState = this.mState;
    if (wrappedDrawableState != null && wrappedDrawableState.canConstantState()) {
      this.mState.mChangingConfigurations = getChangingConfigurations();
      return this.mState;
    } 
    return null;
  }
  
  @NonNull
  public Drawable getCurrent() {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight() {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth() {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight() {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth() {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity() {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(@NonNull Rect paramRect) {
    return this.mDrawable.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState() {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion() {
    return this.mDrawable.getTransparentRegion();
  }
  
  public final Drawable getWrappedDrawable() {
    return this.mDrawable;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable) {
    invalidateSelf();
  }
  
  @RequiresApi(19)
  public boolean isAutoMirrored() {
    return this.mDrawable.isAutoMirrored();
  }
  
  protected boolean isCompatTintEnabled() {
    return true;
  }
  
  public boolean isStateful() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isCompatTintEnabled : ()Z
    //   4: ifeq -> 24
    //   7: aload_0
    //   8: getfield mState : Landroidx/core/graphics/drawable/WrappedDrawableState;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull -> 24
    //   16: aload_1
    //   17: getfield mTint : Landroid/content/res/ColorStateList;
    //   20: astore_1
    //   21: goto -> 26
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull -> 37
    //   30: aload_1
    //   31: invokevirtual isStateful : ()Z
    //   34: ifne -> 47
    //   37: aload_0
    //   38: getfield mDrawable : Landroid/graphics/drawable/Drawable;
    //   41: invokevirtual isStateful : ()Z
    //   44: ifeq -> 52
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -> 54
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: ireturn
  }
  
  public void jumpToCurrentState() {
    this.mDrawable.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate() {
    if (!this.mMutated && super.mutate() == this) {
      this.mState = mutateConstantState();
      Drawable drawable = this.mDrawable;
      if (drawable != null)
        drawable.mutate(); 
      WrappedDrawableState wrappedDrawableState = this.mState;
      if (wrappedDrawableState != null) {
        drawable = this.mDrawable;
        if (drawable != null) {
          Drawable.ConstantState constantState = drawable.getConstantState();
        } else {
          drawable = null;
        } 
        wrappedDrawableState.mDrawableState = (Drawable.ConstantState)drawable;
      } 
      this.mMutated = true;
    } 
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect) {
    Drawable drawable = this.mDrawable;
    if (drawable != null)
      drawable.setBounds(paramRect); 
  }
  
  protected boolean onLevelChange(int paramInt) {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    this.mDrawable.setAlpha(paramInt);
  }
  
  @RequiresApi(19)
  public void setAutoMirrored(boolean paramBoolean) {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt) {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean) {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean) {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfint) {
    null = this.mDrawable.setState(paramArrayOfint);
    return (updateTint(paramArrayOfint) || null);
  }
  
  public void setTint(int paramInt) {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.mState.mTint = paramColorStateList;
    updateTint(getState());
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode) {
    this.mState.mTintMode = paramMode;
    updateTint(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return (super.setVisible(paramBoolean1, paramBoolean2) || this.mDrawable.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public final void setWrappedDrawable(Drawable paramDrawable) {
    Drawable drawable = this.mDrawable;
    if (drawable != null)
      drawable.setCallback(null); 
    this.mDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      WrappedDrawableState wrappedDrawableState = this.mState;
      if (wrappedDrawableState != null)
        wrappedDrawableState.mDrawableState = paramDrawable.getConstantState(); 
    } 
    invalidateSelf();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\drawable\WrappedDrawableApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */