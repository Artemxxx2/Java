package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LayoutParams extends ViewGroup.MarginLayoutParams {
  private static final int[] ATTRS = new int[] { 16843137 };
  
  Paint dimPaint;
  
  boolean dimWhenOffset;
  
  boolean slideable;
  
  public float weight = 0.0F;
  
  public LayoutParams() {
    super(-1, -1);
  }
  
  public LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.weight = typedArray.getFloat(0, 0.0F);
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
    this.weight = paramLayoutParams.weight;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */