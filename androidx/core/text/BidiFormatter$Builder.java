package androidx.core.text;

import java.util.Locale;

public final class Builder {
  private int mFlags;
  
  private boolean mIsRtlContext;
  
  private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
  
  public Builder() {
    initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
  }
  
  public Builder(Locale paramLocale) {
    initialize(BidiFormatter.isRtlLocale(paramLocale));
  }
  
  public Builder(boolean paramBoolean) {
    initialize(paramBoolean);
  }
  
  private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean) {
    BidiFormatter bidiFormatter;
    if (paramBoolean) {
      bidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
    } else {
      bidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
    } 
    return bidiFormatter;
  }
  
  private void initialize(boolean paramBoolean) {
    this.mIsRtlContext = paramBoolean;
    this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
    this.mFlags = 2;
  }
  
  public BidiFormatter build() {
    return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
  }
  
  public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
    return this;
  }
  
  public Builder stereoReset(boolean paramBoolean) {
    if (paramBoolean) {
      this.mFlags |= 0x2;
    } else {
      this.mFlags &= 0xFFFFFFFD;
    } 
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\BidiFormatter$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */