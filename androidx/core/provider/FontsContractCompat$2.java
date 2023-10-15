package androidx.core.provider;

import android.os.Handler;
import androidx.core.content.res.ResourcesCompat;

final class null implements SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult> {
  public void onReply(FontsContractCompat.TypefaceResult paramTypefaceResult) {
    if (paramTypefaceResult == null) {
      fontCallback.callbackFailAsync(1, handler);
    } else if (paramTypefaceResult.mResult == 0) {
      fontCallback.callbackSuccessAsync(paramTypefaceResult.mTypeface, handler);
    } else {
      fontCallback.callbackFailAsync(paramTypefaceResult.mResult, handler);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */