package androidx.core.widget;

import android.view.animation.AnimationUtils;

class ClampedScroller {
  private long mDeltaTime = 0L;
  
  private int mDeltaX = 0;
  
  private int mDeltaY = 0;
  
  private int mEffectiveRampDown;
  
  private int mRampDownDuration;
  
  private int mRampUpDuration;
  
  private long mStartTime = Long.MIN_VALUE;
  
  private long mStopTime = -1L;
  
  private float mStopValue;
  
  private float mTargetVelocityX;
  
  private float mTargetVelocityY;
  
  private float getValueAt(long paramLong) {
    if (paramLong < this.mStartTime)
      return 0.0F; 
    long l = this.mStopTime;
    if (l < 0L || paramLong < l)
      return AutoScrollHelper.constrain((float)(paramLong - this.mStartTime) / this.mRampUpDuration, 0.0F, 1.0F) * 0.5F; 
    float f = this.mStopValue;
    return 1.0F - f + f * AutoScrollHelper.constrain((float)(paramLong - l) / this.mEffectiveRampDown, 0.0F, 1.0F);
  }
  
  private float interpolateValue(float paramFloat) {
    return -4.0F * paramFloat * paramFloat + paramFloat * 4.0F;
  }
  
  public void computeScrollDelta() {
    if (this.mDeltaTime != 0L) {
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = interpolateValue(getValueAt(l1));
      long l2 = this.mDeltaTime;
      this.mDeltaTime = l1;
      f = (float)(l1 - l2) * f;
      this.mDeltaX = (int)(this.mTargetVelocityX * f);
      this.mDeltaY = (int)(f * this.mTargetVelocityY);
      return;
    } 
    throw new RuntimeException("Cannot compute scroll delta before calling start()");
  }
  
  public int getDeltaX() {
    return this.mDeltaX;
  }
  
  public int getDeltaY() {
    return this.mDeltaY;
  }
  
  public int getHorizontalDirection() {
    float f = this.mTargetVelocityX;
    return (int)(f / Math.abs(f));
  }
  
  public int getVerticalDirection() {
    float f = this.mTargetVelocityY;
    return (int)(f / Math.abs(f));
  }
  
  public boolean isFinished() {
    boolean bool;
    if (this.mStopTime > 0L && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void requestStop() {
    long l = AnimationUtils.currentAnimationTimeMillis();
    this.mEffectiveRampDown = AutoScrollHelper.constrain((int)(l - this.mStartTime), 0, this.mRampDownDuration);
    this.mStopValue = getValueAt(l);
    this.mStopTime = l;
  }
  
  public void setRampDownDuration(int paramInt) {
    this.mRampDownDuration = paramInt;
  }
  
  public void setRampUpDuration(int paramInt) {
    this.mRampUpDuration = paramInt;
  }
  
  public void setTargetVelocity(float paramFloat1, float paramFloat2) {
    this.mTargetVelocityX = paramFloat1;
    this.mTargetVelocityY = paramFloat2;
  }
  
  public void start() {
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStopTime = -1L;
    this.mDeltaTime = this.mStartTime;
    this.mStopValue = 0.5F;
    this.mDeltaX = 0;
    this.mDeltaY = 0;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\widget\AutoScrollHelper$ClampedScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */