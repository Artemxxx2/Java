package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

class SavedState extends AbsSavedState {
  public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
      public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel) {
        return new SlidingPaneLayout.SavedState(param2Parcel, null);
      }
      
      public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new SlidingPaneLayout.SavedState(param2Parcel, null);
      }
      
      public SlidingPaneLayout.SavedState[] newArray(int param2Int) {
        return new SlidingPaneLayout.SavedState[param2Int];
      }
    };
  
  boolean isOpen;
  
  SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.isOpen = bool;
  }
  
  SavedState(Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.isOpen);
  }
}


/* Location:              C:\Users\Root1\Desktop\Stash\output\!\androidx\slidingpanelayout\widget\SlidingPaneLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */