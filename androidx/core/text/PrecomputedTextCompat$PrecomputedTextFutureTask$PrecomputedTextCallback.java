package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;

class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
  private PrecomputedTextCompat.Params mParams;
  
  private CharSequence mText;
  
  PrecomputedTextCallback(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence) {
    this.mParams = paramParams;
    this.mText = paramCharSequence;
  }
  
  public PrecomputedTextCompat call() throws Exception {
    return PrecomputedTextCompat.create(this.mText, this.mParams);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */