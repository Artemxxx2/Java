package androidx.core.location;

import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.NonNull;

public final class LocationManagerCompat {
  public static boolean isLocationEnabled(@NonNull LocationManager paramLocationManager) {
    return (Build.VERSION.SDK_INT >= 28) ? paramLocationManager.isLocationEnabled() : ((paramLocationManager.isProviderEnabled("network") || paramLocationManager.isProviderEnabled("gps")));
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\location\LocationManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */