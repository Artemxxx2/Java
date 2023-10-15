package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<ResultReceiver> {
  public ResultReceiver createFromParcel(Parcel paramParcel) {
    return new ResultReceiver(paramParcel);
  }
  
  public ResultReceiver[] newArray(int paramInt) {
    return new ResultReceiver[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\android\support\v4\os\ResultReceiver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */