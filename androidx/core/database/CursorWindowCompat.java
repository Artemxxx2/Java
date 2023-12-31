package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CursorWindowCompat {
  @NonNull
  public static CursorWindow create(@Nullable String paramString, long paramLong) {
    return (Build.VERSION.SDK_INT >= 28) ? new CursorWindow(paramString, paramLong) : ((Build.VERSION.SDK_INT >= 15) ? new CursorWindow(paramString) : new CursorWindow(false));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\database\CursorWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */