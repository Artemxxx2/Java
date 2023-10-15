package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;
import javax.annotation.Nullable;

@Deprecated
@KeepForSdk
@Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
  @NonNull
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
  
  @VersionField(id = 1)
  final int zza;
  
  @Field(getter = "getTimeMillis", id = 2)
  private final long zzb;
  
  @Field(getter = "getEventType", id = 11)
  private int zzc;
  
  @Field(getter = "getWakeLockName", id = 4)
  private final String zzd;
  
  @Field(getter = "getSecondaryWakeLockName", id = 10)
  private final String zze;
  
  @Field(getter = "getCodePackage", id = 17)
  private final String zzf;
  
  @Field(getter = "getWakeLockType", id = 5)
  private final int zzg;
  
  @Nullable
  @Field(getter = "getCallingPackages", id = 6)
  private final List zzh;
  
  @Field(getter = "getEventKey", id = 12)
  private final String zzi;
  
  @Field(getter = "getElapsedRealtime", id = 8)
  private final long zzj;
  
  @Field(getter = "getDeviceState", id = 14)
  private int zzk;
  
  @Field(getter = "getHostPackage", id = 13)
  private final String zzl;
  
  @Field(getter = "getBeginPowerPercentage", id = 15)
  private final float zzm;
  
  @Field(getter = "getTimeout", id = 16)
  private final long zzn;
  
  @Field(getter = "getAcquiredWithTimeout", id = 18)
  private final boolean zzo;
  
  private long zzp;
  
  @Constructor
  WakeLockEvent(@Param(id = 1) int paramInt1, @Param(id = 2) long paramLong1, @Param(id = 11) int paramInt2, @Param(id = 4) String paramString1, @Param(id = 5) int paramInt3, @Nullable @Param(id = 6) List paramList, @Param(id = 12) String paramString2, @Param(id = 8) long paramLong2, @Param(id = 14) int paramInt4, @Param(id = 10) String paramString3, @Param(id = 13) String paramString4, @Param(id = 15) float paramFloat, @Param(id = 16) long paramLong3, @Param(id = 17) String paramString5, @Param(id = 18) boolean paramBoolean) {
    this.zza = paramInt1;
    this.zzb = paramLong1;
    this.zzc = paramInt2;
    this.zzd = paramString1;
    this.zze = paramString3;
    this.zzf = paramString5;
    this.zzg = paramInt3;
    this.zzp = -1L;
    this.zzh = paramList;
    this.zzi = paramString2;
    this.zzj = paramLong2;
    this.zzk = paramInt4;
    this.zzl = paramString4;
    this.zzm = paramFloat;
    this.zzn = paramLong3;
    this.zzo = paramBoolean;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzg);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzh, false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 10, this.zze, false);
    SafeParcelWriter.writeInt(paramParcel, 11, this.zzc);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzi, false);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzl, false);
    SafeParcelWriter.writeInt(paramParcel, 14, this.zzk);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzm);
    SafeParcelWriter.writeLong(paramParcel, 16, this.zzn);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzf, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzo);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final int zza() {
    return this.zzc;
  }
  
  public final long zzb() {
    return this.zzp;
  }
  
  public final long zzc() {
    return this.zzb;
  }
  
  @NonNull
  public final String zzd() {
    String str1;
    List list = this.zzh;
    String str2 = this.zzd;
    int i = this.zzg;
    if (list == null) {
      str1 = "";
    } else {
      str1 = TextUtils.join(",", (Iterable)str1);
    } 
    int j = this.zzk;
    String str3 = this.zze;
    String str4 = str3;
    if (str3 == null)
      str4 = ""; 
    String str5 = this.zzl;
    str3 = str5;
    if (str5 == null)
      str3 = ""; 
    float f = this.zzm;
    String str6 = this.zzf;
    str5 = str6;
    if (str6 == null)
      str5 = ""; 
    boolean bool = this.zzo;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\t");
    stringBuilder.append(str2);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(str1);
    stringBuilder.append("\t");
    stringBuilder.append(j);
    stringBuilder.append("\t");
    stringBuilder.append(str4);
    stringBuilder.append("\t");
    stringBuilder.append(str3);
    stringBuilder.append("\t");
    stringBuilder.append(f);
    stringBuilder.append("\t");
    stringBuilder.append(str5);
    stringBuilder.append("\t");
    stringBuilder.append(bool);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */