package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FontFileResourceEntry {
  @NonNull
  private final String mFileName;
  
  private boolean mItalic;
  
  private int mResourceId;
  
  private int mTtcIndex;
  
  private String mVariationSettings;
  
  private int mWeight;
  
  public FontFileResourceEntry(@NonNull String paramString1, int paramInt1, boolean paramBoolean, @Nullable String paramString2, int paramInt2, int paramInt3) {
    this.mFileName = paramString1;
    this.mWeight = paramInt1;
    this.mItalic = paramBoolean;
    this.mVariationSettings = paramString2;
    this.mTtcIndex = paramInt2;
    this.mResourceId = paramInt3;
  }
  
  @NonNull
  public String getFileName() {
    return this.mFileName;
  }
  
  public int getResourceId() {
    return this.mResourceId;
  }
  
  public int getTtcIndex() {
    return this.mTtcIndex;
  }
  
  @Nullable
  public String getVariationSettings() {
    return this.mVariationSettings;
  }
  
  public int getWeight() {
    return this.mWeight;
  }
  
  public boolean isItalic() {
    return this.mItalic;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\res\FontResourcesParserCompat$FontFileResourceEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */