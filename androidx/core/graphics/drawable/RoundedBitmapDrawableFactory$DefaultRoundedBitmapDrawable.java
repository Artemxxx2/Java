package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;

class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
  DefaultRoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap) {
    super(paramResources, paramBitmap);
  }
  
  void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2) {
    GravityCompat.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
  }
  
  public boolean hasMipMap() {
    boolean bool;
    if (this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void setMipMap(boolean paramBoolean) {
    if (this.mBitmap != null) {
      BitmapCompat.setHasMipMap(this.mBitmap, paramBoolean);
      invalidateSelf();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\graphics\drawable\RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */