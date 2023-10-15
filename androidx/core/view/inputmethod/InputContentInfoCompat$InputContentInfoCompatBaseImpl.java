package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class InputContentInfoCompatBaseImpl implements InputContentInfoCompat.InputContentInfoCompatImpl {
  @NonNull
  private final Uri mContentUri;
  
  @NonNull
  private final ClipDescription mDescription;
  
  @Nullable
  private final Uri mLinkUri;
  
  InputContentInfoCompatBaseImpl(@NonNull Uri paramUri1, @NonNull ClipDescription paramClipDescription, @Nullable Uri paramUri2) {
    this.mContentUri = paramUri1;
    this.mDescription = paramClipDescription;
    this.mLinkUri = paramUri2;
  }
  
  @NonNull
  public Uri getContentUri() {
    return this.mContentUri;
  }
  
  @NonNull
  public ClipDescription getDescription() {
    return this.mDescription;
  }
  
  @Nullable
  public Object getInputContentInfo() {
    return null;
  }
  
  @Nullable
  public Uri getLinkUri() {
    return this.mLinkUri;
  }
  
  public void releasePermission() {}
  
  public void requestPermission() {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputContentInfoCompat$InputContentInfoCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */