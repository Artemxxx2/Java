package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.Creator<FragmentTabHost.SavedState> {
  public FragmentTabHost.SavedState createFromParcel(Parcel paramParcel) {
    return new FragmentTabHost.SavedState(paramParcel);
  }
  
  public FragmentTabHost.SavedState[] newArray(int paramInt) {
    return new FragmentTabHost.SavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\FragmentTabHost$SavedState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */