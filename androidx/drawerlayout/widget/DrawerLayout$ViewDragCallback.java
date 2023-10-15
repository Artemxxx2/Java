package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;

class ViewDragCallback extends ViewDragHelper.Callback {
  private final int mAbsGravity;
  
  private ViewDragHelper mDragger;
  
  private final Runnable mPeekRunnable = new Runnable() {
      public void run() {
        DrawerLayout.ViewDragCallback.this.peekDrawer();
      }
    };
  
  ViewDragCallback(int paramInt) {
    this.mAbsGravity = paramInt;
  }
  
  private void closeOtherDrawer() {
    int i = this.mAbsGravity;
    byte b = 3;
    if (i == 3)
      b = 5; 
    View view = DrawerLayout.this.findDrawerWithGravity(b);
    if (view != null)
      DrawerLayout.this.closeDrawer(view); 
  }
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2) {
    if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0)); 
    paramInt2 = DrawerLayout.this.getWidth();
    return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2) {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView) {
    boolean bool;
    if (DrawerLayout.this.isDrawerView(paramView)) {
      bool = paramView.getWidth();
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2) {
    View view;
    if ((paramInt1 & 0x1) == 1) {
      view = DrawerLayout.this.findDrawerWithGravity(3);
    } else {
      view = DrawerLayout.this.findDrawerWithGravity(5);
    } 
    if (view != null && DrawerLayout.this.getDrawerLockMode(view) == 0)
      this.mDragger.captureChildView(view, paramInt2); 
  }
  
  public boolean onEdgeLock(int paramInt) {
    return false;
  }
  
  public void onEdgeTouched(int paramInt1, int paramInt2) {
    DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
  }
  
  public void onViewCaptured(View paramView, int paramInt) {
    ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
    closeOtherDrawer();
  }
  
  public void onViewDragStateChanged(int paramInt) {
    DrawerLayout.this.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f;
    paramInt2 = paramView.getWidth();
    if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
      f = (paramInt1 + paramInt2) / paramInt2;
    } else {
      f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
    } 
    DrawerLayout.this.setDrawerViewOffset(paramView, f);
    if (f == 0.0F) {
      paramInt1 = 4;
    } else {
      paramInt1 = 0;
    } 
    paramView.setVisibility(paramInt1);
    DrawerLayout.this.invalidate();
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield this$0 : Landroidx/drawerlayout/widget/DrawerLayout;
    //   4: aload_1
    //   5: invokevirtual getDrawerViewOffset : (Landroid/view/View;)F
    //   8: fstore_3
    //   9: aload_1
    //   10: invokevirtual getWidth : ()I
    //   13: istore #4
    //   15: aload_0
    //   16: getfield this$0 : Landroidx/drawerlayout/widget/DrawerLayout;
    //   19: aload_1
    //   20: iconst_3
    //   21: invokevirtual checkDrawerViewAbsoluteGravity : (Landroid/view/View;I)Z
    //   24: ifeq -> 63
    //   27: fload_2
    //   28: fconst_0
    //   29: fcmpl
    //   30: ifgt -> 57
    //   33: fload_2
    //   34: fconst_0
    //   35: fcmpl
    //   36: ifne -> 49
    //   39: fload_3
    //   40: ldc 0.5
    //   42: fcmpl
    //   43: ifle -> 49
    //   46: goto -> 57
    //   49: iload #4
    //   51: ineg
    //   52: istore #5
    //   54: goto -> 106
    //   57: iconst_0
    //   58: istore #5
    //   60: goto -> 106
    //   63: aload_0
    //   64: getfield this$0 : Landroidx/drawerlayout/widget/DrawerLayout;
    //   67: invokevirtual getWidth : ()I
    //   70: istore #6
    //   72: fload_2
    //   73: fconst_0
    //   74: fcmpg
    //   75: iflt -> 99
    //   78: iload #6
    //   80: istore #5
    //   82: fload_2
    //   83: fconst_0
    //   84: fcmpl
    //   85: ifne -> 106
    //   88: iload #6
    //   90: istore #5
    //   92: fload_3
    //   93: ldc 0.5
    //   95: fcmpl
    //   96: ifle -> 106
    //   99: iload #6
    //   101: iload #4
    //   103: isub
    //   104: istore #5
    //   106: aload_0
    //   107: getfield mDragger : Landroidx/customview/widget/ViewDragHelper;
    //   110: iload #5
    //   112: aload_1
    //   113: invokevirtual getTop : ()I
    //   116: invokevirtual settleCapturedViewAt : (II)Z
    //   119: pop
    //   120: aload_0
    //   121: getfield this$0 : Landroidx/drawerlayout/widget/DrawerLayout;
    //   124: invokevirtual invalidate : ()V
    //   127: return
  }
  
  void peekDrawer() {
    View view;
    int i = this.mDragger.getEdgeSize();
    int j = this.mAbsGravity;
    int k = 0;
    if (j == 3) {
      j = 1;
    } else {
      j = 0;
    } 
    if (j != 0) {
      view = DrawerLayout.this.findDrawerWithGravity(3);
      if (view != null)
        k = -view.getWidth(); 
      k += i;
    } else {
      view = DrawerLayout.this.findDrawerWithGravity(5);
      k = DrawerLayout.this.getWidth() - i;
    } 
    if (view != null && ((j != 0 && view.getLeft() < k) || (j == 0 && view.getLeft() > k)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
      DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams)view.getLayoutParams();
      this.mDragger.smoothSlideViewTo(view, k, view.getTop());
      layoutParams.isPeeking = true;
      DrawerLayout.this.invalidate();
      closeOtherDrawer();
      DrawerLayout.this.cancelChildViewTouch();
    } 
  }
  
  public void removeCallbacks() {
    DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
  }
  
  public void setDragger(ViewDragHelper paramViewDragHelper) {
    this.mDragger = paramViewDragHelper;
  }
  
  public boolean tryCaptureView(View paramView, int paramInt) {
    boolean bool;
    if (DrawerLayout.this.isDrawerView(paramView) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(paramView) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$ViewDragCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */