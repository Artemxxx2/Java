package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface PermissionCompatDelegate {
  boolean onActivityResult(@NonNull Activity paramActivity, @IntRange(from = 0L) int paramInt1, int paramInt2, @Nullable Intent paramIntent);
  
  boolean requestPermissions(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from = 0L) int paramInt);
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityCompat$PermissionCompatDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */