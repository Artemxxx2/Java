package androidx.core.text;

import java.nio.CharBuffer;

abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
  private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;
  
  TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm) {
    this.mAlgorithm = paramTextDirectionAlgorithm;
  }
  
  private boolean doCheck(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    switch (this.mAlgorithm.checkRtl(paramCharSequence, paramInt1, paramInt2)) {
      default:
        return defaultIsRtl();
      case 1:
        return false;
      case 0:
        break;
    } 
    return true;
  }
  
  protected abstract boolean defaultIsRtl();
  
  public boolean isRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    if (paramCharSequence != null && paramInt1 >= 0 && paramInt2 >= 0 && paramCharSequence.length() - paramInt2 >= paramInt1)
      return (this.mAlgorithm == null) ? defaultIsRtl() : doCheck(paramCharSequence, paramInt1, paramInt2); 
    throw new IllegalArgumentException();
  }
  
  public boolean isRtl(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    return isRtl(CharBuffer.wrap(paramArrayOfchar), paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */