package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "ConnectionTelemetryConfigurationCreator")
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
  @NonNull
  @KeepForSdk
  public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzl();
  
  @Field(getter = "getRootTelemetryConfiguration", id = 1)
  private final RootTelemetryConfiguration zza;
  
  @Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
  private final boolean zzb;
  
  @Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
  private final boolean zzc;
  
  @Nullable
  @Field(getter = "getMethodInvocationMethodKeyAllowlist", id = 4)
  private final int[] zzd;
  
  @Field(getter = "getMaxMethodInvocationsLogged", id = 5)
  private final int zze;
  
  @Nullable
  @Field(getter = "getMethodInvocationMethodKeyDisallowlist", id = 6)
  private final int[] zzf;
  
  @Constructor
  public ConnectionTelemetryConfiguration(@NonNull @Param(id = 1) RootTelemetryConfiguration paramRootTelemetryConfiguration, @Param(id = 2) boolean paramBoolean1, @Param(id = 3) boolean paramBoolean2, @Nullable @Param(id = 4) int[] paramArrayOfint1, @Param(id = 5) int paramInt, @Nullable @Param(id = 6) int[] paramArrayOfint2) {
    this.zza = paramRootTelemetryConfiguration;
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
    this.zzd = paramArrayOfint1;
    this.zze = paramInt;
    this.zzf = paramArrayOfint2;
  }
  
  @KeepForSdk
  public int getMaxMethodInvocationsLogged() {
    return this.zze;
  }
  
  @Nullable
  @KeepForSdk
  public int[] getMethodInvocationMethodKeyAllowlist() {
    return this.zzd;
  }
  
  @Nullable
  @KeepForSdk
  public int[] getMethodInvocationMethodKeyDisallowlist() {
    return this.zzf;
  }
  
  @KeepForSdk
  public boolean getMethodInvocationTelemetryEnabled() {
    return this.zzb;
  }
  
  @KeepForSdk
  public boolean getMethodTimingTelemetryEnabled() {
    return this.zzc;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, (Parcelable)this.zza, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, getMethodInvocationTelemetryEnabled());
    SafeParcelWriter.writeBoolean(paramParcel, 3, getMethodTimingTelemetryEnabled());
    SafeParcelWriter.writeIntArray(paramParcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
    SafeParcelWriter.writeInt(paramParcel, 5, getMaxMethodInvocationsLogged());
    SafeParcelWriter.writeIntArray(paramParcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @NonNull
  public final RootTelemetryConfiguration zza() {
    return this.zza;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\ConnectionTelemetryConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */