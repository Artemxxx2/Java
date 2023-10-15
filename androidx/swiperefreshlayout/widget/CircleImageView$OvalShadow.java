package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.shapes.OvalShape;

class OvalShadow extends OvalShape {
  private RadialGradient mRadialGradient;
  
  private Paint mShadowPaint = new Paint();
  
  OvalShadow(int paramInt) {
    paramCircleImageView.mShadowRadius = paramInt;
    updateRadialGradient((int)rect().width());
  }
  
  private void updateRadialGradient(int paramInt) {
    float f1 = (paramInt / 2);
    float f2 = CircleImageView.this.mShadowRadius;
    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
    this.mRadialGradient = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, tileMode);
    this.mShadowPaint.setShader((Shader)this.mRadialGradient);
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint) {
    int i = CircleImageView.this.getWidth();
    int j = CircleImageView.this.getHeight();
    i /= 2;
    float f1 = i;
    float f2 = (j / 2);
    paramCanvas.drawCircle(f1, f2, f1, this.mShadowPaint);
    paramCanvas.drawCircle(f1, f2, (i - CircleImageView.this.mShadowRadius), paramPaint);
  }
  
  protected void onResize(float paramFloat1, float paramFloat2) {
    super.onResize(paramFloat1, paramFloat2);
    updateRadialGradient((int)paramFloat1);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\CircleImageView$OvalShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */