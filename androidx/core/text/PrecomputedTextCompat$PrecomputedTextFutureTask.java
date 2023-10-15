package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {
  PrecomputedTextFutureTask(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence) {
    super(new PrecomputedTextCallback(paramParams, paramCharSequence));
  }
  
  private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
    private PrecomputedTextCompat.Params mParams;
    
    private CharSequence mText;
    
    PrecomputedTextCallback(@NonNull PrecomputedTextCompat.Params param2Params, @NonNull CharSequence param2CharSequence) {
      this.mParams = param2Params;
      this.mText = param2CharSequence;
    }
    
    public PrecomputedTextCompat call() throws Exception {
      return PrecomputedTextCompat.create(this.mText, this.mParams);
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\text\PrecomputedTextCompat$PrecomputedTextFutureTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */