package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

final class null extends InputConnectionWrapper {
  null(InputConnection paramInputConnection, boolean paramBoolean) {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitContent(InputContentInfo paramInputContentInfo, int paramInt, Bundle paramBundle) {
    return listener.onCommitContent(InputContentInfoCompat.wrap(paramInputContentInfo), paramInt, paramBundle) ? true : super.commitContent(paramInputContentInfo, paramInt, paramBundle);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputConnectionCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */