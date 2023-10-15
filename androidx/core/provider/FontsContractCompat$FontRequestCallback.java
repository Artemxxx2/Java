package androidx.core.provider;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FontRequestCallback {
  public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
  
  public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
  
  public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
  
  public static final int FAIL_REASON_MALFORMED_QUERY = 3;
  
  public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
  
  public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
  
  public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final int RESULT_OK = 0;
  
  public void onTypefaceRequestFailed(int paramInt) {}
  
  public void onTypefaceRetrieved(Typeface paramTypeface) {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface FontRequestFailReason {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$FontRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */