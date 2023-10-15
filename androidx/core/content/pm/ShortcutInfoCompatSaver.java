package androidx.core.content.pm;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ShortcutInfoCompatSaver<T> {
  @AnyThread
  public abstract T addShortcuts(List<ShortcutInfoCompat> paramList);
  
  @WorkerThread
  public List<ShortcutInfoCompat> getShortcuts() throws Exception {
    return new ArrayList<ShortcutInfoCompat>();
  }
  
  @AnyThread
  public abstract T removeAllShortcuts();
  
  @AnyThread
  public abstract T removeShortcuts(List<String> paramList);
  
  @RestrictTo({RestrictTo.Scope.LIBRARY})
  public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
    public Void addShortcuts(List<ShortcutInfoCompat> param1List) {
      return null;
    }
    
    public Void removeAllShortcuts() {
      return null;
    }
    
    public Void removeShortcuts(List<String> param1List) {
      return null;
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutInfoCompatSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */