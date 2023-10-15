package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzm implements Parcelable.Creator {
  static void zza(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, paramGetServiceRequest.zzc);
    SafeParcelWriter.writeInt(paramParcel, 2, paramGetServiceRequest.zzd);
    SafeParcelWriter.writeInt(paramParcel, 3, paramGetServiceRequest.zze);
    SafeParcelWriter.writeString(paramParcel, 4, paramGetServiceRequest.zzf, false);
    SafeParcelWriter.writeIBinder(paramParcel, 5, paramGetServiceRequest.zzg, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 6, (Parcelable[])paramGetServiceRequest.zzh, paramInt, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, paramGetServiceRequest.zzi, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, (Parcelable)paramGetServiceRequest.zzj, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 10, (Parcelable[])paramGetServiceRequest.zzk, paramInt, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 11, (Parcelable[])paramGetServiceRequest.zzl, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, paramGetServiceRequest.zzm);
    SafeParcelWriter.writeInt(paramParcel, 13, paramGetServiceRequest.zzn);
    SafeParcelWriter.writeBoolean(paramParcel, 14, paramGetServiceRequest.zzo);
    SafeParcelWriter.writeString(paramParcel, 15, paramGetServiceRequest.zza(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */