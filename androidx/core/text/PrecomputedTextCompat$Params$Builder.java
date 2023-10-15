package androidx.core.text;

import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class Builder {
  private int mBreakStrategy;
  
  private int mHyphenationFrequency;
  
  @NonNull
  private final TextPaint mPaint;
  
  private TextDirectionHeuristic mTextDir;
  
  public Builder(@NonNull TextPaint paramTextPaint) {
    this.mPaint = paramTextPaint;
    if (Build.VERSION.SDK_INT >= 23) {
      this.mBreakStrategy = 1;
      this.mHyphenationFrequency = 1;
    } else {
      this.mHyphenationFrequency = 0;
      this.mBreakStrategy = 0;
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    } else {
      this.mTextDir = null;
    } 
  }
  
  @NonNull
  public PrecomputedTextCompat.Params build() {
    return new PrecomputedTextCompat.Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
  }
  
  @RequiresApi(23)
  public Builder setBreakStrategy(int paramInt) {
    this.mBreakStrategy = paramInt;
    return this;
  }
  
  @RequiresApi(23)
  public Builder setHyphenationFrequency(int paramInt) {
    this.mHyphenationFrequency = paramInt;
    return this;
  }
  
  @RequiresApi(18)
  public Builder setTextDirection(@NonNull TextDirectionHeuristic paramTextDirectionHeuristic) {
    this.mTextDir = paramTextDirectionHeuristic;
    return this;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\PrecomputedTextCompat$Params$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */