package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.core.provider.FontRequest;

public final class ProviderResourceEntry implements FontResourcesParserCompat.FamilyResourceEntry {
  @NonNull
  private final FontRequest mRequest;
  
  private final int mStrategy;
  
  private final int mTimeoutMs;
  
  public ProviderResourceEntry(@NonNull FontRequest paramFontRequest, int paramInt1, int paramInt2) {
    this.mRequest = paramFontRequest;
    this.mStrategy = paramInt1;
    this.mTimeoutMs = paramInt2;
  }
  
  public int getFetchStrategy() {
    return this.mStrategy;
  }
  
  @NonNull
  public FontRequest getRequest() {
    return this.mRequest;
  }
  
  public int getTimeout() {
    return this.mTimeoutMs;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\res\FontResourcesParserCompat$ProviderResourceEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */