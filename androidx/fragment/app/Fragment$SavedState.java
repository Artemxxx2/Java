package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class SavedState implements Parcelable {
  public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
      public Fragment.SavedState createFromParcel(Parcel param2Parcel) {
        return new Fragment.SavedState(param2Parcel, null);
      }
      
      public Fragment.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new Fragment.SavedState(param2Parcel, param2ClassLoader);
      }
      
      public Fragment.SavedState[] newArray(int param2Int) {
        return new Fragment.SavedState[param2Int];
      }
    };
  
  final Bundle mState;
  
  SavedState(Bundle paramBundle) {
    this.mState = paramBundle;
  }
  
  SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
    this.mState = paramParcel.readBundle();
    if (paramClassLoader != null) {
      Bundle bundle = this.mState;
      if (bundle != null)
        bundle.setClassLoader(paramClassLoader); 
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mState);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\fragment\app\Fragment$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */