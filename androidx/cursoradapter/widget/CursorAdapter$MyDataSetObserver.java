package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

class MyDataSetObserver extends DataSetObserver {
  public void onChanged() {
    CursorAdapter cursorAdapter = CursorAdapter.this;
    cursorAdapter.mDataValid = true;
    cursorAdapter.notifyDataSetChanged();
  }
  
  public void onInvalidated() {
    CursorAdapter cursorAdapter = CursorAdapter.this;
    cursorAdapter.mDataValid = false;
    cursorAdapter.notifyDataSetInvalidated();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cursoradapter\widget\CursorAdapter$MyDataSetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */