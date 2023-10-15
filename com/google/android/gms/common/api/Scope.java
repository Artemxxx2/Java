package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
  @NonNull
  public static final Parcelable.Creator<Scope> CREATOR = new zza();
  
  @VersionField(id = 1)
  final int zza;
  
  @Field(getter = "getScopeUri", id = 2)
  private final String zzb;
  
  @Constructor
  Scope(@Param(id = 1) int paramInt, @Param(id = 2) String paramString) {
    Preconditions.checkNotEmpty(paramString, "scopeUri must not be null or empty");
    this.zza = paramInt;
    this.zzb = paramString;
  }
  
  public Scope(@NonNull String paramString) {
    this(1, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return (this == paramObject) ? true : (!(paramObject instanceof Scope) ? false : this.zzb.equals(((Scope)paramObject).zzb));
  }
  
  @NonNull
  @KeepForSdk
  public String getScopeUri() {
    return this.zzb;
  }
  
  public int hashCode() {
    return this.zzb.hashCode();
  }
  
  @NonNull
  public String toString() {
    return this.zzb;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeString(paramParcel, 2, getScopeUri(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\api\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */