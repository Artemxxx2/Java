package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class LayoutParams extends ViewGroup.MarginLayoutParams {
  public int anchorGravity = 0;
  
  public int dodgeInsetEdges = 0;
  
  public int gravity = 0;
  
  public int insetEdge = 0;
  
  public int keyline = -1;
  
  View mAnchorDirectChild;
  
  int mAnchorId = -1;
  
  View mAnchorView;
  
  CoordinatorLayout.Behavior mBehavior;
  
  boolean mBehaviorResolved = false;
  
  Object mBehaviorTag;
  
  private boolean mDidAcceptNestedScrollNonTouch;
  
  private boolean mDidAcceptNestedScrollTouch;
  
  private boolean mDidBlockInteraction;
  
  private boolean mDidChangeAfterNestedScroll;
  
  int mInsetOffsetX;
  
  int mInsetOffsetY;
  
  final Rect mLastChildRect = new Rect();
  
  public LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
    this.gravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
    this.mAnchorId = typedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
    this.anchorGravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
    this.keyline = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
    this.insetEdge = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
    this.dodgeInsetEdges = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
    this.mBehaviorResolved = typedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
    if (this.mBehaviorResolved)
      this.mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, typedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior)); 
    typedArray.recycle();
    CoordinatorLayout.Behavior behavior = this.mBehavior;
    if (behavior != null)
      behavior.onAttachedToLayoutParams(this); 
  }
  
  public LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
  
  public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    super(paramMarginLayoutParams);
  }
  
  public LayoutParams(LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
  
  private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout) {
    this.mAnchorView = paramCoordinatorLayout.findViewById(this.mAnchorId);
    View view = this.mAnchorView;
    if (view != null) {
      if (view == paramCoordinatorLayout) {
        if (paramCoordinatorLayout.isInEditMode()) {
          this.mAnchorDirectChild = null;
          this.mAnchorView = null;
          return;
        } 
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
      } 
      for (ViewParent viewParent = view.getParent(); viewParent != paramCoordinatorLayout && viewParent != null; viewParent = viewParent.getParent()) {
        if (viewParent == paramView) {
          if (paramCoordinatorLayout.isInEditMode()) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
          } 
          throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
      } 
      this.mAnchorDirectChild = view;
      return;
    } 
    if (paramCoordinatorLayout.isInEditMode()) {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
    stringBuilder.append(paramCoordinatorLayout.getResources().getResourceName(this.mAnchorId));
    stringBuilder.append(" to anchor view ");
    stringBuilder.append(paramView);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private boolean shouldDodge(View paramView, int paramInt) {
    boolean bool;
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).insetEdge, paramInt);
    if (i != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, paramInt) & i) == i) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout) {
    if (this.mAnchorView.getId() != this.mAnchorId)
      return false; 
    View view = this.mAnchorView;
    for (ViewParent viewParent = view.getParent(); viewParent != paramCoordinatorLayout; viewParent = viewParent.getParent()) {
      if (viewParent == null || viewParent == paramView) {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return false;
      } 
      if (viewParent instanceof View)
        view = (View)viewParent; 
    } 
    this.mAnchorDirectChild = view;
    return true;
  }
  
  boolean checkAnchorChanged() {
    boolean bool;
    if (this.mAnchorView == null && this.mAnchorId != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    if (paramView2 != this.mAnchorDirectChild && !shouldDodge(paramView2, ViewCompat.getLayoutDirection((View)paramCoordinatorLayout))) {
      CoordinatorLayout.Behavior<View> behavior = this.mBehavior;
      return (behavior != null && behavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2));
    } 
    return true;
  }
  
  boolean didBlockInteraction() {
    if (this.mBehavior == null)
      this.mDidBlockInteraction = false; 
    return this.mDidBlockInteraction;
  }
  
  View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView) {
    if (this.mAnchorId == -1) {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return null;
    } 
    if (this.mAnchorView == null || !verifyAnchorView(paramView, paramCoordinatorLayout))
      resolveAnchorView(paramView, paramCoordinatorLayout); 
    return this.mAnchorView;
  }
  
  @IdRes
  public int getAnchorId() {
    return this.mAnchorId;
  }
  
  @Nullable
  public CoordinatorLayout.Behavior getBehavior() {
    return this.mBehavior;
  }
  
  boolean getChangedAfterNestedScroll() {
    return this.mDidChangeAfterNestedScroll;
  }
  
  Rect getLastChildRect() {
    return this.mLastChildRect;
  }
  
  void invalidateAnchor() {
    this.mAnchorDirectChild = null;
    this.mAnchorView = null;
  }
  
  boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView) {
    boolean bool2;
    boolean bool1 = this.mDidBlockInteraction;
    if (bool1)
      return true; 
    CoordinatorLayout.Behavior<View> behavior = this.mBehavior;
    if (behavior != null) {
      bool2 = behavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);
    } else {
      bool2 = false;
    } 
    bool2 |= bool1;
    this.mDidBlockInteraction = bool2;
    return bool2;
  }
  
  boolean isNestedScrollAccepted(int paramInt) {
    switch (paramInt) {
      default:
        return false;
      case 1:
        return this.mDidAcceptNestedScrollNonTouch;
      case 0:
        break;
    } 
    return this.mDidAcceptNestedScrollTouch;
  }
  
  void resetChangedAfterNestedScroll() {
    this.mDidChangeAfterNestedScroll = false;
  }
  
  void resetNestedScroll(int paramInt) {
    setNestedScrollAccepted(paramInt, false);
  }
  
  void resetTouchBehaviorTracking() {
    this.mDidBlockInteraction = false;
  }
  
  public void setAnchorId(@IdRes int paramInt) {
    invalidateAnchor();
    this.mAnchorId = paramInt;
  }
  
  public void setBehavior(@Nullable CoordinatorLayout.Behavior paramBehavior) {
    CoordinatorLayout.Behavior behavior = this.mBehavior;
    if (behavior != paramBehavior) {
      if (behavior != null)
        behavior.onDetachedFromLayoutParams(); 
      this.mBehavior = paramBehavior;
      this.mBehaviorTag = null;
      this.mBehaviorResolved = true;
      if (paramBehavior != null)
        paramBehavior.onAttachedToLayoutParams(this); 
    } 
  }
  
  void setChangedAfterNestedScroll(boolean paramBoolean) {
    this.mDidChangeAfterNestedScroll = paramBoolean;
  }
  
  void setLastChildRect(Rect paramRect) {
    this.mLastChildRect.set(paramRect);
  }
  
  void setNestedScrollAccepted(int paramInt, boolean paramBoolean) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.mDidAcceptNestedScrollNonTouch = paramBoolean;
      case 0:
        break;
    } 
    this.mDidAcceptNestedScrollTouch = paramBoolean;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */