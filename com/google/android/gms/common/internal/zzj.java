package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConnectionInfoCreator")
public final class zzj extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzj> CREATOR = new zzk();
  
  @Field(id = 1)
  Bundle zza;
  
  @Field(id = 2)
  Feature[] zzb;
  
  @Field(defaultValue = "0", id = 3)
  int zzc;
  
  @Nullable
  @Field(id = 4)
  ConnectionTelemetryConfiguration zzd;
  
  public zzj() {}
  
  @Constructor
  zzj(@Param(id = 1) Bundle paramBundle, @Param(id = 2) Feature[] paramArrayOfFeature, @Param(id = 3) int paramInt, @Nullable @Param(id = 4) ConnectionTelemetryConfiguration paramConnectionTelemetryConfiguration) {
    this.zza = paramBundle;
    this.zzb = paramArrayOfFeature;
    this.zzc = paramInt;
    this.zzd = paramConnectionTelemetryConfiguration;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.zzb, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeParcelable(paramParcel, 4, (Parcelable)this.zzd, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */