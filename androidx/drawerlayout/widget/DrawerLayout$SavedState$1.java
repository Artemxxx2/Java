package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.ClassLoaderCreator<DrawerLayout.SavedState> {
  public DrawerLayout.SavedState createFromParcel(Parcel paramParcel) {
    return new DrawerLayout.SavedState(paramParcel, null);
  }
  
  public DrawerLayout.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return new DrawerLayout.SavedState(paramParcel, paramClassLoader);
  }
  
  public DrawerLayout.SavedState[] newArray(int paramInt) {
    return new DrawerLayout.SavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\drawerlayout\widget\DrawerLayout$SavedState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */