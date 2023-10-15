package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState> {
  public CoordinatorLayout.SavedState createFromParcel(Parcel paramParcel) {
    return new CoordinatorLayout.SavedState(paramParcel, null);
  }
  
  public CoordinatorLayout.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return new CoordinatorLayout.SavedState(paramParcel, paramClassLoader);
  }
  
  public CoordinatorLayout.SavedState[] newArray(int paramInt) {
    return new CoordinatorLayout.SavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\coordinatorlayout\widget\CoordinatorLayout$SavedState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */