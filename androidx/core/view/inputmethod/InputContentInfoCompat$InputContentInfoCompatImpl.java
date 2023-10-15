package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

interface InputContentInfoCompatImpl {
  @NonNull
  Uri getContentUri();
  
  @NonNull
  ClipDescription getDescription();
  
  @Nullable
  Object getInputContentInfo();
  
  @Nullable
  Uri getLinkUri();
  
  void releasePermission();
  
  void requestPermission();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputContentInfoCompat$InputContentInfoCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */