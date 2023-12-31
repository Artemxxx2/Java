package androidx.core.provider;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

public class FontInfo {
  private final boolean mItalic;
  
  private final int mResultCode;
  
  private final int mTtcIndex;
  
  private final Uri mUri;
  
  private final int mWeight;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public FontInfo(@NonNull Uri paramUri, @IntRange(from = 0L) int paramInt1, @IntRange(from = 1L, to = 1000L) int paramInt2, boolean paramBoolean, int paramInt3) {
    this.mUri = (Uri)Preconditions.checkNotNull(paramUri);
    this.mTtcIndex = paramInt1;
    this.mWeight = paramInt2;
    this.mItalic = paramBoolean;
    this.mResultCode = paramInt3;
  }
  
  public int getResultCode() {
    return this.mResultCode;
  }
  
  @IntRange(from = 0L)
  public int getTtcIndex() {
    return this.mTtcIndex;
  }
  
  @NonNull
  public Uri getUri() {
    return this.mUri;
  }
  
  @IntRange(from = 1L, to = 1000L)
  public int getWeight() {
    return this.mWeight;
  }
  
  public boolean isItalic() {
    return this.mItalic;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$FontInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */