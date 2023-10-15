package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

final class null extends InputConnectionWrapper {
  null(InputConnection paramInputConnection, boolean paramBoolean) {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean performPrivateCommand(String paramString, Bundle paramBundle) {
    return InputConnectionCompat.handlePerformPrivateCommand(paramString, paramBundle, listener) ? true : super.performPrivateCommand(paramString, paramBundle);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\view\inputmethod\InputConnectionCompat$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */