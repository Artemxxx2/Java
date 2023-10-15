package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
  @NonNull
  public static final Parcelable.Creator<Feature> CREATOR = new zzc();
  
  @Field(getter = "getName", id = 1)
  private final String zza;
  
  @Deprecated
  @Field(getter = "getOldVersion", id = 2)
  private final int zzb;
  
  @Field(defaultValue = "-1", getter = "getVersion", id = 3)
  private final long zzc;
  
  @Constructor
  public Feature(@NonNull @Param(id = 1) String paramString, @Param(id = 2) int paramInt, @Param(id = 3) long paramLong) {
    this.zza = paramString;
    this.zzb = paramInt;
    this.zzc = paramLong;
  }
  
  @KeepForSdk
  public Feature(@NonNull String paramString, long paramLong) {
    this.zza = paramString;
    this.zzc = paramLong;
    this.zzb = -1;
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof Feature) {
      paramObject = paramObject;
      if (((getName() != null && getName().equals(paramObject.getName())) || (getName() == null && paramObject.getName() == null)) && getVersion() == paramObject.getVersion())
        return true; 
    } 
    return false;
  }
  
  @NonNull
  @KeepForSdk
  public String getName() {
    return this.zza;
  }
  
  @KeepForSdk
  public long getVersion() {
    long l1 = this.zzc;
    long l2 = l1;
    if (l1 == -1L)
      l2 = this.zzb; 
    return l2;
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { getName(), Long.valueOf(getVersion()) });
  }
  
  @NonNull
  public final String toString() {
    Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this);
    toStringHelper.add("name", getName());
    toStringHelper.add("version", Long.valueOf(getVersion()));
    return toStringHelper.toString();
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */