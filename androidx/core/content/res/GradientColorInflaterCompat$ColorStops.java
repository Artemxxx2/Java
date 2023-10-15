package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.List;

final class ColorStops {
  final int[] mColors;
  
  final float[] mOffsets;
  
  ColorStops(@ColorInt int paramInt1, @ColorInt int paramInt2) {
    this.mColors = new int[] { paramInt1, paramInt2 };
    this.mOffsets = new float[] { 0.0F, 1.0F };
  }
  
  ColorStops(@ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3) {
    this.mColors = new int[] { paramInt1, paramInt2, paramInt3 };
    this.mOffsets = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  ColorStops(@NonNull List<Integer> paramList, @NonNull List<Float> paramList1) {
    int i = paramList.size();
    this.mColors = new int[i];
    this.mOffsets = new float[i];
    for (byte b = 0; b < i; b++) {
      this.mColors[b] = ((Integer)paramList.get(b)).intValue();
      this.mOffsets[b] = ((Float)paramList1.get(b)).floatValue();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\res\GradientColorInflaterCompat$ColorStops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */