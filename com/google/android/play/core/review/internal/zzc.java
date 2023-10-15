package com.google.android.play.core.review.internal;

import android.os.BadParcelableException;
import android.os.IBinder;
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
  
  public static void zzc(Parcel paramParcel, Parcelable paramParcelable) {
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
  
  public static void zzd(Parcel paramParcel, IInterface paramIInterface) {
    paramParcel.writeStrongBinder((IBinder)paramIInterface);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */