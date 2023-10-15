package androidx.core.provider;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class FontFamilyResult {
  public static final int STATUS_OK = 0;
  
  public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
  
  public static final int STATUS_WRONG_CERTIFICATES = 1;
  
  private final FontsContractCompat.FontInfo[] mFonts;
  
  private final int mStatusCode;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public FontFamilyResult(int paramInt, @Nullable FontsContractCompat.FontInfo[] paramArrayOfFontInfo) {
    this.mStatusCode = paramInt;
    this.mFonts = paramArrayOfFontInfo;
  }
  
  public FontsContractCompat.FontInfo[] getFonts() {
    return this.mFonts;
  }
  
  public int getStatusCode() {
    return this.mStatusCode;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$FontFamilyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */