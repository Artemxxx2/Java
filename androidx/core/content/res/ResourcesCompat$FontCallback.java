package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class FontCallback {
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final void callbackFailAsync(final int reason, @Nullable Handler paramHandler) {
    Handler handler = paramHandler;
    if (paramHandler == null)
      handler = new Handler(Looper.getMainLooper()); 
    handler.post(new Runnable() {
          public void run() {
            ResourcesCompat.FontCallback.this.onFontRetrievalFailed(reason);
          }
        });
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler paramHandler) {
    Handler handler = paramHandler;
    if (paramHandler == null)
      handler = new Handler(Looper.getMainLooper()); 
    handler.post(new Runnable() {
          public void run() {
            ResourcesCompat.FontCallback.this.onFontRetrieved(typeface);
          }
        });
  }
  
  public abstract void onFontRetrievalFailed(int paramInt);
  
  public abstract void onFontRetrieved(@NonNull Typeface paramTypeface);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\res\ResourcesCompat$FontCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */