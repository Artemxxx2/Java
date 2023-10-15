package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<BackStackState> {
  public BackStackState createFromParcel(Parcel paramParcel) {
    return new BackStackState(paramParcel);
  }
  
  public BackStackState[] newArray(int paramInt) {
    return new BackStackState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\BackStackState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */