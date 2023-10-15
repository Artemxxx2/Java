package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<ParcelImpl> {
  public ParcelImpl createFromParcel(Parcel paramParcel) {
    return new ParcelImpl(paramParcel);
  }
  
  public ParcelImpl[] newArray(int paramInt) {
    return new ParcelImpl[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\versionedparcelable\ParcelImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */