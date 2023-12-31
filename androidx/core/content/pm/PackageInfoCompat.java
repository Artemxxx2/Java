package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;

public final class PackageInfoCompat {
  public static long getLongVersionCode(@NonNull PackageInfo paramPackageInfo) {
    return (Build.VERSION.SDK_INT >= 28) ? paramPackageInfo.getLongVersionCode() : paramPackageInfo.versionCode;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\content\pm\PackageInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */