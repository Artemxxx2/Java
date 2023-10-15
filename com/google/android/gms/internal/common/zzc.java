package com.google.android.gms.internal.common;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzc {
  private static final ClassLoader zza = zzc.class.getClassLoader();
  
  public static Parcelable zza(Parcel paramParcel, Parcelable.Creator paramCreator) {
    return (paramParcel.readInt() == 0) ? null : (Parcelable)paramCreator.createFromParcel(paramParcel);
  }
  
  public static void zzb(Parcel paramParcel) {
    int i = paramParcel.dataAvail();
    if (i <= 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Parcel data not fully consumed, unread size: ");
    stringBuilder.append(i);
    throw new BadParcelableException(stringBuilder.toString());
  }
  
  public static void zzc(Parcel paramParcel, boolean paramBoolean) {
    paramParcel.writeInt(paramBoolean);
  }
  
  public static void zzd(Parcel paramParcel, Parcelable paramParcelable) {
    if (paramParcelable == null) {
      paramParcel.writeInt(0);
      return;
    } 
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
  
  public static void zze(Parcel paramParcel, Parcelable paramParcelable) {
    if (paramParcelable == null) {
      paramParcel.writeInt(0);
      return;
    } 
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 1);
  }
  
  public static void zzf(Parcel paramParcel, IInterface paramIInterface) {
    if (paramIInterface == null) {
      paramParcel.writeStrongBinder(null);
      return;
    } 
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
  }
  
  public static boolean zzg(Parcel paramParcel) {
    return (paramParcel.readInt() != 0);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\internal\common\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */