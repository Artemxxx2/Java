package androidx.core.provider;

import android.content.Context;
import java.util.concurrent.Callable;

final class null implements Callable<FontsContractCompat.TypefaceResult> {
  public FontsContractCompat.TypefaceResult call() throws Exception {
    FontsContractCompat.TypefaceResult typefaceResult = FontsContractCompat.getFontInternal(context, request, style);
    if (typefaceResult.mTypeface != null)
      FontsContractCompat.sTypefaceCache.put(id, typefaceResult.mTypeface); 
    return typefaceResult;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\provider\FontsContractCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */