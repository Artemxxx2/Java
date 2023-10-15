package com.google.android.play.core.review;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"RestrictedApi"})
public abstract class ReviewInfo implements Parcelable {
  public static final Parcelable.Creator<ReviewInfo> CREATOR = new zzb();
  
  public static ReviewInfo zzc(PendingIntent paramPendingIntent, boolean paramBoolean) {
    return new zza(paramPendingIntent, false);
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)zza(), 0);
    paramParcel.writeInt(zzb());
  }
  
  abstract PendingIntent zza();
  
  abstract boolean zzb();
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\play\core\review\ReviewInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */