package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

final class null implements Parcelable.ClassLoaderCreator<AbsSavedState> {
  public AbsSavedState createFromParcel(Parcel paramParcel) {
    return createFromParcel(paramParcel, (ClassLoader)null);
  }
  
  public AbsSavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    if (paramParcel.readParcelable(paramClassLoader) == null)
      return AbsSavedState.EMPTY_STATE; 
    throw new IllegalStateException("superState must be null");
  }
  
  public AbsSavedState[] newArray(int paramInt) {
    return new AbsSavedState[paramInt];
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\customview\view\AbsSavedState$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */