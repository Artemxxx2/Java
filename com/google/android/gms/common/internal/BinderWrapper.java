package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepForSdk
@KeepName
public final class BinderWrapper implements Parcelable {
  @NonNull
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzh();
  
  private IBinder zza;
  
  @KeepForSdk
  public BinderWrapper(@NonNull IBinder paramIBinder) {
    this.zza = paramIBinder;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(@NonNull Parcel paramParcel, int paramInt) {
    paramParcel.writeStrongBinder(this.zza);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\com\google\android\gms\common\internal\BinderWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */