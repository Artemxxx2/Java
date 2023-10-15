package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzc extends zzh implements zze {
  zzc(IBinder paramIBinder) {
    super(paramIBinder, "com.android.vending.billing.IInAppBillingService");
  }
  
  public final int zza(int paramInt, String paramString1, String paramString2) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(3);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    Parcel parcel1 = zzp(5, parcel2);
    paramInt = parcel1.readInt();
    parcel1.recycle();
    return paramInt;
  }
  
  public final int zzc(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(paramInt);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(10, parcel2);
    paramInt = parcel1.readInt();
    parcel1.recycle();
    return paramInt;
  }
  
  public final Bundle zzd(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(9);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(902, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zze(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(9);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(12, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(3);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    parcel2.writeString(null);
    Parcel parcel1 = zzp(3, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzg(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(paramInt);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    parcel2.writeString(null);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(8, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzh(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(6);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(9, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzi(int paramInt, String paramString1, String paramString2, String paramString3) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(3);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    Parcel parcel1 = zzp(4, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzj(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(9);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString(paramString3);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(11, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzk(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(3);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(2, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzl(int paramInt, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(paramInt);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    zzj.zzc(parcel2, (Parcelable)paramBundle1);
    zzj.zzc(parcel2, (Parcelable)paramBundle2);
    Parcel parcel1 = zzp(901, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final Bundle zzm(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(8);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    parcel2.writeString("subs");
    zzj.zzc(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zzp(801, parcel2);
    Bundle bundle = (Bundle)zzj.zza(parcel1, Bundle.CREATOR);
    parcel1.recycle();
    return bundle;
  }
  
  public final void zzn(int paramInt, String paramString, Bundle paramBundle, zzg paramzzg) throws RemoteException {
    Parcel parcel = zzo();
    parcel.writeInt(12);
    parcel.writeString(paramString);
    zzj.zzc(parcel, (Parcelable)paramBundle);
    zzj.zzd(parcel, paramzzg);
    zzq(1201, parcel);
  }
  
  public final int zzr(int paramInt, String paramString1, String paramString2) throws RemoteException {
    Parcel parcel2 = zzo();
    parcel2.writeInt(paramInt);
    parcel2.writeString(paramString1);
    parcel2.writeString(paramString2);
    Parcel parcel1 = zzp(1, parcel2);
    paramInt = parcel1.readInt();
    parcel1.recycle();
    return paramInt;
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\play_billing\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */