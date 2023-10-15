package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(25)
final class InputContentInfoCompatApi25Impl implements InputContentInfoCompat.InputContentInfoCompatImpl {
  @NonNull
  final InputContentInfo mObject;
  
  InputContentInfoCompatApi25Impl(@NonNull Uri paramUri1, @NonNull ClipDescription paramClipDescription, @Nullable Uri paramUri2) {
    this.mObject = new InputContentInfo(paramUri1, paramClipDescription, paramUri2);
  }
  
  InputContentInfoCompatApi25Impl(@NonNull Object paramObject) {
    this.mObject = (InputContentInfo)paramObject;
  }
  
  @NonNull
  public Uri getContentUri() {
    return this.mObject.getContentUri();
  }
  
  @NonNull
  public ClipDescription getDescription() {
    return this.mObject.getDescription();
  }
  
  @Nullable
  public Object getInputContentInfo() {
    return this.mObject;
  }
  
  @Nullable
  public Uri getLinkUri() {
    return this.mObject.getLinkUri();
  }
  
  public void releasePermission() {
    this.mObject.releasePermission();
  }
  
  public void requestPermission() {
    this.mObject.requestPermission();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputContentInfoCompat$InputContentInfoCompatApi25Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */