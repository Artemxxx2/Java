package androidx.legacy.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class SlideDrawable extends InsetDrawable implements Drawable.Callback {
  private final boolean mHasMirroring;
  
  private float mOffset;
  
  private float mPosition;
  
  private final Rect mTmpRect;
  
  SlideDrawable(Drawable paramDrawable) {
    super(paramDrawable, 0);
    if (Build.VERSION.SDK_INT > 18)
      bool = true; 
    this.mHasMirroring = bool;
    this.mTmpRect = new Rect();
  }
  
  public void draw(@NonNull Canvas paramCanvas) {
    copyBounds(this.mTmpRect);
    paramCanvas.save();
    int i = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView());
    byte b = 1;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i != 0)
      b = -1; 
    int j = this.mTmpRect.width();
    float f1 = -this.mOffset;
    float f2 = j;
    paramCanvas.translate(f1 * f2 * this.mPosition * b, 0.0F);
    if (i != 0 && !this.mHasMirroring) {
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.scale(-1.0F, 1.0F);
    } 
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public float getPosition() {
    return this.mPosition;
  }
  
  public void setOffset(float paramFloat) {
    this.mOffset = paramFloat;
    invalidateSelf();
  }
  
  public void setPosition(float paramFloat) {
    this.mPosition = paramFloat;
    invalidateSelf();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\legacy\app\ActionBarDrawerToggle$SlideDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */