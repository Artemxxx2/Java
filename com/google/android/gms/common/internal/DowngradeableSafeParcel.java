package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
  private static final Object zza = new Object();
  
  private boolean zzb = false;
  
  @KeepForSdk
  protected static boolean canUnparcelSafely(@NonNull String paramString) {
    synchronized (zza) {
      return true;
    } 
  }
  
  @Nullable
  @KeepForSdk
  protected static Integer getUnparcelClientVersion() {
    synchronized (zza) {
      return null;
    } 
  }
  
  @KeepForSdk
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  @KeepForSdk
  public void setShouldDowngrade(boolean paramBoolean) {
    this.zzb = paramBoolean;
  }
  
  @KeepForSdk
  protected boolean shouldDowngrade() {
    return this.zzb;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */