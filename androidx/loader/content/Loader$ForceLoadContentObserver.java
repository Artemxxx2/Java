package androidx.loader.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class ForceLoadContentObserver extends ContentObserver {
  public ForceLoadContentObserver() {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications() {
    return true;
  }
  
  public void onChange(boolean paramBoolean) {
    Loader.this.onContentChanged();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\loader\content\Loader$ForceLoadContentObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */