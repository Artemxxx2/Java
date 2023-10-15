package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@Class(creator = "GoogleCertificatesLookupQueryCreator")
public final class zzo extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzo> CREATOR = new zzp();
  
  @Field(getter = "getCallingPackage", id = 1)
  private final String zza;
  
  @Field(getter = "getAllowTestKeys", id = 2)
  private final boolean zzb;
  
  @Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 3)
  private final boolean zzc;
  
  @Field(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")
  private final Context zzd;
  
  @Field(getter = "getIsChimeraPackage", id = 5)
  private final boolean zze;
  
  @Constructor
  zzo(@Param(id = 1) String paramString, @Param(id = 2) boolean paramBoolean1, @Param(id = 3) boolean paramBoolean2, @Param(id = 4) IBinder paramIBinder, @Param(id = 5) boolean paramBoolean3) {
    this.zza = paramString;
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
    this.zzd = (Context)ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(paramIBinder));
    this.zze = paramBoolean3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)ObjectWrapper.wrap(this.zzd), false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zze);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */