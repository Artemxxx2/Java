package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@Class(creator = "GetServiceRequestCreator")
@Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
  @NonNull
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();
  
  static final Scope[] zza = new Scope[0];
  
  static final Feature[] zzb = new Feature[0];
  
  @VersionField(id = 1)
  final int zzc;
  
  @Field(id = 2)
  final int zzd;
  
  @Field(id = 3)
  int zze;
  
  @Field(id = 4)
  String zzf;
  
  @Nullable
  @Field(id = 5)
  IBinder zzg;
  
  @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_SCOPES", id = 6)
  Scope[] zzh;
  
  @Field(defaultValueUnchecked = "new android.os.Bundle()", id = 7)
  Bundle zzi;
  
  @Nullable
  @Field(id = 8)
  Account zzj;
  
  @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 10)
  Feature[] zzk;
  
  @Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 11)
  Feature[] zzl;
  
  @Field(id = 12)
  boolean zzm;
  
  @Field(defaultValue = "0", id = 13)
  int zzn;
  
  @Field(getter = "isRequestingTelemetryConfiguration", id = 14)
  boolean zzo;
  
  @Nullable
  @Field(getter = "getAttributionTag", id = 15)
  private String zzp;
  
  @Constructor
  GetServiceRequest(@Param(id = 1) int paramInt1, @Param(id = 2) int paramInt2, @Param(id = 3) int paramInt3, @Param(id = 4) String paramString1, @Nullable @Param(id = 5) IBinder paramIBinder, @Param(id = 6) Scope[] paramArrayOfScope, @Param(id = 7) Bundle paramBundle, @Nullable @Param(id = 8) Account paramAccount, @Param(id = 10) Feature[] paramArrayOfFeature1, @Param(id = 11) Feature[] paramArrayOfFeature2, @Param(id = 12) boolean paramBoolean1, @Param(id = 13) int paramInt4, @Param(id = 14) boolean paramBoolean2, @Nullable @Param(id = 15) String paramString2) {
    Scope[] arrayOfScope = paramArrayOfScope;
    if (paramArrayOfScope == null)
      arrayOfScope = zza; 
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    Feature[] arrayOfFeature = paramArrayOfFeature1;
    if (paramArrayOfFeature1 == null)
      arrayOfFeature = zzb; 
    paramArrayOfFeature1 = paramArrayOfFeature2;
    if (paramArrayOfFeature2 == null)
      paramArrayOfFeature1 = zzb; 
    this.zzc = paramInt1;
    this.zzd = paramInt2;
    this.zze = paramInt3;
    if ("com.google.android.gms".equals(paramString1)) {
      this.zzf = "com.google.android.gms";
    } else {
      this.zzf = paramString1;
    } 
    if (paramInt1 < 2) {
      if (paramIBinder != null) {
        Account account = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder));
      } else {
        paramString1 = null;
      } 
      this.zzj = (Account)paramString1;
    } else {
      this.zzg = paramIBinder;
      this.zzj = paramAccount;
    } 
    this.zzh = arrayOfScope;
    this.zzi = bundle;
    this.zzk = arrayOfFeature;
    this.zzl = paramArrayOfFeature1;
    this.zzm = paramBoolean1;
    this.zzn = paramInt4;
    this.zzo = paramBoolean2;
    this.zzp = paramString2;
  }
  
  @NonNull
  @KeepForSdk
  public Bundle getExtraArgs() {
    return this.zzi;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  @Nullable
  public final String zza() {
    return this.zzp;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\GetServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */