package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public final class zzs extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zzs> CREATOR = new zzt();
  
  @Field(getter = "getCallingPackage", id = 1)
  private final String zza;
  
  @Nullable
  @Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
  private final zzj zzb;
  
  @Field(getter = "getAllowTestKeys", id = 3)
  private final boolean zzc;
  
  @Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
  private final boolean zzd;
  
  @Constructor
  zzs(@Param(id = 1) String paramString, @Nullable @Param(id = 2) IBinder paramIBinder, @Param(id = 3) boolean paramBoolean1, @Param(id = 4) boolean paramBoolean2) {
    String str1;
    this.zza = paramString;
    String str2 = null;
    if (paramIBinder == null) {
      paramString = str2;
    } else {
      try {
        byte[] arrayOfByte;
        IObjectWrapper iObjectWrapper = zzy.zzg(paramIBinder).zzd();
        if (iObjectWrapper == null) {
          iObjectWrapper = null;
        } else {
          arrayOfByte = (byte[])ObjectWrapper.unwrap(iObjectWrapper);
        } 
        if (arrayOfByte != null) {
          zzk zzk = new zzk(arrayOfByte);
        } else {
          Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
          str1 = str2;
        } 
      } catch (RemoteException remoteException) {
        Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", (Throwable)remoteException);
        str1 = str2;
      } 
    } 
    this.zzb = (zzj)str1;
    this.zzc = paramBoolean1;
    this.zzd = paramBoolean2;
  }
  
  zzs(String paramString, @Nullable zzj paramzzj, boolean paramBoolean1, boolean paramBoolean2) {
    this.zza = paramString;
    this.zzb = paramzzj;
    this.zzc = paramBoolean1;
    this.zzd = paramBoolean2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zza, false);
    zzj zzj1 = this.zzb;
    zzj zzj2 = zzj1;
    if (zzj1 == null) {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      zzj2 = null;
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)zzj2, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzd);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */