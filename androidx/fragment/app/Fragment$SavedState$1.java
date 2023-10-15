package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.ClassLoaderCreator<Fragment.SavedState> {
  public Fragment.SavedState createFromParcel(Parcel paramParcel) {
    return new Fragment.SavedState(paramParcel, null);
  }
  
  public Fragment.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return new Fragment.SavedState(paramParcel, paramClassLoader);
  }
  
  public Fragment.SavedState[] newArray(int paramInt) {
    return new Fragment.SavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\Fragment$SavedState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */