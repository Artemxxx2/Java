package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<FragmentState> {
  public FragmentState createFromParcel(Parcel paramParcel) {
    return new FragmentState(paramParcel);
  }
  
  public FragmentState[] newArray(int paramInt) {
    return new FragmentState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */