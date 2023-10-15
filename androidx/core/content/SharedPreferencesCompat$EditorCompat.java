package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
public final class EditorCompat {
  private static EditorCompat sInstance;
  
  private final Helper mHelper = new Helper();
  
  @Deprecated
  public static EditorCompat getInstance() {
    if (sInstance == null)
      sInstance = new EditorCompat(); 
    return sInstance;
  }
  
  @Deprecated
  public void apply(@NonNull SharedPreferences.Editor paramEditor) {
    this.mHelper.apply(paramEditor);
  }
  
  private static class Helper {
    public void apply(@NonNull SharedPreferences.Editor param2Editor) {
      try {
        param2Editor.apply();
      } catch (AbstractMethodError abstractMethodError) {
        param2Editor.commit();
      } 
    }
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\SharedPreferencesCompat$EditorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */