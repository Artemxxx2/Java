package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

public class DialogCompat {
  @NonNull
  public static View requireViewById(@NonNull Dialog paramDialog, int paramInt) {
    if (Build.VERSION.SDK_INT >= 28)
      return paramDialog.requireViewById(paramInt); 
    View view = paramDialog.findViewById(paramInt);
    if (view != null)
      return view; 
    throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\DialogCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */