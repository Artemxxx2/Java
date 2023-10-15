package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;

class Ring {
  int mAlpha = 255;
  
  Path mArrow;
  
  int mArrowHeight;
  
  final Paint mArrowPaint = new Paint();
  
  float mArrowScale = 1.0F;
  
  int mArrowWidth;
  
  final Paint mCirclePaint = new Paint();
  
  int mColorIndex;
  
  int[] mColors;
  
  int mCurrentColor;
  
  float mEndTrim = 0.0F;
  
  final Paint mPaint = new Paint();
  
  float mRingCenterRadius;
  
  float mRotation = 0.0F;
  
  boolean mShowArrow;
  
  float mStartTrim = 0.0F;
  
  float mStartingEndTrim;
  
  float mStartingRotation;
  
  float mStartingStartTrim;
  
  float mStrokeWidth = 5.0F;
  
  final RectF mTempBounds = new RectF();
  
  Ring() {
    this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mArrowPaint.setStyle(Paint.Style.FILL);
    this.mArrowPaint.setAntiAlias(true);
    this.mCirclePaint.setColor(0);
  }
  
  void draw(Canvas paramCanvas, Rect paramRect) {
    RectF rectF = this.mTempBounds;
    float f1 = this.mRingCenterRadius;
    float f2 = this.mStrokeWidth / 2.0F + f1;
    if (f1 <= 0.0F)
      f2 = Math.min(paramRect.width(), paramRect.height()) / 2.0F - Math.max(this.mArrowWidth * this.mArrowScale / 2.0F, this.mStrokeWidth / 2.0F); 
    rectF.set(paramRect.centerX() - f2, paramRect.centerY() - f2, paramRect.centerX() + f2, paramRect.centerY() + f2);
    f2 = this.mStartTrim;
    f1 = this.mRotation;
    f2 = (f2 + f1) * 360.0F;
    f1 = (this.mEndTrim + f1) * 360.0F - f2;
    this.mPaint.setColor(this.mCurrentColor);
    this.mPaint.setAlpha(this.mAlpha);
    float f3 = this.mStrokeWidth / 2.0F;
    rectF.inset(f3, f3);
    paramCanvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0F, this.mCirclePaint);
    f3 = -f3;
    rectF.inset(f3, f3);
    paramCanvas.drawArc(rectF, f2, f1, false, this.mPaint);
    drawTriangle(paramCanvas, f2, f1, rectF);
  }
  
  void drawTriangle(Canvas paramCanvas, float paramFloat1, float paramFloat2, RectF paramRectF) {
    if (this.mShowArrow) {
      Path path = this.mArrow;
      if (path == null) {
        this.mArrow = new Path();
        this.mArrow.setFillType(Path.FillType.EVEN_ODD);
      } else {
        path.reset();
      } 
      float f1 = Math.min(paramRectF.width(), paramRectF.height()) / 2.0F;
      float f2 = this.mArrowWidth * this.mArrowScale / 2.0F;
      this.mArrow.moveTo(0.0F, 0.0F);
      this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0F);
      path = this.mArrow;
      float f3 = this.mArrowWidth;
      float f4 = this.mArrowScale;
      path.lineTo(f3 * f4 / 2.0F, this.mArrowHeight * f4);
      this.mArrow.offset(f1 + paramRectF.centerX() - f2, paramRectF.centerY() + this.mStrokeWidth / 2.0F);
      this.mArrow.close();
      this.mArrowPaint.setColor(this.mCurrentColor);
      this.mArrowPaint.setAlpha(this.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(paramFloat1 + paramFloat2, paramRectF.centerX(), paramRectF.centerY());
      paramCanvas.drawPath(this.mArrow, this.mArrowPaint);
      paramCanvas.restore();
    } 
  }
  
  int getAlpha() {
    return this.mAlpha;
  }
  
  float getArrowHeight() {
    return this.mArrowHeight;
  }
  
  float getArrowScale() {
    return this.mArrowScale;
  }
  
  float getArrowWidth() {
    return this.mArrowWidth;
  }
  
  int getBackgroundColor() {
    return this.mCirclePaint.getColor();
  }
  
  float getCenterRadius() {
    return this.mRingCenterRadius;
  }
  
  int[] getColors() {
    return this.mColors;
  }
  
  float getEndTrim() {
    return this.mEndTrim;
  }
  
  int getNextColor() {
    return this.mColors[getNextColorIndex()];
  }
  
  int getNextColorIndex() {
    return (this.mColorIndex + 1) % this.mColors.length;
  }
  
  float getRotation() {
    return this.mRotation;
  }
  
  boolean getShowArrow() {
    return this.mShowArrow;
  }
  
  float getStartTrim() {
    return this.mStartTrim;
  }
  
  int getStartingColor() {
    return this.mColors[this.mColorIndex];
  }
  
  float getStartingEndTrim() {
    return this.mStartingEndTrim;
  }
  
  float getStartingRotation() {
    return this.mStartingRotation;
  }
  
  float getStartingStartTrim() {
    return this.mStartingStartTrim;
  }
  
  Paint.Cap getStrokeCap() {
    return this.mPaint.getStrokeCap();
  }
  
  float getStrokeWidth() {
    return this.mStrokeWidth;
  }
  
  void goToNextColor() {
    setColorIndex(getNextColorIndex());
  }
  
  void resetOriginals() {
    this.mStartingStartTrim = 0.0F;
    this.mStartingEndTrim = 0.0F;
    this.mStartingRotation = 0.0F;
    setStartTrim(0.0F);
    setEndTrim(0.0F);
    setRotation(0.0F);
  }
  
  void setAlpha(int paramInt) {
    this.mAlpha = paramInt;
  }
  
  void setArrowDimensions(float paramFloat1, float paramFloat2) {
    this.mArrowWidth = (int)paramFloat1;
    this.mArrowHeight = (int)paramFloat2;
  }
  
  void setArrowScale(float paramFloat) {
    if (paramFloat != this.mArrowScale)
      this.mArrowScale = paramFloat; 
  }
  
  void setBackgroundColor(int paramInt) {
    this.mCirclePaint.setColor(paramInt);
  }
  
  void setCenterRadius(float paramFloat) {
    this.mRingCenterRadius = paramFloat;
  }
  
  void setColor(int paramInt) {
    this.mCurrentColor = paramInt;
  }
  
  void setColorFilter(ColorFilter paramColorFilter) {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  void setColorIndex(int paramInt) {
    this.mColorIndex = paramInt;
    this.mCurrentColor = this.mColors[this.mColorIndex];
  }
  
  void setColors(@NonNull int[] paramArrayOfint) {
    this.mColors = paramArrayOfint;
    setColorIndex(0);
  }
  
  void setEndTrim(float paramFloat) {
    this.mEndTrim = paramFloat;
  }
  
  void setRotation(float paramFloat) {
    this.mRotation = paramFloat;
  }
  
  void setShowArrow(boolean paramBoolean) {
    if (this.mShowArrow != paramBoolean)
      this.mShowArrow = paramBoolean; 
  }
  
  void setStartTrim(float paramFloat) {
    this.mStartTrim = paramFloat;
  }
  
  void setStrokeCap(Paint.Cap paramCap) {
    this.mPaint.setStrokeCap(paramCap);
  }
  
  void setStrokeWidth(float paramFloat) {
    this.mStrokeWidth = paramFloat;
    this.mPaint.setStrokeWidth(paramFloat);
  }
  
  void storeOriginals() {
    this.mStartingStartTrim = this.mStartTrim;
    this.mStartingEndTrim = this.mEndTrim;
    this.mStartingRotation = this.mRotation;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\swiperefreshlayout\widget\CircularProgressDrawable$Ring.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */