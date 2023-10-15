package androidx.cursoradapter.widget;

import android.database.Cursor;

interface CursorFilterClient {
  void changeCursor(Cursor paramCursor);
  
  CharSequence convertToString(Cursor paramCursor);
  
  Cursor getCursor();
  
  Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\cursoradapter\widget\CursorFilter$CursorFilterClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */