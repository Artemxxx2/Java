package androidx.core.text;

class TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
  private final boolean mDefaultIsRtl;
  
  TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean) {
    super(paramTextDirectionAlgorithm);
    this.mDefaultIsRtl = paramBoolean;
  }
  
  protected boolean defaultIsRtl() {
    return this.mDefaultIsRtl;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */