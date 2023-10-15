package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;

class ChangeObserver extends ContentObserver {
  ChangeObserver() {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications() {
    return true;
  }
  
  public void onChange(boolean paramBoolean) {
    CursorAdapter.this.onContentChanged();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cursoradapter\widget\CursorAdapter$ChangeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */