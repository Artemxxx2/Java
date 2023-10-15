package androidx.core.content.pm;

import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class NoopImpl extends ShortcutInfoCompatSaver<Void> {
  public Void addShortcuts(List<ShortcutInfoCompat> paramList) {
    return null;
  }
  
  public Void removeAllShortcuts() {
    return null;
  }
  
  public Void removeShortcuts(List<String> paramList) {
    return null;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\ShortcutInfoCompatSaver$NoopImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */