package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LayoutParams extends ViewGroup.MarginLayoutParams {
  private static final int FLAG_IS_CLOSING = 4;
  
  private static final int FLAG_IS_OPENED = 1;
  
  private static final int FLAG_IS_OPENING = 2;
  
  public int gravity = 0;
  
  boolean isPeeking;
  
  float onScreen;
  
  int openState;
  
  public LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public LayoutParams(int paramInt1, int paramInt2, int paramInt3) {
    this(paramInt1, paramInt2);
    this.gravity = paramInt3;
  }
  
  public LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
    this.gravity = typedArray.getInt(0, 0);
    typedArray.recycle();
  }
  
  public LayoutParams(@NonNull ViewGroup.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
  
  public LayoutParams(@NonNull ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    super(paramMarginLayoutParams);
  }
  
  public LayoutParams(@NonNull LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
    this.gravity = paramLayoutParams.gravity;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */