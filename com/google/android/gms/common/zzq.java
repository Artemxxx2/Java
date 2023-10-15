package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesLookupResponseCreator")
public final class zzq extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzq> CREATOR = new zzr();
  
  @Field(getter = "getResult", id = 1)
  private final boolean zza;
  
  @Nullable
  @Field(getter = "getErrorMessage", id = 2)
  private final String zzb;
  
  @Field(getter = "getStatusValue", id = 3)
  private final int zzc;
  
  @Field(getter = "getFirstPartyStatusValue", id = 4)
  private final int zzd;
  
  @Constructor
  zzq(@Param(id = 1) boolean paramBoolean, @Param(id = 2) String paramString, @Param(id = 3) int paramInt1, @Param(id = 4) int paramInt2) {
    this.zza = paramBoolean;
    this.zzb = paramString;
    this.zzc = zzy.zza(paramInt1) - 1;
    this.zzd = zzd.zza(paramInt2) - 1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, this.zza);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  @Nullable
  public final String zza() {
    return this.zzb;
  }
  
  public final boolean zzb() {
    return this.zza;
  }
  
  public final int zzc() {
    return zzd.zza(this.zzd);
  }
  
  public final int zzd() {
    return zzy.zza(this.zzc);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */