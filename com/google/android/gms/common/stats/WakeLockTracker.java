package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@Deprecated
@KeepForSdk
public class WakeLockTracker {
  private static WakeLockTracker zza = new WakeLockTracker();
  
  @NonNull
  @KeepForSdk
  public static WakeLockTracker getInstance() {
    return zza;
  }
  
  @KeepForSdk
  public void registerAcquireEvent(@NonNull Context paramContext, @NonNull Intent paramIntent, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, int paramInt, @NonNull String paramString4) {}
  
  @KeepForSdk
  public void registerDeadlineEvent(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, int paramInt, @NonNull List<String> paramList, boolean paramBoolean, long paramLong) {}
  
  @KeepForSdk
  public void registerEvent(@NonNull Context paramContext, @NonNull String paramString1, int paramInt1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt2, @NonNull List<String> paramList) {}
  
  @KeepForSdk
  public void registerEvent(@NonNull Context paramContext, @NonNull String paramString1, int paramInt1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt2, @NonNull List<String> paramList, long paramLong) {}
  
  @KeepForSdk
  public void registerReleaseEvent(@NonNull Context paramContext, @NonNull Intent paramIntent) {}
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\stats\WakeLockTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */