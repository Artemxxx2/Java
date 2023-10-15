package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<FragmentManagerState> {
  public FragmentManagerState createFromParcel(Parcel paramParcel) {
    return new FragmentManagerState(paramParcel);
  }
  
  public FragmentManagerState[] newArray(int paramInt) {
    return new FragmentManagerState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentManagerState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */