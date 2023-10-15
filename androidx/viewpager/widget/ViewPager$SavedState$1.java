package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.ClassLoaderCreator<ViewPager.SavedState> {
  public ViewPager.SavedState createFromParcel(Parcel paramParcel) {
    return new ViewPager.SavedState(paramParcel, null);
  }
  
  public ViewPager.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    return new ViewPager.SavedState(paramParcel, paramClassLoader);
  }
  
  public ViewPager.SavedState[] newArray(int paramInt) {
    return new ViewPager.SavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\viewpager\widget\ViewPager$SavedState$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */