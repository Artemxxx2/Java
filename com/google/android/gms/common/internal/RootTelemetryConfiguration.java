package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "RootTelemetryConfigurationCreator")
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
  @NonNull
  @KeepForSdk
  public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzai();
  
  @Field(getter = "getVersion", id = 1)
  private final int zza;
  
  @Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
  private final boolean zzb;
  
  @Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
  private final boolean zzc;
  
  @Field(getter = "getBatchPeriodMillis", id = 4)
  private final int zzd;
  
  @Field(getter = "getMaxMethodInvocationsInBatch", id = 5)
  private final int zze;
  
  @Constructor
  public RootTelemetryConfiguration(@Param(id = 1) int paramInt1, @Param(id = 2) boolean paramBoolean1, @Param(id = 3) boolean paramBoolean2, @Param(id = 4) int paramInt2, @Param(id = 5) int paramInt3) {
    this.zza = paramInt1;
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
    this.zzd = paramInt2;
    this.zze = paramInt3;
  }
  
  @KeepForSdk
  public int getBatchPeriodMillis() {
    return this.zzd;
  }
  
  @KeepForSdk
  public int getMaxMethodInvocationsInBatch() {
    return this.zze;
  }
  
  @KeepForSdk
  public boolean getMethodInvocationTelemetryEnabled() {
    return this.zzb;
  }
  
  @KeepForSdk
  public boolean getMethodTimingTelemetryEnabled() {
    return this.zzc;
  }
  
  @KeepForSdk
  public int getVersion() {
    return this.zza;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getVersion());
    SafeParcelWriter.writeBoolean(paramParcel, 2, getMethodInvocationTelemetryEnabled());
    SafeParcelWriter.writeBoolean(paramParcel, 3, getMethodTimingTelemetryEnabled());
    SafeParcelWriter.writeInt(paramParcel, 4, getBatchPeriodMillis());
    SafeParcelWriter.writeInt(paramParcel, 5, getMaxMethodInvocationsInBatch());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\RootTelemetryConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */