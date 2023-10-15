package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
  private final Object zza;
  
  public LifecycleActivity(@NonNull Activity paramActivity) {
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zza = paramActivity;
  }
  
  @KeepForSdk
  public LifecycleActivity(@NonNull ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public final Activity zza() {
    return (Activity)this.zza;
  }
  
  @NonNull
  public final FragmentActivity zzb() {
    return (FragmentActivity)this.zza;
  }
  
  public final boolean zzc() {
    return this.zza instanceof Activity;
  }
  
  public final boolean zzd() {
    return this.zza instanceof FragmentActivity;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\internal\LifecycleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */