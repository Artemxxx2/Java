package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

class Helper {
  public void apply(@NonNull SharedPreferences.Editor paramEditor) {
    try {
      paramEditor.apply();
    } catch (AbstractMethodError abstractMethodError) {
      paramEditor.commit();
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\SharedPreferencesCompat$EditorCompat$Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */