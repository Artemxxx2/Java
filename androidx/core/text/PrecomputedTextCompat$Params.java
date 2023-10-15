package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;

public final class Params {
  private final int mBreakStrategy;
  
  private final int mHyphenationFrequency;
  
  @NonNull
  private final TextPaint mPaint;
  
  @Nullable
  private final TextDirectionHeuristic mTextDir;
  
  final PrecomputedText.Params mWrapped;
  
  @RequiresApi(28)
  public Params(@NonNull PrecomputedText.Params paramParams) {
    this.mPaint = paramParams.getTextPaint();
    this.mTextDir = paramParams.getTextDirection();
    this.mBreakStrategy = paramParams.getBreakStrategy();
    this.mHyphenationFrequency = paramParams.getHyphenationFrequency();
    if (Build.VERSION.SDK_INT < 29)
      paramParams = null; 
    this.mWrapped = paramParams;
  }
  
  @SuppressLint({"NewApi"})
  Params(@NonNull TextPaint paramTextPaint, @NonNull TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT >= 29) {
      this.mWrapped = (new PrecomputedText.Params.Builder(paramTextPaint)).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();
    } else {
      this.mWrapped = null;
    } 
    this.mPaint = paramTextPaint;
    this.mTextDir = paramTextDirectionHeuristic;
    this.mBreakStrategy = paramInt1;
    this.mHyphenationFrequency = paramInt2;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Params))
      return false; 
    paramObject = paramObject;
    return !equalsWithoutTextDirection((Params)paramObject) ? false : (!(Build.VERSION.SDK_INT >= 18 && this.mTextDir != paramObject.getTextDirection()));
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean equalsWithoutTextDirection(@NonNull Params paramParams) {
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.mBreakStrategy != paramParams.getBreakStrategy())
        return false; 
      if (this.mHyphenationFrequency != paramParams.getHyphenationFrequency())
        return false; 
    } 
    if (this.mPaint.getTextSize() != paramParams.getTextPaint().getTextSize())
      return false; 
    if (this.mPaint.getTextScaleX() != paramParams.getTextPaint().getTextScaleX())
      return false; 
    if (this.mPaint.getTextSkewX() != paramParams.getTextPaint().getTextSkewX())
      return false; 
    if (Build.VERSION.SDK_INT >= 21) {
      if (this.mPaint.getLetterSpacing() != paramParams.getTextPaint().getLetterSpacing())
        return false; 
      if (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), paramParams.getTextPaint().getFontFeatureSettings()))
        return false; 
    } 
    if (this.mPaint.getFlags() != paramParams.getTextPaint().getFlags())
      return false; 
    if (Build.VERSION.SDK_INT >= 24) {
      if (!this.mPaint.getTextLocales().equals(paramParams.getTextPaint().getTextLocales()))
        return false; 
    } else if (Build.VERSION.SDK_INT >= 17 && !this.mPaint.getTextLocale().equals(paramParams.getTextPaint().getTextLocale())) {
      return false;
    } 
    if (this.mPaint.getTypeface() == null) {
      if (paramParams.getTextPaint().getTypeface() != null)
        return false; 
    } else if (!this.mPaint.getTypeface().equals(paramParams.getTextPaint().getTypeface())) {
      return false;
    } 
    return true;
  }
  
  @RequiresApi(23)
  public int getBreakStrategy() {
    return this.mBreakStrategy;
  }
  
  @RequiresApi(23)
  public int getHyphenationFrequency() {
    return this.mHyphenationFrequency;
  }
  
  @Nullable
  @RequiresApi(18)
  public TextDirectionHeuristic getTextDirection() {
    return this.mTextDir;
  }
  
  @NonNull
  public TextPaint getTextPaint() {
    return this.mPaint;
  }
  
  public int hashCode() {
    return (Build.VERSION.SDK_INT >= 24) ? ObjectsCompat.hash(new Object[] { 
          Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), 
          Integer.valueOf(this.mHyphenationFrequency) }) : ((Build.VERSION.SDK_INT >= 21) ? ObjectsCompat.hash(new Object[] { 
          Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), 
          Integer.valueOf(this.mHyphenationFrequency) }) : ((Build.VERSION.SDK_INT >= 18) ? ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) }) : ((Build.VERSION.SDK_INT >= 17) ? ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) }) : ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) }))));
  }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder("{");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("textSize=");
    stringBuilder2.append(this.mPaint.getTextSize());
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", textScaleX=");
    stringBuilder2.append(this.mPaint.getTextScaleX());
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", textSkewX=");
    stringBuilder2.append(this.mPaint.getTextSkewX());
    stringBuilder1.append(stringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 21) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", letterSpacing=");
      stringBuilder2.append(this.mPaint.getLetterSpacing());
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", elegantTextHeight=");
      stringBuilder2.append(this.mPaint.isElegantTextHeight());
      stringBuilder1.append(stringBuilder2.toString());
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", textLocale=");
      stringBuilder2.append(this.mPaint.getTextLocales());
      stringBuilder1.append(stringBuilder2.toString());
    } else if (Build.VERSION.SDK_INT >= 17) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", textLocale=");
      stringBuilder2.append(this.mPaint.getTextLocale());
      stringBuilder1.append(stringBuilder2.toString());
    } 
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", typeface=");
    stringBuilder2.append(this.mPaint.getTypeface());
    stringBuilder1.append(stringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 26) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(", variationSettings=");
      stringBuilder2.append(this.mPaint.getFontVariationSettings());
      stringBuilder1.append(stringBuilder2.toString());
    } 
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", textDir=");
    stringBuilder2.append(this.mTextDir);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", breakStrategy=");
    stringBuilder2.append(this.mBreakStrategy);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(", hyphenationFrequency=");
    stringBuilder2.append(this.mHyphenationFrequency);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append("}");
    return stringBuilder1.toString();
  }
  
  public static class Builder {
    private int mBreakStrategy;
    
    private int mHyphenationFrequency;
    
    @NonNull
    private final TextPaint mPaint;
    
    private TextDirectionHeuristic mTextDir;
    
    public Builder(@NonNull TextPaint param2TextPaint) {
      this.mPaint = param2TextPaint;
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
    public Builder setBreakStrategy(int param2Int) {
      this.mBreakStrategy = param2Int;
      return this;
    }
    
    @RequiresApi(23)
    public Builder setHyphenationFrequency(int param2Int) {
      this.mHyphenationFrequency = param2Int;
      return this;
    }
    
    @RequiresApi(18)
    public Builder setTextDirection(@NonNull TextDirectionHeuristic param2TextDirectionHeuristic) {
      this.mTextDir = param2TextDirectionHeuristic;
      return this;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\PrecomputedTextCompat$Params.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */