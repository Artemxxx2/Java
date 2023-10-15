package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;

class DragHelperCallback extends ViewDragHelper.Callback {
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2) {
    SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
    if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
      int i = SlidingPaneLayout.this.getWidth() - SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin + SlidingPaneLayout.this.mSlideableView.getWidth();
      paramInt2 = SlidingPaneLayout.this.mSlideRange;
      paramInt1 = Math.max(Math.min(paramInt1, i), i - paramInt2);
    } else {
      paramInt2 = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
      int i = SlidingPaneLayout.this.mSlideRange;
      paramInt1 = Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    } 
    return paramInt1;
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2) {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView) {
    return SlidingPaneLayout.this.mSlideRange;
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2) {
    SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, paramInt2);
  }
  
  public void onViewCaptured(View paramView, int paramInt) {
    SlidingPaneLayout.this.setAllChildrenVisible();
  }
  
  public void onViewDragStateChanged(int paramInt) {
    if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0)
      if (SlidingPaneLayout.this.mSlideOffset == 0.0F) {
        SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
        slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
        slidingPaneLayout = SlidingPaneLayout.this;
        slidingPaneLayout.dispatchOnPanelClosed(slidingPaneLayout.mSlideableView);
        SlidingPaneLayout.this.mPreservedOpenState = false;
      } else {
        SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
        slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
        SlidingPaneLayout.this.mPreservedOpenState = true;
      }  
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    SlidingPaneLayout.this.onPanelDragged(paramInt1);
    SlidingPaneLayout.this.invalidate();
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   4: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
    //   7: astore #4
    //   9: aload_0
    //   10: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   13: invokevirtual isLayoutRtlSupport : ()Z
    //   16: ifeq -> 109
    //   19: aload_0
    //   20: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   23: invokevirtual getPaddingRight : ()I
    //   26: aload #4
    //   28: getfield rightMargin : I
    //   31: iadd
    //   32: istore #5
    //   34: fload_2
    //   35: fconst_0
    //   36: fcmpg
    //   37: iflt -> 67
    //   40: iload #5
    //   42: istore #6
    //   44: fload_2
    //   45: fconst_0
    //   46: fcmpl
    //   47: ifne -> 79
    //   50: iload #5
    //   52: istore #6
    //   54: aload_0
    //   55: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   58: getfield mSlideOffset : F
    //   61: ldc 0.5
    //   63: fcmpl
    //   64: ifle -> 79
    //   67: iload #5
    //   69: aload_0
    //   70: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   73: getfield mSlideRange : I
    //   76: iadd
    //   77: istore #6
    //   79: aload_0
    //   80: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   83: getfield mSlideableView : Landroid/view/View;
    //   86: invokevirtual getWidth : ()I
    //   89: istore #5
    //   91: aload_0
    //   92: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   95: invokevirtual getWidth : ()I
    //   98: iload #6
    //   100: isub
    //   101: iload #5
    //   103: isub
    //   104: istore #6
    //   106: goto -> 173
    //   109: aload_0
    //   110: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   113: invokevirtual getPaddingLeft : ()I
    //   116: istore #6
    //   118: aload #4
    //   120: getfield leftMargin : I
    //   123: iload #6
    //   125: iadd
    //   126: istore #5
    //   128: fload_2
    //   129: fconst_0
    //   130: fcmpl
    //   131: ifgt -> 161
    //   134: iload #5
    //   136: istore #6
    //   138: fload_2
    //   139: fconst_0
    //   140: fcmpl
    //   141: ifne -> 173
    //   144: iload #5
    //   146: istore #6
    //   148: aload_0
    //   149: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   152: getfield mSlideOffset : F
    //   155: ldc 0.5
    //   157: fcmpl
    //   158: ifle -> 173
    //   161: iload #5
    //   163: aload_0
    //   164: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   167: getfield mSlideRange : I
    //   170: iadd
    //   171: istore #6
    //   173: aload_0
    //   174: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   177: getfield mDragHelper : Landroidx/customview/widget/ViewDragHelper;
    //   180: iload #6
    //   182: aload_1
    //   183: invokevirtual getTop : ()I
    //   186: invokevirtual settleCapturedViewAt : (II)Z
    //   189: pop
    //   190: aload_0
    //   191: getfield this$0 : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
    //   194: invokevirtual invalidate : ()V
    //   197: return
  }
  
  public boolean tryCaptureView(View paramView, int paramInt) {
    return SlidingPaneLayout.this.mIsUnableToDrag ? false : ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).slideable;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$DragHelperCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */