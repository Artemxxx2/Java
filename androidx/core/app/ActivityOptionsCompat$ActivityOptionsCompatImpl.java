package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
  private final ActivityOptions mActivityOptions;
  
  ActivityOptionsCompatImpl(ActivityOptions paramActivityOptions) {
    this.mActivityOptions = paramActivityOptions;
  }
  
  public Rect getLaunchBounds() {
    return (Build.VERSION.SDK_INT < 24) ? null : this.mActivityOptions.getLaunchBounds();
  }
  
  public void requestUsageTimeReport(@NonNull PendingIntent paramPendingIntent) {
    if (Build.VERSION.SDK_INT >= 23)
      this.mActivityOptions.requestUsageTimeReport(paramPendingIntent); 
  }
  
  @NonNull
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect) {
    return (Build.VERSION.SDK_INT < 24) ? this : new ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(paramRect));
  }
  
  public Bundle toBundle() {
    return this.mActivityOptions.toBundle();
  }
  
  public void update(@NonNull ActivityOptionsCompat paramActivityOptionsCompat) {
    if (paramActivityOptionsCompat instanceof ActivityOptionsCompatImpl) {
      paramActivityOptionsCompat = paramActivityOptionsCompat;
      this.mActivityOptions.update(((ActivityOptionsCompatImpl)paramActivityOptionsCompat).mActivityOptions);
    } 
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\core\app\ActivityOptionsCompat$ActivityOptionsCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */